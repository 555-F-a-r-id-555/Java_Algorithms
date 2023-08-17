package Lesson04_5;

public class BinaryTree<T extends Comparable<T>> {

    private TreeNode root;

    private class TreeNode {
        T value;
        TreeNode left;
        TreeNode right;

        TreeNode(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }



    public BinaryTree() {
        root = null;
    }

    // добавление значения
    public void add(T value) {
        root = addRec(root, value);
    }

    private TreeNode addRec(TreeNode root, T value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }

        if (value.compareTo(root.value) < 0) {
            root.left = addRec(root.left, value);
        } else if (value.compareTo(root.value) > 0) {
            root.right = addRec(root.right, value);
        }

        return root;
    }

    // поиск значения
    public boolean search(T value) {
        return searchRec(root, value);
    }

    private boolean searchRec(TreeNode root, T value) {
        if (root == null) {
            return false;
        }

        if (value.compareTo(root.value) == 0) {
            return true;
        }

        if (value.compareTo(root.value) < 0) {
            return searchRec(root.left, value);
        } else {
            return searchRec(root.right, value);
        }
    }

    //Симметричный обход
    public void inorderTraversal() {
        inorderTraversalRec(root);
    }

    private void inorderTraversalRec(TreeNode root) {
        if (root != null) {
            inorderTraversalRec(root.left);
            System.out.print(root.value + " ");
            inorderTraversalRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(8);
        tree.add(2);
        tree.add(4);

        System.out.println("Inorder traversal:");
        tree.inorderTraversal();

        System.out.println("\nSearch for value 3: " + tree.search(3));
        System.out.println("Search for value 6: " + tree.search(6));
    }
}
