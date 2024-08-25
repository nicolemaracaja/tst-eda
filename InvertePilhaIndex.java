import java.util.NoSuchElementException;
import java.util.*;

class InvertePilhaIndex {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int tamanho = sc.nextInt();
        sc.nextLine();

        String[] entrada = sc.nextLine().split(" ");

        int[] valores = new int[tamanho];

        for (int i = 0; i < entrada.length; i++){
            valores[i] = Integer.parseInt(entrada[i]);
        }

        int index = sc.nextInt();

        Pilha pilha = new Pilha(tamanho);

        for (int i = 0; i < valores.length; i++){
            pilha.push(valores[i]);
        }

        pilha.inverteAteIndex(index);

        System.out.println("-");
        System.out.println(pilha.toString());

        sc.close();
    }

}

class Pilha {

    private int topo;
    private int[] pilha;

    public Pilha(int capacidade){
        this.pilha = new int[capacidade];
        this.topo = -1; //começa como uma posição inexistente
    }

    public boolean isEmpty(){
        return this.topo == -1; //se o topo não for atualizado, a pilha está vazia
    }

    public boolean isFull(){
        return this.topo + 1 == this.pilha.length; //verifica se o topo está no limite do array
    }

    public void push(String removido){
        if (this.isFull()){
            throw new RuntimeException("Pilha cheia!");
        }
        this.topo++;
        this.pilha[topo] = removido; //incrementa o topo e atualiza o valor
    }

    public int pop(){
        if (this.isEmpty()){
            throw new NoSuchElementException("Pilha está vazia!");
        }
        return this.pilha[topo--]; //decrementa o topo
    }

    public void inverteAteIndex(int index){
        Pilha aux1 = new Pilha(index + 1);

        for (int i = 0; i <= index; i++){
            aux1.push(this.pop());
        }

        Pilha aux2 = new Pilha(index + 1);

        while (!aux1.isEmpty()){
            aux2.push(aux1.pop());
        }

        while (!aux2.isEmpty()){
            this.push(aux2.pop());
        }
    }

    /*public int peek(){
        if (this.isEmpty()){
            throw new NoSuchElementException("Pilha está vazia!");
        }
        return this.pilha[topo];
    }*/

    public String toString(){
        Pilha pilhaAux = new Pilha(this.topo + 1);
        String saida = "";

        while (!this.isEmpty()){
            int valorRemovido = this.pop();
            pilhaAux.push(valorRemovido);

            if (saida.equals("")){
                saida += valorRemovido;
            } else {
                saida += "\n" + valorRemovido;
            }
        }

        while (!pilhaAux.isEmpty()){
            this.push(pilhaAux.pop());
        }

        return saida;
    }

    //Retorna a posição da primeira ocorrência do valor
    /*public int indexOf(int valor){
        Pilha pilhaAux = new Pilha(this.topo + 1);
        int pos = 0;

        while (!this.isEmpty()){
            int valorAtual = this.pop();

            if (valorAtual == valor){
                while (!pilhaAux.isEmpty()){
                    this.push(pilhaAux.pop());
                }
                this.push(valorAtual);
                return pos;
            }
            pilhaAux.push(valorAtual);
            pos++;
        }

        while (!pilhaAux.isEmpty()){
            this.push(pilhaAux.pop());
        }

        return -1;
    }*/

    public int size(){
        return this.topo + 1;
    }

}
