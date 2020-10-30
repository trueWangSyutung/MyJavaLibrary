
import cn.syutung.Library.Tools;
import java.util.Scanner;
public class TestStack {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String StdIn = input.next();
        input.close();
        System.out.println(Tools.sum(StdIn));
    }
}
