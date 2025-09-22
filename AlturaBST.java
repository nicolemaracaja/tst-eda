import java.util.*;

public class AlturaBST {
    
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

        System.out.println(tree.height());
        sc.close();
    }
}

class MinhaBST {

    MeuNode root;

    public MinhaBST6(){
        this.root = null;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public void add(int v){
        if (isEmpty()){
            this.root = new MeuNode6(v);
        } else {
            recursiveAdd(this.root, v);
        }
    }

    public void recursiveAdd(MeuNode current, int v){
        if (v < current.value){
            if (current.left == null){
                MeuNode newNode = new MeuNode(v);
                current.left = newNode;
                newNode.parent = current;
            } else {
                recursiveAdd(current.left, v);
            }
        } else {
            if (current.right == null) {
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

    public int height(MeuNode current){
        if (current == null){
            return -1;
        } else {
            return 1 + Math.max(height(current.left), height(current.right));
        }
    }
}

class MeuNode {

    int value;
    MeuNode6 left;
    MeuNode6 right;
    MeuNode6 parent;

    public MeuNode(int v){
        this.value = v;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
