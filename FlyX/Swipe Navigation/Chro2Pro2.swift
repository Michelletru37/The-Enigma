//
//  Progeny2ViewController.swift
//  FlyX5
//
//  Created by Michelle Truong on 6/20/16.
//  Copyright © 2016 Michelle Truong. All rights reserved.
//

import UIKit

class Chro2Pro2: UIViewController, UITableViewDataSource, UITableViewDelegate {

    @IBOutlet var Menu: UIBarButtonItem!
    
    @IBOutlet var tableView: UITableView!
    struct Objects {
        var sectionName : String!
        var sectionObjects : [String]!
    }
    var objectsArray = [Objects]()
    
    var identities = [String]()
    var identitiesZero = [String]()
    var identitiesOne = [String]()
    var identitiesTwo = [String]()
    
    var progenyGenotypes = ["E(w+)/E(w+); Dr/TM3 Sb",
                            "E(w+)/CyO; Dr/TM3 Sb",
                            "E(w+)/E(w+); +/TM3 Sb",
                            "E(w+)/E(w+); +/+",
                            "E(w+)/CyO; Dr/+",
                            "E(w+)/CyO; +/TM3 Sb",
                            "E(w+)/CyO; +/+",
                            "CyO/CyO; Dr/TM3 Sb",
                            "CyO/CyO; Dr/+",
                            "CyO/CyO; +/TM3 Sb",
                            "CyO/CyO; +/+"]
    
    //var visuals = [UIImage(named: "1"),UIImage(named: "2"),UIImage(named: "3"),UIImage(named: "4"),UIImage(named: "5"),UIImage(named: "6"),UIImage(named: "7"),UIImage(named: "8"),UIImage(named: "9"),UIImage(named: "10"),UIImage(named: "11"),UIImage(named: "12"),UIImage(named: "13"),UIImage(named: "14"),UIImage(named: "15"),UIImage(named: "16")]
    var images = [UIImage(named: "C2P2.001"),
                  UIImage(named: "C2P2.002"),
                  UIImage(named: "fruitfly"),
                  UIImage(named: "fruitfly"),
                  UIImage(named: "fruitfly"),
                  UIImage(named: "fruitfly"),
                  UIImage(named: "fruitfly"),
                  UIImage(named: "fruitfly")]
    
    var sec2progeny2 = [UIImage(named: "C2P2.003"),
                    UIImage(named: "C2P2.004"),
                    UIImage(named: "C2P2.005"),
                    UIImage(named: "C2P2.006"),
                    UIImage(named: "C2P2.007"),
                    UIImage(named: "C2P2.008")]
    
    var sec3progeny2 = [UIImage(named: "C2P2.009"),
                    UIImage(named: "C2P2.010"),
                    UIImage(named: "C2P2.011"),
                    UIImage(named: "C2P2.012")]
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.

        

        objectsArray = [Objects(sectionName: "Set Cross To Make Final Stock", sectionObjects : ["E(w+)/E(w+); Dr/TM3 Sb"]), Objects(sectionName: "or", sectionObjects: ["E(w+)/CyO; Dr/TM3 Sb"]), Objects(sectionName: "Discard", sectionObjects : ["E(w+)/E(w+); Dr/+", "E(w+)/E(w+); +/TM3 Sb", "E(w+)/E(w+); +/+", "E(w+)/CyO; Dr/+", "E(w+)/CyO; +/TM3 Sb", "E(w+)/CyO; +/+"]), Objects(sectionName: "Lethal", sectionObjects : ["CyO/CyO; Dr/TM3 Sb", "CyO/CyO; Dr/+", "CyO/CyO; +/TM3 Sb", "CyO/CyO; +/+"])]
        
        identities = ["9"]
        identitiesZero = ["10"]
        identitiesOne = ["11", "12", "13", "14", "15", "16"]
        identitiesTwo = ["17", "18", "19", "20"]
 
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
        
        let cell = self.tableView.dequeueReusableCell(withIdentifier: "cell2", for: indexPath) as! CustomCell
        if indexPath.section == 0 {
            cell.accessoryType = UITableViewCellAccessoryType.checkmark
            if indexPath.row == 0 {
                
                cell.photo.image = images[0]
            }
            /*if indexPath.row == 1 {
                cell.photo.image = images[1]
            }*/
            //cell.genotype.text = progenyGenotypes[indexPath.row]
            
            cell.genotype.text = objectsArray[indexPath.section].sectionObjects[indexPath.row]
        }
        // cell.genderSymbol.image = gender[indexPath.row]
        if indexPath.section == 1 {


           /* func tableView(tableView: UITableView, willDisplayHeaderView view: UIView, forSection section: Int) {
                
                let header = view as! UITableViewHeaderFooterView
                header.textLabel?.font = UIFont(name: "Oriya Sangam MN", size: 15)
            }*/

            //if indexPath.row == 0 {
            //  cell.photo.image = UIImage(named: "diagrams.001")
            
            //}
            cell.accessoryType = UITableViewCellAccessoryType.checkmark
            cell.genotype.text = objectsArray[indexPath.section].sectionObjects[indexPath.row]
           // cell.photo.image = sec2progeny2[indexPath.row]
            if indexPath.row == 0 {
            cell.photo.image = images[1]
            }
        }
        if indexPath.section == 2 {
            cell.accessoryType = UITableViewCellAccessoryType.disclosureIndicator
            cell.photo.image = sec2progeny2[indexPath.row]
            cell.genotype.text = objectsArray[indexPath.section].sectionObjects[indexPath.row]
        }
        if indexPath.section == 3 {
            cell.accessoryType = UITableViewCellAccessoryType.disclosureIndicator
            cell.photo.image = sec3progeny2[indexPath.row]
            cell.genotype.text = objectsArray[indexPath.section].sectionObjects[indexPath.row]
        }
        return cell

    }
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        tableView.deselectRow(at: indexPath, animated: true)
        
        let cell = self.tableView.dequeueReusableCell(withIdentifier: "cell2", for: indexPath) as! CustomCell

        
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
            self.navigationController?.pushViewController(viewController2!, animated: true)
        }
        
    }
    func numberOfSections(in tableView: UITableView) -> Int {
        return 4
        //return objectsArray.count
    }
    
    func  tableView(_ tableView: UITableView, titleForHeaderInSection section: Int) -> String? {
        return objectsArray[section].sectionName
    }





}
