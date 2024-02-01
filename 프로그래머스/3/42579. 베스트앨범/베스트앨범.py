def solution(genres, plays):
    answer = []
    genres_set = set(genres)
    genres_plays_counts = {}
    
    for i in range(len(genres)):
        if genres[i] in genres_plays_counts:
            temp = [*(genres_plays_counts[genres[i]]), (plays[i], i)]
            genres_plays_counts[genres[i]] = temp
        else:
            genres_plays_counts[genres[i]] = [(plays[i], i)]
    
    genres_plays_sum = dict.fromkeys(genres_set, 0)
    
    for gen in genres_set:
        for play, index in genres_plays_counts[gen]:
            genres_plays_sum[gen] += play
            
    ranks = sorted(genres_plays_sum.items(), key = lambda x : x[1], reverse=True)
    for rank, _ in ranks:
        temp = sorted(genres_plays_counts[rank], key = lambda x : -x[0])
        for i in range(2):
            if len(temp) == 1:
                answer.append(temp[i][1])
                break
            answer.append(temp[i][1])
                    
    return answer