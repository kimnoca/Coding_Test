def solution(my_string):
    answer = 0
    split = []
    for i in range(len(my_string)):
        if not my_string[i].isdigit():
            my_string = my_string.replace(my_string[i], "-")
    split = my_string.split("-")
    for i in range(len(split)):
        if split[i] != "":
            answer += int(split[i])
    return answer