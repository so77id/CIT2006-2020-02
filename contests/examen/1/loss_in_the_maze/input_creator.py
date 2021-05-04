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

ch = [0,0,0,1]



def get_maze(m_size):
    maze = []
    for i in range(m_size):
        row = []
        for j in range(m_size):
            row.append(random.choice(ch))
        maze.append(row)

    return maze


for i in range(4, N_FILES):
    l_size = random.randrange(5, 10)+1
    maze = get_maze(l_size)
    print(l_size)

    x = random.randrange(l_size)
    y = random.randrange(l_size)

    while maze[x][y] == 0:
        x = random.randrange(l_size)
        y = random.randrange(l_size)
    
    init = (x,y)
    
    x = random.randrange(l_size)
    y = random.randrange(l_size)

    while maze[x][y] == 0 or init == (x,y):
        x = random.randrange(l_size)
        y = random.randrange(l_size)
    
    fin = (x,y)

    # print(init, fin)



    with open(IN_PATH.format(str(i).zfill(2)), 'w') as file:
        file.write("{}\n".format(init[0]))
        file.write("{}\n".format(init[1]))
        file.write("{}\n".format(fin[0]))
        file.write("{}\n".format(fin[1]))
        file.write("{}\n".format(l_size))

        for j in range(l_size):
            file.write("{}\n".format(' '.join([str(r) for r in maze[j]])))
                
     
    # with open(OUT_PATH.format(str(i).zfill(2)), 'w') as file:
    #     file.write("{}\n".format(' '.join([str(li) for li in l_])))
