package BinaryTree;

public class CountOfNodes {
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

    // BinaryTree class containing methods for building the tree and counting nodes
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

        // Method to count the total number of nodes in the binary tree
        public int countNodes(Node root) {
            if (root == null) {
                return 0; // Base case: No node means count is 0
            }

            // Recursively count nodes in the left and right subtrees
            int leftCount = countNodes(root.left);
            int rightCount = countNodes(root.right);

            // Total count is the sum of leftCount, rightCount, and 1 (for the current node)
            return leftCount + rightCount + 1;
        }

        // Main method to test the implementation
        public static void main(String args[]) {
            // Array representing the tree nodes (-1 indicates null)
            int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
            BinaryTree tree = new BinaryTree();

            // Using an array to pass idx as a reference
            int[] idx = {0};
            Node root = tree.buildTree(nodes, idx);

            // Calculate and display the total count of nodes
            int totalNodes = tree.countNodes(root);
            System.out.println("Total number of nodes in the tree: " + totalNodes);
        }
    }
}

