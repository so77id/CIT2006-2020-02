import random

IN_PATH='./input/input{}.txt'
OUT_PATH='./output/output{}.txt'
N_FILES=15
N_SIZE_OF_LIST_MAX=10000

DIVISOR_START=100
DIVISOR_STOP=100

def create_list(n):
    l = []
    for i in range(n):
        l.append(random.randrange(-245, 245))
    return l

# def sol(l):
#     s = []
#     for i in range(len(l)):
#         # print("i", i)
#         ap = False
#         for j in range(i+1, len(l)):
#             # print("\tj", j)
#             if l[i] < l[j]:
#                 s.append(j-i)
#                 ap=True
#                 break
#         if not ap:
#             s.append(0)
#     # s.append(0)
#     return s

def sol(l):
    res = [0 for i in range(len(l))]
    for i in range(len(l)):
        res[i] = -1;
        j = 1
        while j < len(l):
            if l[(i+j) % len(l)] > l[i]:
                res[i] = l[(i+j) % len(l)]
                break
            j+=1
    return res



for i in range(N_FILES):
    min = i*(N_SIZE_OF_LIST_MAX//(DIVISOR_START * (N_FILES-i)))+1
    max = (i+1)*(N_SIZE_OF_LIST_MAX//(DIVISOR_STOP * (N_FILES-(i))))+1

    n = random.randrange(min, max)
    T = create_list(n)
    # T = [1,2,1]
    S = sol(T)

    # print(S)
    # break



    with open(IN_PATH.format(str(i).zfill(2)), 'w') as file:
        file.write(f"{n}\n")
        T_ = " ".join([str(t) for t in T])
        file.write(f"{T_}\n")

    with open(OUT_PATH.format(str(i).zfill(2)), 'w') as file:
        l_ = " ".join([str(s) for s in S])
        file.write(f"{l_}\n")
