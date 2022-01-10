public class Tree<T extends Comparable<T>> {
    class Node {
        T data; //new T() is wrong
        Node left;
        Node right;

        public Node(T element) {
            data = element;
            left = right = null;
        }
    }

    Node root;

    Tree() {
        root = null;
    }

    Tree(T element) {
        root = new Node(element);
    }

    private void addElement(Node node, T element) {
        if (node.data.compareTo(element) > 0) {
            if (node.left == null) {
                node.left = new Node(element);
            } else {
                addElement(node.left, element);
            }
        }
        if (node.data.compareTo(element) < 0) {
            if (node.right == null) {
                node.right = new Node(element);
            } else {
                addElement(node.right, element);
            }
        }
    }


    void addElement(T element) {
        if (root == null) {
            root = new Node(element);
        } else {
            addElement(root, element);
        }
    }


    void addElement2(T element) {
        Node newNode = new Node(element);
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (element.compareTo(current.data) < 0) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    void deleteElement(T element) {
        Node node = root;
        Node parent = root;
        boolean isLeftChild = false;
        while ((node != null) && (node.data.compareTo(element) != 0)) {
            parent = node;
            if (node.data.compareTo(element) > 0) {
                node = node.left;
                isLeftChild = true;
            } else {
                node = node.right;
                isLeftChild = false;
            }
        }
        if (node != null) {
            //no childs
            if (count() == 1) {
                root = null;
            } else {
                if (node.left == null && node.right == null)  {
                    if (parent.data.compareTo(element) > 0) {
                        parent.left = null;
                        node = null;
                    } else {
                        parent.right = null;
                        node = null;
                    }

                    //1 child
                } else if (node.left == null || node.right == null) {
                    if (node == root) {
                        if (root.left == null) {
                            root = root.right;
                        } else {
                           root = root.left;
                        }
                        node = null;
                    } else if (node.left == null) {
                        if (parent.data.compareTo(element) > 0) {
                            parent.left = node.right;
                            node = null;
                        } else {
                            parent.right = node.right;
                            node = null;
                        }
                    } else {
                        if (parent.data.compareTo(element) > 0) {
                            parent.left = node.left;
                            node = null;
                        } else {
                            parent.right = node.left;
                            node = null;
                        }
                    }
                    //2 childs
                } else {
                    Node successorParent = node;
                    Node successor = node;
                    Node current = node.right;
                    while(current != null) {
                        successorParent = successor;
                        successor = current;
                        current = current.left;
                    }
                    if (successor != node.right) {
                        successorParent.left = successor.right;
                        successor.right = node.right;
                    }

                    if (node == root) {
                        root = successor;
                    } else if (isLeftChild) {
                        parent.left = successor;
                    } else {
                        parent.right = successor;
                    }
                    successor.left = node.left;
                }
            }
        }
    }

    boolean findElement(T element) {
        Node node = root;
        while ((node != null) && node.data.compareTo(element) != 0) {
            if (node.data.compareTo(element) > 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return (node != null);
    }

    private int count(Node node) {
        if (node == null) {
            return 0;
        }
        return count(node.right) + count(node.left) + 1;
    }

    int count() {
        return count(this.root);
    }

    private void klr(Node node) {
        if (node != null) {
            System.out.print(node.data.toString() + " ");
            klr(node.left);
            klr(node.right);
        }
    }

    void klr() {
        klr(root);
        System.out.println();
    }

    private void lrk(Node node) {
        if (node != null) {
            lrk(node.left);
            lrk(node.right);
            System.out.print(node.data.toString() + " ");
        }
    }

    void lrk() {
        lrk(root);
        System.out.println();
    }

    private void lkr(Node node) {
        if (node != null) {
            lkr(node.left);
            System.out.print(node.data.toString() + " ");
            lkr(node.right);
        }
    }

    void lkr() {
        lkr(root);
        System.out.println();
    }
}
