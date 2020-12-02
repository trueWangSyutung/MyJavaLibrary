import cn.syutung.ListLibrary.*;

public class TestQueue {
    public static void main(String[] args) {

        MyQueue<String> p =
                new MyQueue<>(3); 
        //创建一个长度为三的泛型为字符串的队列
        p.enqueue("张三");  //张三入列
        p.enqueue("李四");  //李四入列
        p.enqueue("王五");  //王五入列
        System.out.println("当前队列:"+p.toString()); //当前队列
        p.enqueue("'孙八"); //入列，扩容
        System.out.println("当前队列:"+p.toString()); //当前队列
        p.enqueue("周九");  //入列
        System.out.println("当前队列:"+p.toString()); //当前队列
        System.out.println("当前出队："+p.dequeue());
        System.out.println("当前队列:"+p.toString()); //当前队列
        System.out.println("当前出队："+p.dequeue());
        System.out.println("当前队列:"+p.toString()); //当前队列
        p.enqueue("刘一");
        p.enqueue("陈二");
        p.enqueue("钱六");
        System.out.println("当前队列:"+p.toString()); //当前队列

       
    }
}
