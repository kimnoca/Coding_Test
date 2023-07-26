def solution(nums):
    n = len(nums)//2
    phones = dict.fromkeys(nums)
    if len(phones) > n:
        return n
    else :
        return len(phones)