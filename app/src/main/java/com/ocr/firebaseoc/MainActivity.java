package com.ocr.firebaseoc;

import androidx.annotation.Nullable;
import android.os.Bundle;

import com.firebase.ui.auth.AuthUI;
import com.ocr.firebaseoc.databinding.ActivityMainBinding;
import java.util.Collections;
import java.util.List;


public class MainActivity extends BaseActivity<ActivityMainBinding> {
    private static final int RC_SIGN_IN = 123;

    @Override
    ActivityMainBinding getViewBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupListeners();
    }

    private void setupListeners(){
        // Login Button
        binding.loginButton.setOnClickListener(view -> {
            startSignInActivity();
        });
    }

    private void startSignInActivity(){

        // Choose authentication providers
        List<AuthUI.IdpConfig> providers =
                Collections.singletonList(new AuthUI.IdpConfig.EmailBuilder().build());

        // Launch the activity
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setTheme(R.style.LoginTheme)
                        .setAvailableProviders(providers)
                        .setIsSmartLockEnabled(false, true)
                        .setLogo(R.drawable.ic_logo_auth)
                        .build(),
                RC_SIGN_IN);
    }
}