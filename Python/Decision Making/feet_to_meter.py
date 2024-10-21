# -*- coding: utf-8 -*-

# Get inputs of feet and inches
feetValue = float(input("Enter the number of feet: "))
inchesValue = float(input("Enter the number of inches: "))

# Convert feet + inches into metres
metres = ((feetValue * 12 + inchesValue) * 2.54) / 100

# Rounding value up to 2 decimal points
totalMetres = round(metres, 2)

# Display the calculated metres as output
print(f"The distance in metres is {totalMetres:.2f}m")

# Additional message related to world/Irish record
if (totalMetres > 8.95):
    print("A new world long jump record")
    print("A new Irish long jump record")
elif (totalMetres <= 8.95 and totalMetres > 8.07):
    print("A new Irish long jump record")    
