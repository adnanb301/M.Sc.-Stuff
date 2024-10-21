
# Function takes input of 'list' and returns 'mean' 
def calc_mean(numbers):
    return sum(numbers)/len(numbers)

# Function takes input of 'list' and returns 'mode' 
def calc_mode(numbers):
    freq =[]
    values = sorted(list(set(numbers)))
    for i in values:
        freq.append(numbers.count(i))
        
    return values[freq.index(max(freq))]

# Function takes input of 'list' and returns 'standard deviation' 
def calc_std_dev(numbers):
    from math import sqrt
    mean_value = calc_mean(numbers)
    sqrd_deviations = [ (x-mean_value) ** 2 for x in numbers]
    return sqrt(sum(sqrd_deviations)/(len(numbers)-1))

# Function takes input of 'list' and returns 'mode skeness' 
def calc_mode_skewness(numbers):
    return ((calc_mean(numbers) - calc_mode(numbers))/calc_std_dev(numbers))


# numbers22 = [9,1,2,5,4,3,4,9,3,9]
if __name__ == "__main__":
   print(calc_mode_skewness([1,2,2,3,4,5]))
