import java.util.*;

class ValorMaisProximoBST {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] elementos = sc.nextLine().split(" ");
        int[] values = new int[elementos.length];

        for (int i = 0; i < elementos.length; i++){
            values[i] = Integer.parseInt(elementos[i]);
        }

        int value = sc.nextInt();
        sc.nextLine();

        MinhaBST tree = new MinhaBST();

        for (int v : values){
            tree.add(v);
        }

        List<Integer> preOrder = new ArrayList<>();
        tree.preOrder(tree.getRoot(), preOrder);
        System.out.println(preOrder);

        int valorMaisProximo = tree.encontrarValorMaisProximo(value);
        System.out.println(valorMaisProximo);
        sc.close();
    }
}

class MinhaBST{

    MeuNode root;

    public MinhaBST(){
        this.root = null;
    }

    public MeuNode getRoot(){
        return this.root;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public void add(int value){
        if (isEmpty()){
            this.root = new MeuNode(value);
        } else {
            recursiveAdd(this.root, value);
        }
    }

    private void recursiveAdd(MeuNode current, int value){
        if (value < current.value){
            if (current.left == null){
                current.left = new MeuNode(value);
            } else {
                recursiveAdd(current.left, value);
            }
        } else {
            if (current.right == null){
                current.right = new MeuNode(value);
            } else {
                recursiveAdd(current.right, value);
            }
        }
    }

    public int encontrarValorMaisProximo(int value){
        return encontrarValorMaisProximo(this.root, value, this.root.value);
    }

    private int encontrarValorMaisProximo(MeuNode current, int value, int valorMaisProximo){
        if (current == null){
            return valorMaisProximo;
        }

        //calcula qual o valor mais próximo
        if (Math.abs(value - current.value) < Math.abs(value - valorMaisProximo)){
            valorMaisProximo = current.value;
        }

        if (value < current.value){
            return encontrarValorMaisProximo(current.left, value, valorMaisProximo);
        } else if (value > current.value){
            return encontrarValorMaisProximo(current.right, value, valorMaisProximo);
        } else {
            return current.value;
        }
    }

    public void preOrder(MeuNode node, List<Integer> saida){
        if (node != null){
            saida.add(node.value);
            preOrder(node.left, saida);
            preOrder(node.right, saida);
        }
    }

}

class MeuNode{
    
    int value;
    MeuNode left;
    MeuNode right;

    public MeuNode(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
