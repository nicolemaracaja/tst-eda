import java.util.*;

class Rotacoes {
    
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
        } else {
            avl.root = avl.balancear(avl.root);
        }

        sc.close();
    }
}

class AVL {

    No root;

    public AVL(){
        this.root = null;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public boolean isBalanced(){
        return Math.abs(height(this.root.left) - height(this.root.right)) <= 1;
    }

    public void add(int v){
        this.root = add(this.root, v, null);
    }

    public No add(No current, int v, No parent){
        if (current == null){
            No newNode = new No(v);
            newNode.parent = parent;
            return newNode;
        }

        if (v < current.value){
            current.left = add(current.left, v, current);
        } else {
            current.right = add(current.right, v, current);
        }

        return current;
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
        if (current == null){
            return null;
        }

        int balance = balance(current);

        //desbalanceado para a esquerda (rotaciona para a direita)
        if (balance > 1){
            if (balance(current.left) < 0){
                current.left = rotacaoEsquerda(current.left);
            }
            return rotacaoDireita(current);
        }

        //desbalanceado para a direita (rotaciona para a esquerda)
        if (balance < -1){
            if (balance(current.right) > 0){
                current.right = rotacaoDireita(current.right);
            }
            return rotacaoEsquerda(current);
        }

        return current;
    }

    public No rotacaoDireita(No current){
        No pivot = current.left; 
        current.left = pivot.right;
        pivot.right = current;

        //atualiza os pais
        pivot.parent = current.parent;
        current.parent = pivot;

        if (pivot.parent != null){
            if (pivot.parent.left == current){
                pivot.parent.left = pivot;
            } else {
                pivot.parent.right = pivot;
            }
        } else {
            this.root = pivot;
        }

        System.out.println("rot_dir(" + current.value + ")");
        imprimirPreOrdem(this.root);
        return pivot; // retorna a nova raiz
    }

    public No rotacaoEsquerda(No current){
        No pivot = current.right;
        current.right = pivot.left;
        pivot.left = current;

        //atualiza os pais
        pivot.parent = current.parent;
        current.parent = pivot;

        if (pivot.parent != null){
            if (pivot.parent.right == current){
                pivot.parent.right = pivot;
            } else {
                pivot.parent.left = pivot;
            }
        } else {
            this.root = pivot;
        }

        System.out.println("rot_esq(" + current.value + ")");
        imprimirPreOrdem(this.root);
        return pivot; // retorna a nova raiz
    }


    public void imprimirPreOrdem(No current){
        List<Integer> result = new ArrayList<>();
        imprimirPreOrdem(current, result);
        System.out.println(result);
    }

    public void imprimirPreOrdem(No current, List<Integer> result){
        if (current != null){
            result.add(current.value);
            imprimirPreOrdem(current.left, result);
            imprimirPreOrdem(current.right, result);
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

