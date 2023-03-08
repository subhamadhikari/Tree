package part2;

import java.util.Scanner;

public class SizeBT {
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        NodeBT1 root = createTree();
        System.out.println("Size of binary tree: " + sizeOfBinaryTree(root));
        System.out.println("Maximum value of binary tree: " + maxInBT(root));
    }

    public static NodeBT1 createTree() {
        NodeBT1 root = null;

        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        root = new NodeBT1(data);

        System.out.println("Enter for left node of: " + data);
        root.left = createTree();
        System.out.println("Enter for right node of: " + data);
        root.right = createTree();

        return root;
    }

    // gives total number of nodes in a binary tree.
    public static int sizeOfBinaryTree(NodeBT1 root) {
        if (root == null) {
            return 0;
        }
        int leftSize = sizeOfBinaryTree(root.left);
        int rightSize = sizeOfBinaryTree(root.right);

        return rightSize + leftSize + 1;
    }

    public static int maxInBT(NodeBT1 root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int leftMax = maxInBT(root.left);
        int rightMax = maxInBT(root.right);
        int maxLR = Math.max(leftMax, rightMax);

        return Math.max(root.data, maxLR);
    }

}

class NodeBT1 {
    int data;
    NodeBT1 left, right;

    public NodeBT1(int data) {
        this.data = data;
    }
}
