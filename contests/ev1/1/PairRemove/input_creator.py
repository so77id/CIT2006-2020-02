import random
import math

IN_PATH='./input/input{}.txt'
OUT_PATH='./output/output{}.txt'
N_FILES=15
N_SIZE_OF_LIST_MAX=10000
S_SIZE_LIST=26

DIVISOR_START=100
DIVISOR_STOP=100

char_list = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']


def create_string(n, char_list):
    s = ""
    s_list = []
    for i in range(n):
        a = random.choice(char_list)
        s += a
        s_list.append(a)
    return s, s_list

def reduce(s_list):
    i = 0
    while i < (len(s_list)-1):
        if s_list[i] == s_list[i+1]:
            del s_list[i+1]
            del s_list[i]
            i=0
        else:
            i+=1
    return s_list

for i in range(N_FILES):
    min = i*(N_SIZE_OF_LIST_MAX//(DIVISOR_START * (N_FILES-i)))+1
    max = (i+1)*(N_SIZE_OF_LIST_MAX//(DIVISOR_STOP * (N_FILES-(i))))+1

    char_size = math.ceil(i/(N_FILES) * S_SIZE_LIST) + 2

    n = random.randrange(min, max)

    s, s_list = create_string(n, char_list[:char_size])
    # print(s , char_list[:char_size])
    ss = ''.join(reduce(s_list))

    # print(s)
    # print(ss)
    # print("-----")
    #
    with open(IN_PATH.format(str(i).zfill(2)), 'w') as file:
        file.write(f"{s}\n")

    with open(OUT_PATH.format(str(i).zfill(2)), 'w') as file:
        file.write(f"{ss}\n")
