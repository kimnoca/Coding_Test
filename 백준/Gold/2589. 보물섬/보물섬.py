from collections import deque

n, m = map(int, input().split(" "))
graph = []
visited = [[0] * m for _ in range(n)]


for _ in range(n):
    graph.append(list(input()))
# L = 육지, W = 바다

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if (
                (0 <= nx < n)
                and (0 <= ny < m)
                and not visited[nx][ny]
                and graph[nx][ny] == "L"
            ):
                visited[nx][ny] = visited[x][y] + 1
                queue.append((nx, ny))


answer = 0

for i in range(n):
    for k in range(m):
        visited = [[0] * m for _ in range(n)]
        if graph[i][k] == "L" and not visited[i][k]:
            visited[i][k] = 1
            bfs(i, k)
        for j in range(len(visited)):
            answer = max(answer, max(visited[j]))
print(answer - 1)
