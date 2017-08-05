package com.njlabs.showjava.ui;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.njlabs.showjava.BuildConfig;
import com.njlabs.showjava.R;

public class About extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupLayout(R.layout.activity_about);
        String appVersionName = getString(R.string.about_version_placeholder) + BuildConfig.VERSION_NAME;
        ((TextView) findViewById(R.id.AppVersion)).setText(appVersionName);
        if(isPro()) {
            ((TextView) findViewById(R.id.AppName)).setText(R.string.show_java_pro);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
