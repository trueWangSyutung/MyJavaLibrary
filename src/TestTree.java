import cn.syutung.TreeLibrary.*;
import java.util.Scanner;
public class TestTree {
    static String s = "A B C # # D E # G # # F # # #";
    String p = "A B C # D # # E F G # # # H I # # J # # K L M N # # O # # P # Q # # R S";
    String r = "A B C # D # # E # F G # # H # # I J K L M N # # O # # # P # Q # R S # # # # T";
    static String[] a = s.split(" ");
    static TwoTree result = new TwoTree(a);

    public static void menu() {
        System.out.println("/********请输入遍历方法****************/");
        System.out.println("/********1.前序遍历(使用递归)**********/");
        System.out.println("/********2.中序遍历(使用递归)**********/");
        System.out.println("/********3.后序遍历(使用递归)**********/");
        System.out.println("/********4.前序遍历(不使用递归)********/");
        System.out.println("/********5.中序遍历(不使用递归)********/");
        System.out.println("/********6.后序遍历(不使用递归)********/");
        System.out.println("/********7.层次遍历(不使用递归)********/");
        System.out.println("/********8.节点数目******************/");
        System.out.println("/********9.节点深度******************/");
        System.out.println("/********-1 . 退出******************/");
        System.out.println("/********请输入遍历方法***************/");
    }
    public static void choose(){
        Scanner in = new Scanner(System.in);
        while (true){
            int i = in.nextInt();
            switch (i){
                case 1 -> {
                    System.out.print("前序遍历：");
                    result.pre();
                }
                case 2 -> {
                    System.out.print("中序遍历：");
                    result.ino();
                }
                case 3 -> {
                    System.out.print("后序遍历：");
                    result.pos();
                }
                case 4 -> {
                    System.out.print("前序遍历：");
                    result.pre_not_used();
                }
                case 5 -> {
                    System.out.print("中序遍历：");
                    result.ino_not_used();
                }
                case 6  -> {
                    System.out.print("后序遍历：");
                    result.bac_not_used();
                }
                case 7 -> {
                    System.out.print("层次遍历：");
                    result.ceng();
                }
                case 8->{
                    System.out.println("节点数目："+result.getNodeNumber());
                }
                case 9 ->{
                    System.out.println("节点深度："+result.getNodeDeepin());
                }
            }
            if (i==-1){
                break;
            }
        }



    }
    public static void main(String[] args) {
        menu();
        choose();
     }
}
