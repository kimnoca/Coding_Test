def solution(quiz):
    answer = []
    tmp = []
    result = 0
    for i in range(len(quiz)):
        tmp = quiz[i].split(" ")
        if tmp[1] == "+":
            result = int(tmp[0]) + int(tmp[2])
        elif tmp[1] == "-":
            result = int(tmp[0]) - int(tmp[2])
        if result == int(tmp[4]):
            answer.append("O")
        else:
            answer.append("X")
    return answer
