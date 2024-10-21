count = 0
# Asking user to enter a string 
winningNumber = input("Enter the winning lotto numbers: ")
ticketNumber = input("Enter your numbers: ")

# Populating 'lists' using list comprehension
winningNumberList = [int(i) for i in winningNumber.split()]
ticketNumberList = [int(i) for i in ticketNumber.split()]

for tNumber in ticketNumberList:
    if tNumber in winningNumberList:
        count += 1

print(f"You matched {count} numbers")

