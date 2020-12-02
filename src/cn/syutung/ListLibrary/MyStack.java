package cn.syutung.ListLibrary;

import java.util.ArrayList;
import java.util.Arrays;

public class MyStack<T> implements Stack<T> {
    private ArrayList<T> data;

    public MyStack(){
        data = new ArrayList<>();
    }


    /***
     * 入栈
     * @param a Object对象
     */
    @Override
    public void push(T a) {
        data.add(a);
    }

    /***
     * 出栈
     * @return 返回最顶部的值
     */
    @Override
    public T pop() {
        T a = data.get(data.size()-1);
        data.remove(data.size()-1);
        return a;
    }

    /***
     * 不出栈获取顶部的值
     * @return 返回最顶部的值
     */
    @Override
    public T get() {
        return data.get(data.size()-1);
    }

    /***
     * 判断栈是否为空
     * @return true or false
     */
    @Override
    public boolean isEmpty() {
        return data.size()==0;
    }

    /***
     * 判断栈的大小
     * @return 大小
     */
    @Override
    public int size() {
        return data.size();
    }

    public String toString() {
        return data.toString() + "\n"+
         "队列长度："+ this.size()+";";
    }

    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>();
        myStack.push("fgdf");
        System.out.println(myStack.toString());
        System.out.println(myStack.pop());
    }
}
