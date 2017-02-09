//
//  Progeny2ViewController.swift
//  FlyX5
//
//  Created by Michelle Truong on 6/20/16.
//  Copyright © 2016 Michelle Truong. All rights reserved.
//

import UIKit

class Chro3Pro2: UIViewController, UITableViewDataSource, UITableViewDelegate {
    
    struct Objects {
        var sectionName : String!
        var sectionObjects : [String]!
    }
    var objectsArray = [Objects]()
    
    @IBOutlet var tableView: UITableView!
    
    var identities = [String]()
    var identitiesZero = [String]()
    var identitiesOne = [String]()
    var identitiesTwo = [String]()
    
    
    var progenyGenotypes = ["Sp/CyO; E(w+)/E(w+)",
                            "Sp/CyO; E(w+)/TM3 Sb",
                            "Sp/+; E(w+)/E(w+)",
                            "+/+; E(w+)/E(w+)",
                            "Sp/+; E(w+)/E(w+)",
                            "+/CyO; E(w+)/TM3 Sb",
                            "+/+; E(w+)/TM3 Sb",
                            "Sp/CyO; TM3 Sb/TM3 Sb",
                            "Sp/+; TM3 Sb/TM3 Sb",
                            "+/CyO; TM3 Sb",
                            "+/+; TM3 Sb/TM3 Sb"]
    
    
    var images = [UIImage(named: "C3P2.001"),
                  UIImage(named: "C3P2.002"),
                  UIImage(named: "fruitfly"),
                  UIImage(named: "fruitfly"),
                  UIImage(named: "fruitfly"),
                  UIImage(named: "fruitfly"),
                  UIImage(named: "fruitfly"),
                  UIImage(named: "fruitfly")]
    
    var sec2Chro3Pro2 = [UIImage(named: "C3P2.003"),
                         UIImage(named: "C3P2.004"),
                         UIImage(named: "C3P2.005"),
                         UIImage(named: "C3P2.006"),
                         UIImage(named: "C3P2.007"),
                         UIImage(named: "C3P2.008")]
    
    var sec3Chro3Pro2 = [UIImage(named: "C2P2.009"),
                         UIImage(named: "C2P2.010"),
                         UIImage(named: "C2P2.011"),
                         UIImage(named: "C2P2.012")]

    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        objectsArray = [Objects(sectionName: "Set Cross to Make Final Stock", sectionObjects : ["Sp/CyO; E(w+)/E(w+)"]), Objects(sectionName: "or", sectionObjects: [ "Sp/CyO; E(w+)/TM3 Sb"]), Objects(sectionName: "Discard", sectionObjects : ["Sp/+; E(w+)/E(w+)", "+/CyO; E(w+)/E(w+)", "+/+; E(w+)/E(w+)", "Sp/+; E(w+)/TM3 Sb", "+/CyO; E(w+)/ TM3 Sb", "+/+; E(w+)/TM3 Sb"]), Objects(sectionName: "Lethal", sectionObjects : ["Sp/CyO; TM3 Sb/TM3 Sb", "Sp/+; TM3 Sb/TM3 Sb", "+/CyO; TM3 Sb/TM3 Sb", "+/+; TM3 Sb/TM3 Sb"])]
        
        identities = ["29"]
        identitiesZero = ["30"]
        identitiesOne = ["31", "32", "33", "34", "35", "36"]
        identitiesTwo = ["37", "38", "39", "40"]
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        //return progenyGenotypes.count
        return objectsArray[section].sectionObjects.count
    }
    //Size of "or" Header
    func tableView(_ tableView: UITableView, heightForHeaderInSection section: Int) -> CGFloat {
        if section == 1 {
            return 3
        }
        return 30
    }
    
    //Adjusting "or" Header
    func tableView(_ tableView: UITableView, willDisplayHeaderView view: UIView, forSection section: Int) {
        if section == 1 {
            let header: UITableViewHeaderFooterView = view as! UITableViewHeaderFooterView
            header.textLabel?.font = UIFont(name: "Oriya Sangam MN", size: 27.0)
            header.textLabel?.textAlignment = NSTextAlignment.center
            header.textLabel?.font = UIFont.boldSystemFont(ofSize: 18)
        }
        
    }
    
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = self.tableView.dequeueReusableCell(withIdentifier: "cell4", for: indexPath) as! CustomCell
        if indexPath.section == 0 {
            cell.accessoryType = UITableViewCellAccessoryType.checkmark
            if indexPath.row == 0 {
                
                cell.photo.image = images[0]
            }

            //cell.genotype.text = progenyGenotypes[indexPath.row]
            
            cell.genotype.text = objectsArray[indexPath.section].sectionObjects[indexPath.row]
        }
        // cell.genderSymbol.image = gender[indexPath.row]
        if indexPath.section == 1 {
            //if indexPath.row == 0 {
            //  cell.photo.image = UIImage(named: "diagrams.001")
            
            //}
            cell.accessoryType = UITableViewCellAccessoryType.checkmark
            cell.genotype.text = objectsArray[indexPath.section].sectionObjects[indexPath.row]
            cell.photo.image = images[1]
            //cell.photo.image = sec2Chro3Pro2[indexPath.row]
        }
        if indexPath.section == 2 {
            cell.accessoryType = UITableViewCellAccessoryType.disclosureIndicator
            cell.photo.image = sec2Chro3Pro2[indexPath.row]
            cell.genotype.text = objectsArray[indexPath.section].sectionObjects[indexPath.row]
        }
        
        if indexPath.section == 3 {
            cell.accessoryType = UITableViewCellAccessoryType.disclosureIndicator
            cell.photo.image = sec3Chro3Pro2[indexPath.row]
            cell.genotype.text = objectsArray[indexPath.section].sectionObjects[indexPath.row]
        }
        return cell

        // cell.genderSymbol.image = gender[indexPath.row]
  
    }
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        tableView.deselectRow(at: indexPath, animated: true)
        
        let cell = self.tableView.dequeueReusableCell(withIdentifier: "cell4", for: indexPath) as! CustomCell

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
            let vc2Name = identitiesZero[indexPath.row]
            let viewController2 = storyboard?.instantiateViewController(withIdentifier: vc2Name)
            self.navigationController?.pushViewController(viewController2!, animated: true)
        }
        if indexPath.section == 2{
            
            let vc2Name = identitiesOne[indexPath.row]
            let viewController2 = storyboard?.instantiateViewController(withIdentifier: vc2Name)
            self.navigationController?.pushViewController(viewController2!, animated: true)
        }
        if indexPath.section == 3 {
            let vc2Name = identitiesTwo[indexPath.row]
            let viewController2 = storyboard?.instantiateViewController(withIdentifier: vc2Name)
            self.navigationController?.pushViewController(viewController2!, animated:  true)
        }
        
        /*let vcName = identities[indexPath.row]
         let viewController = storyboard?.instantiateViewControllerWithIdentifier(vcName)
         self.navigationController?.pushViewController(viewController!, animated: true)
         }
         */
    }
    func numberOfSections(in tableView: UITableView) -> Int {
        return 4
        //return objectsArray.count
    }
    
    func  tableView(_ tableView: UITableView, titleForHeaderInSection section: Int) -> String? {
        return objectsArray[section].sectionName
    }
    
}
