import java.util.*;

class InvertePilhaSemFila {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int tamanho = sc.nextInt();
        sc.nextLine();
        String[] entrada = sc.nextLine().split(" ");

        MinhaPilha pilha = new MinhaPilha(tamanho);

        for (int i = tamanho - 1; i >= 0; i--){
            pilha.push(Integer.parseInt(entrada[i]));
        }

        System.out.println(pilha.toString());
        sc.close();
    }
}

class MinhaPilha {

    private int[] pilha;
    private int topo;

    public MinhaPilha(int capacidade){
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
        return this.pilha[topo--];
    }

    public String toString(){
        if (this.isEmpty()){
            return "";
        }

        MinhaPilha aux = new MinhaPilha(topo+1);
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
}
