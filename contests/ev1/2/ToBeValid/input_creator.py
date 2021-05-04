import random

IN_PATH='./input/input{}.txt'
OUT_PATH='./output/output{}.txt'
N_FILES=15
N_SIZE_OF_LIST_MAX=1000

DIVISOR_START=10
DIVISOR_STOP=10

def create_string(n):
    s = ""
    for i in range(n):
        s += random.choice(['(', ')'])
    return s

def sol(s):
    int = 0
    out = 0
    for c in s:
        if c == '(':
            int+=1
        elif c == ')':
            if int > 0:
                int-=1
            else:
                out+=1;
    return int+out

for i in range(N_FILES):
    min = i*(N_SIZE_OF_LIST_MAX//(DIVISOR_START * (N_FILES-i)))+1
    max = (i+1)*(N_SIZE_OF_LIST_MAX//(DIVISOR_STOP * (N_FILES-(i))))+1

    n = random.randrange(min, max)

    s = create_string(n)
    so = sol(s)

    with open(IN_PATH.format(str(i).zfill(2)), 'w') as file:
        file.write(f"{s}\n")

    with open(OUT_PATH.format(str(i).zfill(2)), 'w') as file:
        file.write(f"{so}\n")
