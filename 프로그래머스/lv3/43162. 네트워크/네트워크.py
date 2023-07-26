def solution(n, computers):
    answer = 0
    visited = [[False] * n for _ in range(n)]

    def dfs(x, y):
        visited[x][y] = True
        for i in range(len(computers[y])):
            if computers[y][i] == 1 and not visited[y][i]:
                dfs(y, i)

    for i in range(n):
        for j in range(n):
            if not visited[i][j] and computers[i][j] == 1:
                answer += 1
                dfs(i, j)

    return answer