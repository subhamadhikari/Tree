package part2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;

public class TopBotttomBT {
    static class Pair {
        int hd;
        Node4 node;

        public Pair(int hd, Node4 node) {
            this.node = node;
            this.hd = hd;
        }
    }

    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node4 root = createTree();
        ArrayList<Integer> tv = topView(root);
        ArrayList<Integer> bv = bottomView(root);

        System.out.println("Top view");
        for (int item : tv) {
            System.out.print(item + " ");
        }
        System.out.println("");
        System.out.println("Bottom view");
        for (int item : bv) {
            System.out.print(item + " ");
        }
    }

    public static ArrayList<Integer> topView(Node4 root) {
        Queue<Pair> q = new ArrayDeque<>();
        // Tree map stores keys values in ascending order
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

        q.add(new Pair(0, root));
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            if (!map.containsKey(cur.hd)) {
                map.put(cur.hd, cur.node.data);
            }
            if (cur.node.left != null) {
                q.add(new Pair(cur.hd - 1, cur.node.left));
            }
            if (cur.node.right != null) {
                q.add(new Pair(cur.hd + 1, cur.node.right));
            }

        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }

    public static ArrayList<Integer> bottomView(Node4 root) {
        Queue<Pair> q = new ArrayDeque<>();
        // Tree map stores keys values in ascending order
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

        q.add(new Pair(0, root));
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            map.put(cur.hd, cur.node.data);
            if (cur.node.left != null) {
                q.add(new Pair(cur.hd - 1, cur.node.left));
            }
            if (cur.node.right != null) {
                q.add(new Pair(cur.hd + 1, cur.node.right));
            }

        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }

    public static Node4 createTree() {

        System.out.println("Enter data:");
        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        Node4 root = new Node4(data);
        System.out.println("Enter for left of " + data);
        root.left = createTree();
        System.out.println("Enter for right of " + data);
        root.right = createTree();

        return root;
    }
}

class Node4 {
    Node4 left, right;
    int data;

    public Node4(int data) {
        this.data = data;
    }
}
