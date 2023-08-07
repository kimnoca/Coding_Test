import sys

input = sys.stdin.readline

# 누적 합 ~
n = int(input())
temp = list((map(int, input().split())))
list = [0, *temp]

for i in range(n + 1):
    list[i] = list[i - 1] + list[i]

m = int(input())

for i in range(m):
    a, b = map(int, input().split())
    print(list[b] - list[a - 1])
