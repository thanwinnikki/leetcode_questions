# We use the 2 pointer method to solved two sum problem. This only works if the list is sorted. Important property.
# This reduces the space complexity is O(1)


def solution(target: int, problem_array: list):
    pointer1 = 0
    pointer2 = len(problem_array) - 1

    while pointer1 < pointer2:
        sum = problem_array[pointer1] + problem_array[pointer2]
        if sum > target:
            pointer2 -= 1
        elif sum < target:
            pointer1 += 1
        else:
            return [pointer1, pointer2]
        
    return [-1, -1]


target = 7
problem = [1,2,3,4,5]
print("The answer is : ", solution(target, problem))
