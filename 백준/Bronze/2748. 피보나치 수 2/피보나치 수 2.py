n = int(input())

fibo = [0] * (n + 1)
fibo[0] = 0
try:
    fibo[1] = 1
    fibo[2] = 1
    for i in range(3, n + 1):
        fibo[i] = fibo[i - 1] + fibo[i - 2]
except:
    pass
print(fibo[n])
