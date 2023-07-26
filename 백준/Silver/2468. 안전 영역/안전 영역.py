import sys

sys.setrecursionlimit(10**7)

n = int(input())

matrix = []
for _ in range(n):
    matrix.append(list(map(int, input().split())))
high = 0
for i in matrix:
    if max(i) > high:
        high = max(i)


def dfs(x, y, high):
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    visited[x][y] = True
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if (0 <= nx < n) and (0 <= ny < n):
            if matrix[nx][ny] > high and not visited[nx][ny]:
                dfs(nx, ny, high)


result = 0
for k in range(high + 1):
    visited = [[False] * n for _ in range(n)]
    count = 0
    for i in range(n):
        for j in range(n):
            if matrix[i][j] > k and not visited[i][j]:
                dfs(i, j, k)
                count += 1

        if count > result:
            result = count
print(result)
