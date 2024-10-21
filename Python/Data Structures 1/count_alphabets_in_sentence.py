from string import ascii_lowercase

# Initializing frequency list
freq = [0] * 26

# User input and converting to lowercase
inputText = input("Enter the text: ").lower()

# Looping through the input text and counting only alphabets
for char in inputText:
    if char.isalpha():
        freq[ascii_lowercase.index(char)]  += 1
        
# Printing 2 lists using 'zip' method
print("\nLetter Frequency")
for letter,frequency in zip(ascii_lowercase,freq):
    print(f"{letter:^5}{frequency:^9}")

print(f"\nMost frequent letter: {ascii_lowercase[freq.index(max(freq))]}")





