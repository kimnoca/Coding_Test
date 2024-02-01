def solution(clothes):
    answer = 1
    hash_map = {}
    
    for  clothe, type in clothes:
        if type in hash_map:
            hash_map[type] = [*hash_map[type], clothe]
        else :
            hash_map[type] = [clothe]
        
    for key, value in hash_map.items():
        answer *= (len(value) + 1)      
        
    return answer - 1