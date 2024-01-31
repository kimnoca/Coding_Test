def solution(participant, completion):
    hash_map = {}
    for part in participant:
        if part in hash_map:
            hash_map[part] += 1
        else:
            hash_map[part] = 1
    for com in completion:
        if com in hash_map:
            hash_map[com] -=1
    for key in hash_map.keys():
        if hash_map[key] != 0:
            return key
    
    
