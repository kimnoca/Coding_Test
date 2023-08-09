from collections import deque


def solution(maps):
    answer = 0
    visited = [[-1] * len(maps[0]) for _ in range(len(maps))]
    print(visited)

    def bfs(x, y):
        visited[x][y] = 1
        queue = deque()
        queue.append((x, y))
        while queue:
            x, y = queue.popleft()
            dx = [1, -1, 0, 0]
            dy = [0, 0, 1, -1]
            for i in range(len(dx)):
                nx = dx[i] + x
                ny = dy[i] + y
                if (0 <= nx < len(maps)) and (0 <= ny < len(maps[nx])):
                    if visited[nx][ny] == -1 and maps[nx][ny] == 1:
                        visited[nx][ny] = visited[x][y] + 1
                        queue.append((nx, ny))
        return visited[len(maps) - 1][len(maps[0]) - 1]

    return bfs(0, 0)