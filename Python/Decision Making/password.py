# -*- coding: utf-8 -*-

# Prompting for user inputs
currentPassword = input("Enter current password: ")
newPassword = input("Enter new password: ")
confirmPassword = input("Re-enter new password: ")

# Main logic:
# - current and new password should be different
# - password length >= 8
# - new pasword and confirm string should match exactly
if (currentPassword != newPassword) and (len(newPassword) >= 8) and (newPassword == confirmPassword):
    print("Password changed")
else:
    print("Password change unsuccessful")
    
    