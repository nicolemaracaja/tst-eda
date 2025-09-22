import java.util.*;

class ContaNosInternos {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(" ");
        int[] values = new int[entrada.length];

        for (int i = 0; i < entrada.length; i++){
            values[i] = Integer.parseInt(entrada[i]);
        }

        MinhaBST tree = new MinhaBST();

        for (int i = 0; i < entrada.length; i++){
            tree.add(values[i]);
        }

        int result = 0;

        for (int i = 0; i < entrada.length; i++){   
            MeuNode no = tree.getNode(values[i]);

            if (!tree.isLeaf(no)){
                result++;
            }
        }

        System.out.println(result);
        sc.close();
    }
}

class MinhaBST{

    MeuNode3 root;

    public MinhaBST(){
        this.root = null;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public MeuNode getRoot(){
        return this.root;
    }

    public void add(int v){
        if (isEmpty()){
            this.root = new MeuNode(v);
        } else {
            recursiveAdd(this.root, v);
        }
    }

    public void recursiveAdd(MeuNode current, int value){
        if (value < current.value){
            if (current.left == null){
                MeuNode newNode = new MeuNode(value);
                current.left = newNode;
                newNode.parent = current;
            } else {
                recursiveAdd(current.left, value);
            }
        } else { //value > current.value
            if (current.right == null){
                MeuNode newNode = new MeuNode(value);
                current.right = newNode;
                newNode.parent = current;
            } else {
                recursiveAdd(current.right, value);
            }
        }
    }

    public MeuNode getNode(int v){
        if (isEmpty()){
            return null;
        } else {
            MeuNode aux = this.root;

            while (aux != null){
                if (v == aux.value){
                    return aux;
                } else if (v < aux.value){
                    aux = aux.left;
                } else if (v > aux.value){
                    aux = aux.right;
                }
            }
        }
        return null;
    }

    public boolean isLeaf(MeuNode current){
        return current.left == null & current.right == null;
    }
}

class MeuNode{

    int value;
    MeuNode left;
    MeuNode right;
    MeuNode parent;

    public MeuNode(int v){
        this.value = v;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}*/
