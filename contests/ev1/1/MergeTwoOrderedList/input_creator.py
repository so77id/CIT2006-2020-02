import random

IN_PATH='./input/input{}.txt'
OUT_PATH='./output/output{}.txt'
N_FILES=15
N_SIZE_OF_LIST_MAX=10000

DIVISOR_START=100
DIVISOR_STOP=100

def get_list(n, max):
    list = []
    for i in range(n):
        list.append(random.randrange(-max, max))
    list.sort()
    return list

def merge_list(l1, l2):
    l = l1 + l2
    l.sort()
    return l

for i in range(N_FILES):
    min = i*(N_SIZE_OF_LIST_MAX//(DIVISOR_START * (N_FILES-i)))+1
    max = (i+1)*(N_SIZE_OF_LIST_MAX//(DIVISOR_STOP * (N_FILES-(i))))+1

    n1 = random.randrange(min, max)
    n2 = random.randrange(min, max)

    # print(n1, n2, min, max)

    l1 = get_list(n1, max)
    l2 = get_list(n2, max)
    l = merge_list(l1, l2)


    with open(IN_PATH.format(str(i).zfill(2)), 'w') as file:
        file.write(f"{n1}\n")
        for n in l1:
            file.write(f"{n}\n")
        file.write(f"{n2}\n")
        for n in l2:
            file.write(f"{n}\n")

    with open(OUT_PATH.format(str(i).zfill(2)), 'w') as file:
        l_ = " ".join([str(n) for n in l])
        file.write(f"{l_}\n")
