def solution(hp):
    answer = 0
    general = 5
    soldier = 3
    worker = 1
    tmp = 0
    while hp != 0:
        if hp >= general:
            hp -= general
            answer += 1
        elif hp < general and hp >= soldier:
            hp -= soldier
            answer += 1
        else:
            hp -= worker
            answer += 1

    return answer