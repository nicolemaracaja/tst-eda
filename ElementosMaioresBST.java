import java.util.*;

public class ElementosMaioresBST {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(" ");
        int[] values = new int[entrada.length];

        for (int i = 0; i < entrada.length; i++){
            values[i] = Integer.parseInt(entrada[i]);
        }

        MinhaBST5 tree = new MinhaBST5();

        for (int i = 0; i < entrada.length; i++){
            tree.add(values[i]);
        }

        int valor = sc.nextInt();
        sc.nextLine();

        System.out.println(tree.preOrder());

        int count = tree.qtdElementosMaiores(valor);
        System.out.println(count);
        sc.close();
    }
}

class MinhaBST5 { 

    MeuNode5 root;

    public MinhaBST5(){
        this.root = null;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public MeuNode5 getNode(int v){
        if (isEmpty()){
            return null;
        } else {
            MeuNode5 aux = this.root;

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

    public void add(int v){
        if (isEmpty()){
            this.root = new MeuNode5(v);
        } else {
            recursiveAdd(this.root, v);
        }
    }

    public void recursiveAdd(MeuNode5 current, int v){
        if (v < current.value){
            if (current.left == null){
                MeuNode5 newNode = new MeuNode5(v);
                current.left = newNode;
                newNode.parent = current;
            } else {
                recursiveAdd(current.left, v);
            }
        } else {
            if (current.right == null){
                MeuNode5 newNode = new MeuNode5(v);
                current.right = newNode;
                newNode.parent = current;
            } else {
                recursiveAdd(current.right, v);
            }
        }
    }

    public List<Integer> preOrder(){
        List<Integer> result = new ArrayList<>();
        preOrder(this.root, result);
        return result;
    }

    public void preOrder(MeuNode5 current, List<Integer> result){
        if (current != null){
            result.add(current.value);
            preOrder(current.left, result);
            preOrder(current.right, result);
        }
    }

    public int qtdElementosMaiores(int v){
        return qtdElementosMaiores(this.root, v);
    }

    public int qtdElementosMaiores(MeuNode5 current, int v){
        if (current == null){
            return 0;
        } 
        if (current.value > v){
            return 1 + qtdElementosMaiores(current.left, v) + qtdElementosMaiores(current.right, v);
        } else {
            return qtdElementosMaiores(current.right, v);
        }
    }


    //preOrder
    //Sysout, left, right
    
    //inOrder
    //left, sysout, right

    //posOrder
    //left, right, sysout
}

class MeuNode5 {

    int value;
    MeuNode5 left;
    MeuNode5 right;
    MeuNode5 parent;

    public MeuNode5(int v){
        this.value = v;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}