def isPrime(n):
    str="Invalid Input"
    
    
    if (n<0):
        return str
    else:
        for x in range(1,n):
            if(n % x==0):
                return False
        return True             
print(isPrime(17))
