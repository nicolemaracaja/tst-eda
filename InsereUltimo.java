import java.util.*;

class InsereUltimo {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split((" "));
        int[] numeros = new int[input.length];

        for (int i = 0; i < input.length; i++){
            numeros[i] = Integer.parseInt(input[i]); 
        }

        insereUltimo(numeros);
        System.out.println(Arrays.toString(numeros));

        sc.close();
    }

    public static void insereUltimo(int[] v){
        int n = v.length;
        int ultimo = v[n-1]; //ultimo elemento
        int i = v.length - 2; //inicializa o indice no penultimo elemento

        while (i >= 0 && v[i] > ultimo){
            v[i+1] = v[i];
            i--;
        }

        v[i+1] = ultimo;
    }
}
