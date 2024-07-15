import java.util.*;

class ComparaStrings {
    
    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);

        String[] s1 = sc.nextLine().split(" ");
        String[] s2 = sc.nextLine().split(" ");

        boolean saida = comparaStrings(s1, s2);

        System.out.println(saida);
        sc.close();
    }

    public static boolean comparaStrings(String[] s1, String[] s2){

        Set<String> set1 = new HashSet<>(Arrays.asList(s1));
        Set<String> set2 = new HashSet<>(Arrays.asList(s2));

        return set1.equals(set2);
    }
}
