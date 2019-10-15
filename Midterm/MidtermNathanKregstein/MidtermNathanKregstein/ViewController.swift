//
//  ViewController.swift
//  MidtermNathanKregstein
//
//  Created by Nathan Kregstein on 10/15/19.
//  Copyright © 2019 Nathan Kregstein. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet weak var roundTripCommuteMiles: UITextField!
    @IBOutlet weak var tranportsegment: UISegmentedControl!
    @IBOutlet weak var transportImage: UIImageView!
    @IBOutlet weak var gasInTankDisplay: UILabel!
    @IBOutlet weak var gasInTankValue: UISlider!
    @IBOutlet weak var totalCommuteTime: UILabel!
    @IBOutlet weak var gasToPurchase: UILabel!
    @IBOutlet weak var showMonthlyCommute: UISwitch!
    
    @IBAction func gasInTankChange(_ sender: UISlider) {
        gasInTankDisplay.text = String(format: "%.0f", gasInTankValue.value) + " gallons"
        if (sender.value <= 1){
            let alert=UIAlertController(title: "Warning", message: "You are running out of gas", preferredStyle: UIAlertController.Style.alert)
            let understoodAction = UIAlertAction(title: "Understood", style:UIAlertAction.Style.cancel, handler: nil)
            alert.addAction(understoodAction)
            present(alert, animated: true, completion: nil)
        }
    }
    @IBAction func commuteSwitchChange(_ sender: UISwitch) {
        commuteCalculations()
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    @IBAction func changeTransport(_ sender: UISegmentedControl) {
        switch sender.selectedSegmentIndex {
        case 0:
            transportImage.image = UIImage.init(named: "car_icon")
        case 1:
            transportImage.image = UIImage.init(named: "bus_icon")
        case 2:
            transportImage.image = UIImage.init(named: "bike_icon")
        default:
            transportImage.image = UIImage.init(named: "car_icon")
        }
        commuteCalculations()
    }
    
    @IBAction func computeCommute(_ sender: Any) {
        commuteCalculations()
    }
    
    func commuteCalculations(){
        var totalMiles = Float(0.0)
        if roundTripCommuteMiles.text!.isEmpty{

        }
        else{
            if(showMonthlyCommute.isOn){
                totalMiles = (Float(roundTripCommuteMiles.text!)!) * 20
            }
            else{
                totalMiles = Float(roundTripCommuteMiles.text!)!
            }
        }
        if tranportsegment.selectedSegmentIndex == 0{
            let commuteTime = ((totalMiles / 20) * 60)
            totalCommuteTime.text = String(format: "%.0f", commuteTime) + " mins"
            let gasNeeded = (totalMiles / 24)
            gasToPurchase.text = String(format: "%.2f", gasNeeded) + " gallons"
        }
        else if tranportsegment.selectedSegmentIndex == 1{
            var commuteTime = ((totalMiles / 12) * 60) + 10
            if(showMonthlyCommute.isOn){
                commuteTime = commuteTime + 190
            }
            totalCommuteTime.text = String(format: "%.0f", commuteTime) + " mins"
            gasToPurchase.text = "0 gallons"
        }
        else if tranportsegment.selectedSegmentIndex == 2{
            let commuteTime = ((totalMiles / 10) * 60)
            totalCommuteTime.text = String(format: "%.0f", commuteTime) + " mins"
            gasToPurchase.text = "0 gallons"
        }
    }
    override func viewDidLoad() {
        roundTripCommuteMiles.delegate = self
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

