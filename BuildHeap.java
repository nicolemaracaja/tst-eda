import java.util.*;

public class BuildHeap {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(" ");
        int[] heapArray = new int[entrada.length];

        for (int i = 0; i < entrada.length; i++){
            heapArray[i] = Integer.parseInt(entrada[i]);
        }

        Heap heap = new Heap(heapArray);
        System.out.println(Arrays.toString(heap.heap));
        
        sc.close();
    }
}

class Heap {

    int[] heap;
    int tail;

    //construtor que cria um heap vazio
    public Heap(int capacidade){
        this.heap = new int[capacidade];
        this.tail = -1;
    }

    //construtor que organiza os elementos do array em uma estrutura heap
    public Heap(int[] heap){
        this.heap = heap;
        this.tail = this.heap.length - 1;
        this.buildHeap();
    }

    public boolean isEmpty(){
        return this.tail == -1;
    }

    public int left(int i){
        return 2 * i + 1;
    }

    public int right(int i){
        return 2 * i + 2;
    }

    public int parent(int i){
        return (i - 1) / 2;
    }

    //adiciona um elemento ao heap, inserindo-o no final do array e ordenando 
    public void add(int n){
        if (tail >= heap.length - 1){
            resize();
        }

        this.tail++;
        this.heap[tail] = n;

        int i = tail;
        while (i > 0 && this.heap[parent(i)] < this.heap[i]){
            swap(i, parent(i));
            i = parent(i);
        }
    }

    //troca os elementos nas posições i e j do array heap
    public void swap(int i, int j){
        int aux = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = aux;
    }

    //dobra o tamanho do array heap quando o limite é atingido
    public void resize(){
        int[] novoHeap = new int[this.heap.length * 2];
        for (int i = 0; i <= tail; i++){
            novoHeap[i] = this.heap[i];
        }
        this.heap = novoHeap;
    }

    //remove sempre a raiz e reestrutura o heap
    public int remove(){
        if (isEmpty()){
            throw new RuntimeException();
        }
        int element = this.heap[0]; //pega o elemento da raiz
        this.heap[0] = this.heap[tail]; //troca a raiz com o último
        this.tail--; //remove o último
        
        this.heapify(0);
        return element;
    }

    //compara o nó atual com seus filhos e troca de lugar com o maior deles
    public void heapify(int i){
        if (isLeaf(i) || !isValidIndex(i)){
            return;
        }

        int index_max = max_index(i, left(i), right(i));

        if (index_max != i){
            swap(i, index_max);
            heapify(index_max);
        }
    }

    //determina o índice de maior valor entre o nó e seus filhos
    public int max_index(int i, int left, int right){
        if (isValidIndex(left) && this.heap[i] < this.heap[left]){
            i = left;
        }

        if (isValidIndex(right) && this.heap[i] < this.heap[right]){
            i = right;
        }

        return i;
    }

    //verifica se o nó é uma folha
    public boolean isLeaf(int i){
        return i > parent(tail) && i <= tail;
    }

    //verifica se o índice é valido
    public boolean isValidIndex(int i){
        return i >= 0 && i <= tail;
    }

    //constroi o heap chamando o heapify de baixo para cima
    public void buildHeap(){
        for (int i = parent(this.tail); i >= 0; i--){
            heapify(i);
        }
    }

}
