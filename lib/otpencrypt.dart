import 'dart:async';

import 'package:flutter/services.dart';

class OTPEncrypt {
  static const MethodChannel _channel = MethodChannel('optencrypt');

  static Future<String?> get platformVersion async {
    final String? version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static Future<Map<String, String>?> decryptQR(String code) async {
    final Map? decryptQR =
        await _channel.invokeMethod('decryptQR',{'qrCode': code});
    return Map<String,String>.from(decryptQR!);
  }

  static Future<String?> calOTP(String str) async {
    String? code = await _channel.invokeMethod('calOTP', {'code':str});
    return code;
  }
}
