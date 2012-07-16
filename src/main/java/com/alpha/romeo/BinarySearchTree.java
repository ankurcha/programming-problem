package com.alpha.romeo;

/**
 * User: achauhan
 * Date: 7/12/12
 */
public class BinarySearchTree<V extends Comparable<V>> {
    class Node {
        Node left;
        Node right;
        V data;
    }

    Node root;

    public void insert(V data) {
        insert(root, data);

    }

    private void insert(Node root, V data) {
        Node newNode = new Node();
        newNode.data = data;
        if(root == null) {
            root = newNode;
        } else if (data.compareTo(root.data) > 0) {
            this.insert(root.right, data);
        } else {
            this.insert(root.left, data);
        }
    }


}
