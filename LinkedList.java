import java.util.NoSuchElementException;

public class LinkedList {
    
    private Node head;
    private Node tail;
    private int size;

    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return this.head == null; //início da lista não foi atualizado
    }

    //adiciona o elemento ao início da linkedlist
    public void addFirst(int valor){
        Node newNode = new Node(valor);

        if (isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head; //atualiza os ponteiros
            this.head.prev = newNode;
            this.head = newNode; //atualiza o head
        }

        this.size++;
    }

    //adiciona o elemento no final da linkedlist
    public void addLast(int valor){
        Node newNode = new Node(valor);

        if (isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode; //atualiza os ponteiros
            newNode.prev = this.tail;
            this.tail = newNode; //atualiza o tail
        }

        this.size++;
    }

    //adiciona um elemento na linkedlist a partir de um index
    public void add(int index, int valor){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index fora dos limites!");
        }

        //se o index for 0, adiciona no início
        if (index == 0){ 
            this.addFirst(valor);
        }
        //se o index for o último, acrescenta no final
        else if (index == size - 1){
            this.addLast(valor);
        }
        else {
            Node newNode = new Node(valor);
            Node aux = this.head;

            for (int i = 0; i < index - 1; i++){
                aux = aux.next;
            }
            //ao final desse for, o aux estará apontado para o nó anterior do novo nó

            newNode.next = aux.next;
            aux.next = newNode;
            newNode.next.prev = newNode;
            newNode.prev = aux;

            size++;
        }
    }

    //retorna o valor do primeiro nó
    public int getFirst(){
        if (isEmpty()){
            throw new NoSuchElementException("Lista vazia!");
        }
        return this.head.value;
    }

    //retorna o valor do último nó
    public int getLast(){
        if (isEmpty()){
            throw new NoSuchElementException("Lista vazia!");
        }
        return this.tail.value;
    }

    //Rteorna o valor do nó a partir do index
    public int get (int index){

        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index fora dos limites!");
        }

        Node aux = this.head;

        for (int i = 0; i < index; i++){
            aux = aux.next;
        }

        return aux.value;
    }

    //retorna o index da primeira ocorrência do nó
    public int indexOf(Node node){
        Node aux = this.head;
        int index = 0;
        while (node != null){
            if (aux.value == node.value){
                return index;
            }
            aux = aux.next;
            index++;
        }
        return -1;
    }

    //retorna se há o nó na linkedlist
    public boolean contains(Node node){
        return indexOf(node) != -1;
    }

    //remove o primeiro elemento da linkedlist
    public int removeFirst(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        int valor = this.head.value;

        if (this.head.next == null){ //se só tiver um elemento na lista
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }
        size--;
        return valor;
    }

    //remove o último elemento da linkedlist
    public int removeLast(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        int valor = this.tail.value;

        if (this.head.next == null){ //se só tiver um elemento na lista
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        size--;
        return valor;
    }

    //remove o elemento pelo index
    public int remove (int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        if (index == 0){
            this.removeFirst();
        }
        if (index == size - 1){
            this.removeLast();
        }

        Node aux = this.head;
        for (int i = 0; i < index; i++){
            aux = aux.next;
        }

        aux.next.prev = aux.next;
        aux.prev.next = aux.prev;
        size--;
        return aux.value;
    }

    //remove o elemento pelo nó
    public boolean remove (Node node){
        Node aux = this.head;
        for (int i = 0; i < this.size; i++){
            if (aux.value == node.value){
                if (i == 0){
                    removeFirst();
                } else if (i == size - 1){
                    removeLast();
                } else {
                    aux.prev.next = aux.next;
                    aux.next.prev = aux.prev;
                    size--;
                }
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    //retorna o tamanho da linkedlist
    public int size(){
        return this.size;
    }

    //move o elemento para a cabeça da fila
    public void moveToHead(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        Node aux = this.head;
        for (int i = 0; i < index; i++){
            aux = aux.next;
        }

        if (aux == this.tail){
            this.tail = aux.prev;
            aux.next.prev = aux.prev;
        }

        aux.next = this.head;
        this.head.prev = aux;
        aux.prev = null;
        this.head = aux;
    }
}

class Node {

    int value;
    Node prev;
    Node next;

    Node(int v){
        this.value = v;
    }
}
