package BinaryTree;

public class TreeTraversal {
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

        // In-order Traversal (Left, Root, Right)
        public void inorderTraversal(Node root) {
            if (root == null) return;
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }

        // Pre-order Traversal (Root, Left, Right)
        public void preorderTraversal(Node root) {
            if (root == null) return;
            System.out.print(root.data + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }

        // Post-order Traversal (Left, Right, Root)
        public void postorderTraversal(Node root) {
            if (root == null) return;
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String args[]) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();

        // Using an array to pass idx as a reference
        int[] idx = {0};
        Node root = tree.buildTree(nodes, idx);

        // Display all nodes using different traversals
        System.out.println("In-order Traversal:");
        tree.inorderTraversal(root);

        System.out.println("\nPre-order Traversal:");
        tree.preorderTraversal(root);

        System.out.println("\nPost-order Traversal:");
        tree.postorderTraversal(root);
    }
}
