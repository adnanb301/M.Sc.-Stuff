# Creating an empty list to store input marks
validMarks = []
# Loop for 6 valid input marks
while len(validMarks) < 6:
    marks = int(input("Enter the mark: "))
# Check for validity of marks range i.e. 0-100 (inclusive)
    if marks >= 0 and marks <=100:
        validMarks.append(marks)
    else:
        print("Invalid mark:", marks)
# Printing results of average, min and max
print("Number of mark:", len(validMarks))
print("Average mark:", round(sum(validMarks)/6))
print("Highest mark:", max(validMarks))
print("Lowest mark:", min(validMarks))

