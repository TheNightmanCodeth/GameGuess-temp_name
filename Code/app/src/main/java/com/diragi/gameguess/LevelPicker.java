package com.diragi.gameguess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class LevelPicker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_picker);
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
                startActivity(intentOne);
                break;
            case R.id.two:
                //two
                Log.d("LevelPicker", "two");
                Intent intentTwo = new Intent(getBaseContext(), Game.class);
                intentTwo.putExtra("LEVEL", 2);
                intentTwo.putExtra("ANSWER", "PORTAL");
                startActivity(intentTwo);
                break;
        }

    }
}
