package Lesson04;

public class ReadBlackTree {
    private Node root;

    class Node{
        private int value;
        private Color color;
        private Node leftChild;
        private Node rightChild;

        public Node() {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", color=" + color +
                    '}';
        }
    }

    private enum Color {
        RED, Black
    }
    public boolean add(int value) {
        if (root!=null){
            boolean result = addNode(root,value);
            root = rebalnce(root);
            root.color = Color.Black;
            return result;
        }else {
            root = new Node();
            root.color = Color.Black;
            root.value = value;
            return true;
        }
    }

    private boolean addNode(Node node, int value) {
        if(node.value == value){
            return false;
        } else{
            if (node.value> value){
                if (node.leftChild!= null){
                    boolean result = addNode(node.leftChild,value);
                    node.leftChild = rebalnce(node.leftChild);
                    return result;
                }else {
                    node.leftChild =new Node();
                    node.leftChild.color = Color.RED;
                    node.leftChild.value = value;
                    return true;
                }
            }else {
                if (node.rightChild!=null){
                    boolean result = addNode(node.rightChild,value);
                    node.rightChild = rebalnce(node.rightChild);
                    return result;
                } else {
                    node.rightChild = new Node();
                    node.rightChild.color = Color.RED;
                    node.rightChild.value = value;
                    return true;
                }
            }
        }
    }

    private Node rebalnce(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.rightChild!= null && result.rightChild.color == Color.RED &&
                    (result.leftChild== null || result.leftChild.color == Color.Black)){
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.leftChild!= null && result.leftChild.color == Color.RED &&
                    result.leftChild.leftChild == null && result.leftChild.leftChild.color == Color.RED){
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.leftChild!=null && result.leftChild.color == Color.RED &&
            result.rightChild!=null && result.rightChild.color == Color.RED){
                needRebalance = true;
                colorSwap(result);
            }
        }
        while (needRebalance);
        return result;
    }

    private Node rightSwap(Node node) {
        Node rightChild = node.rightChild;
        Node betweenChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }

    private Node leftSwap(Node node) {
        Node leftChild = node.leftChild;
        Node betweenChild = leftChild.rightChild;
        leftChild.rightChild = node;
        node.leftChild = betweenChild;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }

    private void colorSwap(Node node){
        node.rightChild.color = Color.Black;
        node.leftChild.color = Color.Black;
        node.color = Color.RED;
    }


}
