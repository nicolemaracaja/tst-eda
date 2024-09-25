/*import java.util.Scanner;

class SomaFolhas {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(" ");
        int[] values = new int[entrada.length];

        for (int i = 0; i < entrada.length; i++){
            values[i] = Integer.parseInt(entrada[i]);
        }

        MinhaBST4 tree = new MinhaBST4();

        for (int v : values){
            tree.add(v);
        }

        int result = 0;

        for (int i = 0; i < entrada.length; i++){
            MeuNode4 no = tree.getNode(values[i]);

            if (tree.isLeaf(no)){
                result = result + no.value;
            }
        }

        System.out.println(result);

        sc.close();
    }
}

class MinhaBST4 {

    MeuNode4 root;

    public MinhaBST4(){
        this.root = null;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public MeuNode4 getRoot(){
        return this.root;
    }

    public MeuNode4 getNode(int v){
        if (isEmpty()){
            return null;
        } else {
            MeuNode4 aux = this.root;

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

    public boolean isLeaf(MeuNode4 current){
        return current.left == null && current.right == null;
    }

    public void add(int v){
        if (isEmpty()){
            this.root = new MeuNode4(v);
        } else {
            recursiveAdd(this.root, v);
        }
    }

    public void recursiveAdd(MeuNode4 current, int v){
        if (v < current.value){
            if (current.left == null){
                MeuNode4 newNode = new MeuNode4(v);
                current.left = newNode;
                newNode.parent = current;
            } else {
                recursiveAdd(current.left, v);
            }
        } else {
            if (current.right == null){
                MeuNode4 newNode = new MeuNode4(v);
                current.right = newNode;
                newNode.parent = current;
            } else {
                recursiveAdd(current.right, v);
            }
        }
    }
}

class MeuNode4 {

    int value;
    MeuNode4 left;
    MeuNode4 right;
    MeuNode4 parent;

    public MeuNode4(int v){
        this.value = v;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}*/
