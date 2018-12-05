def isArmstrong(n):
    t = len(n)
    s = int(n)
    total = 0
    num = s
    while s > 0:
        d = s % 10
        total = total + (d ** t)
        s = int(s / 10)
    if num == total:
        return True
    else:
        return False

x ='-99'
if isArmstrong(x):
    print(True)
else:
    print(False)

