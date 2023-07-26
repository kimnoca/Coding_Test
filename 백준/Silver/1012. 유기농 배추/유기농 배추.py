import sys

sys.setrecursionlimit(10**7)


def dfs(x, y):
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    visited[x][y] = True
    for i in range(4):
        cx = x + dx[i]
        cy = y + dy[i]
        if cx < 0 or cy < 0 or cx >= m or cy >= n:
            continue
        if graph[cx][cy] == 1 and not visited[cx][cy]:
            dfs(cx, cy)


T = int(input())
for i_ in range(T):
    m, n, v = map(int, input().split())
    graph = [[0] * n for _ in range(m)]
    visited = [[False] * n for _ in range(m)]
    for _ in range(v):
        a, b = map(int, input().split())
        graph[a][b] = 1
    # print(graph)
    count = 0

    for i in range(m):
        for j in range(n):
            if not visited[i][j] and graph[i][j] == 1:
                dfs(i, j)
                count += 1
    print(count)
