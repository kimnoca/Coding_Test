import math

n = int(input())

dp = [0] * (n + 1)

try:
    dp[1] = 0
    dp[2] = 1
    dp[3] = 1
except:
    pass
for i in range(4, n + 1):
    num1 = math.inf
    num2 = math.inf
    num3 = math.inf
    if i % 3 == 0:
        num1 = dp[i // 3] + 1
    if i % 2 == 0:
        num2 = dp[i // 2] + 1
    num3 = dp[i - 1] + 1
    dp[i] = min(num1, num2, num3)


print(dp[n])
