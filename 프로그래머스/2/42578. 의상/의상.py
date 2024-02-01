def solution(clothes):
    answer = 1
    hash_map = {}
    
    for clothe in clothes:
        if clothe[1] in hash_map:
            hash_map[clothe[1]] = [*hash_map[clothe[1]], clothe[0]]
        else :
            hash_map[clothe[1]] = [clothe[0]]
        
    for key, value in hash_map.items():
        answer *= (len(value) + 1)      
        
    return answer - 1