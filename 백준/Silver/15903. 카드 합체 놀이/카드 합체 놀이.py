import heapq

n, m = map(int, input().split())
queue = list(map(int, input().split()))
heapq.heapify(queue)


for i in range(m):
    x = heapq.heappop(queue)
    y = heapq.heappop(queue)
    heapq.heappush(queue, x + y)
    heapq.heappush(queue, x + y)


print(sum(queue))
