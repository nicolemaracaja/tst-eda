import java.util.NoSuchElementException;

//LIFO - Last in, first out (O último que entra é o primeiro a sair)
public class Stack {
    
    private int[] pilha;
    private int topo;

    public Stack(int capacidade){
        this.pilha = new int[capacidade];
        this.topo = -1; //topo começa em uma posição inexistente
    }

    //verifica se a pilha está vazia
    public boolean isEmpty(){
        return topo == -1;
    }
 
    //verifica se a pilha está cheia
    public boolean isFull(){
        return this.topo + 1 == pilha.length;
    }
 
    //adiciona um elemento novo na pilha
    public void push(int valor){
        if (isFull()){
            throw new RuntimeException("Pilha cheia!");
        }
        this.topo++;
        this.pilha[topo] = valor;
    }
 
    //remove o primeiro elemento da pilha
    public int pop(){
        if (isEmpty()){
            throw new NoSuchElementException("Pilha vazia!");
        }
        return this.pilha[topo--];
    }

    //retorna o primeiro elemento no topo da pilha
    public int peek(){
        if (isEmpty()){
            throw new NoSuchElementException("Pilha vazia!");
        }
        return this.pilha[topo];
    }

    //formata a representação em string da pilha
    public String toString(){
        if (isEmpty()){
            return "";
        }

        Pilha aux = new Pilha(this.topo + 1);
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

    //tamanho da pilha
    public int size(){
        return this.topo + 1;
    }
}
