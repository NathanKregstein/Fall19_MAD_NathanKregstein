package com.example.kregsteinfinal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class SuggestingActivity extends AppCompatActivity {
    private String restaurant;
    private String restaurantURL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggesting);

        Intent intent = getIntent();
        restaurant = intent.getStringExtra("restaurantName");
        restaurantURL = intent.getStringExtra("restaurantURL");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openURL();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView textView = findViewById(R.id.textView3);
        textView.setText("You should check out " + restaurant);
    }

    public void openURL(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(restaurantURL));
        startActivity(intent);
    }


}
