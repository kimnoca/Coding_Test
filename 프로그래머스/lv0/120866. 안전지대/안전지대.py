import copy

answer = 0


def solution(board):
    # answer = 0
    visited = [[False] * len(board) for _ in range(len(board))]
    check = copy.deepcopy(board)  # 원본 리스트에 영향 x
    for x in range(len(check)):
        for y in range(len(check)):
            dx = [1, -1, 0, 0, 1, -1, -1, 1]
            dy = [0, 0, 1, -1, 1, -1, 1, -1]
            if check[x][y] == 1 and not visited[x][y] and board[x][y] == 1:
                visited[x][y] = True
                # print(x, y)
                for i in range(8):
                    nx = dx[i] + x
                    ny = dy[i] + y
                    if (0 <= nx < len(check)) and (0 <= ny < len(check)):
                        check[nx][ny] = 1

    visited = [[False] * len(board) for _ in range(len(board))]

    def dfs(x, y):
        global answer
        answer += 1
        visited[x][y] = True
        dx = [1, -1, 0, 0]
        dy = [0, 0, 1, -1]
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if (0 <= nx < len(check)) and (0 <= ny < len(check)):
                if not visited[nx][ny] and check[nx][ny] == 0:
                    dfs(nx, ny)

    for x in range(len(check)):
        for y in range(len(check)):
            if not visited[x][y] and check[x][y] == 0:
                dfs(x, y)

    return answer
