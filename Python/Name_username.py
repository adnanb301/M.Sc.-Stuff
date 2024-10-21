# -*- coding: utf-8 -*-
"""
Created on Sun Sep 22 15:41:09 2024

@author: Adnan
"""

# Capture input - Full name 
name = input("Enter your first and last names, separated by a space: ").lower()
# Split input string into first and last name
firstname, lastname = name.split()
# Print output - username
print("Your username is:", firstname + lastname[0])

