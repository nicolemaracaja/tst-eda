import java.util.*;

class FiltraLinkedList {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(" ");

        int[] valores = new int[entrada.length];

        for (int i = 0; i < entrada.length; i++){
            valores[i] = Integer.parseInt(entrada[i]);
        }

        int valor = sc.nextInt();
        sc.nextLine();

        MinhaLinkedList2 linkedlist = new MinhaLinkedList2();

        for (int i = 0; i < valores.length; i++){
            linkedlist.addLast(valores[i]);
        }

        linkedlist.removeOcorrencias(valor);

        System.out.println(linkedlist.toString());

        sc.close();
    }
}

class MinhaLinkedList2 {

    private MeuNode2 head;
    private MeuNode2 tail;
    private int size;

    public MinhaLinkedList2(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public void addLast(int value){
        MeuNode2 newNode = new MeuNode2(value);

        if (isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        } else {
            MeuNode2 aux = this.head;

            for (int i = 0; i < size; i++){
                aux = aux.next;
            }

            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }

        this.size++;
    }

    public void removeFirst(){
        if (this.isEmpty()){
            throw new NoSuchElementException();
        }

        if (this.head.next == null){
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }

        this.size--;
    }

    public void removeLast(){
        if (this.isEmpty()){
            throw new NoSuchElementException();
        }

        if (this.head.next == null){
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }

        this.size--;
    }

    public void remove(MeuNode2 node){
        
        if (node == this.head){
            removeFirst();
        } else if (node == this.tail){
            removeLast();
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            this.size--;
        }
    }

    public void removeOcorrencias(int value){
        if (isEmpty()){
            return;
        }

        MeuNode2 aux = this.head;

        while (aux != null){
            if (aux.value == value){
                remove(aux);
            }
            aux = aux.next;
        }

    }

    public String toString(){
        if (isEmpty()){
            return "vazia";
        }

        MeuNode2 aux = this.head;
        String saida = "";

        while (aux.next != null){
            saida += aux.value + " ";
            aux = aux.next;
        }
        saida += aux.value; //ultimo valor
        return saida;
    }
}

class MeuNode2 {

    MeuNode2 prev;
    MeuNode2 next;
    int value;

    public MeuNode2(int v){
        this.value = v;
        this.prev = null;
        this.next = null;
    }
}
