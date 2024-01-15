from collections import deque

t = int(input())

dx = [1, 1, 2, 2, -1, -1, -2, -2]
dy = [2, -2, 1, -1, 2, -2, 1, -1]


def bfs(x, y):
    queue = deque()
    queue.append((start_x, start_y))

    while queue:
        x, y = queue.popleft()

        if x == end_x and y == end_y:
            print(matrix[end_x][end_y])
            return

        for i in range(8):
            nx = dx[i] + x
            ny = dy[i] + y
            if (0 <= nx < n) and (0 <= ny < n) and visited[nx][ny] == False:
                matrix[nx][ny] = matrix[x][y] + 1
                queue.append((nx, ny))
                visited[nx][ny] = True


for _ in range(t):
    n = int(input())
    matrix = []
    visited = []
    for x in range(n):
        matrix.append([0] * n)
        visited.append([False] * n)
    start_x, start_y = map(int, input().split(" "))
    end_x, end_y = map(int, input().split(" "))

    bfs(start_x, start_y)
