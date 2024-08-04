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

    /*public static void inserePrimeiro(int[] v){
        int n = v.length;
        int primeiro = v[0]; //primeiro elemento
        int i = 1; //inicializa o indice no segundo elemento

        while (i < n && v[i] < primeiro){
            v[i-1] = v[i];
            i++;
        }

        v[i-1] = primeiro;
    }*/

    public static void inserePrimeiro(int[] v){

        int indexMenor = getMenor(v);

        for (int i = indexMenor; i >= 0; i--){
            if (v[indexMenor] < v[i]){
                swap(v, indexMenor, i);
            }
        }
            
    }

    public static int getMenor(int[] v){
        int menor = v[0];
        int indexMenor = 0;

        for (int i = 0; i < v.length; i++){
            if (v[i] < menor){
                indexMenor = i;
            }
        }
        return indexMenor;
    }

    public static void swap(int[] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

}