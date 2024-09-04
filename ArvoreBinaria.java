public class ArvoreBinaria {
    
    private Node root; //raiz

    public boolean isEmpty(){
        return this.root == null;
    }

    public void add (int k){  
        Node newNode = new Node(k);

        if (isEmpty()){
            this.root = newNode;
        } else {
            Node aux = this.root;

            while (aux != null){
                if (k < aux.value){
                    if (aux.left == null){
                        aux.left = newNode;
                        return;
                    } else {
                        aux = aux.left;
                    }                   
                } else {
                    if (aux.right == null){
                        aux.right = newNode;
                        return;
                    } else {
                        aux = aux.right;
                    }
                }
            }
        }
    }
}

class Node {

    int value;
    Node left;
    Node right;

    Node (int v){
        this.value = v;
    }
}
