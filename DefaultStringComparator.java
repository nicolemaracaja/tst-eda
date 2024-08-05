public class DefaultStringComparator implements StringComparator {

    @Override
    public int compare(String str1, String str2) {
        return str1.compareTo(str2);
    }
    
}
