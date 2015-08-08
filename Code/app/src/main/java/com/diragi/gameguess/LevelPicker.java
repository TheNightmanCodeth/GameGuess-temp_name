package com.diragi.gameguess;

import android.content.Intent;
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

public class LevelPicker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_picker);
        int buttonId = getIntent().getIntExtra("BUTTONID", 0);

        if (buttonId != 0){

            Button buttonToChange = (Button)findViewById(buttonId);
            buttonToChange.setBackgroundColor(Color.RED);

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
                intentOne.putExtra("IMAGE", R.drawable.zelda);
                intentOne.putExtra("BGCOLOR", 0xFF45b649);
                startActivity(intentOne);
                break;
            case R.id.two:
                //two
                Log.d("LevelPicker", "two");
                Intent intentTwo = new Intent(getBaseContext(), Game.class);
                intentTwo.putExtra("LEVEL", 2);
                intentTwo.putExtra("ANSWER", "PORTAL");
                intentTwo.putExtra("IMAGE", R.drawable.porta);
                intentTwo.putExtra("BGCOLOR", 0xFF454547);
                startActivity(intentTwo);
                break;
            case R.id.three:
                //two
                Log.d("LevelPicker", "three");
                Intent intentThree = new Intent(getBaseContext(), Game.class);
                intentThree.putExtra("LEVEL", 3);
                intentThree.putExtra("ANSWER", "BIOSHOCK");
                intentThree.putExtra("IMAGE", R.drawable.bioshock);
                intentThree.putExtra("BGCOLOR", 0xFF7c6136);
                startActivity(intentThree);
                break;
            case R.id.four:
                //two
                Log.d("LevelPicker", "four");
                Intent intentFour = new Intent(getBaseContext(), Game.class);
                intentFour.putExtra("LEVEL", 4);
                intentFour.putExtra("ANSWER", "LAST OF US");
                intentFour.putExtra("IMAGE", R.drawable.lou);
                intentFour.putExtra("BGCOLOR", 0xFF4b575d);
                startActivity(intentFour);
                break;
        }

    }

}
