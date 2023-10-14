import copy

def solution(score):
    answer = []
    score_avg = list(map(lambda x : (x[0] + x[1]) / 2 , score))
    rank = copy.deepcopy(score_avg)
    rank.sort(reverse=True)
    for i in score_avg:
        answer.append(rank.index(i) + 1)
    return answer