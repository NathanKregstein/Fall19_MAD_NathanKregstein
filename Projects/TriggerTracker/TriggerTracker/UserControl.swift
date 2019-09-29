//
//  UserControl.swift
//  TriggerTracker
//
//  Created by Nathan Kregstein on 9/26/19.
//  Copyright © 2019 Nathan Kregstein. All rights reserved.
//

import Foundation

class User{
    var untapTrigger = 0
    var upkeepTrigger = 0
    var drawTrigger = 0
    var mainPhase1Trigger = 0
    var combatTrigger = 0
    var mainPhase2Trigger = 0
    var endStepTrigger = 0
    
//    var phaseTrigger: [Int] = [0]
    
//    func initializePhaseArray(){
////            phaseTrigger = [untapTrigger, upkeepTrigger, drawTrigger, mainPhase1Trigger, combatTrigger, mainPhase2Trigger, endStepTrigger]
//    }
    
    func updateUserPhaseTriggers(_ phase:Int, _ triggerValue:Int){
        
        switch phase {
        case 0:
          untapTrigger = triggerValue
        case 1:
            upkeepTrigger = triggerValue
        case 2:
            drawTrigger = triggerValue
        case 3:
            mainPhase1Trigger = triggerValue
        case 4:
            combatTrigger = triggerValue
        case 5:
            mainPhase2Trigger = triggerValue
        case 6:
            endStepTrigger = triggerValue
        default:
            print("No Phase found")
        }
//        phaseTrigger[phase] = triggerValue
    }
    
//    func decrement(_ phase:Int){
//        if(phaseTrigger[phase] > 0){
//            phaseTrigger[phase] = phaseTrigger[phase] - 1
//        }
//    }
//    func increment(_ phase:Int){
//            phaseTrigger[phase] = phaseTrigger[phase] - 1
//    }
    
    
}
