from collections import deque

# visited 를 깊이로 사용함 재밌는 아이디어~
n, m = map(int, input().split())
matrix = []
visted = [[0] * m for _ in range(n)]
for _ in range(n):
    matrix.append(list(map(int, input())))


def bfs(x, y):
    visted[x][y] = 1
    queue = deque()
    queue.append((x, y))
    while queue:
        x, y = queue.popleft()
        if x + 1 == n and y + 1 == m:
            return visted[x][y]
        dx = [1, -1, 0, 0]
        dy = [0, 0, 1, -1]
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if (0 <= nx < n) and (0 <= ny < m):
                if visted[nx][ny] == 0 and matrix[nx][ny] == 1:
                    visted[nx][ny] = visted[x][y] + 1
                    queue.append((nx, ny))


print((bfs(0, 0)))