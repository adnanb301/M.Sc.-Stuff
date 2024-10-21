# -*- coding: utf-8 -*-
"""
Created on Sun Sep 22 15:33:14 2024

@author: Adnan
"""

# Capture inputs
mother_name = input("Enter your mother's maiden name: ").lower()
place_name = input("Enter the name of the place you were born: ").lower()
# Print output with space and capital case
print("Your Influencer Name is:",mother_name.capitalize() + " " + place_name.capitalize())