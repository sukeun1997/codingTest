package algorithms;

/**
 * 이진 탐색 트리
 */
public class BinarySearchTree {

    public class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.setData(data);
            setLeft(null);
            setRight(null);
        }

        public void setData(int data) {
            this.data = data;
        }


        public void setLeft(Node left) {
            this.left = left;
        }


        public void setRight(Node right) {
            this.right = right;
        }
    }


    public Node root;

    //탐색
    public boolean find(int id) {
        Node current = root;

        while (current != null) {

            if (current.data == id) {
                return true;
            } else if (current.data > id) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false;
    }

    // 삭제 연산
    public boolean delete(int id) {
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;

        if (current == null) {
            return false;
        }

        while (current.data != id) {
            parent = current;

            if (current.data > id) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
        }

        //Case 1 : 자식 노드가 없을 경우
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }

            if (isLeftChild) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        }

        //Case 2 : 하나의 자식을 갖는 경우
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.setLeft(current.left);
            } else {
                parent.setRight(current.left);
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.setLeft(current.right);
            } else {
                parent.setRight(current.right);
            }
        }

        //Case 3: 두개의 자식을 갖는 경우
        else if (current.right != null && current.left != null) {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.setLeft(successor);
            } else {
                parent.setRight(successor);
            }
            successor.setLeft(current.left);
        }

        return true;
    }

    public Node getSuccessor(Node deleleNode) {
        Node successsor = null;
        Node successsorParent = null;
        Node current = deleleNode.right;
        while (current != null) {
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }
        if (successsor != deleleNode.right) {
            successsorParent.setLeft(successsor.right);
            successsor.setRight(deleleNode.right);
        }
        return successsor;
    }

    //삽입 연산
    private void insert(int id) {
        Node newNode = new Node(id);

        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        Node parent = null;

        while (true) {
            parent = current;
            if (id < current.data) {
                current = current.left;
                if (current == null) {
                    parent.setLeft(newNode);
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.setRight(newNode);
                    return;
                }
            }
        }
    }

    public void display(Node root){
        if(root!=null){
            display(root.left);
            System.out.print(" " + root.data);
            display(root.right);
        }
    }

    public static void main(String[] args) {

        BinarySearchTree b = new BinarySearchTree();
        //트리에 노드를 삽입
        b.insert(3);b.insert(8);
        b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
        b.insert(20);b.insert(25);b.insert(15);b.insert(16);

        System.out.println("트리삽입 결과 : ");
        b.display(b.root);
        System.out.println("");
        System.out.println("이진트리에서 4를 탐색 : " + b.find(4));
        System.out.println("이진트리에서 2를 삭제 : " + b.delete(2));
        b.display(b.root);
        System.out.println("\n이진트리에서 4를 삭제 : " + b.delete(4));
        b.display(b.root);
        System.out.println("\n이진트리에서 10을 삭제 : " + b.delete(10));
        b.display(b.root);
    }

}
