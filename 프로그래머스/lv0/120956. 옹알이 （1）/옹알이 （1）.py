def solution(babbling):
    answer = 0
    can = ["aya", "ye", "woo", "ma"]
    result = []
    skip = []
    for i in range(len(babbling)):
        if babbling[i] in can:
            answer += 1
            skip.append(i)
    for i in range(len(babbling)):
        for k in range(len(can)):
            if can[k] in babbling[i] and i not in skip:
                if babbling[i].replace(can[k], "") == "":
                    babbling[i] = babbling[i].replace(can[k], "")
                    result.append(babbling[i].replace(can[k], ""))
                else:
                    babbling[i] = babbling[i].replace(can[k], "-")
                    result.append(babbling[i].replace(can[k], "-"))
    for i in range(len(result)):
        result[i] = result[i].replace("-", "")
        if result[i] == "":
            answer += 1
    return answer