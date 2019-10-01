//
//  ViewController.swift
//  SavingsCalculator
//
//  Created by Nathan Kregstein on 9/30/19.
//  Copyright © 2019 Nathan Kregstein. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet weak var originalPriceTextField: UITextField!
    
    @IBOutlet weak var discountPercentDisplayed: UILabel!
    
    @IBOutlet weak var PercentStepper: UIStepper!
    
    @IBOutlet weak var newTotal: UILabel!
    
    @IBOutlet weak var moneySavedDisplay: UILabel!
    
    @IBAction func changeDiscountPercent(_ sender: Any) {
        if PercentStepper.value < 0{
            let alert=UIAlertController(title: "Warning", message: "Can't have a negative discount", preferredStyle: UIAlertController.Style.alert)
    
            let okAction=UIAlertAction(title: "OK", style: UIAlertAction.Style.default, handler: {action in
                self.PercentStepper.value = 0
            })
            alert.addAction(okAction)
            present(alert, animated: true, completion: nil)
            PercentStepper.value = 0
        }
        discountPercentDisplayed.text = String( format: "%.0f", PercentStepper.value) + "% Discount"
        updateTotal()
        
    }
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    func textFieldDidEndEditing(_ textField: UITextField) {
        updateTotal()
    }
    func updateTotal(){
        var originalPrice: Float
        var total: Float
        var moneySaved: Float
        if(originalPriceTextField.text!.isEmpty){
            originalPrice = 0.0
        }else {
            originalPrice = Float(originalPriceTextField.text!)!
        }
        if(PercentStepper.value != 0){
            total = originalPrice - (originalPrice * (Float(PercentStepper.value)/100))
        }
        else{
            total = originalPrice
        }
        print(total)
        moneySaved = originalPrice - total
        print(moneySaved)
        
        let roundedTotal = Float(String(format: "%.1f", total))
        
        let roundedMoneySaved = Float(String(format: "%.1f", moneySaved))
        
        let currencyFormatter = NumberFormatter()
        
        currencyFormatter.numberStyle=NumberFormatter.Style.currency
        
        newTotal.text = currencyFormatter.string(from: NSNumber(value: roundedTotal!))
        moneySavedDisplay.text = currencyFormatter.string( from: NSNumber( value: roundedMoneySaved!))
        
        
    }
    override func viewDidLoad() {
        originalPriceTextField.delegate = self
        
//        NotificationCenter.default.addObserver(self, selector: #selector(keyboardWillShow), name: UIResponder.keyboardWillShowNotification, object: nil)
        
        NotificationCenter.default.addObserver(self, selector: #selector(keyboardWillHide), name: UIResponder.keyboardWillHideNotification, object: nil)

        let tap: UITapGestureRecognizer = UITapGestureRecognizer(target: self, action: #selector(self.dismissKeyboard))
        
        view.addGestureRecognizer(tap)
  
        
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    @objc func dismissKeyboard(){
        view.endEditing(true)
    }
    
//    @objc func keyboardWillShow(notification: NSNotification){
//        if let keyboardSize = (notification.userInfo?[UIResponder.keyboardFrameEndUserInfoKey] as? NSValue)?.cgRectValue{
//            if self.view.frame.origin.y == 0{
//                self.view.frame.origin.y -= keyboardSize.height
//            }
//        }
//    }
    
    @objc func keyboardWillHide(notification: NSNotification) {
        if ((notification.userInfo?[UIResponder.keyboardFrameEndUserInfoKey] as? NSValue)?.cgRectValue)
            != nil {
            if self.view.frame.origin.y != 0 {
                self.view.frame.origin.y = 0
            }
        }
    }


}

