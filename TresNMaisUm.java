import java.util.Scanner;

class TresNMaisUm {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i = scanner.nextInt();
        int j = scanner.nextInt();

        int ini = Math.min(i, j);
        int fim = Math.max(i, j);

        int tamanhoMaxSeq = 0;

        for (int num = ini; num <= fim; num++) {
            int tamanhoSeq = calculaTamanhoSequencia(num);
            if (tamanhoSeq > tamanhoMaxSeq) {
                tamanhoMaxSeq = tamanhoSeq;
            }
        }
        System.out.println(tamanhoMaxSeq);
        scanner.close();
    }

    public static int calculaTamanhoSequencia(int n) {
        int tamanho = 1;
        long atual = n;

        while (atual != 1) {
            if (atual % 2 == 0) {
                atual /= 2;
            } else {
                atual = atual * 3 + 1;
            }
            tamanho++;
        }
        return tamanho;
    }
}
