def solution(arr1, arr2):
    answer = []

    for i in range(len(arr1)):
        answer.append([])  # 2차원 리스트 동적 생성
        for j in range(len(arr1[i])):
            answer[i].append(arr1[i][j] + arr2[i][j])

    return answer


print(solution([[1, 2], [2, 3]], [[3, 4], [5, 6]]))
