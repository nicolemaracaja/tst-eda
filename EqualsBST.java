import java.util.Scanner;

public class EqualsBST {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] entrada1 = sc.nextLine().split(" ");
        int[] values1 = new int[entrada1.length];

        for (int i = 0; i < entrada1.length; i++){
            values1[i] = Integer.parseInt(entrada1[i]);
        }

        MinhaBST tree1 = new MinhaBST();

        for (int i = 0; i < entrada1.length; i++){
            tree1.add(values1[i]);
        }

        String[] entrada2 = sc.nextLine().split(" ");
        int[] values2 = new int[entrada2.length];

        for (int i = 0; i < entrada2.length; i++){
            values2[i] = Integer.parseInt(entrada2[i]);
        }

        MinhaBST tree2 = new MinhaBST();

        for (int i = 0; i < entrada2.length; i++){
            tree2.add(values2[i]);
        }

        System.out.println(tree1.equals(tree2));
        sc.close();
    }
}

class MinhaBST {

    MeuNode root;
    int size;

    public MinhaBST(){
        this.root = null;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public void add(int v){
        if (isEmpty()){
            this.root = new MeuNode(v);
        } else {
            recursiveAdd(this.root, v);
        }
        this.size++;
    }

    public void recursiveAdd(MeuNode8 current, int v){
        if (v < current.value){
            if (current.left == null){
                MeuNode newNode = new MeuNode(v);
                current.left = newNode;
                newNode.parent = current;
            } else {
                recursiveAdd(current.left, v);
            }
        } else {
            if (current.left == null){
                MeuNode newNode = new MeuNode(v);
                current.right = newNode;
                newNode.parent = current;
            } else {
                recursiveAdd(current.right, v);
            }
        }
    }

    public int size(){
        return this.size;
    }

    public boolean equals(MinhaBST outra){
        if (this.size != outra.size){
            return false;
        }
        return equals(this.root, outra.root);
    }

    public boolean equals(MeuNode n1, MeuNode n2){
        if (n1 == null && n2 == null){
            return true;
        }
        if (n1 == null || n2 == null){
            return false;
        }
        return (n1.value == n2.value) && equals(n1.left, n2.left) && equals(n1.right, n2.right);
    }
}

class MeuNode {

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
