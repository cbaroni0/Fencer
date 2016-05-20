package com.example.baroni.fencer;

/**
 * Created by Christopher Baroni on 5/17/2015.
 */
public abstract class Class {
    public int HPmax;
    public int HPnow;
    public int Str;
    public int Def;
    public int Spd;
    public int Balmax;
    public int Balnow;
    public boolean isDowned;
    public String name;

    int duelKnock(Class opponent) {

        if ( !(this.getClass().getName().equalsIgnoreCase("Duelist")))
        {
            return 0;
        }
        else
        {
            return (Spd - opponent.Balnow);
        }
    }

    void knock(int taken) {
        if(taken >= Balnow) {
            Balnow = 0;
            this.isDowned = true;
        }
        else {
            Balnow -= taken;
        }
    }

    void damage(int taken, Class opponent) {
        if (opponent.getClass().getName().equalsIgnoreCase("rogue") && this.isDowned) //down is a boolean that is true if the person is down
        {
            taken = taken * 3;
        }

        if(taken >= this.HPnow) {
            this.HPnow = 0;
        }
        else {
            this.HPnow -= taken;
        }
    }
}



