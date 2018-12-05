def getCollatzSequence(x):

    if x % 2 == 0:
        print(x // 2)
        return x // 2

    elif x % 2 == 1:
        result = 3 * x + 1
        print(result)
        return result
n=input("Given number:")
while n != 1:
    n=getCollatzSequence(int(n))
