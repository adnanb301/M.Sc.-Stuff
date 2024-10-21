# -*- coding: utf-8 -*-
"""
Created on Sun Sep 22 15:47:59 2024

@author: Adnan
"""
# import "math" lib for sqrt function

from math import sqrt

# Capture required inputs in float

power = float(input("Enter the power: "))
resistance = float(input("Enter the resistance: "))

# calculate voltage

voltage = sqrt(power*resistance)

# Display calculated voltages

print(f"Voltage is {voltage:.1f}")

