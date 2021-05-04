import random

IN_PATH='./input/input{}.txt'
OUT_PATH='./output/output{}.txt'
N_FILES=15
N_SIZE_OF_LIST_MAX=10000

DIVISOR_START=100
DIVISOR_STOP=100

chars = [chr(i) for i in range(33,126,1)]

def cmp(a,b):
    if b[1] != a[1]:
        return b[1] - a[1]
    else:
        return ord(a[0]) - ord(b[0])

def get_string(n):
    s = []
    while n>0:
        f = random.randrange(1,n+1)
        n = n-f
        symb = random.choice(chars)
        s.extend([symb for i in range(f)])
    return s

for i in range(N_FILES):
    minv = i*(N_SIZE_OF_LIST_MAX//(DIVISOR_START * (N_FILES-i)))+1
    maxv = (i+1)*(N_SIZE_OF_LIST_MAX//(DIVISOR_STOP * (N_FILES-(i))))+1

    n = random.randrange(minv, maxv)
    s = get_string(n)

    m = {}
    for c in s:
        if c in m:
            m[c]+=1
        else:
            m[c]=1

    items = [(k,v) for k,v in m.items()]
    items.sort(key=cmp)
    random.shuffle(s)
    items = ''.join([c*f for c,f in items])
    s = ''.join([c for c in s])
    print(s, items)


    with open(IN_PATH.format(str(i).zfill(2)), 'w') as file:
        file.write("{}\n".format(s))

    with open(OUT_PATH.format(str(i).zfill(2)), 'w') as file:
        file.write("{}\n".format(items))
        
