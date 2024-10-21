# -*- coding: utf-8 -*-
"""
Created on Mon Oct  7 11:07:16 2024

@author: Adnan
"""

# List of valid alphabets
alpha = "WABCDEFGHIJKLMNOPQRSTUV"

# Initializing variables 
weight = 8
total = 0
i= 0

# Capturing a valid input
ppsn = input("Enter the PPSN: ")

# Calculating total of digit according to defind weight
while i < 7:
    total += (int(ppsn[i]) * weight)
    weight -= 1
    i += 1
result = total % 23

# Comparing if resulted value matching same index in 'alpha' list

if alpha[result] == ppsn[-1]:
    print(f"PPSN {ppsn} is valid")
else:
    print(f"PPSN {ppsn} is not valid")