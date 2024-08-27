/*import java.util.NoSuchElementException;

//FIFO - First in, first out (O primeiro que entra é o primeiro que sai)
public class Queue {
    
    private int[] fila;
    private int head;
    private int tail;
    private int size;

    public Queue(int capacidade){
        this.fila = new int[capacidade];
        this.head = -1;
        this.tail = -1;
        this.size = 0;
    }

    public boolean isEmpty(){
        return this.head == -1 && this.tail == -1;
    }

    public boolean isFull(){
        return (tail + 1) % fila.length == this.head;
    }

    //adiciona um elemento ao final da fila
    public void addLast(int value){
        if (isFull()){
            throw new RuntimeException("Fila cheia!");
        }

        if (isEmpty()){
            this.head = 0;
        }

        this.tail = (tail + 1) % fila.length;
        this.fila[tail] = value;
        size++;
    }

    //remove o primeiro elemento da fila
    public int removeFirst(){
        if (isEmpty()){
            throw new NoSuchElementException("Fila vazia!");
        }
    
        if (this.head == this.tail){
            this.head = -1;
            this.tail = -1;
        } else {
            head = (head + 1) % fila.length;
        }

        size--;
        return this.fila[head];
    }
 
    //retorna o primeiro elemento da fila
    public int getFirst(){
        if (isEmpty()){
            throw new NoSuchElementException("Fila vazia!");
        }
        return this.fila[head];
    }

    //retorna o último elemento da fila
    public int getLast(){
        if (isEmpty()){
            throw new NoSuchElementException("Fila vazia!");
        }
        return this.fila[tail];
    }

    //formata a representação da fila em string
    public String toString(){
        if (isEmpty()){
            return "";
        }

        Queue aux = new Queue(this.size);
        String saida = "";

        while (!this.isEmpty()){
            int removido = this.removeFirst();
            aux.addLast(removido);

            if (saida.equals("")){
                saida += removido;
            } else {
                saida += ", " + removido;
            }
        }

        while (!aux.isEmpty()){
            this.addLast(aux.removeFirst());
        }

        return saida;
    }

    //retorna o primeiro index do valor parâmetro
    public int indexOf(int value){
        Queue aux = new Queue(this.size);
        int index = -1;

        while (!this.isEmpty()){
            int removido = removeFirst();
            aux.addLast(removido);
            index++;
            if (removido == value){
                break;
            }
        }

        while (!this.isEmpty()){
            aux.addLast(this.removeFirst());
        }

        while (!aux.isEmpty()){
            this.addLast(aux.removeFirst());
        }

        return index;
    }

    //retorna o último index do valor parâmetro
    public int lastIndexOf(int value){
        Queue aux = new Queue(this.size);
        int index = -1;
        int lastIndex = -1;

        while (!this.isEmpty()){
            int removido = removeFirst();
            aux.addLast(removido);
            index++;
            if (removido == value){
                lastIndex = index;
            }
        }

        while (!this.isEmpty()){
            aux.addLast(this.removeFirst());
        }

        while (!aux.isEmpty()){
            this.addLast(aux.removeFirst());
        }

        return lastIndex;
    }

    //retorna o tamanho da fila
    public int size(){
        return this.size;
    }
}*/
