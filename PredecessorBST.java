import java.util.*;

public class PredecessorBST {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(" ");
        int[] values = new int[entrada.length];

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < entrada.length; i++){
            values[i] = Integer.parseInt(entrada[i]);
        }

        MinhaBST2 tree = new MinhaBST2();

        for (int v : values){
            tree.add(v);
        }

        int predecessor = tree.predecessor(tree.getRoot()).value;

        List<Integer> saida = new ArrayList<>();

        for (int v : values){
            if (v == predecessor){
                break;
            } else {
                saida.add(v);
            }
        }

        System.out.println();

        sc.close();
    }
}

class MinhaBST2 {

    MeuNode2 root;

    public MinhaBST2(){
        this.root = null;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public MeuNode2 getRoot(){
        return this.root;
    }

    public void add(int value){
        if (isEmpty()){
            this.root = new MeuNode2(value);
        } else {
            recursiveAdd(this.root, value);
        }
    }

    private void recursiveAdd(MeuNode2 current, int valor){
        if (valor < current.value){
            if (current.left == null){
                MeuNode2 newNode = new MeuNode2(valor);
                current.left = newNode;
                newNode.parent = current;
                return;
            } else {
                recursiveAdd(current.left, valor);
            }
        } else {
            if (current.right == null){
                MeuNode2 newNode = new MeuNode2(valor);
                current.right = newNode;
                newNode.parent = current;
            } else {
                recursiveAdd(current.right, valor);
            }
        }
    }

    public MeuNode2 max(){
        if (isEmpty()){
            return null;
        } else {
            return max(this.root);
        }
    }

    public MeuNode2 max(MeuNode2 current){
        if (current.right == null){
            return current;
        } else {
            return max(current.right);
        }
    }

    public MeuNode2 predecessor(MeuNode2 current){
        if (isEmpty()){
            return null;
        }
        if (current == null){
            return null;
        }
        if (current.left != null){
            return max(current.left);
        } else {
            MeuNode2 aux = current.parent;
            while (aux != null && aux.value > current.value){
                aux = aux.parent;
            }
            return aux;
        }
    }
}

class MeuNode2 {

    int value;
    MeuNode2 left;
    MeuNode2 right;
    MeuNode2 parent;

    public MeuNode2(int v){
        this.value = v;
        this.left = null;
        this.right = null;
    }

}