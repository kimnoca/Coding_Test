def solution(arr):
    answer = []
    arr.reverse()
    num = arr.pop()
    answer.append(num)
    while len(arr) != 0:
        num = arr.pop()
        if answer[len(answer) - 1] == num:
            continue
        else:
            answer.append(num)
    return answer