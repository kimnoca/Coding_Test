def solution(s):
    answer = True
    stack = []
    flag = 0
    for c in s:
        if flag < 0:
            return False
        if c == "(":
            flag += 1
        else :
            flag -= 1
    if flag != 0: return False
    return True