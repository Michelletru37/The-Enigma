//
//  Chro3Cross1.swift
//  FlyX7
//
//  Created by Michelle Truong on 8/15/16.
//  Copyright © 2016 Michelle Truong. All rights reserved.
//

import UIKit

class Chro3Cross1: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        
        
        let label = UILabel(frame: CGRect(x: 0, y: 0, width: view.frame.width, height: view.frame.height))
        label.backgroundColor = UIColor.clear
        label.numberOfLines = 2
        label.textAlignment = NSTextAlignment.center
        label.textColor = UIColor.white
        label.text = "Cross Starting Genotype\nWith Double Balancer"
        label.font = label.font.withSize(18)
        self.navigationItem.titleView = label

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
