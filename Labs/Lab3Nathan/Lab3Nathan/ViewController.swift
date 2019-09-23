//
//  ViewController.swift
//  Lab3Nathan
//
//  Created by Nathan Kregstein on 9/19/19.
//  Copyright © 2019 Nathan Kregstein. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var PictureLabel: UILabel!
    @IBOutlet weak var ImageShown: UIImageView!
    @IBOutlet weak var ImageControl: UISegmentedControl!
    @IBOutlet weak var FontSizeLabel: UILabel!
    @IBOutlet weak var ColorControl: UISegmentedControl!
    @IBOutlet weak var CapitalSwitch: UISwitch!
    
    
    func updateImage(){
        if ImageControl.selectedSegmentIndex == 0{
            ImageShown.image = UIImage(named: "pattern1")
            PictureLabel.text = "Sea Coral Pattern"
        }
        else{
            ImageShown.image = UIImage(named: "pattern3")
            PictureLabel.text = "Flower Pattern"
        }
    }
    func updateCaps(){
        if CapitalSwitch.isOn{
            PictureLabel.text = PictureLabel.text?.uppercased()
        }else{
            PictureLabel.text = PictureLabel.text?.lowercased()
        }
    }
    @IBAction func ChangeInfo(_ sender: Any) {
        updateCaps()
        updateImage()
    }
    
    @IBAction func UpdateFontCaps(_ sender: UISwitch) {
        updateCaps()
    }
    
    @IBAction func ChangeColor(_ sender: UISegmentedControl) {
        if ColorControl.selectedSegmentIndex == 0{
            PictureLabel.textColor = UIColor.red
        }
        else if ColorControl.selectedSegmentIndex == 1{
            PictureLabel.textColor = UIColor.green
        }
        else{
            PictureLabel.textColor = UIColor.blue
        }
    }
    
    @IBAction func ChangeFontSize(_ sender: UISlider) {
        let fontSize = sender.value
        FontSizeLabel.text = String(format: "%.0f", fontSize)
        let fontSizeCGFloat = CGFloat(fontSize)
        PictureLabel.font = UIFont.systemFont(ofSize: fontSizeCGFloat)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

