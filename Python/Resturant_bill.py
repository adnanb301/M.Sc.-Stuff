# -*- coding: utf-8 -*-
"""
Created on Sun Sep 22 15:47:59 2024

@author: Adnan
"""

# Capture required inputs in float

mealCost = float(input("Enter the cost of the meal: "))
svcCharge = float(input("Enter the service charge: "))
tip = float(input("Enter the tip: "))

# calculate total bill

totalBill = mealCost * (1+ svcCharge/100) + tip

# Display total bill

print(f"The total bill is {totalBill:.2f} Euro")

