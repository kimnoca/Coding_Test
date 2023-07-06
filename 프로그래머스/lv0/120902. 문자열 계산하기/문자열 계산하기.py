def solution(my_string):
    answer = 0
    i = 0
    my_string = my_string.split(" ")
    while i != (len(my_string)):
        if my_string[i].isdigit():
            answer += int(my_string[i])
            i += 1
        else:
            if my_string[i] == "+":
                answer += int(my_string[i + 1])
            else:
                answer -= int(my_string[i + 1])
            i += 2
    return answer