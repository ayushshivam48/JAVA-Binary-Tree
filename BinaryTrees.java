package BinaryTree;
public class BinaryTrees {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        public Node buildTree(int nodes[], int[] idx) {
            if (idx[0] >= nodes.length || nodes[idx[0]] == -1) {
                idx[0]++;  // Move index forward and return null for this node
                return null;
            }

            Node newNode = new Node(nodes[idx[0]++]);  // Create a new node and increment the index
            newNode.left = buildTree(nodes, idx);      // Recursively build the left subtree
            newNode.right = buildTree(nodes, idx);     // Recursively build the right subtree

            return newNode;
        }
    }

    public static void main(String args[]) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();

        // Using an array to pass idx as a reference
        int[] idx = {0};
        Node root = tree.buildTree(nodes, idx);

        // Display the root node data
        if (root != null) {
            System.out.println("Root Node Data: " + root.data);
        } else {
            System.out.println("The tree is empty.");
        }
    }
}
