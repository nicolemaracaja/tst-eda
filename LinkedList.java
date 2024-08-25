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

    public void add(int index, int valor){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index fora dos limites!");
        }

        if (index == 0){
            this.addFirst(valor);
        }
        else if (index == size){
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

    public int getFirst(){
        if (isEmpty()){
            throw new NoSuchElementException("Lista vazia!");
        }
        return this.head.value;
    }

    public int getLast(){
        if (isEmpty()){
            throw new NoSuchElementException("Lista vazia!");
        }
        return this.tail.value;
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