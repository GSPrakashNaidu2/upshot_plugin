import 'dart:async';

import 'package:flutter/services.dart';

class UpshotPlugin {
  static const MethodChannel _channel = MethodChannel('upshot_plugin');

  static Future<String?> get platformVersion async {
    final String? version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static Future<String?> get getSomething async {
    final String? value = await _channel.invokeMethod('getSomething');
    return value;
  }

  static Future<String?> get createEvent async {
    final String? eventId = await _channel.invokeMethod('createEvent');
    return eventId;
  }
}
