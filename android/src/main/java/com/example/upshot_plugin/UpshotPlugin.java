package com.example.upshot_plugin;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.brandkinesis.BrandKinesis;
import com.brandkinesis.callback.BKAuthCallback;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

/** UpshotPlugin */
public class UpshotPlugin implements FlutterPlugin, MethodCallHandler {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private MethodChannel channel;
  private Activity activity;
  private BrandKinesis brandKinesis;

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "upshot_plugin");
    channel.setMethodCallHandler(new UpshotPlugin(this.UpshotPluginRegister(flutterPluginBinding.getApplicationContext(), )));
  }

  public void UpshotPluginRegister(Activity activity, MethodChannel methodChannel){
    this.activity = activity;
    this.channel = methodChannel;
    this.channel.setMethodCallHandler(this);
  }

  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
    if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    } else if(call.method.equals("")){
//      brandKinesis.initialiseBrandKinesis(context, new BKAuthCallback(){
//        @Override
//        public void onAuthenticationError(String s) {
//
//        }
//
//        @Override
//        public void onAuthenticationSuccess() {
//
//        }
//      });
    } else {
      result.notImplemented();
    }
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    channel.setMethodCallHandler(null);
  }
}
