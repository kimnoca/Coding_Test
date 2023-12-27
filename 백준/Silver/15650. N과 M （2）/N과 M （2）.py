n, m = map(int, input().split())


array = []


def dfs(start):
    if m == len(array):
        print(*array)
        return

    for i in range(start, n + 1):
        if i not in array:
            array.append(i)
            dfs(i)
            array.pop()


dfs(1)
