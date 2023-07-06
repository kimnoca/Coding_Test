def solution(n):
    answer = 0
    tmp = str(n)
    for i in range(len(tmp)):
        answer += int(tmp[i])
    return answer
