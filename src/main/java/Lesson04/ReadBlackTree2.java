package Lesson04;

 class RedBlackTree2 {
    private Node root;
    private Node NULL_LEAF;

     class Node {
         private int value;
        private Color color;
         private Node parent;
         private Node left;
         private Node right;

         public Node(int value, Color color) {
             this.value = value;
             this.color = color;
             this.parent = null;
             this.left = null;
             this.right = null;
         }
     }

    public RedBlackTree2() {
        NULL_LEAF = new Node(0, Color.BLACK);
        root = NULL_LEAF;
    }

    public void add(int value) {
        Node new_node = new Node(value, Color.RED);
        addRecursive(root, new_node);
        balanceAfterAdd(new_node);
    }

    private void addRecursive(Node parent, Node new_node) {
        if (parent == NULL_LEAF) {
            root = new_node;
        } else if (new_node.value < parent.value) {
            if (parent.left == NULL_LEAF) {
                parent.left = new_node;
                new_node.parent = parent;
            } else {
                addRecursive(parent.left, new_node);
            }
        } else {
            if (parent.right == NULL_LEAF) {
                parent.right = new_node;
                new_node.parent = parent;
            } else {
                addRecursive(parent.right, new_node);
            }
        }
    }

    private void balanceAfterAdd(Node node) {
        while (node.parent.color == Color.RED) {
            if (node.parent == node.parent.parent.left) {
                Node uncle = node.parent.parent.right;
                if (uncle.color == Color.RED) {
                    node.parent.color = Color.BLACK;
                    uncle.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.right) {
                        node = node.parent;
                        leftRotate(node);
                    }
                    node.parent.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    rightRotate(node.parent.parent);
                }
            } else {
                Node uncle = node.parent.parent.left;
                if (uncle.color == Color.RED) {
                    node.parent.color = Color.BLACK;
                    uncle.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.left) {
                        node = node.parent;
                        rightRotate(node);
                    }
                    node.parent.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    leftRotate(node.parent.parent);
                }
            }

        }
        root.color = Color.BLACK;
        if (node.parent.left.color == Color.RED && node.parent.right.color == Color.RED) {
            flipColors(node.parent);
        }
    }

    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != NULL_LEAF) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == NULL_LEAF) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    private void rightRotate(Node y) {
        Node x = y.left;
        y.left = x.right;
        if (x.right != NULL_LEAF) {
            x.right.parent = y;
        }
        x.parent = y.parent;
        if (y.parent == NULL_LEAF) {
            root = x;
        } else if (y == y.parent.left) {
            y.parent.left = x;
        } else {
            y.parent.right = x;
        }
        x.right = y;
        y.parent = x;
    }

     private void flipColors(Node node) {
         node.color = Color.RED;
         node.left.color = Color.BLACK;
         node.right.color = Color.BLACK;
     }


     public static void main(String[] args) {
        RedBlackTree2 tree = new RedBlackTree2();
        tree.add(10);
        tree.add(5);
        tree.add(15);
    }

    private enum Color {
        RED, BLACK
    }
}
