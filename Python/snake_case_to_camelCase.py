# -*- coding: utf-8 -*-
"""
Created on Sun Sep 22 14:44:22 2024

@author: Adnan
"""

# Capture input in snake_case
varname = input("Enter variable name in snake_case: ")
# Replace underscore _ with space
no_underscore = varname.replace("_", " ")
# Convert string into "title" case
title_case = no_underscore.title()
# Remove spaces
no_space = title_case.replace(" ", "")
# Finally concatenate final version by changing first letter into lowercase 
camelCase = no_space[0].lower() + no_space[1:]
# Display converted variable in camelCase form
print(camelCase)