// *Сравнить время выполнения замены символа "а" на "А" любой строки 
// содержащей >1000 символов средствами String и StringBuilder.
import java.util.Random;

public class task2_3 {
    public static void main(String[] args) {
        String[] letter_list = new String[]
            {"a", "b", "c", "d", "e", "f", "g",
            "h", "i", "j", "k", "l", "m", "n", "o", "p",
            "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        Random r = new Random();  
                                        
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            builder.append(letter_list[r.nextInt(26)]); 
        }
        String str = builder.toString();

        long start = System.nanoTime(); 
        str.replace("a", "A");
        System.out.println(System.nanoTime() - start);

        start = System.nanoTime();
        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == 'a'){
                builder.setCharAt(i, 'A');
            }
        }
        System.out.println(System.nanoTime() - start);
        System.out.println(builder);
        System.out.println(str);
    }
} 
