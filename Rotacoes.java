import java.util.*;

public class Rotacoes {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        AVL avl = new AVL();

        String[] entrada = sc.nextLine().split(" ");

        for (String v : entrada){
            int num = Integer.parseInt(v);
            avl.add(num);
        }

        if (avl.isBalanced()){
            System.out.println("balanceada");
        }
        sc.close();
    }
}

class AVL {

    No root;

    public AVL(){
        this.root = null;
    }

    public boolean isBalanced(){
        return Math.abs(height(this.root.left) - height(this.root.right)) <= 1;
    }

    public void add(int v){
        this.root = add(this.root, v);
    }

    public No add(No current, int v){
        if (current == null){
            return new No(v);
        }

        if (v < current.value){
            current.left = add(current.left, v);
        } else {
            current.right = add(current.right, v);
        }

        return balancear(current);
    }

    public int balance(No current){
        if (current == null){
            return 0;
        } else {
            return height(current.left) - height(current.right);
        }
    }

    public int height(){
        return height(this.root);
    }

    private int height(No current){
        if (current == null){
            return -1;
        } else {
            return 1 + Math.max(height(current.left), height(current.right));
        }

    }

    public No balancear(No current) {
        int balance = balance(current);

        if (balance > 1 && (height(current.left.left)) >= height(current.left.right)){
            return rotacaoDireita(current);
        }

        if (balance < -1 && (height(current.right.right) >= height(current.right.left))){
            return rotacaoEsquerda(current);
        }

        if (balance > 1 && (height(current.left.right) > height(current.left.left))){
            current.left = rotacaoEsquerda(current.left);
            return rotacaoDireita(current);
        }

        if (balance < -1 && (height(current.right.left) > height(current.right.right))){
            current.right = rotacaoDireita(current.right);
            return rotacaoEsquerda(current);
        }

        return current;
    }

    public No rotacaoDireita(No current){
        No pivot = current.left;
        current.left = pivot.right;
        pivot.right = current;
        System.out.println("rot_dir(" + current.value + ")");
        imprimirPreOrdem(pivot);
        return pivot; // retorna a nova raiz
    }

    public No rotacaoEsquerda(No current){
        No pivot = current.right;
        current.right = pivot.left;
        pivot.left = current;
        System.out.println("rot_esq(" + current.value + ")");
        imprimirPreOrdem(pivot);
        return pivot; // retorna a nova raiz
    }

    public void imprimirPreOrdem(No current){
        if (current != null){
            System.out.println(current.value + " ");
            imprimirPreOrdem(current.left);
            imprimirPreOrdem(current.right);
        }
    }
}

class No {
    int value;
    No left;
    No right;
    No parent;

    public No(int value){
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
