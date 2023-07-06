def solution(s):
    answer = 1
    tmp = []
    tmp.append(s[0])
    x = 1
    y = 0

    for i in range(1, len(s)):
        if x == y:
            tmp.clear()
            tmp.append(s[i])
            x = 1
            y = 0
            answer += 1
            continue
        if tmp[0] == s[i]:
            x += 1
        if tmp[0] != s[i]:
            y += 1

    return answer