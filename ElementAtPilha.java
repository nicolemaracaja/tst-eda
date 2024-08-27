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
        Pilhazinha aux = new Pilhazinha(this.topo + 1);
        int pos = 0;
        String saida = "indice invalido";

        if (index < 0 || index > this.topo){
            return "indice invalido";
        }

        while (!this.isEmpty()){
            int removido = this.pop();

            if (pos == index){
                saida = Integer.toString(removido);
            }       
            aux.push(removido);
            pos++;
        }

        while (!aux.isEmpty()){
            this.push(aux.pop());
        }


        return saida;
    }
}