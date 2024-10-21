# -*- coding: utf-8 -*-
"""
Created on Mon Oct  7 11:35:51 2024

@author: Adnan
"""

from random import randint, seed

# Initializing variables
guess_number = 0
loop_counter = 0
secret_number = 45

# Setting up 'seed' and 'random number'
seed(1)
secret_number = randint(1, 100)

# Starting loop to input and get out of the loop if user guessed it already
while loop_counter < 10:
    guess_number = int(input("Enter your guess: "))
    if guess_number > secret_number:
        print("Too high")
    elif guess_number < secret_number:
        print("Too low")
    elif guess_number == secret_number:
        print(f"You win, you got it in {loop_counter +1} guesses")
        break
    if loop_counter == 9:
        print(f"You lose, the number was {secret_number}")
    loop_counter += 1
    
    