package com.example.triggertrackerandroid;

import android.view.View;

public class GameTracker {
    public int[] yourTurnTriggers = {0,0,0,0,0,0,0};
    public int[] enemyTurnTriggers = {0,0,0,0,0,0,0};
    public boolean yourTurn = true;

    private int currentPhase = 0;

    public int getCurrentPhase() {
        return currentPhase;
    }

    public boolean nextPhase(){
        if (currentPhase < 6){
            currentPhase++;
        }
        else{
            yourTurn =! yourTurn;
            currentPhase = 0;
        }
        return checkTriggers();
    }

    public boolean checkTriggers(){
        if(yourTurn){
            if(yourTurnTriggers[currentPhase]>0){
                return true;
            }
        }
        else{
            if(enemyTurnTriggers[currentPhase]>0){
                return true;
            }
        }
        return false;
    }

    //increase your trigger functions
    public void increaseUntapYou(){
        yourTurnTriggers[0] = yourTurnTriggers[0] + 1;
    }

    public void increaseUpkeepYou(){
            yourTurnTriggers[1] = yourTurnTriggers[1] + 1;
    }

    public void increaseDrawYou(){
            yourTurnTriggers[2] = yourTurnTriggers[2] + 1;
    }

    public void increaseMainPhase1You(){
        yourTurnTriggers[3] = yourTurnTriggers[3] + 1;
    }

    public void increaseCombatYou(){
        yourTurnTriggers[4] = yourTurnTriggers[4] + 1;
    }

    public void increaseMainPhase2You(){
        yourTurnTriggers[5] = yourTurnTriggers[5] + 1;
    }

    public void increaseEndStepYou(){
        yourTurnTriggers[6] = yourTurnTriggers[6] + 1;
    }

//increase triggers on enemies turn

    public void increaseUntapEnemy(){
        enemyTurnTriggers[0] = enemyTurnTriggers[0] + 1;
    }

    public void increaseUpkeepEnemy(){
        enemyTurnTriggers[1] = enemyTurnTriggers[1] + 1;
    }

    public void increaseDrawEnemy(){
        enemyTurnTriggers[2] = enemyTurnTriggers[2] + 1;
    }

    public void increaseMainPhase1Enemy(){
        enemyTurnTriggers[3] = enemyTurnTriggers[3] + 1;
    }

    public void increaseCombatEnemy(){
        enemyTurnTriggers[4] = enemyTurnTriggers[4] + 1;
    }

    public void increaseMainPhase2Enemy(){
        enemyTurnTriggers[5] = enemyTurnTriggers[5] + 1;
    }

    public void increaseEndStepEnemy(){
        enemyTurnTriggers[6] = enemyTurnTriggers[6] + 1;
    }



    //decrease triggers
    public void decUntapYou(){
        if(yourTurnTriggers[0]!= 0)
        yourTurnTriggers[0] = yourTurnTriggers[0] - 1;
    }

    public void decUpkeepYou(){
        if(yourTurnTriggers[1]!= 0)
        yourTurnTriggers[1] = yourTurnTriggers[1] - 1;
    }

    public void decDrawYou(){
        if(yourTurnTriggers[2]!= 0)
        yourTurnTriggers[2] = yourTurnTriggers[2] - 1;
    }

    public void decMainPhase1You(){
        if(yourTurnTriggers[3]!= 0)
        yourTurnTriggers[3] = yourTurnTriggers[3] - 1;
    }

    public void decCombatYou(){
        if(yourTurnTriggers[4]!= 0)
        yourTurnTriggers[4] = yourTurnTriggers[4] - 1;
    }

    public void decMainPhase2You(){
        if(yourTurnTriggers[5]!= 0)
        yourTurnTriggers[5] = yourTurnTriggers[5] - 1;
    }

    public void decEndStepYou(){
        if(yourTurnTriggers[6]!= 0)
        yourTurnTriggers[6] = yourTurnTriggers[6] - 1;
    }

//increase triggers on enemies turn

    public void decUntapEnemy(){
        if(enemyTurnTriggers[0]!= 0)
        enemyTurnTriggers[0] = enemyTurnTriggers[0] + 1;
    }

    public void decUpkeepEnemy(){
        if(enemyTurnTriggers[1]!= 0)
        enemyTurnTriggers[1] = enemyTurnTriggers[1] - 1;
    }

    public void decDrawEnemy(){
        if(enemyTurnTriggers[2]!= 0)
        enemyTurnTriggers[2] = enemyTurnTriggers[2] - 1;
    }

    public void decMainPhase1Enemy(){
        if(enemyTurnTriggers[3]!= 0)
        enemyTurnTriggers[3] = enemyTurnTriggers[3] - 1;
    }

    public void decCombatEnemy(){
        if(enemyTurnTriggers[4]!= 0)
        enemyTurnTriggers[4] = enemyTurnTriggers[4] - 1;
    }

    public void decMainPhase2Enemy(){
        if(enemyTurnTriggers[5]!= 0)
        enemyTurnTriggers[5] = enemyTurnTriggers[5] - 1;
    }

    public void decEndStepEnemy(){
        if(enemyTurnTriggers[6]!= 0)
        enemyTurnTriggers[6] = enemyTurnTriggers[6] - 1;
    }

//    public  void increase(View view){
//        //switch statement from id to decide which variable is increased
////        switch (view){
////
////        }
//    }

//    public  void decrease(View view){
//
//    }



}
