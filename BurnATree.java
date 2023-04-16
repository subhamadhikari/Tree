package part2;

import java.util.Scanner;

/**
 * BurnATree
 */
public class BurnATree {
    static Scanner sc;
    static int ans = -1;

    static class Depth {
        int d;

        public Depth(int d) {
            this.d = d;
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter data for the root node");
        sc = new Scanner(System.in);
        Node8 root = createTree();
        System.out.println("Time to burn " + minTime(root, 1));
    }

    public static int minTime(Node8 root, int target) {
        Depth depth = new Depth(-1);
        burn(root, target, depth);
        return ans;
    }

    public static int burn(Node8 root, int target, Depth depth) {
        if (root == null) {
            return 0;
        }
        if (root.data == target) {
            depth.d = 1; // it is calculating depth from root
            return 1; // it is returning height of the tree
        }

        Depth ld = new Depth(-1);
        Depth rd = new Depth(-1);

        int lh = burn(root.left, target, ld);
        int rh = burn(root.right, target, rd);

        if (ld.d != -1) {
            ans = Math.max(ans, ld.d + 1 + rh);
            depth.d = ld.d + 1;
        } else if (rd.d != -1) {
            ans = Math.max(ans, rd.d + lh + 1);
            depth.d = rd.d + 1;
        }
        return Math.max(lh, rh) + 1;
    }

    public static Node8 createTree() {
        Node8 root = null;

        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        root = new Node8(data);

        System.out.println("Left of " + data);
        root.left = createTree();
        System.out.println("Right of " + data);
        root.right = createTree();

        return root;
    }
}

class Node8 {
    Node8 left, right;
    int data;

    public Node8(int data) {
        this.data = data;
    }
}