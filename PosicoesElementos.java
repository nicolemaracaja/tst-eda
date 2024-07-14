import java.util.*;

class PosicoesElementos {
    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        String valor = sc.nextLine();
        String[] seq = sc.nextLine().split(" ");

        String saida = "";

        for (int i = 0; i < seq.length; i++){
            if (seq[i].equals(valor)){
                saida = saida + i + " ";
            }
        }

        if (saida.equals("")){
            System.out.println("-1");
        }else{
            System.out.println(saida.trim());
        }
        sc.close();
    }
}
