package BinaryTree;

public class SumOfNodes {
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

    // BinaryTree class containing methods for building the tree and calculating the sum of nodes
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

        // Method to calculate the sum of all nodes in the binary tree
        public int sumOfNodes(Node root) {
            if (root == null) {
                return 0; // Base case: if there's no node, the sum is 0
            }

            // Recursively calculate the sum of nodes in the left and right subtrees
            int leftSum = sumOfNodes(root.left);
            int rightSum = sumOfNodes(root.right);

            // Total sum is the sum of leftSum, rightSum, and the current node's data
            return leftSum + rightSum + root.data;
        }

        // Main method to test the implementation
        public static void main(String args[]) {
            // Array representing the tree nodes (-1 indicates null)
            int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
            BinaryTree tree = new BinaryTree();

            // Using an array to pass idx as a reference
            int[] idx = {0};
            Node root = tree.buildTree(nodes, idx);

            // Calculate and display the sum of all nodes
            int totalSum = tree.sumOfNodes(root);
            System.out.println("Sum of all nodes in the tree: " + totalSum);
        }
    }
}
