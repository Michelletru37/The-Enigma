//
//  Progeny2ViewController.swift
//  FlyX5
//
//  Created by Michelle Truong on 6/20/16.
//  Copyright © 2016 Michelle Truong. All rights reserved.
//

import UIKit

class Chro3Pro1: UIViewController, UITableViewDataSource, UITableViewDelegate {
    
    struct Objects {
        var sectionName : String!
        var sectionObjects : [String]!
    }
    var objectsArray = [Objects]()
    
    @IBOutlet var tableView: UITableView!
    
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
    var images = [UIImage(named: "C3P1.001"),
                  UIImage(named: "C3P1.002"),
                  UIImage(named: "fruitfly"),
                  UIImage(named: "fruitfly"),
                  UIImage(named: "fruitfly"),
                  UIImage(named: "fruitfly"),
                  UIImage(named: "fruitfly"),
                  UIImage(named: "fruitfly")]
    
    var sec2Chro3Pro1 = [UIImage(named: "C3P1.003"),
                         UIImage(named: "C3P1.004"),
                         UIImage(named: "C3P1.005"),
                         UIImage(named: "C3P1.006")]
    
    var sec3Chro3Pro1 = [UIImage(named: "C3P1.007"),
                         UIImage(named: "C3P1.008")]
    
    
    //var visuals = [UIImage(named: "diagrams.001"), UIImage(named: "diagrams.002"), UIImage(named: "diagrams.003"), UIImage(named: "diagrams.004"), UIImage(named: "diagrams.005"), UIImage(named: "diagrams.006"), UIImage(named: "diagrams.007"), UIImage(named: "diagrams.008")]
    
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        objectsArray = [Objects(sectionName: "Use for Next Cross", sectionObjects : ["+/CyO; E(w+)/ TM3 Sb", "Sp/+; E(w+)/TM3 Sb",]), Objects(sectionName: "Discard", sectionObjects : ["+/CyO; E(w+)/Dr", "Sp/+; E(w+)/ Dr", "+/CyO; Dr/TM3 Sb", "Sp/+; Dr/TM3 Sb"]), Objects(sectionName: "Lethal", sectionObjects : ["+/CyO; TM3 Sb/TM3 Sb", "Sp/+; TM3 Sb/TM3 Sb"])]
        
        identities = ["21", "22"]
        identitiesOne = ["23", "24", "25", "26"]
        identitiesTwo = ["27", "28"]
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
        let cell = self.tableView.dequeueReusableCell(withIdentifier: "cell3", for: indexPath) as! CustomCell
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
            if indexPath.row == 0 {
                cell.photo.image = images[0]
            
            }
            cell.genotype.text = objectsArray[indexPath.section].sectionObjects[indexPath.row]
            cell.photo.image = sec2Chro3Pro1[indexPath.row]
        }
        if indexPath.section == 2 {
            cell.photo.image = sec3Chro3Pro1[indexPath.row]
            cell.genotype.text = objectsArray[indexPath.section].sectionObjects[indexPath.row]
        }
        return cell

    }
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        tableView.deselectRow(at: indexPath, animated: true)
        
        let cell = self.tableView.dequeueReusableCell(withIdentifier: "cell3", for: indexPath) as! CustomCell

        /*let row = array[indexPath.row]
         row.completed = !row.completed
         if row.completed {
         cell?.accessoryType = UITableViewCellAccessoryType.Checkmark
         } else {
         cell?.accessoryType = UITableViewCellAccessoryType.DisclosureIndicator
         */
        
        //if we're in sectionName = "use for next cross", then let vcName = identities1[indexPath.row]
        if indexPath.section == 0 {
            let vc2Name = identities[indexPath.row]
            let viewController2 = storyboard?.instantiateViewController(withIdentifier: vc2Name)
            self.navigationController?.pushViewController(viewController2!, animated: true)
        }
        if indexPath.section == 1 {
            
            cell.accessoryType = UITableViewCellAccessoryType.disclosureIndicator
            let vc2Name = identitiesOne[indexPath.row]
            let viewController2 = storyboard?.instantiateViewController(withIdentifier: vc2Name)
            self.navigationController?.pushViewController(viewController2!, animated: true)
        }
        if indexPath.section == 2{
            
            cell.accessoryType = UITableViewCellAccessoryType.disclosureIndicator
            let vc2Name = identitiesTwo[indexPath.row]
            let viewController2 = storyboard?.instantiateViewController(withIdentifier: vc2Name)
            self.navigationController?.pushViewController(viewController2!, animated: true)
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
    
}
