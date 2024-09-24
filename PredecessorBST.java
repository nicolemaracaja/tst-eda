/*import java.util.*;

public class PredecessorBST {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(" ");
        int[] values = new int[entrada.length];

        for (int i = 0; i < entrada.length; i++){
            values[i] = Integer.parseInt(entrada[i]);
        }

        int n = sc.nextInt();
        sc.nextLine();

        BST tree = new BST();

        for (int v : values){
            tree.add(v);
        }

        ArrayList<Integer> predecessores = tree.encontraPredecessor(tree.search(n));
        System.out.println(predecessores.toString());

        sc.close();
    }
}

class BST {

    Node root;
    private int size;
    private ArrayList<Integer> predecessores;

    public BST(){
        this.root = null;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public Node getRoot(){
        return this.root;
    }

    public void add(int value){
        this.size++;
        if (isEmpty()){
            this.root = new Node(value);
        } else {
            recursiveAdd(this.root, value);
        }
    }

    private void recursiveAdd(Node current, int valor){
        if (valor < current.value){
            if (current.left == null){
                Node newNode = new Node(valor);
                current.left = newNode;
                newNode.parent = current;
                return;
            } else {
                recursiveAdd(current.left, valor);
            }
        } else {
            if (current.right == null){
                Node newNode = new Node(valor);
                current.right = newNode;
                newNode.parent = current;
                return;
            } else {
                recursiveAdd(current.right, valor);
            }
        }
    }

    public Node max(){
        if (isEmpty()){
            return null;
        } else {
            return max(this.root);
        }
    }

    public Node max(Node current){
        if (current.right == null){
            return current;
        } else {
            return max(current.right);
        }
    }

    public Node min(){
        if (isEmpty()){
            return null;
        } else {
            return min(this.root);
        }
    }

    public Node min(Node current){
        if (current.left == null){
            return current;
        } else {
            return min(current.left);
        }
    }

    public Node search(int element){
        return search(this.root, element);
    }

    public Node search(Node current, int element){
        if (current == null){
            return null;
        }
        if (current.value == element){
            return current;
        } 
        if (element < current.value){
            return search(current.left, element);
        } else {
            return search(current.right, element);
        }
    }

    //Maior valor menor que o current
    public Node predecessor(Node current){
        if (isEmpty()){
            return null;
        }
        if (current == null){
            return null;
        }
        if (current.left != null){
            return max(current.left);
        } else {    
            Node aux = current.parent;

            while (aux != null && aux.value > current.value){
                aux = aux.parent;
            }
            return aux;
        }
    }

    //Menor valor maior que o current
    public Node sucessor(Node current){
        if (isEmpty()){
            return null;
        }
        if (current == null){
            return null;
        }
        if (current.right != null){
            return min(current.right);
        } else {
            Node aux = current.parent;

            while (aux != null && aux.value < current.value){
                aux = aux.parent;
            }
            return aux;
        }
    }

    public ArrayList<Integer> encontraPredecessor(Node node){
        predecessores = new ArrayList<>();
        
        if(node == null){
            return null;
        }

        predecessores.add(node.value);
        Node predecessor = predecessor(node);

        if(node.left != null){
            Node nodeAux = node.left;
            while (nodeAux != null){
                predecessores.add(nodeAux.value);
                nodeAux = nodeAux.right;
            }
        } else {
            Node nodeAux = node.parent;

            while(nodeAux != null && nodeAux.value > node.value){
                if (nodeAux == predecessor){
                    predecessores.add(nodeAux.value);
                    break;
                } else {
                    predecessores.add(nodeAux.value);
                    nodeAux = nodeAux.parent;
                }
            }

            if(nodeAux != null){
                predecessores.add(nodeAux.value);
            }
        }

        return predecessores;
    }


    public int size(){
        return this.size;
    }
}

class Node {

    int value;
    Node left;
    Node right;
    Node parent;

    public Node(int v){
        this.value = v;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

}*/