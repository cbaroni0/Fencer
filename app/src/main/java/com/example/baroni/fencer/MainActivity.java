package com.example.baroni.fencer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.titlescreen);
    }

    public void onClick(View view) {
        startActivity(new Intent(this, Options.class));
        finish();
    }
}
