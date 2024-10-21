# -*- coding: utf-8 -*-
"""
Created on Mon Oct  7 12:46:14 2024

@author: Adnan
"""

# Taking input from user to check if variable is valid according to this:
    # Letter, number and "_" Underscore
    # invalid otherwise
var_input = input("Enter the variable name: ")

# Looping through each character 
for char in var_input:
    if (char.isalpha() or char.isdigit() or char == "_"):
        valid = True
    else:
        print(f"Invalid character {char}")
        valid = False
        break
# Checking "valid" flag
if valid:
    print("Valid variable name")