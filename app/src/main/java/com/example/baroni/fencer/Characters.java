package com.example.baroni.fencer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Christopher Baroni on 5/17/2015.
 */
public class Characters extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.characterstats);

        ProgressBar HP  = (ProgressBar) findViewById(R.id.HP);
        ProgressBar str = (ProgressBar) findViewById(R.id.str);
        ProgressBar def = (ProgressBar) findViewById(R.id.def);
        ProgressBar spd = (ProgressBar) findViewById(R.id.spd);
        ProgressBar bal = (ProgressBar) findViewById(R.id.bal);
        HP.setMax(12);
        str.setMax(7);
        def.setMax(3);
        spd.setMax(8);
        bal.setMax(10);

    }

    public void onClick(View view) {
        ProgressBar HP  = (ProgressBar) findViewById(R.id.HP);
        ProgressBar str = (ProgressBar) findViewById(R.id.str);
        ProgressBar def = (ProgressBar) findViewById(R.id.def);
        ProgressBar spd = (ProgressBar) findViewById(R.id.spd);
        ProgressBar bal = (ProgressBar) findViewById(R.id.bal);
        TextView title  = (TextView) findViewById(R.id.textView);

        switch(view.getId())
        {
            case R.id.barbarian:
                HP .setProgress(new Barbarian().HPmax);
                str.setProgress(new Barbarian().Str);
                def.setProgress(new Barbarian().Def);
                spd.setProgress(new Barbarian().Spd);
                bal.setProgress(new Barbarian().Balmax);
                title.setText("Barbarian");
                break;
            case R.id.duelist:
                HP .setProgress(new Duelist().HPmax);
                str.setProgress(new Duelist().Str);
                def.setProgress(new Duelist().Def);
                spd.setProgress(new Duelist().Spd);
                bal.setProgress(new Duelist().Balmax);
                title.setText("Duelist");
                break;
            case R.id.guard:
                HP .setProgress(new Guard().HPmax);
                str.setProgress(new Guard().Str);
                def.setProgress(new Guard().Def);
                spd.setProgress(new Guard().Spd);
                bal.setProgress(new Guard().Balmax);
                title.setText("Guard");
                break;
            case R.id.hero:
                HP .setProgress(new Hero().HPmax);
                str.setProgress(new Hero().Str);
                def.setProgress(new Hero().Def);
                spd.setProgress(new Hero().Spd);
                bal.setProgress(new Hero().Balmax);
                title.setText("Hero");
                break;
            case R.id.rogue:
                HP .setProgress(new Rogue().HPmax);
                str.setProgress(new Rogue().Str);
                def.setProgress(new Rogue().Def);
                spd.setProgress(new Rogue().Spd);
                bal.setProgress(new Rogue().Balmax);
                title.setText("Rogue");
                break;
            case R.id.returntomm:
                startActivity(new Intent(this, Options.class));
                finish();
        }
    }
}
