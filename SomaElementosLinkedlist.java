/*class SomaElementosLinkedlist {
    
    public static void main(String[] args){
        int[] valores = new int[]{1, 2, 3, 4, 5, 6};

        MinhaLinkedList lista = new MinhaLinkedList();

        for (int i = 0; i < valores.length; i++){
            lista.addLast(valores[i]);
        }

        int saida = lista.soma();

        System.out.println(saida);
    }
}

class MinhaLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public MinhaLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private boolean isEmpty(){
        return this.head == null; 
    }

    public void addLast(int value){
        Node newNode = new Node(value);

        if (this.isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.size++;
    }

    public int soma(){
        if (this.head == null){
            return 0;
        }

        int soma = 0;
        Node current = this.head;

        while (current != null){
            soma += current.value;
            current = current.next;
        }

        return soma;
    }

    public int size(){
        return this.size;
    }
}

class Node {

    int value;
    Node prev;
    Node next;

    public Node(int v){
        this.value = v;
        this.prev = null;
        this.next = null;
    }
}*/

