package com.example.baroni.fencer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Christopher Baroni on 5/20/2015.
 */
public class Game extends Activity {
    String player1Class;
    String player2Class;
    Class p1;
    Class p2;
    AnimationDrawable idleP1;
    AnimationDrawable idleP2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);


        //getting selected class
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openFileInput("characterchoice.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            player1Class = bufferedReader.readLine();
            player1Class = player1Class.toLowerCase();
            inputStreamReader.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            finish();
        } catch (IOException e) {
            e.printStackTrace();
        }//finish getting selected class

        //set P1
        switch (player1Class) {
            case "barbarian":
                p1 = new Barbarian();
                break;
            case "duelist":
                p1 = new Duelist();
                break;
            case "guard":
                p1 = new Guard();
                break;
            case "hero":
                p1 = new Hero();
                break;
            case "rogue":
                p1 = new Rogue();
                break;
            default:
                break;
        }//end switch
        //set P2
        int n = (int) ((Math.random() * 4) + 1);
        switch (n) {
            case 1:
                p2 = new Barbarian();
                player2Class = "barbarian";
            case 2:
                p2 = new Duelist();
                player2Class = "duelist";
                break;
            case 3:
                p2 = new Guard();
                player2Class = "guard";
                break;
            case 4:
                p2 = new Hero();
                player2Class = "hero";
                break;
            case 5:
                p2 = new Rogue();
                player2Class = "rogue";
                break;
            default:
                break;
        }//end switch


        ImageView P1 = (ImageView) findViewById(R.id.P1img);
        BitmapDrawable P1frame1 = (BitmapDrawable) getResources().getDrawable(R.drawable.barbarianidle1);
        BitmapDrawable P1frame2 = (BitmapDrawable) getResources().getDrawable(R.drawable.barbarianidle2);
        switch (player1Class) {
            case "barbarian":
                P1frame1 = (BitmapDrawable) getResources().getDrawable(R.drawable.barbarianidle1r);
                P1frame2 = (BitmapDrawable) getResources().getDrawable(R.drawable.barbarianidle2r);
                break;
            case "duelist":
                P1frame1 = (BitmapDrawable) getResources().getDrawable(R.drawable.duelistidle1r);
                P1frame2 = (BitmapDrawable) getResources().getDrawable(R.drawable.duelistidle2r);
                break;
            case "guard":
                P1frame1 = (BitmapDrawable) getResources().getDrawable(R.drawable.guardidle1);
                P1frame2 = (BitmapDrawable) getResources().getDrawable(R.drawable.guardidle2);
                break;
            case "hero":
                P1frame1 = (BitmapDrawable) getResources().getDrawable(R.drawable.heroidle1r);
                P1frame2 = (BitmapDrawable) getResources().getDrawable(R.drawable.heroidle2r);
                break;
            case "rogue":
                P1frame1 = (BitmapDrawable) getResources().getDrawable(R.drawable.rogueidle1r);
                P1frame2 = (BitmapDrawable) getResources().getDrawable(R.drawable.rogueidle2r);
                break;
            default:
                break;
        }
        idleP1 = new AnimationDrawable();
        idleP1.addFrame(P1frame1, 500);
        idleP1.addFrame(P1frame2, 500);
        idleP1.setOneShot(false);
        P1.setBackground(idleP1);
        idleP1.start();

        ImageView P2 = (ImageView) findViewById(R.id.P2img);
        BitmapDrawable P2frame1 = (BitmapDrawable) getResources().getDrawable(R.drawable.barbarianidle1);
        BitmapDrawable P2frame2 = (BitmapDrawable) getResources().getDrawable(R.drawable.barbarianidle2);
        switch (player2Class) {
            case "barbarian":
                P2frame1 = (BitmapDrawable) getResources().getDrawable(R.drawable.barbarianidle1);
                P2frame2 = (BitmapDrawable) getResources().getDrawable(R.drawable.barbarianidle2);
                break;
            case "duelist":
                P2frame1 = (BitmapDrawable) getResources().getDrawable(R.drawable.duelistidle1);
                P2frame2 = (BitmapDrawable) getResources().getDrawable(R.drawable.duelistidle2);
                break;
            case "guard":
                P2frame1 = (BitmapDrawable) getResources().getDrawable(R.drawable.guardidle1);
                P2frame2 = (BitmapDrawable) getResources().getDrawable(R.drawable.guardidle2);
                break;
            case "hero":
                P2frame1 = (BitmapDrawable) getResources().getDrawable(R.drawable.heroidle1);
                P2frame2 = (BitmapDrawable) getResources().getDrawable(R.drawable.heroidle2);
                break;
            case "rogue":
                P2frame1 = (BitmapDrawable) getResources().getDrawable(R.drawable.rogueidle1);
                P2frame2 = (BitmapDrawable) getResources().getDrawable(R.drawable.rogueidle2);
                break;
            default:
                break;
        }
        idleP2 = new AnimationDrawable();
        idleP2.addFrame(P2frame1, 500);
        idleP2.addFrame(P2frame2, 500);
        idleP2.setOneShot(false);
        P2.setBackground(idleP2);
        idleP2.start();

        ProgressBar P1HP = (ProgressBar) findViewById(R.id.P1HP);
        ProgressBar P2HP = (ProgressBar) findViewById(R.id.P2HP);
        P1HP.setMax(p1.HPmax);
        P2HP.setMax(p2.HPmax);
        P1HP.setProgress(p1.HPmax);
        P2HP.setProgress(p2.HPmax);
        ProgressBar P1Bal = (ProgressBar) findViewById(R.id.P1Bal);
        ProgressBar P2Bal = (ProgressBar) findViewById(R.id.P2Bal);
        P1Bal.setMax(p1.Balmax);
        P2Bal.setMax(p2.Balmax);
        P1Bal.setProgress(p1.Balnow);
        P2Bal.setProgress(p2.Balnow);
    }

    public void onClick(View view) {
        TextView downedP1 = (TextView) findViewById(R.id.downedP1);
        TextView downedP2 = (TextView) findViewById(R.id.downedP2);
        Button block = (Button) findViewById(R.id.Block);
        ProgressBar P1HP = (ProgressBar) findViewById(R.id.P1HP);
        ProgressBar P2HP = (ProgressBar) findViewById(R.id.P2HP);
        ProgressBar P1Bal = (ProgressBar) findViewById(R.id.P1Bal);
        ProgressBar P2Bal = (ProgressBar) findViewById(R.id.P2Bal);

        int p2command = (int)(Math.random()*2);
        if(p2.isDowned && p2command == 2){
            p2command = 1;
        }
        //0 Attack
        //1 Block
        //2 Feint

        switch(view.getId())
        {
            case R.id.Attack:
                //P1 attack P2 attack
                if(p2command == 0)  {
                    //if p1 hits
                    if( Math.random()*p2.Balnow < p1.Spd)  {
                        if(p1.getClass().getName().equalsIgnoreCase("barbarian")){
                            p2.damage(p1.Str + 1, p1);
                        }
                        else{
                            p2.damage(p1.Str - p2.Def, p1);
                        }
                        p2.knock(1 + p1.duelKnock(p2));
                    }
                    else{
                        p2.knock(1);
                    }
                    //if p2 hits
                    if( Math.random()*p1.Balnow < p2.Spd) {
                        if(p2.getClass().getName().equalsIgnoreCase("barbarian")){
                            p1.damage(p2.Str + 1, p2);
                        }
                        else{
                            p1.damage(p2.Str - p1.Def, p2);
                        }
                        p1.knock(1 + p2.duelKnock(p1));
                    }
                    else{
                        p1.knock(1);
                    }
                }// end p1 attack p2 attack
                // p1 attack p2 block
                else if(p2command == 1){
                    if( Math.random()*p2.Balnow < p1.Spd){ //if p1 hits
                        p2.Balnow += 1; //recover one bal
                    }
                    else{ //if the attack misses
                        p2.Balnow += 2; //recover two bal
                    }

                    p1.knock(2 + p1.duelKnock(p2));
                    if(p1.getClass().getName().equalsIgnoreCase("guard")){
                        p1.damage(p2.Str - p1.Def, p2);
                    }
                }
                // p1 attack p2 feint
                else if(p2command == 2){
                    p1.Balnow += 1;
                    if( Math.random()*p2.Balnow < p1.Spd){ //if p1 hits
                        p2.damage(p1.Str + 1, p1);
                        p2.knock(2 + p1.duelKnock(p2));
                    }
                    else{
                        p2.knock(1);
                    }
                }
                break;
            case R.id.Block:
                //only happens if p1 isnt downed
                if(!(p1.isDowned)) {
                    //p1 Blocks p2 attacks
                    if (p2command == 0) {
                        if (Math.random() * p1.Balnow < p2.Spd) { //if p2 hits
                            p1.Balnow += 1; //recover one bal
                        } else {//if the attack misses
                            p1.Balnow += 2; //recover two bal
                        }

                        p2.knock(2 + p1.duelKnock(p1));
                        if (p1.getClass().getName().equalsIgnoreCase("guard")) {
                            p2.damage(p1.Str - p2.Def, p1);
                        }
                    }
                    //p1 Blocks p2 Blocks
                    else if(p2command == 1){
                        if(!(p1.getClass().getName().equalsIgnoreCase("barbarian"))){
                            p1.Balnow += 1;
                        }
                        else{
                            p1.Balnow += 2;
                        }
                        if(!(p2.getClass().getName().equalsIgnoreCase("barbarian"))){
                            p2.Balnow += 1;
                        }
                        else
                        {
                            p2.Balnow += 2;
                        }
                    }
                    //p1 blocks p2 feints
                    else if(p2command == 2){
                        p2.Balnow += 1;
                        if( Math.random()*p1.Balnow < p2.Spd){ //if p2 hits
                            p1.damage(p2.Str - p1.Def, p2);
                            p1.knock(4 + p2.duelKnock(p1));
                        }
                        else {
                            p1.knock(2);
                        }
                    }
                }//end downed check
                break;
            case R.id.Feint:
                //p1 feints p2 attacks
                if(p2command == 0){
                    p2.Balnow += 1;
                    if( Math.random()*p1.Balnow < p2.Spd){ //if p2 hits
                        p1.damage(p2.Str + 1, p2);
                        p1.knock(2 + p2.duelKnock(p1));
                    }
                    else{
                        p1.knock(1);
                    }
                }
                //p1 feints p2 blocks
                else if(p2command == 1)
                {
                    p1.Balnow += 1;
                    if( Math.random()%p2.Balnow < p1.Spd){ //if p1 hits
                        p2.damage(p1.Str - p2.Def, p1);
                        p2.knock(4 + p1.duelKnock(p2));
                    }
                    else{
                        p2.knock(2);
                    }
                }
                //p1 feints p2 feints
                else if(p2command == 2){
                    if( Math.random()*p2.Balnow < p1.Spd){//if p1 hits
                        p2.damage(p1.Str/2 - p2.Def, p1);
                        if(p1.getClass().getName().equalsIgnoreCase("barbarian")){
                            p2.knock(4);
                        }
                        else{
                            p2.knock(2 + p1.duelKnock(p2));
                        }
                    }
                    else{
                        p2.knock(1);
                    }
                    if( Math.random()*p1.Balnow < p2.Spd){ //if p2 hits {
                        p1.damage(p2.Str/2 - p1.Def, p2);
                        if(p2.getClass().getName().equalsIgnoreCase("barbarian")){
                            p1.knock(4);
                        }
                        else{
                            p1.knock(2 + p2.duelKnock(p1));
                        }
                    }
                    else{
                        p1.knock(1);
                    }
                }
                break;
        }//end switch


            //oh, and not a case, but runs every time:

            P1HP.setProgress(p1.HPnow);
            P2HP.setProgress(p2.HPnow);
            P1Bal.setProgress(p1.Balnow);
            P2Bal.setProgress(p2.Balnow);

            if (p1.HPnow < 1) {
                popAlert("Game Over", "You Lose");
                startActivity(new Intent(this, CharSelect.class));
                finish();
            }
            else if (p2.HPnow < 1) {
                popAlert("Congratulations", "You Win");
                startActivity(new Intent(this, CharSelect.class));
                finish();
            }

            if (p1.isDowned) {
                p1.isDowned = false;
                p1.Balnow = p1.Balmax;
                downedP1.setText("");
                block.setBackgroundColor(android.R.drawable.btn_default);
            }
            if (p2.isDowned) {
                p2.isDowned = false;
                p2.Balnow = p1.Balmax;
                downedP2.setText("");
            }

            if (p1.Balnow < 1) {
                p1.isDowned = true;
                downedP1.setText("DOWNED");
                block.setBackgroundColor(Color.RED);

            }
            if (p2.Balnow < 1) {
                p2.isDowned = true;
                downedP2.setText("DOWNED");
            }
        //final checks -- skips if player pushed block while downed
        if(!(p1.isDowned && (view.getId() == R.id.Block))) {
            if (p1.getClass().getName().equals("hero")) {
                if (p1.Balnow != p1.Balmax)
                    p1.Balnow += 1;
            }
            if (p2.getClass().getName().equals("hero")) {
                if (p2.Balnow != p2.Balmax)
                    p2.Balnow += 1;
            }
        }//end final checks
        //test
    }//end onClick

    private void popAlert(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .setIcon(getResources().getDrawable(android.R.drawable.ic_menu_info_details))
                .create()
                .show();
    }

}//end
