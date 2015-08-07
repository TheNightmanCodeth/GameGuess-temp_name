package com.diragi.gameguess;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game extends AppCompatActivity {

    TextView test;
    List<String> choices;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button ten;
    Button eleven;
    Button twelve;
    int current = 0;
    String answer = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        View view = findViewById(R.id.buttonOne);
        View root = view.getRootView();
        int bgColor = getIntent().getIntExtra("BGCOLOR", 0xFF000000);
        root.setBackgroundColor(bgColor);

        one = (Button)findViewById(R.id.buttonOne);
        two = (Button)findViewById(R.id.buttonTwo);
        three = (Button)findViewById(R.id.buttonThree);
        four = (Button)findViewById(R.id.buttonFour);
        five = (Button)findViewById(R.id.buttonFive);
        six = (Button)findViewById(R.id.buttonSix);
        seven = (Button)findViewById(R.id.buttonSeven);
        eight = (Button)findViewById(R.id.buttonEight);
        nine = (Button)findViewById(R.id.buttonNine);
        ten = (Button)findViewById(R.id.buttonTen);
        eleven = (Button)findViewById(R.id.buttonEleven);
        twelve = (Button)findViewById(R.id.buttonTwelve);


        int level = getIntent().getIntExtra("LEVEL", 1);
        String ans = getIntent().getStringExtra("ANSWER");
        int imgId = getIntent().getIntExtra("IMAGE", R.drawable.error);

        Drawable d = ContextCompat.getDrawable(getApplicationContext(), imgId);
        ImageView gameView = (ImageView)findViewById(R.id.imageView2);
        gameView.setImageDrawable(d);

        ArrayList<Character> game = makeLevel(ans);
        makeGame(game);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
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

    public ArrayList<Character> makeLevel(String answer){

        //Create an array with all of the letters of the answer, so we can assign each letter to a button
        String name = getIntent().getStringExtra("ANSWER");

        //Convert the array to a list so we can randomize and add to it
        ArrayList<Character> ans = new ArrayList<Character>();

        for (char c : name.toCharArray()){

            ans.add(c);

        }

        //get the length of the answer, if it's greater than 12 that's bad news
        if (ans.size() < 12){

            int howManyRand = 12 - ans.size();

            String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

            for (int i = 0; i < howManyRand; i++){

                int rand = new Random().nextInt(letters.length);
                String letter = (letters[rand]);
                Log.d("LETTER", letter);
                char letterChar = letter.charAt(0);
                if (ans.contains(letterChar)){
                    //Go again
                    i--;
                } else {
                    ans.add(letterChar);
                    Log.d("ARRAY", ans.toString());
                }

            }

        } else {
            //We're gunna need more buttons
        }

        return ans;

    }

    public void makeGame(ArrayList<Character> arrayList){

        //First, we need to get the array and randomize it.
        long seed = System.nanoTime();
        Collections.shuffle(arrayList, new Random(seed));
        Log.d("SHUFFLE: ", arrayList.toString());
        //Now that shit's shuffled up, we need to set all of the buttons to the right letter.

        one.setText(arrayList.get(0).toString());
        two.setText(arrayList.get(1).toString());
        three.setText(arrayList.get(2).toString());
        four.setText(arrayList.get(3).toString());
        five.setText(arrayList.get(4).toString());
        six.setText(arrayList.get(5).toString());
        seven.setText(arrayList.get(6).toString());
        eight.setText(arrayList.get(7).toString());
        nine.setText(arrayList.get(8).toString());
        ten.setText(arrayList.get(9).toString());
        eleven.setText(arrayList.get(10).toString());
        twelve.setText(arrayList.get(11).toString());

    }

    public void checkAnswer(View v){

        Button pressed = (Button)v;
        String buttonText = pressed.getText().toString();
        Log.d("Pressed: ", buttonText);
        //TODO: turn the answer into an array and check if each bytton press matches the position

        String name = getIntent().getStringExtra("ANSWER");

        //Convert the array to a list so we can randomize and add to it
        ArrayList<Character> ans = new ArrayList<Character>();

        for (char c : name.toCharArray()){

            ans.add(c);

        }



        if (buttonText.equals(ans.get(current).toString())){
            Log.d("COrrect", "answer");
            //Put the letter into the first textview
            answer = answer + ans.get(current).toString();
            TextView answerTextView = (TextView)findViewById(R.id.answerTextView);
            answerTextView.setText(answer);
            Log.d("TEST", String.valueOf(current) + String.valueOf(ans.size()) +" shit");
            int compare = ans.size() - 1;
            if (current == compare){
                //Win
                Toast.makeText(getApplicationContext(), "Win", Toast.LENGTH_SHORT).show();
            } else {
                current++;
            }
            v.setEnabled(false);

        } else {
            Log.d("wrong", "wrong");
        }

    }

}
