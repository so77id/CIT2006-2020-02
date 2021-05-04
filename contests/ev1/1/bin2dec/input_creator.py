import random

IN_PATH='./input/input{}.txt'
OUT_PATH='./output/output{}.txt'
N_FILES=10
N_SIZE_OF_LIST_MAX=10000

DIVISOR_START=100
DIVISOR_STOP=100

# def create_list(N, max):
#     list_map = {}
#     counter = 0
#
#     while counter < N:
#         new = random.randrange(0, max)
#         if new not in list_map:
#             counter+=1
#             list_map[new] = new
#
#     list_ = np.array(list(list_map.keys()))
#     i = np.arange(list_.size)
#     np.random.shuffle(i)
#     list_ = list_[i]
#
#     return list_.tolist()
def create_bin(i):
    n = [0, 1]
    list = []
    for j in range(i+1):
        list.append(random.choice(n))

    return list

def bin2dec(list):
    n = len(list)
    num = 0
    for i in range(n):
        num += list[i] * 2**(n-1-i)

    return num


for i in range(0, 31):
    print(i)
    list = create_bin(i)
    num = bin2dec(list)
    print (list, num)


    with open(IN_PATH.format(str(i).zfill(2)), 'w') as file:
        file.write(f"{i+1}\n")
        for n in list:
            file.write(f"{n}\n")

    with open(OUT_PATH.format(str(i).zfill(2)), 'w') as file:
        file.write(f"{num}\n")
