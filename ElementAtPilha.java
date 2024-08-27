import java.util.*;

public class ElementAtPilha {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(" ");
        int index = sc.nextInt();

        int[] valores = new int[entrada.length];

        for (int i = 0; i < entrada.length; i++){
            valores[i] = Integer.parseInt(entrada[i]);
        }

        Pilhazinha pilha = new Pilhazinha(valores.length);

        for (int i = 0; i < valores.length; i++){
            pilha.push(valores[i]);
        }

        System.out.println(pilha.pegaValor(index));
        sc.close();
    }
}

class Pilhazinha {

    private int[] pilha;
    private int topo;

    public Pilhazinha(int capacidade){
        this.pilha = new int[capacidade];
        this.topo = -1;
    }

    public boolean isEmpty(){
        return this.topo == -1;
    }

    public boolean isFull(){
        return this.topo + 1 == this.pilha.length;
    }

    public void push(int value){
        if (isFull()){
            throw new RuntimeException();
        }
        this.pilha[++this.topo] = value;
    }

    public int pop(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return this.pilha[this.topo--];
    }

    public String toString(){
        if (this.isEmpty()){
            return "";
        }

        Pilhazinha aux = new Pilhazinha(topo+1);
        String saida = "";

        while (!this.isEmpty()){
            int removido = this.pop();
            aux.push(removido);

            if (saida.equals("")){
                saida += removido;
            } else {
                saida += "\n" + removido;
            }
        }

        while (!aux.isEmpty()){
            this.push(aux.pop());
        }

        return saida;
    }

    public int peek(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return this.pilha[this.topo];
    }

    public String pegaValor(int index){
        if (index < 0 || index > this.topo) {
            return "indice invalido";
        }

        Pilhazinha aux = new Pilhazinha(this.topo + 1);

        while (!this.isEmpty()) {
            aux.push(this.pop());
        }

        int valor = -1;
        for (int i = 0; i <= index; i++) {
            valor = aux.pop();
        }

        while (!aux.isEmpty()) {
            this.push(aux.pop());
        }

        return Integer.toString(valor);
    }
}