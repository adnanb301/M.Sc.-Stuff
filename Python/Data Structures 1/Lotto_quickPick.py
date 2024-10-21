# Asking user to enter a string 
inputNumber = input("Enter the numbers separated by spaces: ")

# Populating a 'list' using list comprehension
numberList = [int(i) for i in inputNumber.split()]

# Validity check
if (len(numberList) == 6) and (min(numberList) >=1) and (max(numberList) <=47) and (len(set(numberList)) == 6) and (numberList == sorted(numberList)):
    print("Valid Quickpick")
else:
    print("Not a valid Quickpick")