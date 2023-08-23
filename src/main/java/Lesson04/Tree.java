package Lesson04;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    Node root;

    public boolean exist(int value) {
        if (root != null) {
            Node node = find(root, value);
            if (node != null) {
                return true;
            }
        }
        return false;
    }

    // обход в глубину;
    private Node find(Node node, int value) {
        if (node.value == value) {
            return node;
        } else {
            for (Node child : node.children) {
                Node result = find(child, value);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

    // обход в ширину;
//    private Node find(int value) {
//        List<Node> line = new ArrayList<>();
//        line.add(root);
//        while (line.size() > 0) {
//            List<Node> nextline = new ArrayList<>();
//            for (Node node : line) {
//                if (node.value == value) {
//                    return node;
//                }
//                nextline.addAll(node.children);
//            }
//            line = nextline;
//        }
//        return null;
//    }

    class Node {
        int value;
        List<Node> children;
    }


}
