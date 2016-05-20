package com.example.baroni.fencer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by Christopher Baroni on 5/19/2015.
 */
public class CharSelect extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_select);

        ProgressBar HP  = (ProgressBar) findViewById(R.id.HPS);
        ProgressBar str = (ProgressBar) findViewById(R.id.strS);
        ProgressBar def = (ProgressBar) findViewById(R.id.defS);
        ProgressBar spd = (ProgressBar) findViewById(R.id.spdS);
        ProgressBar bal = (ProgressBar) findViewById(R.id.balS);
        HP.setMax(12);
        str.setMax(7);
        def.setMax(3);
        spd.setMax(8);
        bal.setMax(10);

    }

    public void onClick(View view) throws IOException {
        ProgressBar HP  = (ProgressBar) findViewById(R.id.HPS);
        ProgressBar str = (ProgressBar) findViewById(R.id.strS);
        ProgressBar def = (ProgressBar) findViewById(R.id.defS);
        ProgressBar spd = (ProgressBar) findViewById(R.id.spdS);
        ProgressBar bal = (ProgressBar) findViewById(R.id.balS);
        TextView title  = (TextView) findViewById(R.id.textViewS);

        switch(view.getId())
        {
            case R.id.barbarianS:
                HP .setProgress(new Barbarian().HPmax);
                str.setProgress(new Barbarian().Str);
                def.setProgress(new Barbarian().Def);
                spd.setProgress(new Barbarian().Spd);
                bal.setProgress(new Barbarian().Balmax);
                title.setText("Barbarian");
                break;
            case R.id.duelistS:
                HP .setProgress(new Duelist().HPmax);
                str.setProgress(new Duelist().Str);
                def.setProgress(new Duelist().Def);
                spd.setProgress(new Duelist().Spd);
                bal.setProgress(new Duelist().Balmax);
                title.setText("Duelist");
                break;
            case R.id.guardS:
                HP .setProgress(new Guard().HPmax);
                str.setProgress(new Guard().Str);
                def.setProgress(new Guard().Def);
                spd.setProgress(new Guard().Spd);
                bal.setProgress(new Guard().Balmax);
                title.setText("Guard");
                break;
            case R.id.heroS:
                HP .setProgress(new Hero().HPmax);
                str.setProgress(new Hero().Str);
                def.setProgress(new Hero().Def);
                spd.setProgress(new Hero().Spd);
                bal.setProgress(new Hero().Balmax);
                title.setText("Hero");
                break;
            case R.id.rogueS:
                HP .setProgress(new Rogue().HPmax);
                str.setProgress(new Rogue().Str);
                def.setProgress(new Rogue().Def);
                spd.setProgress(new Rogue().Spd);
                bal.setProgress(new Rogue().Balmax);
                title.setText("Rogue");
                break;
            case R.id.returntommS:
                startActivity(new Intent(this, Options.class));
                finish();
                break;
            case R.id.selectS:
                if(!(title.getText().equals("Choose A Character"))) {
                    FileOutputStream fileOutputStream = openFileOutput("characterchoice.txt", MODE_PRIVATE);
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                    outputStreamWriter.write((String)title.getText());
                    outputStreamWriter.flush();
                    outputStreamWriter.close();
                    startActivity(new Intent(this, Game.class));
                    finish();
                }
                break;
            default:
                break;
        }
    }
}
