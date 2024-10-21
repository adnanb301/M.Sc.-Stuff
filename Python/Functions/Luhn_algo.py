
# Function to calculate sum of x digits number using Luhn algorithm
def calc_luhn_sum(str_of_digits):
    if str_of_digits.isdigit():
        string_value = ""
        indx = 0
        while indx < len(str_of_digits):
            if indx%2:
                string_value += str(int(str_of_digits[indx])*2)
            else:
                string_value += str(int(str_of_digits[indx]))
            indx += 1
            
        sum_list = [int (i) for i in list(string_value)]
        return sum(sum_list)
    else:
        return 0

# Function to validate the seconds part of Luhn's algorithm
def is_valid_sin(str_of_digits):
    if (len(str_of_digits) == 9) and (calc_luhn_sum(str_of_digits) % 10 == 0) and str_of_digits.isdigit():
        return True
    else:
        return False

if __name__ == "__main__":
    #print(calc_luhn_sum("046454286"))
    print(is_valid_sin("0464X5428"))
    
    