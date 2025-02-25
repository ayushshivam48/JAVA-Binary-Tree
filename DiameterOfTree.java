package BinaryTree;

public class DiameterOfTree {
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

    // BinaryTree class containing methods for building the tree and calculating the diameter
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

        // Method to calculate the height of a tree
        public static int height(Node root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }

        // Method to calculate the diameter of the binary tree (O(n^2) approach)
        public int diameter(Node root) {
            if (root == null) {
                return 0;
            }

            // Calculate height of left and right subtrees
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            // Calculate diameter of left and right subtrees
            int leftDiameter = diameter(root.left);
            int rightDiameter = diameter(root.right);

            // Return the maximum of:
            // 1. Left height + Right height + 1 (diameter passing through root)
            // 2. Left subtree diameter
            // 3. Right subtree diameter
            return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
        }

        // Main method to test the implementation
        public static void main(String args[]) {
            // Array representing the tree nodes (-1 indicates null)
            int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
            BinaryTree tree = new BinaryTree();

            // Using an array to pass idx as a reference
            int[] idx = {0};
            Node root = tree.buildTree(nodes, idx);

            // Calculate and display the diameter of the tree
            int treeDiameter = tree.diameter(root);
            System.out.println("Diameter of the tree: " + treeDiameter);
        }
    }
}
