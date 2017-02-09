//
//  Introduction.swift
//  FlyX
//
//  Created by Michelle Truong on 1/16/17.
//  Copyright © 2017 Michelle Truong. All rights reserved.
//

import Foundation

class Introduction: UIViewController {
    @IBOutlet var IntroScroll: UIScrollView!

    @IBOutlet var GetStarted: UIButton!

    
    @IBAction func GetStarted(_ sender: AnyObject) {
 //       performSegue(withIdentifier: "ButtontoHomepage", sender: self)
    }
    
 
    var imageArray = [UIImage]()
    

    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        navigationController?.isNavigationBarHidden = true


        
        imageArray = [#imageLiteral(resourceName: "Intro1UI(Updated)"), #imageLiteral(resourceName: "Intro2UI(Updated)"), #imageLiteral(resourceName: "Intro3UI(Updated)"), #imageLiteral(resourceName: "Intro4UI(Updated)"), #imageLiteral(resourceName: "Intro5UI(Updated)")]
        
        for i in 0..<imageArray.count{
 
 
            let imageView = UIImageView()
            imageView.image = imageArray[i]
            let xPosition = self.view.frame.width * CGFloat(i)
            imageView.frame = CGRect(x: xPosition, y: 0, width: self.view.frame.width, height: self.view.frame.height)
            IntroScroll.contentSize.width = IntroScroll.frame.width * CGFloat(i + 1)
            IntroScroll.addSubview(imageView)
        }
        

        
    }
//    @IBAction func GetStarted(_ sender: Any) {
 //       var storyboard: UIStoryboard = UIStoryboard(name: "Introduction", bundle: nil)
        //var vc: NewViewController = storyboard.instantiateViewController(withIdentifier: "homepage") as NewViewController
    
    //    var vc: Homepage = storyboard.instantiateViewController(withIdentifier: "homepage") as! Homepage
  //      self.present(vc, animated: true, completion: nil)
        
//    }
//}
}
