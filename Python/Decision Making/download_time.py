# -*- coding: utf-8 -*-

# Get inputs of file size and connection speed
fileSize = float(input("Enter the file size in MB: "))
connectionSpeed = float(input("Enter the connection speed in Mbps: "))

# Calculate time to download a file
time = (fileSize * 8.388608) / connectionSpeed

# Display the calculated time as output
print(f"Download time is {time:.2f} seconds")

# Additional message depends on "time" value
if (time < 60.0):
    print("Download will take less than a minute")
elif (time < 300.0):
    print("Download will take less than 5 minutes")
else:
    print("Too long to download")
