class Potencia {
    
    public static void main(String[] args){
        System.out.println(pot(2, 3));
        System.out.println(pot(2, 10));
    }

    public static int pot(int n, int a){
        if (a == 0){ //qualquer valor elevado a 0, resulta em 1
            return 1;
        }
        return n * pot(n, a - 1);
        //caso de parada é quando a = 0
    }
}
