# import heapq
from heapq import heapify, heappop, heappush
def solution(scoville, K):
    answer = 0
    heapify(scoville)
    while scoville[0] < K:
        if len(scoville) < 2:
            break
        a = heappop(scoville)
        b = heappop(scoville)
        heappush(scoville, a + (b * 2))
        answer += 1
    if (len(scoville) <= 1 and scoville[0] < K):
        return -1
        
    return answer