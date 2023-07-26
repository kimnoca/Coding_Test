def solution(sizes):
    for i in sizes:
        if i[0] < i[1]:
            i[0], i[1] = i[1], i[0]
    return max(map(lambda x: x[0], sizes)) * max(map(lambda x: x[1], sizes))