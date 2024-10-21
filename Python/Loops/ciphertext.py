# -*- coding: utf-8 -*-
"""
Created on Mon Oct  7 14:02:06 2024

@author: Adnan
"""
# Importing required modules 
from string import ascii_lowercase

# Populating list of lowercase alphabets
list_alpha = ascii_lowercase
ciphertext = ""

# Capturing an input
plaintext = input("Enter a message to encipher: ").lower()

# Looping through input text to create a ciphered version
for char in plaintext:
    if char.isalpha():
        ciphertext += list_alpha[25-(ascii_lowercase.index(char))]
    else:
        ciphertext += char
        
print("The enciphered message is:", ciphertext)