def fizzBuzz(n):
    result = []
    for x in range(1, n+1):
        if x % 3 == 0 and x % 5 == 0:
            result.append('"Fizz Buzz"')
        elif x % 3 == 0:
            result.append('"Fizz"')
        elif x % 5 == 0:
            
            result.append('"Buzz"')
        elif x < 0:
            result.append('"invalid inputs"')
        else:
            result.append(str(x))
    return result

def main():
    print(', '.join(fizzBuzz(17)))

main()
