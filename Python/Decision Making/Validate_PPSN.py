# -*- coding: utf-8 -*-

#ppsn = "8765432A"
ppsn = input("Enter the PPSN: ")

#print(ppsn[:7] + " alpha " + ppsn[-1])

if (len(ppsn) == 8) and (ppsn[:7].isdigit() and ppsn[-1].isalpha()):
    print("PPSN is Valid")
else:
    print("PPSN is not valid")
