package com.example.baroni.fencer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Christopher Baroni on 5/17/2015.
 */
public class Options extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.Arcade:
                startActivity(new Intent(this, CharSelect.class));
                finish();
                break;
            case R.id.Multiplayer:
                popAlert("ALERT", "COMING SOON");
                break;
            case R.id.Characters:
                startActivity(new Intent(this, Characters.class));
                finish();
                break;
            default:
                break;
        }
    }
    private void popAlert(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .setIcon(getResources().getDrawable(android.R.drawable.ic_menu_info_details))
                .create()
                .show();
    }
}
