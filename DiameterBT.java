package part2;

import java.util.Scanner;
import java.util.*;;

public class DiameterBT {
    static Scanner sc;
    static int ans = 0;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node6 root = createTree();
        int d1 = diameterBT(root);
        heightBinaryTree(root);

        System.out.println("Diameter from method 1 :->" + d1);
        System.out.println("Diameter from method 2 :->" + ans);
    }

    // ---------------
    // O(N^2) - Time complexity
    public static int diameterBT(Node6 root) {
        if (root == null) {
            return 0;
        }
        int dl = diameterBT(root.left);
        int dr = diameterBT(root.right);
        int cur = heightBt4(root.left) + heightBt4(root.right) + 1;

        return Math.max(cur, Math.max(dl, dr));
    }

    public static int heightBt4(Node6 root) {
        if (root == null) {
            return 0;
        }
        return Math.max(heightBt4(root.left), heightBt4(root.right)) + 1;
    }
    // ---------------

    // Optimized code -- O(N)
    public static int heightBinaryTree(Node6 root) {
        if (root == null) {
            return 0;
        }
        int lh = heightBinaryTree(root.left);
        int rh = heightBinaryTree(root.right);
        ans = Math.max(ans, 1 + lh + rh); // stores diameter
        return 1 + Math.max(lh, rh); // returns height

    }

    public static Node6 createTree() {

        System.out.println("Enter data:");
        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        Node6 root = new Node6(data);
        System.out.println("Enter for left of " + data);
        root.left = createTree();
        System.out.println("Enter for right of " + data);
        root.right = createTree();

        return root;
    }
}

class Node6 {
    Node6 left, right;
    int data;

    public Node6(int data) {
        this.data = data;
    }
}
