def solution(park, routes):
    answer = []
    for i in range(len(park)):
        for j in range(len(park[i])):
            if park[i][j] == "S":
                start_x, start_y = i, j
                break
    cur_x = start_x
    cur_y = start_y
    for r in routes:
        c = r[0]
        t = r[2]
        t = int(t)
        check = True
        if c == "E":
            if cur_y + t < len(park[0]):
                for i in range(cur_y, (cur_y + t + 1)):
                    if park[cur_x][i] == "X":
                        check = False
                        break
                if check:
                    cur_y = cur_y + t
        if c == "W":
            if cur_y - t >= 0:
                for i in range(cur_y, (cur_y - t - 1), -1):
                    if park[cur_x][i] == "X":
                        check = False
                        break
                if check:
                    cur_y = cur_y - t

        if c == "N":
            if cur_x - t >= 0:
                for i in range(cur_x, (cur_x - t - 1), -1):
                    print(i)
                    if park[i][cur_y] == "X":
                        check = False
                        break
                if check:
                    cur_x = cur_x - t
        if c == "S":
            if cur_x + t < len(park):
                for i in range(cur_x, (cur_x + t + 1)):
                    if park[i][cur_y] == "X":
                        check = False
                        break
                if check:
                    cur_x = cur_x + t
    answer.append(cur_x)
    answer.append(cur_y)

    return answer