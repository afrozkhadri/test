def even_sum(a, b):
    if a>b:
        return -1
    
    return sum(i for i in range(a, b + 1) if i % 2 == 0)
print(even_sum(3,7))
