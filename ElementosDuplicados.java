import java.util.*;

class ElementosDuplicados {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //leitura da primeira linha
        String[] entrada = sc.nextLine().split(" "); //leitura da entrada: O(n) + O(m)

        boolean achou = false; //booleano O(1)

        for (int i = 0; i < entrada.length - 1; i++){ //for O(m^2)
            for (int j = i + 1; j < entrada.length; j++){
                if (entrada[i].equals(entrada[j])){
                    achou = true;
                }
            }
        }

        System.out.println(achou); //saida O(1)
        sc.close();
    }
}