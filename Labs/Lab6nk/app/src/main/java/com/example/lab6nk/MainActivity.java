package com.example.lab6nk;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void generateStreetName(View view){
        EditText name = findViewById(R.id.editText);
        String nameValue = name.getText().toString();

        EditText month = findViewById(R.id.editText2);
        int monthvalue;
        if (!month.getText().toString().isEmpty()) {
            monthvalue = Integer.parseInt(month.getText().toString());
        }
        else{
           monthvalue = 0;
        }
//        int monthvalue = month.getText().
        String streetAdjective;

        switch (monthvalue){
            case 1:
                streetAdjective = "Cool ";
                break;
            case 2:
                streetAdjective = "Lil ";
                break;
            case 3:
                streetAdjective = "Bad Boy ";
                break;
            case 4:
                streetAdjective = "The cooler ";
                break;
            case 5:
                streetAdjective = "Killer ";
                break;
            case 6:
                streetAdjective = "Pusher Boi ";
                break;
            case 7:
                streetAdjective = "Big Q ";
                break;
            case 8:
                streetAdjective = "Supa ";
                break;
            case 9:
                streetAdjective = "Crazy ";
                break;
            case 10:
                streetAdjective = "Bad A$$ ";
                break;
            case 11:
                streetAdjective = "Good kid ";
                break;
            case 12:
                streetAdjective = "NO smiles ";
                break;
                default:
                    streetAdjective = "Rule Breaker ";




        }

        TextView streetName = findViewById(R.id.textView2);
        streetName.setText(streetAdjective + nameValue);

        ImageView coolKidsImage = findViewById(R.id.imageView);
        coolKidsImage.setImageResource(R.drawable.coolkids);
    }
}
