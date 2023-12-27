n, s = map(int, input().split())

arr = list(map(int, input().split()))

g = []

answer = 0


def dfs(start):
    global answer
    if s == sum(g) and len(g) > 0:
        answer += 1

    for i in range(start, n):
        g.append(arr[i])
        dfs(i + 1)
        g.pop()


dfs(0)
print(answer)
