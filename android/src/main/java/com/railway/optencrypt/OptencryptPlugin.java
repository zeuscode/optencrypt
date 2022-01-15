package com.railway.optencrypt;

import android.graphics.Path;
import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.core.OTPcore;

import java.util.HashMap;
import java.util.Map;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

/**
 * OptencryptPlugin
 */
public class OptencryptPlugin implements FlutterPlugin, MethodCallHandler {
    /// The MethodChannel that will the communication between Flutter and native Android
    ///
    /// This local reference serves to register the plugin with the Flutter Engine and unregister it
    /// when the Flutter Engine is detached from the Activity
    private MethodChannel channel;
    private OTPcore otPcore;

    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
        channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "optencrypt");
        channel.setMethodCallHandler(this);
        otPcore = new OTPcore();

    }
//
//    计算OTP:
//    qrCode:二维码内容
//            返回OTP
//    String calOTP(String qrCode)
//
//
//    二维码解析：
//    qrCode:二维码内容
//    返回结果类型：Map
//    map内容：
//    解析成功与否标识（1表示失败，2为成功）-》code
//    令牌-》token
//    app识别码(空表示没有)-》appCode
//    刷新事件-》interval
//    Map decryptQR(String qrCode)


    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
        if (call.method.equals("getPlatformVersion")) {
            result.success("Android " + android.os.Build.VERSION.RELEASE);
        } else if (call.method.equals("decryptQR")) {
            String qrCode = call.argument("qrCode");
            Map decryptCode = new HashMap<>();
            try {
                decryptCode = OTPcore.decryptQR(qrCode);
            } catch (Exception e) {
                decryptCode.put("msg", "二维码有误，解析异常");
                decryptCode.put("code", "1");
            }

            result.success(decryptCode);

        } else if (call.method.equals("calOTP")) {
            String code = call.argument("code");
            if (otPcore != null) {
                String otpCode = null;
                try {
                    otpCode = OTPcore.calOTP(code);
                } catch (Exception e) {

                } finally {
                    result.success(otpCode);
                }

            }

        } else {
            result.notImplemented();
        }
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
        channel.setMethodCallHandler(null);
    }
}
