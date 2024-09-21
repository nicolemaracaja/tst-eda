public class Heap {
    
    private int[] heap;
    private int tail;

    public Heap(int capacidade){
        this.heap = new int[capacidade];
        this.tail = -1;
    }

    public Heap(int[] heap){
        this.heap = heap;
        this.tail = this.heap.length - 1;
        this.buildHeap();
    }

    public boolean isEmpty(){
        return this.tail == -1;
    }

    public int left(int i){
        return (2 * i) + 1;
    }

    public int right(int i){
        return (2 * i) + 1;
    }

    public int parent(int i){
        return (i - 1) / 2;
    }

    public void add(int n){
        if (tail >= (heap.length) - 1){
            resize();
        }

        this.tail++;
        this.heap[tail] = n;

        int i = tail;
        while (i > 0 && this.heap[parent(i)] < this.heap[i])~{
            swap(i, parent(i));
            i = parent(i);
        }
    }

    
}
