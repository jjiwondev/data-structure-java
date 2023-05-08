// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press ⌥⏎ with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println(indexOf(5));
    }
    public static int indexOf(int val) {
        for(int i = 0; i<10; i++){
            if( i == val){
                return i;
            }
        }
        return -1;
    }
}