public class BST {
    
    private Node root;

    public BST(){
        this.root = null;
    }

    public boolean isEmpty(){
        return this.root == null;
    }
     
    public void add(int v){
        if (isEmpty()){
            this.root = new Node(v);
        } else {
            recursiveAdd(this.root, v);
        }
    }

    private void recursiveAdd(Node current, int v){
        if (v < current.value){
            if (current.left == null){
                Node newNode = new Node(v);
                current.left = newNode;
                newNode.parent = current;
                return;
            } else {
                recursiveAdd(current.left, v);
            }
        } else { // v > current.value
            if (current.right == null){
                Node newNode = new Node(v);
                current.right = newNode;
                newNode.parent = current;
                return;
            } else {
                recursiveAdd(current.right, v);
            }
        }
    }

    public Node search(int v){
        if (isEmpty()){
            return null;
        } else {
            return recursiveSearch(this.root, v);
        }
    }

    private Node recursiveSearch(Node current, int v) {
        if(current == null){
            return null;
        }
        if(current.value == v){
            return current;
        }
        if (current.value > v){
            return recursiveSearch(current.left, v);
        } else {
            return recursiveSearch(current.right, v);
        }
    }

    public int height(){
        return height(this.root);
    }

    private int height(Node current){
        if (current == null){
            return -1;
        } else {
            return 1 + Math.max(height(current.left), height(current.right));
        }
    }

    public Node min(){
        if (isEmpty()){
            return null;
        }
        return min(this.root);
    }

    private Node min(Node current){
        if (current.left == null){
            return current;
        } else {
            return min(current.left);
        }
    }

    public Node max(){
        if (isEmpty()){
            return null;
        }
        return max(this.root);
    }

    private Node max(Node current){
        if (current.right == null){
            return current;
        } else {
            return max(current.right);
        }
    }

    public int size(){
        return size(this.root);
    }

    private int size(Node current){
        if (current == null){
            return 0;
        } else {
            return 1 + size(current.left) + size(current.right);
        }
    }

    public Node sucessor(Node node){
        if (isEmpty()){
            return null;
        }
        if (node == null){
            return null;
        }
        if (node.right != null){
            return min(node.right);
        } else {
            Node aux = node.parent;
            while (aux != null && aux.value < node.value){
                aux = aux.parent;
            }
            return aux;
        }
    }

    public Node predecessor(Node node){
        if (isEmpty()){
            return null;
        }
        if (node == null){
            return null;
        }
        if (node.left != null){
            return max(node.left);
        } else {
            Node aux = node.parent;
            while (aux != null && aux.value > node.value){
                aux = aux.parent;
            }
            return aux;
        }
    }

    //REMOÇÃO
    public boolean isLeaf(Node node){
        if (node == null){
            return false;
        }
        return node.left == null && node.right == null;
    }

    public boolean hasOnlyLeftChild(Node node){
        if (node == null){
            return false;
        }
        return node.left != null && node.right == null;
    }

    public boolean hasOnlyRightChild(Node node){
        if (node == null){
            return false;
        }
        return node.left == null && node.right != null;
    }

    public void remove(int value){
        Node toRemove = search(value);
        if (toRemove != null){
            remove(toRemove);
        }
    }

    private void remove(Node toRemove){
        if (isLeaf(toRemove)){
            if (toRemove == this.root){
                this.root = null;
            } else {
                if (toRemove.value < toRemove.parent.value){
                    toRemove.parent.left = null;
                } else {
                    toRemove.parent.right = null;
                }
            }

        } else if (hasOnlyLeftChild(toRemove)){
            if (toRemove == this.root){
                this.root = toRemove.left;
                this.root.parent = null;
            } else {
                toRemove.left.parent = toRemove.parent;
                if (toRemove.value < toRemove.parent.value){
                    toRemove.parent.left = toRemove.left;
                } else {
                    toRemove.parent.right = toRemove.left;
                }
            }

        } else if (hasOnlyRightChild(toRemove)){
            if (toRemove == this.root){
                this.root = toRemove.right;
                this.root.parent = null;
            } else {
                toRemove.right.parent = toRemove.parent;
                if (toRemove.value < toRemove.parent.value){
                    toRemove.parent.left = toRemove.right;
                } else {
                    toRemove.parent.right = toRemove.right;
                }
            }

        } else {
            Node sucessor = sucessor(toRemove);
            toRemove.value = sucessor.value;
            remove(sucessor);
        }
    }

}

class Node{

    int value;
    Node left;
    Node right;
    Node parent;

    Node (int v){
        this.value = v;
    }

}
