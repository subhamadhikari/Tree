package part2;

import java.util.Scanner;

public class HeightBT {
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        NodeBT root = createBinaryTree();
        System.out.println("Height of binary tree: " + heightOfBT(root));
    }

    public static NodeBT createBinaryTree() {
        NodeBT root = null;
        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        root = new NodeBT(data);
        System.out.println("Enter data for left of: " + data);
        root.left = createBinaryTree();
        System.out.println("Enter data for the right of: " + data);
        root.right = createBinaryTree();

        return root;
    }

    public static int heightOfBT(NodeBT root) {
        if (root == null) {
            return 0;
        }
        return Math.max(heightOfBT(root.left), heightOfBT(root.right)) + 1;
    }
}

class NodeBT {
    int data;
    NodeBT left, right;

    public NodeBT(int data) {
        this.data = data;
    }
}
