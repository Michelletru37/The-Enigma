//
//  ViewController.swift
//  FlyX5
//
//  Created by Michelle Truong on 6/15/16.
//  Copyright © 2016 Michelle Truong. All rights reserved.
//

import UIKit

class Chro2Pro1: UIViewController, UITableViewDelegate, UITableViewDataSource {

 


    @IBOutlet var tableView: UITableView!
    
    @IBOutlet var List: UIBarButtonItem!
    struct Objects {
        var sectionName : String!
        var sectionObjects : [String]!
    }
    
    var objectsArray = [Objects]()

    

    

    var identities = [String]()
    var identitiesOne = [String]()
    var identitiesTwo = [String]()
    
    var progenyGenotypes = ["E(w+)/CyO; +/TM3 Sb",
                            "E(w+)/CyO; Dr/+",
                            "E(w+)/Sp; +/TM3 Sb",
                            "E(w+)/Sp; Dr/+",
                            "Sp/CyO; +/TM3 Sb",
                            "Sp/CyO; Dr/+",
                            "CyO/CyO; +/TM3 Sb",
                            "CyO/CyO; Dr/+"]
    
    //var visuals = [UIImage(named: "1"),UIImage(named: "2"),UIImage(named: "3"),UIImage(named: "4"),UIImage(named: "5"),UIImage(named: "6"),UIImage(named: "7"),UIImage(named: "8"),UIImage(named: "9"),UIImage(named: "10"),UIImage(named: "11"),UIImage(named: "12"),UIImage(named: "13"),UIImage(named: "14"),UIImage(named: "15"),UIImage(named: "16")]
    var diagrams = [UIImage(named: "C2P1.003"),
                    UIImage(named: "C2P1.004"),
                    UIImage(named: "C2P1.005"),
                    UIImage(named: "C2P1.006"),
                    UIImage(named: "C2P1.007"),
                    UIImage(named: "C2P1.008")]
    
    var images = [UIImage(named: "C2P1.001"),
                  UIImage(named: "C2P1.002"),
                  UIImage(named: "fruitfly"),
                  UIImage(named: "fruitfly"),
                  UIImage(named: "fruitfly"),
                  UIImage(named: "fruitfly"),
                  UIImage(named: "fruitfly"),
                  UIImage(named: "fruitfly")]
    var gender = [UIImage(named: "virgin_female"),
                        UIImage(named: "virgin_male")]

    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.

        
        objectsArray = [Objects(sectionName: "Use for Next Cross", sectionObjects : ["E(w+)/CyO; +/TM3 Sb", "E(w+)/CyO; Dr/+"]), Objects(sectionName: "Discard", sectionObjects : ["E(w+)/Sp; +/TM3 Sb", "E(w+)/Sp; Dr/+", "Sp/CyO; +/TM3 Sb", "Sp/CyO; Dr/+"]), Objects(sectionName: "Lethal", sectionObjects : ["CyO/CyO; +/TM3 Sb", "CyO/CyO; Dr/+"])]
        
        identities = ["1", "2", "3", "4", "5", "6", "7", "8"]
        identitiesOne = ["3", "4", "5", "6"]
        identitiesTwo = ["7", "8"]
        //Open.target = self.revealViewController()
        //Open.action = Selector("revealToggle:")
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        //return progenyGenotypes.count
        return objectsArray[section].sectionObjects.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = self.tableView.dequeueReusableCell(withIdentifier: "cell1", for: indexPath) as! CustomCell
        /*if indexPath.section == 0{
         if indexPath.row == 0 {
         cell.backgroundColor = UIColor.blueColor()
         }
         
         if indexPath.row == 1 {
         cell.backgroundColor = UIColor.blueColor()
         
         }
         
         }*/
        if indexPath.section == 0 {
            cell.accessoryType = UITableViewCellAccessoryType.checkmark
            if indexPath.row == 0 {
            
                cell.photo.image = images[0]
            }
            if indexPath.row == 1 {
                cell.photo.image = images[1]
            }
            //cell.genotype.text = progenyGenotypes[indexPath.row]
        
            cell.genotype.text = objectsArray[indexPath.section].sectionObjects[indexPath.row]
            }
       // cell.genderSymbol.image = gender[indexPath.row]
        if indexPath.section == 1 {
    
              cell.photo.image = diagrams[indexPath.row]
            
            cell.genotype.text = objectsArray[indexPath.section].sectionObjects[indexPath.row]
            //cell.photo.image = UIImage(named: "fruitfly")
        }
        if indexPath.section == 2 {
            if indexPath.row == 0 {
                cell.photo.image = diagrams[4]
            }
            if indexPath.row == 1 {
                cell.photo.image = diagrams[5]
            }
            cell.genotype.text = objectsArray[indexPath.section].sectionObjects[indexPath.row]
        }
        return cell
    }
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        

        
        
        //if we're in sectionName = "use for next cross", then let vcName = identities1[indexPath.row]
        if indexPath.section == 0 {
            let vcName = identities[indexPath.row]
            let viewController = storyboard?.instantiateViewController(withIdentifier: vcName)
            self.navigationController?.pushViewController(viewController!, animated: true)

        }
        if indexPath.section == 1 {
            let vcName = identitiesOne[indexPath.row]
            let viewController = storyboard?.instantiateViewController(withIdentifier: vcName)
            self.navigationController?.pushViewController(viewController!, animated: true)
           
        }
        if indexPath.section == 2{
            
            let vcName = identitiesTwo[indexPath.row]
            let viewController = storyboard?.instantiateViewController(withIdentifier: vcName)
            self.navigationController?.pushViewController(viewController!, animated: true)
        }
        
        /*let vcName = identities[indexPath.row]
         let viewController = storyboard?.instantiateViewControllerWithIdentifier(vcName)
         self.navigationController?.pushViewController(viewController!, animated: true)
         }
         */
    }
    func numberOfSections(in tableView: UITableView) -> Int {
        return 3
        //return objectsArray.count
    }
    
    func  tableView(_ tableView: UITableView, titleForHeaderInSection section: Int) -> String? {
        return objectsArray[section].sectionName
    }
    
    //TODO: ADD SHAKE GESTURE HANDLING
    override func motionEnded(_ motion: UIEventSubtype, with event: UIEvent?) {
        performSegue(withIdentifier: "Chro2Cross1", sender: self)
    }
    
}
