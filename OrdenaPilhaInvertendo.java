import java.util.NoSuchElementException;

public class OrdenaPilhaInvertendo {
    
    public static void main(String[] args){

    }
}

class MinhaPilha{

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
        return this.topo + 1 == pilha.length;
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

    public int peek(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return this.pilha[this.topo];
    }

    public int getMax(int index){
        if (index < 0 || index > topo){
            throw new IndexOutOfBoundsException();
        }

        MinhaPilha aux = new MinhaPilha (index + 1);
        int maior = this.peek();
        int indexMaior = 0;

        for (int i = 0; i <= index; i++){
            int removido = this.pop();

            if(removido > maior){
                maior = removido;
                indexMaior = i;
            }

            aux.push(removido);
        }
        int i = aux.size() - 1;

        while (!aux.isEmpty()){
            int removido = aux.pop();

            if(i != indexMaior){
                this.push(removido);
            }
            i--;
        }

        this.push(maior);
        return maior;
    }

    public int size(){
        return this.topo + 1;
    }
}
