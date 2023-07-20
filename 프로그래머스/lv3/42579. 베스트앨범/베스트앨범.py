## 뭔가 문제인지 알았음
def solution(genres, plays):
    answer = []
    dict = {}
    for i in range(len(genres)):
        if genres[i] not in dict:
            list = []
            list.append((i, plays[i]))
            dict[genres[i]] = list
        else:
            list = dict.get(genres[i])
            list.append((i, plays[i]))
            dict[genres[i]] = list
    for key in dict.keys():
        list = dict.get(key)
        list.sort(key=lambda x: (-x[1], x[0]))  # key point
        dict[key] = list
    sum_dict = {}
    for key in dict.keys():
        list = dict.get(key)
        sum = 0
        for i in range(len(list)):
            sum += list[i][1]
        sum_dict[key] = sum
    sum_dict = sorted(sum_dict.items(), key=lambda x: -x[1])
    for key, v in sum_dict:
        list = dict.get(key)
        stop = 0
        for i in range(len(list)):
            if stop == 2:
                break
            if len(list) == 1:
                answer.append(list[i][0])
                break
            else:
                answer.append(list[i][0])
            stop += 1

    return answer