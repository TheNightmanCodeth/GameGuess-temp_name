package com.diragi.gameguess;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LevelPicker extends AppCompatActivity {

    Set<String> won;
    Set<String> def = new HashSet<String>();
    String TAG = "LevelPicker";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_picker);
        int buttonId = getIntent().getIntExtra("BUTTONID", 0);
        SharedPreferences mPrefs = getApplicationContext().getSharedPreferences("won", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mPrefs.edit();
        won = mPrefs.getStringSet("wonPref", def);
        Log.d(TAG, "Won array: " +won.toString());

        if (won != null) {
            //set up all won levels
            for (String i : won) {
                Log.d("SETTING: ", String.valueOf(i));
                Button changeButton = (Button) findViewById(Integer.parseInt(i));
                changeButton.setBackgroundColor(Color.GREEN);
            }
        }

        if (buttonId != 0){

            Button buttonToChange = (Button)findViewById(buttonId);
            buttonToChange.setBackgroundColor(Color.GREEN);
            won.add(String.valueOf(buttonId));
            editor.putStringSet("wonPref", won);
            editor.commit();

        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_level_picker, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void levelPick(View v){

        switch (v.getId()){
            case R.id.one:
                //One
                Log.d("LevelPicker", "one");
                Intent intentOne = new Intent(getBaseContext(), Game.class);
                intentOne.putExtra("LEVEL", 1);
                intentOne.putExtra("ANSWER", "ZELDA");
                intentOne.putExtra("IMAGE", R.drawable.ic_zelda);
                intentOne.putExtra("BGCOLOR", 0xFF45b649);
                startActivity(intentOne);
                break;
            case R.id.two:
                //two
                Log.d("LevelPicker", "two");
                Intent intentTwo = new Intent(getBaseContext(), Game.class);
                intentTwo.putExtra("LEVEL", 2);
                intentTwo.putExtra("ANSWER", "PORTAL");
                intentTwo.putExtra("IMAGE", R.drawable.ic_porta);
                intentTwo.putExtra("BGCOLOR", 0xFF454547);
                startActivity(intentTwo);
                break;
            case R.id.three:
                //two
                Log.d("LevelPicker", "three");
                Intent intentThree = new Intent(getBaseContext(), Game.class);
                intentThree.putExtra("LEVEL", 3);
                intentThree.putExtra("ANSWER", "BIOSHOCK");
                intentThree.putExtra("IMAGE", R.drawable.ic_bioshock);
                intentThree.putExtra("BGCOLOR", 0xFF7c6136);
                startActivity(intentThree);
                break;
            case R.id.four:
                //two
                Log.d("LevelPicker", "four");
                Intent intentFour = new Intent(getBaseContext(), Game.class);
                intentFour.putExtra("LEVEL", 4);
                intentFour.putExtra("ANSWER", "LAST OF US");
                intentFour.putExtra("IMAGE", R.drawable.ic_lou);
                intentFour.putExtra("BGCOLOR", 0xFF4b575d);
                startActivity(intentFour);
                break;
            case R.id.five:
                Log.d("LevelPicker", "five");
                Intent intentFive = new Intent(getBaseContext(), Game.class);
                intentFive.putExtra("LEVEL", 5);
                intentFive.putExtra("ANSWER", "JAK & DAXTER");
                intentFive.putExtra("IMAGE", R.drawable.ic_jakanddaxter);
                intentFive.putExtra("BGCOLOR", 0xFF8A5937);
                startActivity(intentFive);
                break;
            case R.id.six:
                Log.d("LevelPicker", "six");
                Intent intentSix = new Intent(getBaseContext(), Game.class);
                intentSix.putExtra("LEVEL", 6);
                intentSix.putExtra("ANSWER", "METROID");
                intentSix.putExtra("IMAGE", R.drawable.ic_metroid);
                intentSix.putExtra("BGCOLOR", 0xFF84b839);
                startActivity(intentSix);
                break;
            case R.id.seven:
                Log.d("LevelPicker", "seven");
                Intent intentSev = new Intent(getBaseContext(), Game.class);
                intentSev.putExtra("LEVEL", 7);
                intentSev.putExtra("ANSWER", "GTA");
                intentSev.putExtra("IMAGE", R.drawable.ic_gta);
                intentSev.putExtra("BGCOLOR", 0xFFfdcc9d);
                startActivity(intentSev);
                break;
            case R.id.eight:
                Log.d("LevelPicker", "eight");
                Intent intentEig = new Intent(getBaseContext(), Game.class);
                intentEig.putExtra("LEVEL", 8);
                intentEig.putExtra("ANSWER", "HALO");
                intentEig.putExtra("IMAGE", R.drawable.ic_halo);
                intentEig.putExtra("BGCOLOR", 0xFF3e4041);
                startActivity(intentEig);
                break;
            case R.id.nine:
                Log.d("LevelPicker", "nine");
                Intent intentNin = new Intent(getBaseContext(), Game.class);
                intentNin.putExtra("LEVEL", 9);
                intentNin.putExtra("ANSWER", "HALF LIFE");
                intentNin.putExtra("IMAGE", R.drawable.ic_hl3);
                intentNin.putExtra("BGCOLOR", 0xFF875635);
                startActivity(intentNin);
                break;
            case R.id.ten:
                Log.d("LevelPicker", "ten");
                Intent intentTen = new Intent(getBaseContext(), Game.class);
                intentTen.putExtra("LEVEL", 10);
                intentTen.putExtra("ANSWER", "PARAPPA");
                intentTen.putExtra("IMAGE", R.drawable.ic_parappa);
                intentTen.putExtra("BGCOLOR", 0xFFf26222);
                startActivity(intentTen);



        }

    }

}
