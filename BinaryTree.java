package part2;

import java.util.Scanner;

public class BinaryTree {
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = createTree();

        System.out.println("Inorder Traversal");
        inOrder(root);
        System.out.println("");
        System.out.println("Preorder Traversal");
        preOrder(root);
        System.out.println("");
        System.out.println("Postorder Traversal");
        postOrder(root);

    }

    public static Node createTree() {
        Node root = null;

        System.out.println("Enter data:");
        int data = sc.nextInt();

        // creating tree recursively, so we are setting data == -1 as base case.
        if (data == -1) {
            return null;
        }

        root = new Node(data);

        System.out.println("Enter left for " + data);
        root.left = createTree();

        System.out.println("Enter right for " + data);
        root.right = createTree();

        return root;
    }

    public static void inOrder(Node root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void preOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

}

class Node {
    Node left;
    Node right;
    int data;

    public Node(int data) {
        this.data = data;
    }
}
