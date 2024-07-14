import java.util.*;

class VetorCircular {
    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(" ");
        int qtd = sc.nextInt();

        int elementosImpressos = 0;
        int pos = 0;

        String saida = "";
        while (elementosImpressos < qtd){
            saida += seq[pos] + " ";

            pos = (pos + 1) % seq.length;
            elementosImpressos++;
        }

        System.out.println(saida.trim());
        sc.close();
    }
}
