import java.util.*;

class ElementosDuplicados {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //leitura da primeira linha
        String[] entrada = sc.nextLine().split(" ");

        boolean achou = false;

        for (int i = 0; i < entrada.length - 1; i++){
            for (int j = i + 1; j < entrada.length; j++){
                if (entrada[i].equals(entrada[j])){
                    achou = true;
                }
            }
        }

        System.out.println(achou);
        sc.close();
    }
}