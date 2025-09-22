import java.util.Scanner;

class TrocaVizinhosLinkedList {
    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(" ");
        int index = sc.nextInt();
        sc.nextLine();

        MinhaLinkedList linked = new MinhaLinkedList();

        for (int i = 0; i < entrada.length; i++){
            linked.addLast(Integer.parseInt(entrada[i]));
        }

        linked.trocaVizinhos(index);

        System.out.println(linked.toString());
        sc.close();
    }
}

class MinhaLinkedList {

    private MeuNode head;
    private MeuNode tail;
    private int size;

    public MinhaLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public void addLast(int value){
        MeuNode newNode = new MeuNode(value);

        if (this.isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        size++;
    }

    public void trocaVizinhos(int index){
        if (index < 0 || index >= size - 1){
            throw new IndexOutOfBoundsException();
        }

        MeuNode node1 = this.head;
        for (int i = 0; i < index; i++){
            node1 = node1.next; //valor do index
        }

        MeuNode node2 = node1.next; //proximo valor

        if (node1.prev != null){
            node1.prev.next = node2;
        } else {
            this.head = node2; //caso node1 seja a cabeça da lista
        }

        if (node2.next != null){
            node2.prev.next = node1;
        } else {
            this.tail = node1; //caso node
        }

        node1.next = node2.next;
        node2.prev = node1.prev;

        node1.prev = node2;
        node2.next = node1;
    }

    public String toString(){
        String saida = "";

        if (!this.isEmpty()){
            MeuNode aux = this.head;

            while (aux.next != null){
                saida += aux.value + " ";
                aux = aux.next;
            }
            saida += aux.value; //ultimo valor
        }

        return saida;
    }
}

class MeuNode {

    MeuNode next;
    MeuNode prev;
    int value;

    public MeuNode(int v){
        this.value = v;
        this.next = null;
        this.prev = null;
    }
}
