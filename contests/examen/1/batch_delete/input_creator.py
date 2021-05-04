#!/bin/python3

import math
import os
import random
import re
import sys

IN_PATH='./input/input{}.txt'
OUT_PATH='./output/output{}.txt'
N_FILES=15
N_SIZE_OF_LIST_MAX=10000

DIVISOR_START=100
DIVISOR_STOP=100

ch = [1,1,1,1,1,1,2,2,2,2,2,3,3,3,4,4,5]

def get_list(l_size):
    l = []
    for i in range(l_size):
        l.append(random.randrange(0, 11))
    
    return l

def sol(l, n, m):
    l_ = []
    s = 0
    i = 0
    while i < len(l):
        if s == 0:
            for j in range(n):
                if i+j >= len(l):
                    break
                l_.append(l[i+j])
            i += n
            s = 1
        elif s == 1:
            i += m
            s = 0
    return l_

for i in range(N_FILES):
    minv = i*(N_SIZE_OF_LIST_MAX//(DIVISOR_START * (N_FILES-i)))+1
    maxv = (i+1)*(N_SIZE_OF_LIST_MAX//(DIVISOR_STOP * (N_FILES-(i))))+1

    l_size = random.randrange(minv, maxv)
    n = random.choice(ch)
    m = random.choice(ch)

    l = get_list(l_size)
    l_ = sol(l, n, m)
    print(l_size, n, m, l, l_)
    



    with open(IN_PATH.format(str(i).zfill(2)), 'w') as file:
        file.write("{}\n".format(n))
        file.write("{}\n".format(m))
        file.write("{}\n".format(l_size))
        for j in range(l_size):
            file.write("{}\n".format(l[j]))
                
     
    with open(OUT_PATH.format(str(i).zfill(2)), 'w') as file:
        file.write("{}\n".format(' '.join([str(li) for li in l_])))
