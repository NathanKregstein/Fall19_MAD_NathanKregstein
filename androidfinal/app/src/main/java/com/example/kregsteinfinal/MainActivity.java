package com.example.kregsteinfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
//    private ToggleButton toggleButton1;
//    private ToggleButton toggleButton2;

    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private Switch glutenSwitch;
    private ToggleButton toggleButton;
    private EditText editText;
    private TextView suggestedBurrito;
    private Burrito burrito = new Burrito();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        checkBox1 = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        glutenSwitch = findViewById(R.id.switch1);
        editText = findViewById(R.id.editText);
        suggestedBurrito = findViewById(R.id.textView2);
        toggleButton = findViewById(R.id.toggleButton);
    }

    public void buildBurrito(View view){
        if(editText.getText().length() == 0){
            Context context = getApplicationContext();
            CharSequence textDisplay;
            textDisplay = "You must enter your name";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context,textDisplay,duration);
            toast.show();
        }
        else {
            if(toggleButton.isChecked()) {
                suggestedBurrito.setText(editText.getText() + " wants a burrito with meat");
            }
            else {
                suggestedBurrito.setText(editText.getText() + " wants a burrito with veggies");
            }

            if(glutenSwitch.isChecked()){
                suggestedBurrito.setText(suggestedBurrito.getText() + " in a corn tortilla");
            }

            if(checkBox1.isChecked()){
                suggestedBurrito.setText(suggestedBurrito.getText() + " and salsa");
            }
            if(checkBox2.isChecked()){
                suggestedBurrito.setText(suggestedBurrito.getText() + " and sour cream");
            }
            if(checkBox3.isChecked()){
                suggestedBurrito.setText(suggestedBurrito.getText() + " and cheese");
            }
            if(checkBox4.isChecked()){
                suggestedBurrito.setText(suggestedBurrito.getText() + " and guacamole");
            }

            switch (spinner.getSelectedItemPosition()){
                case 0:
                    suggestedBurrito.setText(suggestedBurrito.getText() + ". You should eat on the Hill");
                    break;
                case 1:
                    suggestedBurrito.setText(suggestedBurrito.getText() + ". You should eat at 29th Street");
                    break;
                case 2:
                    suggestedBurrito.setText(suggestedBurrito.getText() + ". You should eat at Pearl Street");
                    break;

                default:
                    suggestedBurrito.setText(suggestedBurrito.getText() + ". You should eat on the Hill");
                    break;
            }
        }
        if(!checkBox4.isChecked() && !checkBox3.isChecked() && !checkBox2.isChecked() && !checkBox1.isChecked()){
            Context context = getApplicationContext();
            CharSequence textDisplay;
            textDisplay = "Maybe add more to your burrito";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context,textDisplay,duration);
            toast.show();
        }


    }

    public void findRes(View view){
        burrito.setVar(spinner.getSelectedItemPosition());
        Intent intent = new Intent(this,SuggestingActivity.class);
        intent.putExtra("restaurantName", burrito.getLocation());
        intent.putExtra("restaurantURL", burrito.getLocationURL());
        startActivity(intent);
    }
}
