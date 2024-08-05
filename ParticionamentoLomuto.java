import java.util.Arrays;
import java.util.Scanner;

class ParticionamentoLomuto {
    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        
        String[] v = sc.nextLine().split(" ");

        int[] array = new int[v.length];
        
        for (int i = 0; i < v.length; i++) {
            array[i] = Integer.parseInt(v[i]);
        }

        particionamento(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array));

        sc.close();
    }

    public static void particionamento(int[] v, int ini, int fim){
        int pivot = v[fim];
        int i = fim;

        for (int j = fim-1; j >= 0; j--){
            if (v[j] > pivot){
                i--;
                swap(v, i, j);
                System.out.println(Arrays.toString(v));
            }
        }
        swap(v, fim, i);
    }

    public static void swap(int[] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}
