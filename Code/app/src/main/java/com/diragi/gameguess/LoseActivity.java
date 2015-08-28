package com.diragi.gameguess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class LoseActivity extends AppCompatActivity {

    int currentLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);

        currentLevel = getIntent().getIntExtra("LEVEL", 1);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lose, menu);
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

    @Override
    public void onBackPressed() {

        Intent home = new Intent(getBaseContext(), LevelPicker.class);
        startActivity(home);

    }

    public void onRetryClick(View v) {

        switch (currentLevel){
            case 1:
                //One
                Log.d("LevelPicker", "one");
                Intent intentOne = new Intent(getBaseContext(), Game.class);
                intentOne.putExtra("LEVEL", 1);
                intentOne.putExtra("ANSWER", "ZELDA");
                intentOne.putExtra("IMAGE", R.drawable.ic_zelda);
                intentOne.putExtra("BGCOLOR", 0xFF45b649);
                startActivity(intentOne);
                break;
            case 2:
                //two
                Log.d("LevelPicker", "two");
                Intent intentTwo = new Intent(getBaseContext(), Game.class);
                intentTwo.putExtra("LEVEL", 2);
                intentTwo.putExtra("ANSWER", "PORTAL");
                intentTwo.putExtra("IMAGE", R.drawable.ic_porta);
                intentTwo.putExtra("BGCOLOR", 0xFF454547);
                startActivity(intentTwo);
                break;
            case 3:
                //two
                Log.d("LevelPicker", "three");
                Intent intentThree = new Intent(getBaseContext(), Game.class);
                intentThree.putExtra("LEVEL", 3);
                intentThree.putExtra("ANSWER", "BIOSHOCK");
                intentThree.putExtra("IMAGE", R.drawable.ic_bioshock);
                intentThree.putExtra("BGCOLOR", 0xFF7c6136);
                startActivity(intentThree);
                break;
            case 4:
                //two
                Log.d("LevelPicker", "four");
                Intent intentFour = new Intent(getBaseContext(), Game.class);
                intentFour.putExtra("LEVEL", 4);
                intentFour.putExtra("ANSWER", "LAST OF US");
                intentFour.putExtra("IMAGE", R.drawable.ic_lou);
                intentFour.putExtra("BGCOLOR", 0xFF4b575d);
                startActivity(intentFour);
                break;
            case 5:
                Log.d("LevelPicker", "five");
                Intent intentFive = new Intent(getBaseContext(), Game.class);
                intentFive.putExtra("LEVEL", 5);
                intentFive.putExtra("ANSWER", "JAK & DAXTER");
                intentFive.putExtra("IMAGE", R.drawable.ic_jakanddaxter);
                intentFive.putExtra("BGCOLOR", 0xFF8A5937);
                startActivity(intentFive);
                break;
            case 6:
                Log.d("LevelPicker", "six");
                Intent intentSix = new Intent(getBaseContext(), Game.class);
                intentSix.putExtra("LEVEL", 6);
                intentSix.putExtra("ANSWER", "METROID");
                intentSix.putExtra("IMAGE", R.drawable.ic_metroid);
                intentSix.putExtra("BGCOLOR", 0xFF84b839);
                startActivity(intentSix);
                break;
            case 7:
                Log.d("LevelPicker", "seven");
                Intent intentSev = new Intent(getBaseContext(), Game.class);
                intentSev.putExtra("LEVEL", 7);
                intentSev.putExtra("ANSWER", "GTA");
                intentSev.putExtra("IMAGE", R.drawable.ic_gta);
                intentSev.putExtra("BGCOLOR", 0xFFfdcc9d);
                startActivity(intentSev);
                break;

        }

    }
}
