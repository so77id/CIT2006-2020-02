import random

IN_PATH='./input/input{}.txt'
OUT_PATH='./output/output{}.txt'
N_FILES=15
N_SIZE_OF_LIST_MAX=10000

DIVISOR_START=100
DIVISOR_STOP=100

# def get_list(n, max):
#     list = []
#     for i in range(n):
#         list.append(random.randrange(-max, max))
#     list.sort()
#     return list
#
# def merge_list(l1, l2):
#     l = l1 + l2
#     l.sort()
#     return l

def create_list(n):
    l = []
    for i in range(n):
        l.append(random.randrange(-245, 245))
    return l

def sol(l):
    s = []
    for i in range(len(l)):
        # print("i", i)
        ap = False
        for j in range(i+1, len(l)):
            # print("\tj", j)
            if l[i] < l[j]:
                s.append(j-i)
                ap=True
                break
        if not ap:
            s.append(0)
    # s.append(0)
    return s



for i in range(N_FILES):
    min = i*(N_SIZE_OF_LIST_MAX//(DIVISOR_START * (N_FILES-i)))+1
    max = (i+1)*(N_SIZE_OF_LIST_MAX//(DIVISOR_STOP * (N_FILES-(i))))+1

    n = random.randrange(min, max)
    T = create_list(n)
    S = sol(T)

    print(n, T, S)


    with open(IN_PATH.format(str(i).zfill(2)), 'w') as file:
        file.write(f"{n}\n")
        T_ = " ".join([str(t) for t in T])
        file.write(f"{T_}\n")

    with open(OUT_PATH.format(str(i).zfill(2)), 'w') as file:
        l_ = " ".join([str(s) for s in S])
        file.write(f"{l_}\n")
