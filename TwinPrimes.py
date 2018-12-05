def isPrime(n):
   for i in range(2, n):
      if n % i == 0:
         return False
   return True

def twinPrimes(start, end):
   for i in range(start, end):
      j = i + 2
      if(isPrime(i) and isPrime(j)):
         print("{:d} and {:d}".format(i, j))

twinPrimes(1, 20)
