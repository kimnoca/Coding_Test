def solution(array, commands):
    answer = []
    for a in commands:
        i = a[0] - 1
        j = a[1]
        k = a[2]
        tmp = array[i:j]
        tmp.sort()
        answer.append(tmp[k - 1])

    return answer