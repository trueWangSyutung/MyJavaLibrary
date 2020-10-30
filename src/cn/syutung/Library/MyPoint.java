package cn.syutung.Library;

public class MyPoint<T>  implements Point<T>
{
     public T data;
     public MyPoint<T> next;
    public MyPoint(){
        this(null,null);
    }
    //调用下面的构造方法，给这个节点赋值null
    public MyPoint(
            T data,
            MyPoint<T> next
    ){
        this.data = data;
        this.next = next;
    }
    public MyPoint(MyPoint<T> a){
        this(a.data,a.next);
    }
    public MyPoint<T> getNext() {
        return next;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public void setNext(MyPoint<T> next) {
        this.next = next;
    }
    /***
     * 判断是否存在下一个节点
     * @return true或者false
     */
    public boolean hasNext(){
        return this.next != null;
    }
    @Override
    public String toString() {
        if (hasNext()){
            return  data.toString() +
                    "," + next.toString()
                    ;
        }else{
            return  data.toString() ;
        }

    }
}
