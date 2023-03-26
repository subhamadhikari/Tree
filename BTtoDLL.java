package part2;

import java.util.Scanner;

public class BTtoDLL {
    static Scanner sc;
    static Node5 prev = null, head = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node5 root = createTree();
        converToDll(root);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.right;
        }
    }

    public static void converToDll(Node5 root) {
        if (root == null) {
            return;
        }
        converToDll(root.left);
        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        converToDll(root.right);
    }

    public static Node5 createTree() {

        System.out.println("Enter data:");
        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        Node5 root = new Node5(data);
        System.out.println("Enter for left of " + data);
        root.left = createTree();
        System.out.println("Enter for right of " + data);
        root.right = createTree();

        return root;
    }

}

class Node5 {
    Node5 left;
    Node5 right;
    int data;

    public Node5(int data) {
        this.data = data;
    }
}
