
import java.util.Scanner;

class MaxHeap {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(" ");
        int[] heapArray = new int[entrada.length];

        for (int i = 0; i < entrada.length; i++) {
            heapArray[i] = Integer.parseInt(entrada[i]);
        }

        Heap heap = new Heap(heapArray);

        System.out.println(heap.isMaxHeap());

        sc.close();
    }
}

class Heap {

    int[] heap;
    int tail;

    public Heap(int capacidade){
        this.heap = new int[capacidade];
        this.tail = -1;
    }

    public Heap(int[] heap){
        this.heap = heap;
        this.tail = this.heap.length - 1;
        //this.buildHeap(); //constrói o heap a partir do array de entrada
    }

    public int[] getHeapArray(){
        return this.heap;
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

    public void add(int n){
        if (tail >= heap.length - 1){
            resize(); //aumenta o array, se necessário
        }

        this.tail++;
        this.heap[tail] = n;

        int i = tail;
        while (i > 0 && this.heap[parent(i)] < this.heap[i]){
            swap(i, parent(i)); //troca com o pai, se ele for menor que o filho
            i = parent(i);
        }
    }

    public int remove(){
        if (isEmpty()){
            throw new RuntimeException();
        }

        int element = this.heap[0]; //pega a raiz;
        this.heap[0] = this.heap[tail]; //troca a raiz com o último
        this.tail--; //remove o último(raiz)

        this.heapify(0); //reordena o heap
        return element;
    }

    public void heapify(int i){
        if (isLeaf(i) || !isValidIndex(i)){
            return;
        }

        //encontra o maior
        int index_max = max_index(i, left(i), right(i)); 

        if (index_max != i){
            swap(i, index_max);
            heapify(index_max);
        }
    }

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
    public boolean isLeaf(int index){
        return index > parent(tail) && index <= tail; 
    }

    public boolean isValidIndex(int index){
        return index >= 0 && index <= tail; 
    }

    public void swap(int i, int j){
        int aux = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = aux;
    }

    public void resize(){
        int[] novoHeap = new int[this.heap.length * 2]; //dobra o tamanho
        for (int i = 0; i <= tail; i++){
            novoHeap[i] = this.heap[i]; //copia os elementos antigos para o novo array
        }
        this.heap = novoHeap;
    }

    /*public void buildHeap(){
        for (int i = parent(this.tail); i >= 0; i--){
            heapify(i);
        }
    }*/

    public boolean isMaxHeap(){
        for (int i = 0; i <= (tail - 1) / 2; i++){
            //verifica se o nó pai é maior que o filho esquerdo
            if (left(i) <= tail && heap[i] < heap[left(i)]){
                return false;
            }
            //verifica se o nó pai é maior que o filho direito
            if (right(i) <= tail && heap[i] < heap[right(i)]){
                return false;
            }
        }
        return true;
    }
}
