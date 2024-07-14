import java.util.*;

class EncontraPrimeiroNegativo {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] numeros = sc.nextLine().split(" ");

        String saida = "-";

        for (int i = 0; i < numeros.length; i++){
            if (Integer.parseInt(numeros[i]) < 0){
                saida = numeros[i];
                break;
            }
        }
        System.out.println(saida);
        sc.close();
    }
}
