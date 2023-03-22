package codeStates.datastructure;

public class BinarySearchTreeImple {
    public static class Node{
        private int data;
        private Node left;
        private Node right;

        public Node(final int data) {
            this.setData(data);
            this.left = null;
            this.right = null;
        }

        public int getData() {
            return this.data;
        }

        public void setData(final int data) {
            this.data = data;
        }

        public Node getLeft() {
            return this.left;
        }

        public void setLeft(final Node left) {
            this.left = left;
        }

        public Node getRight() {
            return this.right;
        }

        public void setRight(final Node right) {
            this.right = right;
        }
    }

    public static class binarySearchTree{
        public Node root;

        public binarySearchTree(final Node root) {
            this.root = root;
        }

        //tree에 value 추가
        public void insert(int data){
            Node newNode = new Node(data);
            if(root ==null){ //root가 없으면
                root = newNode;
                return;
            }
            if(root.data== data) return;

            Node currentNode=root;
            Node parentNode=null;

            while(true){
                parentNode = currentNode;
            }
        }
    }
}
