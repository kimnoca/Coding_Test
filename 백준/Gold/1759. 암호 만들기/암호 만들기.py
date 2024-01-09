n, m = map(int, input().split())
string = list(input().split(" "))
string.sort()

visited = []

check = ["a", "e", "i", "o", "u"]


def dfs(start):
    if len(visited) == n:
        visited.sort()
        check1 = 0
        check2 = 0
        for i in visited:
            if i in check:
                check1 += 1
            else:
                check2 += 1
        if check1 >= 1 and check2 >= 2:
            print("".join(visited))
        return

    for i in range(start, m):
        if string[i] not in visited:
            visited.append(string[i])
            dfs(i + 1)
            visited.pop()


dfs(0)
