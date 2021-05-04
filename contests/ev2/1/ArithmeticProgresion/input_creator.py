import random

IN_PATH='./input/input{}.txt'
OUT_PATH='./output/output{}.txt'
N_FILES=15
N_SIZE_OF_LIST_MAX=10000

DIVISOR_START=100
DIVISOR_STOP=100

sol = [True, True, True, False]
N = 10
minn = 100

def get_list(n):
    step = random.randrange(2, N)
    min = random.randrange(1,100)
    l = [i for i in range(min, min + n*step,step)]

    res = random.choice(sol)
    if not res:
        l.append(random.choice(l)+1)
    
    random.shuffle(l)

    return l, res
    
        

for i in range(N_FILES):
    minv = i*(N_SIZE_OF_LIST_MAX//(DIVISOR_START * (N_FILES-i)))+1
    maxv = (i+1)*(N_SIZE_OF_LIST_MAX//(DIVISOR_STOP * (N_FILES-(i))))+1

    n = random.randrange(minv, maxv)
    l, res = get_list(n)

    with open(IN_PATH.format(str(i).zfill(2)), 'w') as file:
        file.write("{}\n".format(len(l)))
        T_ = " ".join([str(t) for t in l])
        file.write("{}\n".format(T_))

    with open(OUT_PATH.format(str(i).zfill(2)), 'w') as file:
        file.write("{}\n".format(res))
        
