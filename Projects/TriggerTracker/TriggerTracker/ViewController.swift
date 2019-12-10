//
//  ViewController.swift
//  TriggerTracker
//
//  Created by Nathan Kregstein on 9/26/19.
//  Copyright © 2019 Nathan Kregstein. All rights reserved.
//

import UIKit
import SafariServices

class ViewController: UIViewController {
    var currentPhase = 0;
    var you = User()
    var enemy = User()
    var phaseArray: [Int] = [0,0,0,0,0,0,0,0,0,0,0,0,0,0]
     var Gold = UIColor.init(red: 0.83, green: 0.68, blue: 0.21, alpha: 1)
    
    @IBOutlet weak var untapTriggerShown: UILabel!
    @IBOutlet weak var upkeepTriggerShown: UILabel!
    @IBOutlet weak var drawTriggerShown: UILabel!
    @IBOutlet weak var mainPhase1TriggerShown: UILabel!
    @IBOutlet weak var combatTriggerShown: UILabel!
    @IBOutlet weak var mainPhase2TriggerShown: UILabel!
    @IBOutlet weak var endTriggerShown: UILabel!
    
    @IBOutlet weak var untapLabel: UILabel!
    @IBOutlet weak var upkeepLabel: UILabel!
    @IBOutlet weak var drawLabel: UILabel!
    @IBOutlet weak var mainPhase1Label: UILabel!
    @IBOutlet weak var combatLabel: UILabel!
    @IBOutlet weak var mainPhase2Label: UILabel!
    @IBOutlet weak var endStepLabel: UILabel!
    
  
    
    
    @IBOutlet weak var untapStepperValue: UIStepper!
    @IBOutlet weak var upkeepStepperValue: UIStepper!
    @IBOutlet weak var drawStepperValue: UIStepper!
    @IBOutlet weak var mainPhase1StepperValue: UIStepper!
    @IBOutlet weak var combatStepperValue: UIStepper!
    @IBOutlet weak var mainPhase2StepperValue: UIStepper!
    
    @IBOutlet weak var endStepStepperValue: UIStepper!
    
    @IBAction func NextPhaseButton(_ sender: UIButton) {
        nextPhase()
    }
    
    @IBOutlet weak var playerTracker: UISegmentedControl!
    
    @IBAction func incrementTrigger(_ sender: UIStepper) {
        if playerTracker.selectedSegmentIndex == 0{
            you.updateUserPhaseTriggers(sender.tag, Int(sender.value))
        }
        else{
            enemy.updateUserPhaseTriggers(sender.tag, Int(sender.value))
        }
        updateAllTriggersShown()
        phaseArray = [you.untapTrigger, you.upkeepTrigger, you.drawTrigger, you.mainPhase1Trigger, you.combatTrigger, you.mainPhase2Trigger, you.endStepTrigger, enemy.untapTrigger, enemy.upkeepTrigger, enemy.drawTrigger, enemy.mainPhase1Trigger, enemy.combatTrigger, enemy.mainPhase2Trigger,enemy.endStepTrigger]
    }
    
    @IBAction func InfoDisplay(_ sender: UIButton) {
        if let url = URL(string: "https://primagames.com/tips/magic-gathering-phases-guide"){
            let infoVC = SFSafariViewController(url: url)
            present(infoVC, animated: true)
        }
        else if let url = URL(string: "https://magic.wizards.com/en/articles/archive/magic-academy/dynamics-turn-2006-11-04"){
            let infoVC = SFSafariViewController(url: url)
            present(infoVC, animated: true)
        }
        
        //based on https://www.youtube.com/watch?v=gnjXbR2eNDE
        
    }
    
