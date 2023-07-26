import sys

sys.setrecursionlimit(10**7)


n = int(input())

matrix = []

for _ in range(n):
    matrix.append(list(map(int, input())))

visited = [[False] * n for _ in range(n)]


def dfs(x, y):
    global cnt
    cnt += 1
    visited[x][y] = True
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if (0 <= nx < n) and (0 <= ny < n):
            if not visited[nx][ny] and matrix[nx][ny] == 1:
                dfs(nx, ny)


result = []
for i in range(n):
    for j in range(n):
        cnt = 0
        if matrix[i][j] == 1 and not visited[i][j]:
            dfs(i, j)
        if cnt != 0:
            result.append(cnt)
result.sort()
print(len(result))
for i in result:
    print(i)
