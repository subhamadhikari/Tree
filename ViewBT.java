package part2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ViewBT {
    static Scanner sc;
    static HashMap<Integer, Integer> hm = new HashMap<>();

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        Node3 root = createTree();
        leftView(root);

    }

    public static void leftView(Node3 root) {
        ArrayList<Node3> list = new ArrayList<>();

        printLeftView(root, list, 0);
        for (Node3 node : list) {
            System.out.print(node.data + " ");
        }

    }

    public static void printLeftView(Node3 root, ArrayList<Node3> list, int level) {
        if (root == null) {
            return;
        }
        if (list.size() <= level) {
            list.add(level, root);
        }
        // if (list.get(level) == null) {
        // list.add(root);
        // }
        printLeftView(root.left, list, level + 1);
        printLeftView(root.right, list, level + 1);
    }

    public static Node3 createTree() {

        System.out.println("Enter data:");
        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        Node3 root = new Node3(data);
        System.out.println("Enter for left of " + data);
        root.left = createTree();
        System.out.println("Enter for right of " + data);
        root.right = createTree();

        return root;
    }
}

class Node3 {
    Node3 left, right;
    int data;

    public Node3(int data) {
        this.data = data;
    }
}
