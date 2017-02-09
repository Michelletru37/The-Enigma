//
//  Homepage.swift
//  FlyX7
//
//  Created by Michelle Truong on 7/8/16.
//  Copyright © 2016 Michelle Truong. All rights reserved.
//

import UIKit

class Homepage: ViewController {
    var navBar:UINavigationBar=UINavigationBar()

    override func viewDidLoad() {
        super.viewDidLoad()
        
        //Mark:Gets Rid of Shadow Line in Nav Bar
        UINavigationBar.appearance().shadowImage = UIImage()
        UINavigationBar.appearance().setBackgroundImage(UIImage(), for: .default)






        //Mark: Multiline Title


        let label = UILabel(frame: CGRect(x: 0, y: 0, width: view.frame.width, height: view.frame.height))
        label.backgroundColor = UIColor.clear
        label.numberOfLines = 2
        label.textAlignment = NSTextAlignment.center
        label.textColor = UIColor.white
        label.text = "On Which Chromosome is\nthe Element?"
        label.font = label.font.withSize(18)
        self.navigationItem.titleView = label


        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    func setNavBarToTheView()
    {
        navBar.frame=CGRect(x: 0, y: 0, width: 320, height: 100)  // Here you can set you Width and Height for your navBar
        self.view .addSubview(navBar)
    }
    

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }


}
