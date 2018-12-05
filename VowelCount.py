def vowelCount(a):
    
    num_vowels=0
    for char in a:
        if char in "aeiouAEIOU":
           num_vowels = num_vowels+1
    return num_vowels

a="afroz"

print(vowelCount(a))
