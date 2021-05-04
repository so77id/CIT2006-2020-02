import random

IN_PATH='./input/input{}.txt'
OUT_PATH='./output/output{}.txt'
N_FILES=15
N_SIZE_OF_LIST_MAX=1000

DIVISOR_START=10
DIVISOR_STOP=10

def get_number(size):
    n = ""
    for i in range(size):
        if i == 0:
            n += random.choice(['1', '2', '3', '4', '5', '6', '7', '8', '9'])
        else:
            n += random.choice(['0', '1', '2', '3', '4', '5', '6', '7', '8', '9'])
    return n, int(n)
def num2s(num):
    s = ""
    while num > 0:
        s += str(num%10)
        num //= 10
    return s[::-1]


for i in range(N_FILES):
    min = i*(N_SIZE_OF_LIST_MAX//(DIVISOR_START * (N_FILES-i)))+1
    max = (i+1)*(N_SIZE_OF_LIST_MAX//(DIVISOR_STOP * (N_FILES-(i))))+1

    n = random.randrange(min, max)
    num_s, num = get_number(n)
    plus = num + 1
    plus = num2s(plus)

    with open(IN_PATH.format(str(i).zfill(2)), 'w') as file:
        file.write(f"{n}\n")
        for c in num_s:
            file.write(f'{c}\n')

    with open(OUT_PATH.format(str(i).zfill(2)), 'w') as file:
        plus = ' '.join([c for c in plus])
        file.write(f'{plus}\n')
