import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class BinarySearchTreeNode {
    public int data;
    public BinarySearchTreeNode left;
    public BinarySearchTreeNode right;

    BinarySearchTreeNode (int nodeData) {
        this.data = nodeData;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    public BinarySearchTreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insertNode(int nodeData) {
        this.root = this.insertNode(this.root, nodeData);
    }

    private BinarySearchTreeNode insertNode(BinarySearchTreeNode root, int nodeData) {
        if (root == null) {
            root = new BinarySearchTreeNode(nodeData);
        } else {
            if (nodeData <= root.data) {
                root.left = this.insertNode(root.left, nodeData);
            } else {
                root.right = this.insertNode(root.right, nodeData);
            }
        }

        return root;
    }
}

class BinarySearchTreePrintHelper {
    public static void printInorder(BinarySearchTreeNode root, String sep, BufferedWriter bufferedWriter) throws IOException {
        if (root == null) {
            return;
        }

        BinarySearchTreePrintHelper.printInorder(root.left, sep, bufferedWriter);

        if (root.left != null) {
            bufferedWriter.write(sep);
        }

        bufferedWriter.write(String.valueOf(root.data));

        if (root.right != null) {
            bufferedWriter.write(sep);
        }

        BinarySearchTreePrintHelper.printInorder(root.right, sep, bufferedWriter);
    }
}

class Result {

    /*
     * Complete the 'rootForest' function below.
     *
     * The function is expected to return an INTEGER_BINARY_SEARCH_TREE_ARRAY.
     * The function accepts INTEGER_BINARY_SEARCH_TREE tree as parameter.
     */

    /*
     * For your reference:
     *
     * BinarySearchTreeNode {
     *     int data;
     *     BinarySearchTreeNode left;
     *     BinarySearchTreeNode right;
     * }
     *
//      */
    
    public static List<BinarySearchTreeNode> rootForest(BinarySearchTreeNode root, List<Integer> to_delete) {
        
    }

}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        BinarySearchTree tree = new BinarySearchTree();

        int treeCount = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, treeCount).forEach(i -> {
            try {
                int treeItem = Integer.parseInt(bufferedReader.readLine().trim());

                tree.insertNode(treeItem);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        
        List<Integer> to_delete = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<BinarySearchTreeNode> res = Result.rootForest(tree.root, to_delete);
        
        Collections.sort(res, (a, b) -> {return a.data - b.data;});
        
        for(BinarySearchTreeNode root:res) {
            BinarySearchTreePrintHelper.printInorder(root, " ", bufferedWriter);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}