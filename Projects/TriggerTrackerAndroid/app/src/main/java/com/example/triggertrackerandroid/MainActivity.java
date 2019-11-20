package com.example.triggertrackerandroid;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    GameTracker mygame;

    ToggleButton turnPreview;

    TextView untapTriggerVisuals;
    TextView upkeepTriggerVisuals;
    TextView drawTriggerVisuals;
    TextView mainPhase1TriggerVisuals;
    TextView combatTriggerVisuals;
    TextView mainPhase2TriggerVisuals;
    TextView endStepTriggerVisuals;

    TextView untapVisuals;
    TextView upkeepVisuals;
    TextView drawVisuals;
    TextView mainPhase1Visuals;
    TextView combatVisuals;
    TextView mainPhase2Visuals;
    TextView endStepVisuals;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        untapTriggerVisuals = (TextView) findViewById(R.id.untapTriggers);
        upkeepTriggerVisuals = (TextView) findViewById(R.id.upkeepTriggers);
        drawTriggerVisuals = (TextView) findViewById(R.id.drawTriggers);
        mainPhase1TriggerVisuals = (TextView) findViewById(R.id.mainPhase1Triggers);
        combatTriggerVisuals = (TextView) findViewById(R.id.combatTriggers);
        mainPhase2TriggerVisuals = (TextView) findViewById(R.id.mainPhase2Triggers);
        endStepTriggerVisuals = (TextView) findViewById(R.id.endStepTriggers);

        untapVisuals =  findViewById(R.id.untap);
        upkeepVisuals =  findViewById(R.id.upkeep);
        drawVisuals =  findViewById(R.id.draw);
        mainPhase1Visuals =  findViewById(R.id.mainPhase1);
        combatVisuals =  findViewById(R.id.combat);
        mainPhase2Visuals =  findViewById(R.id.mainPhase2);
        endStepVisuals = findViewById(R.id.endStep);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        turnPreview = findViewById(R.id.toggleButton) ;
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               nextPhase();
            }
        });
        mygame = new GameTracker();
        changeHighlight();
    }

    public void nextPhase(){
        if(mygame.nextPhase()){
            Context context = getApplicationContext();
            CharSequence textDisplay;
            Log.i("triggers", String.valueOf(mygame.yourTurnTriggers[mygame.getCurrentPhase()]) );
            if(mygame.yourTurn) {
                textDisplay = "You have " + mygame.yourTurnTriggers[mygame.getCurrentPhase()] + " triggers this phase";
            }
            else{
                textDisplay = "you have " + mygame.enemyTurnTriggers[mygame.getCurrentPhase()] + " triggers this phase";
            }
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context,textDisplay,duration);
            View view = toast.getView();
            view.setBackgroundColor(getResources().getColor(R.color.primaryLightColor));
            toast.show();
        }
        changeHighlight();
    }

    private void changeHighlight(){
        if(mygame.yourTurn == turnPreview.isChecked()) {
            switch (mygame.getCurrentPhase()) {
                case 0:
                    untapVisuals.setTextColor(getResources().getColor(R.color.highlight));
                    endStepVisuals.setTextColor(getResources().getColor(R.color.primaryTextColor));
                    break;
                case 1:
                    upkeepVisuals.setTextColor(getResources().getColor(R.color.highlight));
                    untapVisuals.setTextColor(getResources().getColor(R.color.primaryTextColor));
                    break;
                case 2:
                    drawVisuals.setTextColor(getResources().getColor(R.color.highlight));
                    upkeepVisuals.setTextColor(getResources().getColor(R.color.primaryTextColor));
                    break;
                case 3:
                    mainPhase1Visuals.setTextColor(getResources().getColor(R.color.highlight));
                    drawVisuals.setTextColor(getResources().getColor(R.color.primaryTextColor));
                    break;
                case 4:
                    combatVisuals.setTextColor(getResources().getColor(R.color.highlight));
                    mainPhase1Visuals.setTextColor(getResources().getColor(R.color.primaryTextColor));
                    break;
                case 5:
                    mainPhase2Visuals.setTextColor(getResources().getColor(R.color.highlight));
                    combatVisuals.setTextColor(getResources().getColor(R.color.primaryTextColor));
                    break;
                case 6:
                    endStepVisuals.setTextColor(getResources().getColor(R.color.highlight));
                    mainPhase2Visuals.setTextColor(getResources().getColor(R.color.primaryTextColor));
                    break;
                default:
                    break;
            }
        }
        else{
            endStepVisuals.setTextColor(getResources().getColor(R.color.primaryTextColor));
            untapVisuals.setTextColor(getResources().getColor(R.color.primaryTextColor));
            upkeepVisuals.setTextColor(getResources().getColor(R.color.primaryTextColor));
            drawVisuals.setTextColor(getResources().getColor(R.color.primaryTextColor));
            mainPhase1Visuals.setTextColor(getResources().getColor(R.color.primaryTextColor));
            combatVisuals.setTextColor(getResources().getColor(R.color.primaryTextColor));
            mainPhase2Visuals.setTextColor(getResources().getColor(R.color.primaryTextColor));

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void increase(View view){
//        view.getId();
        String name = getResources().getResourceEntryName(view.getId());
        if(turnPreview.isChecked()) {
            switch (name) {
                case "incUntap":
                    mygame.increaseUntapYou();
                    break;
                case "incUpkeep":
                    mygame.increaseUpkeepYou();
                    break;
                case "incDraw":
                    mygame.increaseDrawYou();
                    break;
                case "incMain1":
                    mygame.increaseMainPhase1You();
                    break;
                case "incCombat":
                    mygame.increaseCombatYou();
                    break;
                case "incMain2":
                    mygame.increaseMainPhase2You();
                    break;
                case "incEndStep":
                    mygame.increaseEndStepYou();
                    break;
                default:
                    Log.i("incError", "Increase id not found");
                    break;

            }
        }
        else{
            switch (name) {
                case "incUntap":
                    mygame.increaseUntapEnemy();
                    break;
                case "incUpkeep":
                    mygame.increaseUpkeepEnemy();
                    break;
                case "incDraw":
                    mygame.increaseDrawEnemy();
                    break;
                case "incMain1":
                    mygame.increaseMainPhase1Enemy();
                    break;
                case "incCombat":
                    mygame.increaseCombatEnemy();
                    break;
                case "incMain2":
                    mygame.increaseMainPhase2Enemy();
                    break;
                case "incEndStep":
                    mygame.increaseEndStepEnemy();
                    break;
                default:
                    Log.i("incError", "Increase id not found");
                    break;

            }
        }
        updateVisuals();
    }

    public void decrease(View view){
        String name = getResources().getResourceEntryName(view.getId());
        if(turnPreview.isChecked()) {
            switch (name) {
                case "decUntap":
                    mygame.decUntapYou();
                    break;
                case "decUpkeep":
                    mygame.decUpkeepYou();
                    break;
                case "decDraw":
                    mygame.decDrawYou();
                    break;
                case "decMain1":
                    mygame.decMainPhase1You();
                    break;
                case "decCombat":
                    mygame.decCombatYou();
                    break;
                case "decMain2":
                    mygame.decMainPhase2You();
                    break;
                case "incEndStep":
                    mygame.decEndStepYou();
                    break;
                default:
                    Log.i("decError", "Decrease id not found");
                    break;

            }
        }
        else{
            switch (name) {
                case "decUntap":
                    mygame.decUntapEnemy();
                    break;
                case "decUpkeep":
                    mygame.decUpkeepEnemy();
                    break;
                case "decDraw":
                    mygame.decDrawEnemy();
                    break;
                case "decMain1":
                    mygame.decMainPhase1Enemy();
                    break;
                case "decCombat":
                    mygame.decCombatEnemy();
                    break;
                case "decMain2":
                    mygame.decMainPhase2Enemy();
                    break;
                case "decEndStep":
                    mygame.decEndStepEnemy();
                    break;
                default:
                    Log.i("decError", "Decrease id not found");
                    break;

            }
        }
        updateVisuals();
    }
    public void updateVisuals(){
        if(turnPreview.isChecked()) {
            untapTriggerVisuals.setText(mygame.yourTurnTriggers[0] + " Triggers");
            upkeepTriggerVisuals.setText(mygame.yourTurnTriggers[1] + " Triggers");
            drawTriggerVisuals.setText(mygame.yourTurnTriggers[2] + " Triggers");
            mainPhase1TriggerVisuals.setText(mygame.yourTurnTriggers[3] + " Triggers");
            combatTriggerVisuals.setText(mygame.yourTurnTriggers[4] + " Triggers");
            mainPhase2TriggerVisuals.setText(mygame.yourTurnTriggers[5] + " Triggers");
            endStepTriggerVisuals.setText(mygame.yourTurnTriggers[6] + " Triggers");
        }
        else{
            untapTriggerVisuals.setText(mygame.enemyTurnTriggers[0] + " Triggers");
            upkeepTriggerVisuals.setText(mygame.enemyTurnTriggers[1] + " Triggers");
            drawTriggerVisuals.setText(mygame.enemyTurnTriggers[2] + " Triggers");
            mainPhase1TriggerVisuals.setText(mygame.enemyTurnTriggers[3] + " Triggers");
            combatTriggerVisuals.setText(mygame.enemyTurnTriggers[4] + " Triggers");
            mainPhase2TriggerVisuals.setText(mygame.enemyTurnTriggers[5] + " Triggers");
            endStepTriggerVisuals.setText(mygame.enemyTurnTriggers[6] + " Triggers");
        }
    }

    public void switchShownTurn(View view){
        updateVisuals();
        changeHighlight();
    }

}
