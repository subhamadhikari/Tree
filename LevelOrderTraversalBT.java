package part2;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LevelOrderTraversalBT {
    static Scanner sc;
    static Queue<Node2> q = new ArrayDeque<>();
    static Queue<Node2> q2 = new LinkedList<>();

    public static Node2 createTree() {
        Node2 root = null;

        System.out.println("Enter data:");
        int data = sc.nextInt();

        // creating tree recursively, so we are setting data == -1 as base case.
        if (data == -1) {
            return null;
        }

        root = new Node2(data);

        System.out.println("Enter left for " + data);
        root.left = createTree();

        System.out.println("Enter right for " + data);
        root.right = createTree();

        return root;
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node2 root = createTree();
        // int heightBT = heightOfBT(root);
        // for (int i = 1; i <= heightBT; i++) {
        // currentLevel(root, i);
        // }
        System.out.println("Method 2 (i)");
        queueLevelOrderTraversal(root);
        System.out.println("");
        System.out.println("Method 2 (ii)");
        queueLevelOrderTraversal2(root);
    }

    // METHOD-1

    // gives value of individual level; so use it in loop to print level by level
    // O(N^2) -> Time complexity
    public static void currentLevel(Node2 root, int level) {
        if (root == null) {
            return;
        }

        if (level == 1) {
            System.out.print(root.data + " ");
        } else if (level > 1) {
            currentLevel(root.left, level - 1);
            currentLevel(root.right, level - 1);
        }

    }

    public static int heightOfBT(Node2 root) {
        if (root == null) {
            return 0;
        }
        return Math.max(heightOfBT(root.left), heightOfBT(root.right)) + 1;
    }

    // METHOD-2 (USING QUEUE)
    // time complexity - O(N)
    // (i)
    public static void queueLevelOrderTraversal(Node2 root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        if (root.left != null) {
            q.offer(root.left);
        }
        if (root.right != null) {
            q.offer(root.right);
        }
        queueLevelOrderTraversal(q.poll());

    }

    // (ii)
    public static void queueLevelOrderTraversal2(Node2 root) {

        q2.add(root);
        q2.add(null);

        while (!q2.isEmpty()) {
            Node2 cur = q.poll();
            // for printing in next line
            if (cur == null) {
                if (q2.isEmpty()) {
                    return;
                }
                q2.add(null);
                System.out.println("");
            }
            //

            System.out.print(cur.data);

            if (cur.left != null) {
                q2.add(cur.left);
            }
            if (cur.right != null) {
                q2.add(cur.right);
            }

        }

    }

}

class Node2 {
    Node2 left;
    Node2 right;
    int data;

    public Node2(int data) {
        this.data = data;
    }
}
