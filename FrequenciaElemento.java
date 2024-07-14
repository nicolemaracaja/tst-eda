import java.util.*;

class FrequenciaElemento {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String valor = sc.nextLine();
        String[] numeros = sc.nextLine().split(" ");

        int qtd = 0;
        for (int i = 0; i < numeros.length; i++){
            if (numeros[i].equals(valor)){
                qtd++;
            }
        }
        System.out.println(qtd);

        sc.close();
    }
}
