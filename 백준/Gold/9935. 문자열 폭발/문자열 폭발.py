string = list(input())
target = list(input())
stack = []


index = 0

for i in range(len(string)):
    stack.append(string[i])
    if len(stack) >= len(target):
        for k in range(len(target)):
            # print(k)
            if stack[len(stack) - k - 1] == target[len(target) - k - 1]:
                index += 1
            else:
                index = 0
                break
        if index == len(target):
            # print(stack)
            index = 0
            for j in range(len(target)):
                stack.pop()

if "".join(stack) == "":
    print("FRULA")
else:
    print("".join(stack))
