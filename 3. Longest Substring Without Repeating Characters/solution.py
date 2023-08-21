# Given a string s, find the length of the longest 
# substring
# without repeating characters.

def solution(s) :
    pointer1 = 0
    pointer2 = 0
    dict = set()
    maxCount = 0
    while pointer2 < len(s):
        if s[pointer2] not in dict :
            dict.add(s[pointer2])
            maxCount = max(maxCount, len(dict))
            pointer2 += 1
        else :
            dict.discard(s[pointer1])
            pointer1 += 1
    return maxCount
    

print("The longest substring without repeating characters length is " + str(solution("hello")))