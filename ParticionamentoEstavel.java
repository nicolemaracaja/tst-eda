import java.util.Arrays;
import java.util.Scanner;

public class ParticionamentoEstavel {
    
    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(" ");
        int[] arr = new int[entrada.length-1];

        for (int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(entrada[i]);
        }

        partition(arr);
        System.out.println(Arrays.toString(arr));

        sc.close();
    }

    public static void partition(int[] v){
        if (v.length == 0){
            return;
        }

        int pivot = v[0];
        int[] menores = new int[v.length];
        int[] maiores = new int[v.length];

        int menorCount = 0;
        int maiorCount = 0;

        for (int i = 1; i < v.length; i++){
            if (v[i] <= pivot){
                menores[menorCount] = v[i];
                menorCount++;
            }else{
                maiores[maiorCount] = v[i];
                maiorCount++;
            }
        }

        System.arraycopy(menores, 0, v, 0, menorCount);
        v[menorCount] = pivot;
        System.arraycopy(maiores, 0, v, menorCount+1, maiorCount);
    }
}
