import java.util.Scanner;

class QuickSortPassoAPasso {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String[] v = sc.nextLine().split(" ");

        int[] array = new int[v.length];
        
        for (int i = 0; i < v.length; i++) {
            array[i] = Integer.parseInt(v[i]);
        }

        quickSort(array, 0, array.length - 1);

        sc.close();
    }

    public static int particionamento(int[] v, int ini, int fim){
        int pivot = v[ini];
        int i = ini;

        for (int j = ini + 1; j <= fim; j++){
            if (v[j] <= pivot){
                i++;
                swap(v, i, j);
            }
        }
        swap(v, ini, i);
        return i;
    }

    public static void quickSort(int[] v, int ini, int fim){

        if (ini < fim){

            int indexPivot = particionamento(v, ini, fim);
            System.out.println(formataSaida(v));
            quickSort(v, ini, indexPivot-1);
            quickSort(v, indexPivot+1, fim);
        }
    }

    public static void swap(int[] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

    public static String formataSaida(int[] v){
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < v.length; i++) {
            sb.append(v[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
