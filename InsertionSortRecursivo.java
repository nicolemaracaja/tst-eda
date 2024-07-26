import java.util.*;

class InsertionSortRecursivo {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split((" "));
        int[] numeros = new int[input.length];

        for (int i = 0; i < input.length; i++){
            numeros[i] = Integer.parseInt(input[i]); 
        }

        insertionSortRecursivo(numeros, numeros.length);
        sc.close();
    }

    public static void insertionSortRecursivo(int[] v, int n){

        if (n <= 1) { //array com um ou menos elementos ja ta ordenado
            return;
        }

        // Ordena os primeiros n-1 elementos
        insertionSortRecursivo(v, n - 1);

        int ultimo = v[n - 1]; //ultimo elemento
        int i = n - 2; //indice que começa no penultimo elemento

        while (i >= 0 && v[i] > ultimo) {
            v[i + 1] = v[i];
            i--;
        }

        v[i + 1] = ultimo;

        System.out.println(Arrays.toString(v));
    }
}
