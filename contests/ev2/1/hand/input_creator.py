import random

IN_PATH='./input/input{}.txt'
OUT_PATH='./output/output{}.txt'
N_FILES=15
N_SIZE_OF_LIST_MAX=10000

DIVISOR_START=100
DIVISOR_STOP=100

resp = [True, True, True, False]

def get_list(n_lists, size, maxv):
    l = []
    for i in range(n_lists):
        n = random.randrange(0, maxv)
        # l.append(n)
        for j in range(size):
            l.append(n+j)

    res = random.choice(resp)
    if res == True:
        random.shuffle(l)
        return l, True
    else:
        s = random.randrange(0, size)
        for i in range(s):
            l.append(random.randrange(0,maxv))
        random.shuffle(l)
        return l, False



for i in range(N_FILES):
    minv = i*(N_SIZE_OF_LIST_MAX//(DIVISOR_START * (N_FILES-i)))+1
    maxv = (i+1)*(N_SIZE_OF_LIST_MAX//(DIVISOR_STOP * (N_FILES-(i))))+1

    n = random.randrange(minv, maxv)
    n_lists = random.randrange(minv, min(maxv, n + (1 if n == minv else 0)))

    l, res = get_list(n_lists, n, maxv)
    # print (n , n_lists, res, l)

    with open(IN_PATH.format(str(i).zfill(2)), 'w') as file:
        file.write("{}\n".format(len(l)))
        file.write("{}\n".format(n_lists))
        T_ = " ".join([str(t) for t in l])
        file.write("{}\n".format(T_))

    with open(OUT_PATH.format(str(i).zfill(2)), 'w') as file:
        file.write("{}\n".format(res))
        
