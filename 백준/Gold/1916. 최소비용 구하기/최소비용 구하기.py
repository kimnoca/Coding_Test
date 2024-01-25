import heapq, sys

input = sys.stdin.readline

n = int(input())

m = int(input())


INF = 10e7
distance = [int(INF)] * (n + 1)


graph = [[] for _ in range(n + 1)]

for _ in range(m):
    u, v, w = map(int, input().split())
    graph[u].append([v, w])

start, end = map(int, input().split())


def dijkstra(start):
    queue = []

    heapq.heappush(queue, [0, start])
    distance[start] = 0

    while queue:
        dis, now = heapq.heappop(queue)

        if distance[now] < dis:
            continue

        for i in graph[now]:
            if dis + i[1] < distance[i[0]]:
                distance[i[0]] = dis + i[1]
                heapq.heappush(queue, [dis + i[1], i[0]])


dijkstra(start)
print(distance[end])
