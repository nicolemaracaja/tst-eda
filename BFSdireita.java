import java.util.Scanner;

class BFSdireita {
    
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

        System.out.println(tree.bfsDireita());
        
        sc.close();
    }
}

class MinhaBST {

    MeuNode root;

    public MinhaBST(){
        this.root = null;
    }

    public boolean isEmpty(){
        return this.root == null;
    }
     
    public void add(int v){
        if(isEmpty()){
            this.root = new MeuNode7(v);
        } else {
            recursiveAdd(this.root, v);
        }
    }

    public void recursiveAdd(MeuNode7 current, int v){
        if (v < current.value){
            if (current.left == null){
                MeuNode newNode = new MeuNode(v);
                current.left = newNode;
                newNode.parent = current;
            } else {
                recursiveAdd(current.left, v);
            }
        } else {
            if (current.right == null){
                MeuNode newNode = new MeuNode(v);
                current.right = newNode;
                newNode.parent = current;
            } else {
                recursiveAdd(current.right, v);
            }
        }
    }

    public int height(){
        return height(this.root);
    }

    public int height(MeuNode7 current){
        if (current == null){
            return 0;
        } else {
            return 1 + Math.max(height(current.left), height(current.right));
        }
    }

    public String bfsDireita(){
        if (root == null){
            return "";
        }
        
        String saida = "";
        int height = height(this.root);

        for (int i = 1; i <= height; i++){
            saida += bfsDireita(this.root, i, saida);
        }

        return saida.trim();
    }

    public String bfsDireita(MeuNode7 current, int i, String saida){
        if (current == null){
            return "";
        }
        if (i == 1){
            return current.value + " ";
        } else if (i > 1){
            return bfsDireita(current.right, i - 1, saida) + bfsDireita(current.left, i - 1, saida);
        }
        return "";
    }
}

class MeuNode {

    int value;
    MeuNode7 left;
    MeuNode7 right;
    MeuNode7 parent;

    public MeuNode(int v){
        this.value = v;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