    @IBAction func changePlayerTurnShown(_ sender: UISegmentedControl) {
        updateAllTriggersShown()
        updateSimpleLabels()
    }
    
    
    func updateAllTriggersShown(){
        if playerTracker.selectedSegmentIndex == 0{
//            untapTriggerShown.text = String(you.untapTrigger) + " Triggers"
//            upkeepTriggerShown.text = String(you.upkeepTrigger) + " Triggers"
//            drawTriggerShown.text = String(you.drawTrigger) + " Triggers"
//            mainPhase1TriggerShown.text = String(you.mainPhase1Trigger) + " Triggers"
//            combatTriggerShown.text = String(you.combatTrigger) + " Triggers"
//            mainPhase2TriggerShown.text = String(you.mainPhase2Trigger) + " Triggers"
//            endTriggerShown.text = String(you.endStepTrigger) + " Triggers"
            
            untapStepperValue.value = Double(you.untapTrigger)
            upkeepStepperValue.value = Double(you.upkeepTrigger)
            drawStepperValue.value = Double(you.drawTrigger)
            mainPhase1StepperValue.value = Double(you.mainPhase1Trigger)
            combatStepperValue.value = Double(you.combatTrigger)
            mainPhase2StepperValue.value = Double(you.mainPhase2Trigger)
            endStepStepperValue.value = Double(you.endStepTrigger)
            
            
        }
        else if playerTracker.selectedSegmentIndex == 1{
//            untapTriggerShown.text = String(enemy.untapTrigger) + " Triggers"
//            upkeepTriggerShown.text = String(enemy.upkeepTrigger) + " Triggers"
//            drawTriggerShown.text = String(enemy.drawTrigger) + " Triggers"
//            mainPhase1TriggerShown.text = String(enemy.mainPhase1Trigger) + " Triggers"
//            combatTriggerShown.text = String(enemy.combatTrigger) + " Triggers"
//            mainPhase2TriggerShown.text = String(enemy.mainPhase2Trigger) + " Triggers"
//            endTriggerShown.text = String(enemy.endStepTrigger) + " Triggers"
//
            untapStepperValue.value = Double(enemy.untapTrigger)
            upkeepStepperValue.value = Double(enemy.upkeepTrigger)
            drawStepperValue.value = Double(enemy.drawTrigger)
            mainPhase1StepperValue.value = Double(enemy.mainPhase1Trigger)
            combatStepperValue.value = Double(enemy.combatTrigger)
            mainPhase2StepperValue.value = Double(enemy.mainPhase2Trigger)
            endStepStepperValue.value = Double(enemy.endStepTrigger)
        }
        updateVisuals()
    }
    override func viewDidLoad() {
//        you.initializePhaseArray()
//        enemy.initializePhaseArray()
        
//        untapLabel.textColor = Gold
        updateSimpleLabels()
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    func updateVisuals(){
        untapTriggerShown.text = String(format: "%.0f",untapStepperValue.value) + " Triggers"
        upkeepTriggerShown.text = String(format: "%.0f",upkeepStepperValue.value) + " Triggers"
        drawTriggerShown.text = String(format: "%.0f",drawStepperValue.value) + " Triggers"
        mainPhase1TriggerShown.text = String(format: "%.0f",mainPhase1StepperValue.value) + " Triggers"
        combatTriggerShown.text = String(format: "%.0f",combatStepperValue.value) + " Triggers"
        mainPhase2TriggerShown.text = String(format: "%.0f",mainPhase2StepperValue.value) + " Triggers"
        endTriggerShown.text = String(format: "%.0f",endStepStepperValue.value) + " Triggers"
    }
    
    func updateSimpleLabels(){
        if playerTracker.selectedSegmentIndex == 0{
            untapLabel.textColor = UIColor.blue
            upkeepLabel.textColor = UIColor.blue
            drawLabel.textColor = UIColor.blue
            mainPhase1Label.textColor = UIColor.blue
            combatLabel.textColor = UIColor.blue
            mainPhase2Label.textColor = UIColor.blue
            endStepLabel.textColor = UIColor.blue
            
            playerTracker.tintColor = UIColor.blue
            
        }
        else if playerTracker.selectedSegmentIndex == 1{
            untapLabel.textColor = UIColor.purple
            upkeepLabel.textColor = UIColor.purple
            drawLabel.textColor = UIColor.purple
            mainPhase1Label.textColor = UIColor.purple
            combatLabel.textColor = UIColor.purple
            mainPhase2Label.textColor = UIColor.purple
            endStepLabel.textColor = UIColor.purple
            
            playerTracker.tintColor = UIColor.purple
        }
        displayCurrentPhase()
        
    }
    func nextPhase(){
        if(currentPhase < 13){
            currentPhase = currentPhase + 1
        }
        else{
            currentPhase = 0
            playerTracker.selectedSegmentIndex = 0
            changePlayerTurnShown(playerTracker)
        }
        checkPhase()
        if currentPhase == 7{
            playerTracker.selectedSegmentIndex = 1
            changePlayerTurnShown(playerTracker)
        }
        updateSimpleLabels()
    }
    
    func checkPhase(){
        if(phaseArray[currentPhase] > 0){
            showTriggerAlert()
        }
    }
    func displayCurrentPhase(){
        if playerTracker.selectedSegmentIndex == 0{
            switch currentPhase {
            case 0:
                untapLabel.textColor = Gold
            case 1:
                upkeepLabel.textColor = Gold
            case 2:
                drawLabel.textColor = Gold
            case 3:
                mainPhase1Label.textColor = Gold
            case 4:
                combatLabel.textColor = Gold
            case 5:
                mainPhase2Label.textColor = Gold
            case 6:
                endStepLabel.textColor = Gold
            default:
                print ("No case found in displayCurrentPhase")
            }
        }
        else if playerTracker.selectedSegmentIndex == 1{
            switch currentPhase {
            case 7:
                untapLabel.textColor = Gold
            case 8:
                upkeepLabel.textColor = Gold
            case 9:
                drawLabel.textColor = Gold
            case 10:
                mainPhase1Label.textColor = Gold
            case 11:
                combatLabel.textColor = Gold
            case 12:
                mainPhase2Label.textColor = Gold
            case 13:
                endStepLabel.textColor = Gold
            default:
                print ("No case found in displayCurrentPhase")
            }
        }
 
    }
    
    func showTriggerAlert(){
        let alert=UIAlertController(title: "Check your Cards", message: "You have " + String(phaseArray[currentPhase]) + " triggers this phase", preferredStyle: UIAlertController.Style.alert)
        //create a UIAlertAction object for the button
        let cancelAction=UIAlertAction(title: "Resolved", style:UIAlertAction.Style.cancel, handler: nil)
        alert.addAction(cancelAction) //adds the alert action to the alert object
        
//        let okAction=UIAlertAction(title: "OK", style: UIAlertAction.Style.default, handler: {action in
//        })
//        alert.addAction(okAction)
        present(alert, animated: true, completion: nil)
    }

}

