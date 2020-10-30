package cn.syutung.Library;

import java.util.Arrays;

public class MyQueue<T> implements Queue<T> {
    private int front=-1;
    private int mo=-1;
    private Object[] list;
    public MyQueue(int i){
        list = new Object[i];
        front =0;
        mo = 0;
    }
    public MyQueue(){
        this(64);
    }
    public MyQueue(T[] args){
        this();
        if (args!=null){
            front = 0;
            if (args.length>list.length){
                Object[] bak = this.list;
                this.list = new Object[list.length*2];
                if (bak.length >= 0)
                    System.arraycopy(bak, 0, list, 0, bak.length);
                    this.mo = args.length-1;

            }else{
                System.arraycopy(args, 0, list, 0, args.length);
                this.mo = args.length-1;
            }
        }
    }
    /***
     * 入队
     * @param ap Object对象
     */
    @Override
    public void enqueue(T ap) {
        if ((list.length)<mo+1){
            Object[] bak = this.list;
            this.list = new Object[list.length*2];
            int p = 0;
            for (int i=0;i<bak.length;i++){
                if (bak[i]!=null){
                    p=i;
                    break;
                }
            }
            if (bak.length >= 0)
                System.arraycopy(bak, p, list, 0, bak.length-p);
            list[bak.length-p] = ap;
            this.front=0;
            this.mo = bak.length-p+1;

        }else{
            this.list[mo] = ap;
            this.mo ++;
        }
    }

    @Override
    public Object dequeue() {
        Object r = list[front];
        list[front] = null;
        front++;
        return r;
    }

    @Override
    public boolean isEmpty() {
        return list==null;
    }

    @Override
    public int size() {
        return mo-front;
    }


    @Override
    public String toString() {
        return  Arrays.toString(list) + "\n"+
         "队列长度："+ this.size();
    }
}
