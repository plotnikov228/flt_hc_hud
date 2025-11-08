package com.example.flt_hc_hud;

import androidx.annotation.NonNull;

import android.os.Build;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

/** FltHcHudPlugin */
public final class FltHcHudPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    /// The MethodChannel that will handle communication between Flutter and native Android
    private MethodChannel channel;

    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
        channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "flt_hc_hud");
        channel.setMethodCallHandler(this);
    }

    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull MethodChannel.Result result) {
        if ("getPlatformVersion".equals(call.method)) {
            // Убедитесь, что возвращаемый текст совместим с последними стандартами
            result.success("Android " + Build.VERSION.RELEASE);
        } else {
            result.notImplemented();
        }
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
        if (channel != null) {
            channel.setMethodCallHandler(null);
            channel = null;
        }
    }
}