/*import java.util.*;

class ContaNosInternos {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(" ");
        int[] values = new int[entrada.length];

        for (int i = 0; i < entrada.length; i++){
            values[i] = Integer.parseInt(entrada[i]);
        }

        MinhaBST3 tree = new MinhaBST3();

        for (int i = 0; i < entrada.length; i++){
            tree.add(values[i]);
        }

        int result = 0;

        for (int i = 0; i < entrada.length; i++){   
            MeuNode3 no = tree.getNode(values[i]);

            if (!tree.isLeaf(no)){
                result++;
            }
        }

        System.out.println(result);
        sc.close();
    }
}

class MinhaBST3{

    MeuNode3 root;

    public MinhaBST3(){
        this.root = null;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public MeuNode3 getRoot(){
        return this.root;
    }

    public void add(int v){
        if (isEmpty()){
            this.root = new MeuNode3(v);
        } else {
            recursiveAdd(this.root, v);
        }
    }

    public void recursiveAdd(MeuNode3 current, int value){
        if (value < current.value){
            if (current.left == null){
                MeuNode3 newNode = new MeuNode3(value);
                current.left = newNode;
                newNode.parent = current;
            } else {
                recursiveAdd(current.left, value);
            }
        } else { //value > current.value
            if (current.right == null){
                MeuNode3 newNode = new MeuNode3(value);
                current.right = newNode;
                newNode.parent = current;
            } else {
                recursiveAdd(current.right, value);
            }
        }
    }

    public MeuNode3 getNode(int v){
        if (isEmpty()){
            return null;
        } else {
            MeuNode3 aux = this.root;

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

    public boolean isLeaf(MeuNode3 current){
        return current.left == null & current.right == null;
    }
}

class MeuNode3{

    int value;
    MeuNode3 left;
    MeuNode3 right;
    MeuNode3 parent;

    public MeuNode3(int v){
        this.value = v;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}*/
