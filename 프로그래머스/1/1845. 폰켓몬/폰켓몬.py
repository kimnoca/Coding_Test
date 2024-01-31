def solution(nums):
    pick = len(nums) // 2
    nums = set(nums)
    return min(pick, len(nums))
