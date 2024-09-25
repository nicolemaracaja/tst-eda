/*import java.util.*;

public class EncaminhamentoBST {
    
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

        System.out.println(tree.preOrder());
        System.out.println(tree.inOrder());
        System.out.println(tree.posOrder());

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
        if (isEmpty()){
            this.root = new MeuNode(v);
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
                return;
            } else {
                recursiveAdd(current.left, v);
            }
        } else {
            if (current.right == null){
                MeuNode newNode = new MeuNode(v);
                current.right = newNode;
                newNode.parent = current;
                return;
            } else {
                recursiveAdd(current.right, v);
            }
        }
    }

    public List<Integer> preOrder(){
        List<Integer> preOrder = new ArrayList<>();
        preOrder(this.root, preOrder);
        return preOrder;       
    }

    private void preOrder(MeuNode current, List<Integer> preOrder){
        if (current != null){
            preOrder.add(current.value);
            preOrder(current.left, preOrder);
            preOrder(current.right, preOrder);
        }
    }

    public List<Integer> inOrder(){
        List<Integer> inOrder = new ArrayList<>();
        inOrder(this.root, inOrder);
        return inOrder;       
    }

    private void inOrder(MeuNode current, List<Integer> inOrder){
        if (current != null){
            inOrder(current.left, inOrder);
            inOrder.add(current.value);
            inOrder(current.right, inOrder);
        }
    }

    public List<Integer> posOrder(){
        List<Integer> posOrder = new ArrayList<>();
        posOrder(this.root, posOrder);
        return posOrder;       
    }

    private void posOrder(MeuNode current, List<Integer> posOrder){
        if (current != null){
            posOrder(current.left, posOrder);
            posOrder(current.right, posOrder);
            posOrder.add(current.value);
        }
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