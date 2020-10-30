import cn.syutung.Library.*;

public class TestLinearList {
    public static void main(String[] args) {
        InitializationList<Integer> sindleList
                =new InitializationList<>();

        sindleList.add(1);
        System.out.println("当前长度：" + sindleList.size());
        sindleList.add(2);
        System.out.println("当前长度：" + sindleList.size());
        sindleList.add(3);
        System.out.println("当前长度：" + sindleList.size());
        sindleList.add(4);
        System.out.println("当前长度：" + sindleList.size());
        sindleList.add(5);
        System.out.println("当前长度：" + sindleList.size());
        System.out.println("当前链表：" + sindleList.toString());

        System.out.println(sindleList.get(4));
        sindleList.add(4,99);
        System.out.println("当前长度：" + sindleList.size());
        System.out.println("当前链表：" + sindleList.toString());

        sindleList.set(2,290);
        System.out.println("当前长度：" + sindleList.size());
        System.out.println("当前链表：" + sindleList.toString());

        sindleList.del();
        System.out.println("当前长度：" + sindleList.size());
        System.out.println("当前链表：" + sindleList.toString());

        sindleList.del(5);
        System.out.println("当前长度：" + sindleList.size());
        System.out.println("当前链表：" + sindleList.toString());

        sindleList.niZhuan();
        System.out.println("当前长度：" + sindleList.size());
        System.out.println("当前链表：" + sindleList.toString());

        InitializationList<Integer> p =
                new InitializationList<Integer>(
                        new Integer[]{1,2,3,4,5,6,7,8});

        System.out.println("待合并的链表长度：" + p.size());
        System.out.println("待合并的链表：" + p.toString());
        sindleList.heBing(p);
        System.out.println("当前长度：" + sindleList.size());
        System.out.println("当前链表：" + sindleList.toString());


    }
}
