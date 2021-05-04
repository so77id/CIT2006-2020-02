import random

IN_PATH='./input/input{}.txt'
OUT_PATH='./output/output{}.txt'
N_FILES=15
N_SIZE_OF_LIST_MAX=1000

DIVISOR_START=10
DIVISOR_STOP=10

def get_list(n):
    list = []
    for i in range(n):
        list.append(random.choice([0,1,2,3,4,5,6,7,8,9]))
    return list

def change_order(list):
    new_list = []
    i = 0
    while i<len(list):
        new_list.extend(list[i:i+2][::-1])
        i+=2
    return new_list


for i in range(N_FILES):
    min = i*(N_SIZE_OF_LIST_MAX//(DIVISOR_START * (N_FILES-i)))+1
    max = (i+1)*(N_SIZE_OF_LIST_MAX//(DIVISOR_STOP * (N_FILES-(i))))+1

    n = random.randrange(min, max)
    list = get_list(n)
    new_list = change_order(list)

    with open(IN_PATH.format(str(i).zfill(2)), 'w') as file:
        file.write(f"{n}\n")
        for c in list:
            file.write(f'{c}\n')

    with open(OUT_PATH.format(str(i).zfill(2)), 'w') as file:
        new_list = ' '.join([str(c) for c in new_list])
        file.write(f'{new_list}\n')
