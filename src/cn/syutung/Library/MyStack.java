package cn.syutung.Library;

import java.util.Arrays;

public class MyStack<T> implements Stack<T> {
    private Object[] list;
    private int no = -1;
    public MyStack(int length){
        list = new Object[length];
    }
    public MyStack(){
        this(64);
    }


    /***
     * 入栈
     * @param a Object对象
     */
    @Override
    public void push(Object a) {
        this.no ++;
        if (no  >= list.length){
            Object[] bak = this.list;
            this.list = new Object[list.length*2];
            System.arraycopy(bak, 0, list, 0, bak.length);
            //this.no = bak.length;
            list[no] = a;

        }else{
            
            this.list[no] = a;
        }
    }

    /***
     * 出栈
     * @return 返回最顶部的值
     */
    @Override
    public T pop() {
        T r = (T) list[no];
        list[no] = null;
        no-=1;
        return r;
    }

    /***
     * 不出栈获取顶部的值
     * @return 返回最顶部的值
     */
    @Override
    public T get() {
        return  (T) list[no];
    }

    /***
     * 判断栈是否为空
     * @return true or false
     */
    @Override
    public boolean isEmpty() {
        return list==null;
    }

    /***
     * 判断栈的大小
     * @return 大小
     */
    @Override
    public int size() {
        return no+1;
    }

    public String toString() {
        return  Arrays.toString(list) + "\n"+
         "队列长度："+ this.size()+";"+this.no;
    }
}
