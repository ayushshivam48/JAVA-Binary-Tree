package BinaryTree;

import java.util.*;

public class LevelOrder {
    // Node class representing each element in the tree
    static class Node {
        int data;
        Node left;
        Node right;

        // Constructor for the Node
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // BinaryTree class containing methods for building and traversing the tree
    static class BinaryTree {
        // Method to build the tree from an array of integers
        public Node buildTree(int nodes[], int[] idx) {
            if (idx[0] >= nodes.length || nodes[idx[0]] == -1) {
                idx[0]++;
                return null;
            }

            Node newNode = new Node(nodes[idx[0]++]);
            newNode.left = buildTree(nodes, idx);
            newNode.right = buildTree(nodes, idx);

            return newNode;
        }

        // Level Order Traversal method
        public void levelOrder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node curr = q.remove();
                
                if (curr == null) {
                    System.out.println(); // End of level
                    // Queue empty check
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(curr.data + " ");
                    // Adding left and right children to the queue
                    if (curr.left != null) {
                        q.add(curr.left);
                    }
                    if (curr.right != null) {
                        q.add(curr.right);
                    }
                }
            }
        }

        // Main method to test the implementation
        public static void main(String args[]) {
            // Array representing the tree nodes (-1 indicates null)
            int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
            BinaryTree tree = new BinaryTree();

            // Using an array to pass idx as a reference
            int[] idx = {0};
            Node root = tree.buildTree(nodes, idx);

            // Display all nodes using Level Order Traversal
            System.out.println("Level Order Traversal:");
            tree.levelOrder(root);
        }
    }
}
