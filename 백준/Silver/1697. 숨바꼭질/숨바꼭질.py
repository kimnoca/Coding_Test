from collections import deque

n, k = map(int, input().split())


visited = [0] * 100001


def bfs(x):
    queue = deque()
    queue.append(x)

    while queue:
        x = queue.popleft()

        if x == k:
            return visited[k]

        for nx in (x - 1, x + 1, 2 * x):
            if (0 <= nx <= 100000) and not visited[nx]:
                visited[nx] = visited[x] + 1
                queue.append(nx)


print(bfs(n))
