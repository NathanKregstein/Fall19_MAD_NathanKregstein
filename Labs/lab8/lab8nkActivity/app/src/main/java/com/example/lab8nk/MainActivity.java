package com.example.lab8nk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Spinner typeSpinner;
    private Restaurant myRestaurant = new Restaurant();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        typeSpinner = findViewById(R.id.spinner);

    }

    public void findRes(View view){
        myRestaurant.setInfo(typeSpinner.getSelectedItemPosition());

        Intent intent = new Intent(this, FoundRestaurant.class);
        intent.putExtra("restaurantName", myRestaurant.getSelectedRestaurant());
        intent.putExtra("restaurantURL", myRestaurant.getRestaurantURL());
        intent.putExtra("restaurantAddress", myRestaurant.getAddress());
        startActivity(intent);

    }
}
