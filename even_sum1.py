def even_sum(a, b):
    count = 0
    if a>b:
        return -1
    for i in range(a, b, 1):
        if(i % 2 == 0):
            count += i
    return count
    
         
# Driver Function 

print(even_sum(3,8))
