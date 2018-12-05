
def  get_reverse(num):
    
    return s[::-1]
def isPalindrome(num):
    
    rev = reverse(s)

    if (s == rev):
        return True
    return False


s = "131"
ans = isPalindrome(s)

if ans == 1:
    print("Yes")
else:
    print("No")



