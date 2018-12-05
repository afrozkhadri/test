def even_sum(sv, av):
    if sv>av:
        return -1
    return sum(i for i in range(sv, av) if i % 2 == 0)
print(even_sum(3,8))
