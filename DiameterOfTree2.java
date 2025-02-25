package BinaryTree;

public class DiameterOfTree2 {
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

        // A wrapper class to keep track of the diameter
        static class Diameter {
            int value = 0; // This will hold the maximum diameter
        }

        // Method to calculate the height and diameter of the binary tree
        public int heightAndDiameter(Node root, Diameter diameter) {
            if (root == null) {
                return 0; // Height of an empty tree is 0
            }

            // Recursively find the height of the left and right subtrees
            int leftHeight = heightAndDiameter(root.left, diameter);
            int rightHeight = heightAndDiameter(root.right, diameter);

            // Calculate the diameter at this node
            int currentDiameter = leftHeight + rightHeight + 1;

            // Update the maximum diameter
            diameter.value = Math.max(diameter.value, currentDiameter);

            // Return the height of the tree rooted at this node
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

            // Create a Diameter object to hold the maximum diameter
            Diameter diameter = new Diameter();

            // Calculate height and diameter
            tree.heightAndDiameter(root, diameter);

            // Display the maximum diameter of the tree
            System.out.println("Diameter of the tree: " + diameter.value);
        }
    }
}
