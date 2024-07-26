import java.util.*;

class InserePrimeiro {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split((" "));
        int[] numeros = new int[input.length];

        for (int i = 0; i < input.length; i++){
            numeros[i] = Integer.parseInt(input[i]); 
        }

        inserePrimeiro(numeros);
        System.out.println(Arrays.toString(numeros));

        sc.close();
    }

    public static void inserePrimeiro(int[] v){
        int n = v.length;
        int primeiro = v[0]; //primeiro elemento
        int i = 1; //inicializa o indice no segundo elemento

        while (i < n && v[i] < primeiro){
            v[i-1] = v[i];
            i++;
        }

        v[i-1] = primeiro;
    }
}