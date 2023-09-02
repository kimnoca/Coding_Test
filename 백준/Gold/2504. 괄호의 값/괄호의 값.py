string = input()
# 일단 숫자로 나타낼수 있는거 숫자로 replace
string = string.replace("()", "2")
string = string.replace("[]", "3")
string = list(string)
check = True
answer = 0
stack = []
num1 = 0  # () 의 갯수
num2 = 0  # [] 의 갯수


for i in range(len(string)):  # 올바른 괄호 check
    if num1 < 0 or num2 < 0:
        check = False
        break

    if string[i] == "(":  #
        num1 += 1
    elif string[i] == ")":
        num1 -= 1
    elif string[i] == "[":
        num2 += 1
    elif string[i] == "]":
        num2 -= 1

if num1 != 0 or num2 != 0:
    check = False

for i in range(len(string) - 1):
    if string[i] == "(" and string[i + 1] == "]":
        check = False
    elif string[i] == "[" and string[i + 1] == ")":
        check = False

if check == True:
    for i in range(len(string)):
        if string[i] == ")":
            tmp = 0
            while True:
                s = stack.pop()
                if s == "(":
                    stack.append(str(int(tmp) * 2))
                    break
                else:
                    tmp += int(s)
        elif string[i] == "]":
            tmp = 0
            while True:
                s = stack.pop()
                if s == "[":
                    stack.append(str(int(tmp) * 3))
                    break
                else:
                    tmp += int(s)
        else:
            stack.append(string[i])
else:
    print(0)

for i in range(len(stack)):
    answer += int(stack[i])
if check == True:
    print(answer)
