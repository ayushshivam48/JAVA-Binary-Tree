package BinaryTree;

import java.util.*;

public class SumOfNodesAtKthLevel {
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

    // BinaryTree class containing methods for building the tree and calculating the sum at Kth level
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

        // Method to find the sum of nodes at the Kth level
        public int sumAtKthLevel(Node root, int K) {
            if (root == null) {
                return 0;
            }

            // Initialize the queue for level order traversal
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            int currentLevel = 0;
            int sum = 0;

            // Perform level order traversal
            while (!q.isEmpty()) {
                int levelSize = q.size(); // Number of nodes at the current level

                // Check if we've reached the desired level
                if (currentLevel == K) {
                    // Sum all nodes at this level
                    for (int i = 0; i < levelSize; i++) {
                        Node currentNode = q.poll();
                        sum += currentNode.data;
                    }
                    break; // No need to traverse further
                } else {
                    // Traverse the current level and add children to the queue
                    for (int i = 0; i < levelSize; i++) {
                        Node currentNode = q.poll();
                        if (currentNode.left != null) {
                            q.add(currentNode.left);
                        }
                        if (currentNode.right != null) {
                            q.add(currentNode.right);
                        }
                    }
                }

                currentLevel++; // Move to the next level
            }

            return sum; // Return the sum of nodes at the Kth level
        }

        // Main method to test the implementation
        public static void main(String args[]) {
            // Array representing the tree nodes (-1 indicates null)
            int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
            BinaryTree tree = new BinaryTree();

            // Using an array to pass idx as a reference
            int[] idx = {0};
            Node root = tree.buildTree(nodes, idx);

            // Define the level K
            int K = 2;

            // Calculate and display the sum of nodes at level K
            int sum = tree.sumAtKthLevel(root, K);
            System.out.println("Sum of nodes at level " + K + ": " + sum);
        }
    }
}
