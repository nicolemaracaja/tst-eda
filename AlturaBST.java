import java.util.*;

public class AlturaBST {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(" ");
        int[] values = new int[entrada.length];

        for (int i = 0; i < entrada.length; i++){
            values[i] = Integer.parseInt(entrada[i]);
        }

        MinhaBST6 tree = new MinhaBST6();

        for (int i = 0; i < entrada.length; i++){
            tree.add(values[i]);
        }

        System.out.println(tree.height());
        sc.close();
    }
}

class MinhaBST6 {

    MeuNode6 root;

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

    public void recursiveAdd(MeuNode6 current, int v){
        if (v < current.value){
            if (current.left == null){
                MeuNode6 newNode = new MeuNode6(v);
                current.left = newNode;
                newNode.parent = current;
            } else {
                recursiveAdd(current.left, v);
            }
        } else {
            if (current.right == null) {
                MeuNode6 newNode = new MeuNode6(v);
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

    public int height(MeuNode6 current){
        if (current == null){
            return -1;
        } else {
            return 1 + Math.max(height(current.left), height(current.right));
        }
    }
}

class MeuNode6 {

    int value;
    MeuNode6 left;
    MeuNode6 right;
    MeuNode6 parent;

    public MeuNode6(int v){
        this.value = v;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
