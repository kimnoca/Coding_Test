import sys

input = sys.stdin.readline
sys.setrecursionlimit(10**7)


def dfs(v):
    visited[v] = True
    for i in graph[v]:
        if not visited[i]:
            dfs(i)


T = int(input())

for _ in range(T):
    count = -1
    N = int(input())
    graph = [[] for _ in range(N + 1)]
    visited = [False] * (N + 1)
    data = list(map(int, input().split()))
    for i in range(1, N + 1):
        graph[i].append(data[i - 1])
        graph[data[i - 1]].append(i)
    for i in range(N + 1):
        if not visited[i]:
            dfs(i)
            count += 1
    print(count)
