from collections import deque

F, S, G, U, D = map(int, input().split())
# graph = []
count = [0] * (F + 1)
visited = [False] * (F + 1)
#
trans = [U, -1 * D]
# print(trans[1])


# S -> G 로 가야함
# 1번 index를 1층으로 생각
def bfs(v):
    visited[v] = True
    queue = deque([v])
    count[v] = 1
    while queue:
        v = queue.popleft()
        for i in range(2):
            nv = v + trans[i]
            if (0 < nv <= F) and not visited[nv]:
                queue.append(nv)
                visited[nv] = True
                count[nv] = count[v] + 1
    if count[G] == 0:
        return "use the stairs"
    else:
        return count[G] -1


print(bfs(S))