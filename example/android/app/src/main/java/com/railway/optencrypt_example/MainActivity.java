package com.railway.optencrypt_example;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;

//import org.bouncycastle.jce.provider.BouncyCastleProvider;
//
//import java.security.Provider;
//import java.security.Security;

import io.flutter.embedding.android.FlutterActivity;

public class MainActivity extends FlutterActivity {
//
//    public void setupBouncyCastle() {
//        final Provider provider = Security.getProvider(BouncyCastleProvider.PROVIDER_NAME);
//        if (provider == null) {
//            // Web3j will set up the provider lazily when it's first used.
//            return;
//        }
//        if (provider.getClass().equals(BouncyCastleProvider.class)) {
//            // BC with same package name, shouldn't happen in real life.
//            return;
//        }
//        // Android registers its own BC provider. As it might be outdated and might not include
//        // all needed ciphers, we substitute it with a known BC bundled in the app.
//        // Android's BC has its package rewritten to "com.android.org.bouncycastle" and because
//        // of that it's possible to have another BC implementation loaded in VM.
//        Security.removeProvider(BouncyCastleProvider.PROVIDER_NAME);
//        Security.insertProviderAt(new BouncyCastleProvider(), 1);
//    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
//        setupBouncyCastle();
    }
}




