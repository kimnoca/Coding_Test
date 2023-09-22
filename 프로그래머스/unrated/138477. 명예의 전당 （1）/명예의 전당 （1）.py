import heapq

def solution(k, score):
    heap = []
    answer = []
    for i in range(len(score)):
        if len(heap) == k :
            if heap[0] < score[i]:
                heapq.heappop(heap)
            else :
                answer.append(heap[0]) 
                continue
        heapq.heappush(heap, score[i])
        answer.append(heap[0])
    return answer