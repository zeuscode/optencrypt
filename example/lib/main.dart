

import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:optencrypt/otpencrypt.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String content = "";
  String? token = "";

  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
            child: Column(
          children: [
            ElevatedButton(
              child: Text('生成口令'),
              onPressed: () {
                OTPEncrypt.decryptQR("CE99F7B8F6C299A3157DB1458C9BA8426745839E818E3DB87508640594443F4BD1234679855703F6F54970DBB94A6CE01833160").then((value) {
                  Map<String, String>? paraMap = value;
                  //
                  if (paraMap != null) {
                   String? code = paraMap!['code'];
                    token = paraMap!['token'];
                    String? appCode = paraMap!['appCode'];
                    String? interval = paraMap!['interval'];
                    String? msg = paraMap!['msg'];
                    content =
                    "code=${code}==token=${token ??
                        ""}interval==${interval}msg==${msg}appCode=${appCode}";
                  }
                  // content  ="${value}===";
                    setState(() {});
                  }
                );
              },
            ),
            ElevatedButton(
              child: Text('生成口令'),
              onPressed: () {
                OTPEncrypt.calOTP(token!).then((value) {

                  content  ="${value}===";
                  setState(() {});
                }
                );
              },
            ),
            Text(content)
          ],
        )),
      ),
    );
  }
}
