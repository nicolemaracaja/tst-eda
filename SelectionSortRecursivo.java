import java.util.Arrays;
import java.util.Scanner;

class SelectionSortRecursivo {
    
     public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split((" "));
        int[] numeros = new int[input.length];

        for (int i = 0; i < input.length; i++){
            numeros[i] = Integer.parseInt(input[i]); 
        }

        selectionSortRecursivo(numeros, numeros.length);
        sc.close();
    }

    public static void selectionSortRecursivo(int[] v, int n){

        if (n <= 1) { //array com um ou menos elementos ja ta ordenado
            return;
        }

        // Ordena os primeiros n-1 elementos
        selectionSortRecursivo(v, n - 1);

        for (int i = 0; i < n - 1; i++){
            int indexMenor = i;
            for (int j = i + 1; j < n; j++){
                if (v[j] < v[indexMenor]){
                    indexMenor = j;
                }
            }
            swap(v, i, indexMenor);
        }
        System.out.println(Arrays.toString(v));
    }

    public static void swap(int[] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}
