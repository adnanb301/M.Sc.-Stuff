# -*- coding: utf-8 -*-

# Capturing inputs
age = int(input("Enter your age: "))
maritalStatus = input("Enter your marital status: ").lower()

# Logic --> suitable person for TV show
# - 18 >= age <= 35
# - Must be single

if (age >= 18 and age <=35) and (maritalStatus == "single"):
    print("You are suitable for the TV show")
else:
    print("You are not suitable for the TV show")
