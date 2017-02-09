//
//  CustomCell.swift
//  FlyX7
//
//  Created by Michelle Truong on 7/7/16.
//  Copyright © 2016 Michelle Truong. All rights reserved.
//

import UIKit

class CustomCell: UITableViewCell {

    @IBOutlet var genotype: UILabel!
    @IBOutlet var photo: UIImageView!
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
