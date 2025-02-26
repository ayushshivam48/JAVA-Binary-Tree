package BinaryTree;

public class HeightOfTree {
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

        

        // Method to calculate the height of the binary tree
        public int height(Node root) {
            if (root == null) {
                return 0; // Base case: height of empty tree is 0
            }
            // Recursively find the height of left and right subtrees
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            // Height of the tree is max of leftHeight and rightHeight plus 1 (for current node)
            return Math.max(leftHeight, rightHeight) + 1;
        }

        // Main method to test the implementation
        public static void main(String args[]) {
            // Array representing the tree nodes (-1 indicates null)
            int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
            BinaryTree tree = new BinaryTree();

            // Using an array to pass idx as a reference
            int[] idx = {0};
            Node root = tree.buildTree(nodes, idx);

            // Calculate and display the height of the tree
            int treeHeight = tree.height(root);
            System.out.println("\nHeight of the tree: " + treeHeight);
        }
    }
}
