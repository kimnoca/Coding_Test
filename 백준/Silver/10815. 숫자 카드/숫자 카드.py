n = int(input())
has = list(map(int, input().split()))
m = int(input())
target = list(map(int, input().split()))
has.sort()


def bin_search(start, end, n):
    mid = int((start + end) / 2)
    while start <= end:
        if has[mid] == n:
            return 1
        elif has[mid] < n:
            start = mid + 1
            mid = int((start + end) / 2)
        elif has[mid] > n:
            end = mid - 1
            mid = int((start + end) / 2)
    else:
        return 0


result = []
for n in target:
    start = 0
    end = len(has) - 1
    mid = int((start + end) / 2)
    result.append(bin_search(start, end, n))
print(*result)
