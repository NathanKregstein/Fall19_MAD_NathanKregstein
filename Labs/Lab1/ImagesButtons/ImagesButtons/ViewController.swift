//
//  ViewController.swift
//  ImagesButtons
//
//  Created by Nathan Kregstein on 9/3/19.
//  Copyright © 2019 Nathan Kregstein. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var ShownImage: UIImageView!
    
    @IBOutlet weak var photoDescription: UILabel!
    
    let image1 = UIImage(named: "Draw1");
    let image2 = UIImage(named: "Draw2");
    let image3 = UIImage(named: "Draw3");
//    var images: [UIImage];
    var counter = 1;
    
    @IBAction func changeShownImage(_ sender: UIButton) {
        if(sender.tag == 1){
//            if(counter == 0){
//                counter = 3;
//            }
//            else{
//                counter = counter - 1;
//            }
//            ShownImage.image = images[counter];
            photoDescription.text = "Cute Alien";
            ShownImage.image = image1;
        }
        else if(sender.tag == 2){
//            if(counter == 3){
//                counter = 0;
//            }
//            else{
//                counter = counter + 1;
//            }
//            ShownImage.image = images[counter];
            ShownImage.image = image3;
            photoDescription.text = "Cool Alien";
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
//        images = [image1, image2, image3];
        // Do any additional setup after loading the view.
    }


}


