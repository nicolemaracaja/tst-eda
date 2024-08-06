import java.util.*;

class TrocaVizinhos {
    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(" ");    

        int[] array = new int[entrada.length];

        for (int i = 0; i < entrada.length; i++){
            array[i] = Integer.parseInt(entrada[i]);
        }

        trocaVizinhos(array);
        System.out.println(Arrays.toString(array));

        sc.close();
    }

    public static void trocaVizinhos(int[] v){
        
        for (int i = 0; i < v.length - 1; i+=2){
            int aux = v[i];
            v[i] = v[i+1];
            v[i+1] = aux;
        }
    }
}
