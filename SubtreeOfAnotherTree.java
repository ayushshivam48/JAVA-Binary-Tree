package BinaryTree;

public class SubtreeOfAnotherTree {
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

    // BinaryTree class containing methods for building the tree and checking for subtrees
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

        // Method to check if two trees are identical
        public static boolean isIdentical(Node tree1, Node tree2) {
            if (tree1 == null && tree2 == null) {
                return true; // Both trees are empty
            }
            if (tree1 == null || tree2 == null) {
                return false; // One tree is empty, and the other is not
            }
            // Check if current nodes match and recursively check the subtrees
            return (tree1.data == tree2.data)
                    && isIdentical(tree1.left, tree2.left)
                    && isIdentical(tree1.right, tree2.right);
        }

        // Method to check if tree2 is a subtree of tree1
        public boolean isSubtree(Node tree1, Node tree2) {
            if (tree2 == null) {
                return true; // An empty tree is a subtree of any tree
            }
            if (tree1 == null) {
                return false; // Non-empty tree2 cannot be a subtree of an empty tree1
            }

            // If the current node matches, check if the trees are identical
            if (tree1.data == tree2.data && isIdentical(tree1, tree2)) {
                return true;
            }

            // Recursively check left and right subtrees
            return isSubtree(tree1.left, tree2) || isSubtree(tree1.right, tree2);
        }

        // Main method to test the implementation
        public static void main(String args[]) {
            // Array representing the main tree
            int mainTreeNodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
            // Array representing the subtree
            int subTreeNodes[] = {2, 4, -1, -1, 5, -1, -1};

            BinaryTree tree = new BinaryTree();

            // Build the main tree
            int[] idx1 = {0};
            Node mainTreeRoot = tree.buildTree(mainTreeNodes, idx1);

            // Build the subtree
            int[] idx2 = {0};
            Node subTreeRoot = tree.buildTree(subTreeNodes, idx2);

            // Check if the subtree exists in the main tree
            boolean result = tree.isSubtree(mainTreeRoot, subTreeRoot);
            System.out.println("Is the second tree a subtree of the first? " + result);
        }
    }
}
