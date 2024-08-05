import java.util.*;

class SelectionSortPassoAPasso{

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split((" "));
        int[] numeros = new int[input.length];

        for (int i = 0; i < input.length; i++){
            numeros[i] = Integer.parseInt(input[i]); 
        }

        selectionSort(numeros);

        sc.close();
    }

    public static void selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int indexMenor = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[indexMenor]) {
                    indexMenor = j;
                }
            }
            if (indexMenor != i){
                swap(array, i, indexMenor);
            }

            System.out.println(Arrays.toString(array));
        }
    }

    public static void swap(int[] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}