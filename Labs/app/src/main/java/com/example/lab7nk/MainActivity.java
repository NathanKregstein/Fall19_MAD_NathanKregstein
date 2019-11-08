package com.example.lab7nk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.security.Key;

public class MainActivity extends AppCompatActivity {

    private TextView bestGame;
    private ToggleButton toggle;
    private Spinner genre;
    private RadioGroup price;
    private CheckBox PCCheckBox;
    private CheckBox SwitchCheckBox;
    private CheckBox XboxOneCheckBox;
    private CheckBox PS4CheckBox;
    String GameToGet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bestGame = findViewById(R.id.textView2);
        toggle = findViewById(R.id.toggleButton);
        genre = findViewById(R.id.spinner);
        price = findViewById(R.id.radioGroup);
        PCCheckBox = findViewById(R.id.check1);
        SwitchCheckBox = findViewById(R.id.check2);
        XboxOneCheckBox = findViewById(R.id.check3);
        PS4CheckBox = findViewById(R.id.check4);

        if(savedInstanceState != null){
            GameToGet = savedInstanceState.getString("result");
            bestGame.setText(GameToGet + " is the game you should buy");
        }
    }

    public void calculateGame(View view){

        boolean newOrOld = toggle.isChecked();
        String GenreString = String.valueOf(genre.getSelectedItem());
        int priceID = price.getCheckedRadioButtonId();

        boolean PC = PCCheckBox.isChecked();
        boolean Switch = SwitchCheckBox.isChecked();
        boolean XboxOne = XboxOneCheckBox.isChecked();
        boolean PS4 = PS4CheckBox.isChecked();



        if(PC||Switch||XboxOne||PS4){
            if(priceID == -1){
                Context context = getApplicationContext();
                CharSequence text = "Please select a price range";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
            else{
                if(newOrOld){ // if new
                    if(priceID == R.id.radioButton){
                        switch (GenreString){
                            case "Platformer":
                                GameToGet = "Celeste";
                                break;
                            case "Fighter":
                                GameToGet = "Dragon Ball FighterZ";
                                break;
                            case "RPG":
                                GameToGet = "StarDew Valley";
                                break;
                            default:
                                GameToGet = "Celeste";
                                break;
                        }

                    }
                    else{
                        switch (GenreString){
                            case "Platformer":
                                GameToGet = "MarioMaker 2";
                                break;
                            case "Fighter":
                                GameToGet = "Super Smash Bros. Ultimate";
                                break;
                            case "RPG":
                                GameToGet = "OuterWorlds";
                                break;
                            default:
                                GameToGet = "MarioMaker 2";
                                break;
                        }
                    }

                }


                else{ //if old
                        switch (GenreString){
                            case "Platformer":
                                GameToGet = "Crash Bandicoot";
                                break;
                            case "Fighter":
                                GameToGet = "Mortal Kombat";
                                break;
                            case "RPG":
                                GameToGet = "Fallout 3";
                                break;
                            default:
                                GameToGet = "Crash Bandicoot";
                                break;
                        }
                    }

                    bestGame.setText(GameToGet + " is the game you should buy");

                }
        }
        else{
            Context context = getApplicationContext();
            CharSequence text = "Please select a gaming sytem";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("result", GameToGet );

    }
}
