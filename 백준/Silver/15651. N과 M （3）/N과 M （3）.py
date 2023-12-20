n, m = map(int, input().split())

result = []


def dfs():
    if len(result) == m:
        print(*result)
        return

    for i in range(1, n + 1):
        result.append(i)
        dfs()
        result.pop()  # len(result == m) 에서 return 이 나면 여기로 돌아옴


dfs()