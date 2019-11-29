package com.example.lab8nk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FoundRestaurant extends AppCompatActivity {

    private String restaurant;
    private String restaurantURL;
    private String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found_restaurant);
        Intent intent = getIntent();
        restaurant = intent.getStringExtra("restaurantName");
        restaurantURL = intent.getStringExtra("restaurantURL");
        address = intent.getStringExtra("restaurantAddress");

        TextView restaurantText = findViewById(R.id.textViewRestaurant);
        restaurantText.setText(restaurant);
        TextView addressText = findViewById(R.id.textViewAddress);
        addressText.setText(address);
    }

    public void openMenu(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(restaurantURL));
        startActivity(intent);
    }
}
