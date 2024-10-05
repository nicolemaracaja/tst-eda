public class PVTemplate {

    private NodePV root;
    private int size;

    public int alturaPreta() {
        if (isEmpty()){
            return 0;
        }
        return alturaPreta(this.root);
    }

    private int alturaPreta(NodePV node){
        if (node == null){
            return 0;
        } 
        if (node.vermelho == false){
            return 1 + Math.max(alturaPreta(node.left), alturaPreta(node.right));
        }

        return Math.max(alturaPreta(node.left), alturaPreta(node.right));
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public NodePV avo(NodePV node){
        //não ter pai implica em não ter avô
        if (node.getParent() == null){
            return null;
        }
        NodePV pai = node.getParent();
        return pai.getParent(); //avô do nó
    }

    public NodePV tio(NodePV node){
        NodePV avo = avo(node);
        if (avo == null){
            return null;
        }

        NodePV pai = node.getParent();

        if (pai.value > avo.value){ //se o pai for maior que o avô, o tio é necessariamente menor
            return avo.getLeft();
        } else {
            return avo.getRight(); //se o pai for menor que o avô, o tio é necessariamente maior
        }
    }

    //CASO 1: nó é raiz (pinta de preto)
    public void ehCaso1(NodePV node){
        if (node.getParent() == null){
            node.vermelho = false;
        } else {
            ehCaso2(node);
        }
    }

    //CASO 2: O pai do nó é preto (só adiciona)
    public void ehCaso2(NodePV node){
        if (node.parent.vermelho == true){
            ehCaso3(node);
        }
    }

    //CASO 3: Verifica se o tio é vermelho. Se for, troca a cor do pai, tio e avô
    public void ehCaso3(NodePV node){
        NodePV tio = tio(node);
        if (tio != null && tio.vermelho == true){
            NodePV pai = node.getParent();
            NodePV avo = avo(node);

            //troca a cor do tio
            tio.vermelho = false;

            //troca a cor do pai
            if (pai.vermelho == true){
                pai.vermelho = false;
            } else {
                pai.vermelho = true;
            }

            //troca a cor do avô
            if (avo.vermelho == true){
                avo.vermelho = false;
            } else {
                avo.vermelho = true;
            }

            ehCaso1(avo);

        } else {
            ehCaso4(node);
        }
    }

    //CASO 4: Vê se tá em zigue zague, se tiver, rotaciona o pai e chama o caso 5
    public void ehCaso4(NodePV node){
        NodePV pai = node.getParent();
        NodePV avo = avo(node);

        //verifica se é zigue zague (se pai e filho estao em direções opostas)
        if (node == pai.right && pai == avo.left){
            rotateLeft(pai);
            node = node.left;
        } else if (node == pai.left && pai == avo.right){
            rotateRight(pai);
            node = node.right;
        }

        ehCaso5(node);
    }

    //CASO 5: Troca a cor do pai e do avô e rotaciona
    public void ehCaso5(NodePV node){
        NodePV pai = node.getParent();
        NodePV avo = avo(node);

        if (node == pai.left){
            rotateRight(avo);
        } else {
            rotateLeft(avo);
        }

        //troca a cor do pai
        if (pai.vermelho == true){
            pai.vermelho = false;
        } else {
            pai.vermelho = true;
        }

        //troca a cor do avô
        if (avo.vermelho == true){
            avo.vermelho = false;
        } else {
            avo.vermelho = true;
        }
    }

    public void rotateLeft(NodePV node){
        NodePV pivot = node.right;

        node.right = pivot.left;

        if (pivot.left != null){
            pivot.left.parent = node;
        }

        pivot.parent = node.parent;

        if (node.parent == null){
            this.root = pivot;
        } else if (node == node.parent.left){
            node.parent.left = pivot;
        } else {
            node.parent.right = pivot;
        }

        pivot.left = node;
        node.parent = pivot;
    }

    public void rotateRight(NodePV node){
        NodePV pivot = node.left;

        node.left = pivot.right;

        if (pivot.right != null){
            pivot.right.parent = node;
        }

        pivot.parent = node.parent;

        if (node.parent == null){
            this.root = pivot;
        } else if (node == node.parent.left){
            node.parent.left = pivot;
        } else {
            node.parent.right = pivot;
        }

        pivot.right = node;
        node.parent = pivot;
    }
    

    /**
     * Implementação iterativa da adição de um elemento em uma árvore binária de pequisa.
     * @param element o valor a ser adicionado na árvore.
     */
    public void add(int element, boolean vermelho) {
        this.size += 1;
        if (isEmpty())
            this.root = new NodePV(element, vermelho);
        else {
            
            NodePV aux = this.root;
            
            while (aux != null) {
                
                if (element < aux.value) {
                    if (aux.left == null) { 
                        NodePV newNode = new NodePV(element, vermelho);
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.left;
                } else {
                    if (aux.right == null) { 
                        NodePV newNode = new NodePV(element, vermelho);
                        aux.right = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.right;
                }
            }
        }
        
    }
    
    
}


class NodePV {
    
    int value;
    NodePV left;
    NodePV right;
    NodePV parent;
    boolean vermelho;
    
    NodePV(int v, boolean vermelho) {
        this.value = v;
        this.vermelho = vermelho;
    }

    public NodePV getLeft() {
        return this.left;
    }

    public NodePV getRight() {
        return this.right;
    }

    public NodePV getParent() {
        return this.parent;
    }

    public int getValue() {
        return this.value;
    }


    public boolean hasOnlyLeftChild() {
        return (this.left != null && this.right == null);
    }
    
    public boolean hasOnlyRightChild() {
        return (this.left == null && this.right != null);
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }
    
}
