#!/bin/python3

import math
import os
import random
import re
import sys

class BinarySearchTreeNode:
    def __init__(self, node_data):
        self.data = node_data
        self.left = None
        self.right = None

def insert_node_into_binary_search_tree(node, node_data):
    if node == None:
        node = BinarySearchTreeNode(node_data)
    else:
        if (node_data <= node.data):
            node.left = insert_node_into_binary_search_tree(node.left, node_data)
        else:
            node.right = insert_node_into_binary_search_tree(node.right, node_data)

    return node

def print_binary_search_tree_inorder_traversal(node, l):
    if node == None:
        return

    print_binary_search_tree_inorder_traversal(node.left, l)

    l.append(node.data)

    print_binary_search_tree_inorder_traversal(node.right, l)



IN_PATH='./input/input{}.txt'
OUT_PATH='./output/output{}.txt'
N_FILES=15
N_SIZE_OF_LIST_MAX=10000

DIVISOR_START=100
DIVISOR_STOP=100

def create_tree(n, maxv, t_n):
    tree = None
    numbers = []
    to_delete = []
    for i in range(n):
        val = random.randrange(1, maxv)
        while val in numbers:
            val = random.randrange(1, maxv)
        numbers.append(val)
        tree = insert_node_into_binary_search_tree(tree, val)
    for i in range(t_n):
        val = random.choice(numbers)
        while val in to_delete:
            val = random.choice(numbers)
        to_delete.append(val)

    return tree, numbers, to_delete

def find_to_delete(root, to_delete):
    if root == None:
        return None
    if root.left != None and root.left.data == to_delete:
        return root
    if root.right != None and root.right.data == to_delete:
        return root
    
    left = find_to_delete(root.left, to_delete) if root.left != None else None
    right = find_to_delete(root.right, to_delete) if root.right != None else None

    if left != None:
        return left
    if right != None:
        return right

    return None

def get_sol(root, to_delete):
    sol = []
    sol.append(root)

    for n in to_delete:
        for i in range(len(sol)):
            if sol[i].data == n:
                if sol[i].left != None:
                    sol.append(sol[i].left)
                if sol[i].right != None:
                    sol.append(sol[i].right)
                del sol[i]
                break
            else:
                parent = find_to_delete(sol[i], n)
                if parent == None:
                    continue

                tmp = None
                if parent.left != None and parent.left.data == n:
                    tmp = parent.left
                    parent.left = None
                elif parent.right != None and parent.right.data == n:
                    tmp = parent.right
                    parent.right = None
                
                if tmp != None and tmp.left != None:
                    sol.append(tmp.left)
                if tmp != None and tmp.right != None:
                    sol.append(tmp.right)
                break
    
    return sol


def cmp(a, b):
    return b.data - a.data

for i in range(N_FILES):
    minv = i*(N_SIZE_OF_LIST_MAX//(DIVISOR_START * (N_FILES-i)))+1
    maxv = (i+1)*(N_SIZE_OF_LIST_MAX//(DIVISOR_STOP * (N_FILES-(i))))+1

    n = random.randrange(minv, maxv)
    t_n = random.randrange(1, n)

    tree, numbers, to_delete = create_tree(n, maxv, t_n)

    print(numbers, to_delete)

    # print_binary_search_tree_inorder_traversal(tree, "->")
    # print("")
    sol = get_sol(tree, to_delete)
    sol = sorted(sol, key=lambda x:x.data)

    # for s in sol:
    #     print_binary_search_tree_inorder_traversal(s, ",")
    #     print("")

    with open(IN_PATH.format(str(i).zfill(2)), 'w') as file:
        file.write("{}\n".format(n))
        for num in numbers:
            file.write("{}\n".format(num))
        file.write("{}\n".format(t_n))
        # print([t for t in to_delete], to_delete)
        file.write("{}\n".format(" ".join([str(t) for t in to_delete])))
     
    with open(OUT_PATH.format(str(i).zfill(2)), 'w') as file:
        for s in sol:
            l = []
            print_binary_search_tree_inorder_traversal(s, l)
            file.write("{}\n".format(" ".join([str(c) for c in l])))
        
