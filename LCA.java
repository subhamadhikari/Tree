package part2;

import java.util.Scanner;

public class LCA {
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node7 root = createTree();
        Node7 lowestAncestor = lca(root, 6, 7);
        System.out.println("Lowest ancestor -> " + lowestAncestor.data);
    }

    public static Node7 lca(Node7 root, int n1, int n2) {
        if (root == null) {
            return null;
        }

        if (root.data == n1 || root.data == n2) {
            return root;
        }

        Node7 left = lca(root.left, n1, n2);
        Node7 right = lca(root.right, n1, n2);

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        return root;

    }

    public static Node7 createTree() {
        System.out.println("Enter data");
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        Node7 root = new Node7(data);
        System.out.println("Enter for left of " + root.data);
        root.left = createTree();
        System.out.println("Enter for right of " + root.data);
        root.right = createTree();
        return root;

    }
}

class Node7 {
    Node7 left, right;
    int data;

    public Node7(int data) {
        this.data = data;
    }
}
