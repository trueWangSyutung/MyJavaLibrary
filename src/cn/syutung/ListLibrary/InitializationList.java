package cn.syutung.ListLibrary;

/***
 * @apiNote 链表类的实体类
 * @author BISTU_Syutung
 * @version 1.0.1
 * @param <T> 泛型
 */
public class InitializationList<T> implements LianList<T>{
    private   int size = 0;
    public MyPoint<T> head;

    /***
     * 无参构造方法
     */
    public InitializationList(){
        this.head = new MyPoint<>();
    }

    /***
     * 含参数构造方法，传入参数为
     * 一个泛型列表
     * @param args 一个泛型列表
     */
    public InitializationList(
            T[] args
    ){
        this();
        MyPoint<T> list = this.head;
        for (T arg : args) {
            if (arg != null) {
                list.next = new MyPoint<>(arg, null);
                list = list.next;
            }
        }
        size = args.length;
    }


    public int find(T key){
        for (int i=0;i<size();i++){
            if (get(i+1)==key){
                return i;
            }
        }
        return 0;
    }


    /***
     * 从链表中取得相应索引下的data值
     * @param i 输入的索引号
     * @return 链表的相应索引下的data值
     */
    @Override
    public T get(int i){
        MyPoint<T> list = this.head;
        for (int j=0;list!=null && j<i ;j++ ){
            list = list.next;
        }
        if (list!=null && i>=0){
            return list.data;
        }else{
            return null;
        }
    }
    public MyPoint<T> getPoint(int i){
        MyPoint<T> list = this.head;
        for (int j=0;list!=null && j<i ;j++ ){
            list = list.next;
        }
        if (list!=null && i>=0){
            return list;
        }else{
            return null;
        }
    }

    /***
     * 更改链表中的某一位数值
     * @param i 输入的索引号
     * @param p 需要更改后的data值
     */
    @Override
    public void set(int i ,T p){
        MyPoint<T> list = this.head.next;
        int num = 1;
        while (list.hasNext()){
            num++;
            list = list.next;
            if (num == i) {
                list.data = p;
                break;
            }
        }
    }

    /***
     * 输出列表数据大小
     * @return 整数类型
     */
    @Override
    public int size(){
        return size;
    }

    /***
     * 向列表的最后添加元素
     * @param p 需要添加的元素
     */
    public void add(T p){
        add(Integer.MAX_VALUE,p);
    }

    /***
     * 向列表的指定位置添加元素
     * @param i 需要添加的位置
     * @param p 需要添加的元素
     */
    public void add(int i,T p ){
        if (p!=null){
            MyPoint<T> qian = this.head;
            for (int j=0;j<i && qian.hasNext();j++){
                qian = qian.next;
            }
                qian.next = new MyPoint<T>(p,qian.next);
            size++;
        }else{
            System.out.println("Input error!");
        }
    }

    /***
     * 删除列表指定位置的元素
     * @param i 需要删除的位置
     */
    public void del(int i){
            MyPoint<T> qian = this.head;
            for (int j=1;j<i && qian.hasNext();j++){
                qian = qian.next;
            }
            if (qian.hasNext() && i>=0){
                qian.next = qian.next.next;
            }
            size--;
    }

    /***
     * 删除链表最后位置的元素
     */
    public void del(){
        del(size);
    }

    /***
     * 清空链表
     */
    public void clear(){
        this.head.next = null;
        size = 0;
    }

    /***
     * 合并两个链表
     * @param list 被合并的链表
     */
    public void heBing(InitializationList<T> list){
        if (list.head.hasNext()){
            MyPoint<T> qian = this.head;
            for (int j=0;j<size() && qian.next!=null;j++){
                qian = qian.next;
            }
            qian.next = list.head.next;
            size+=list.size();
        }
    }

    /***
     * 逆转当前链表
     */
    public  void niZhuan(){
        if (!head.hasNext() || !head.next.hasNext()){
            return ;
        }

        MyPoint<T> cur = head.next;
        MyPoint<T> next = null;
        MyPoint<T> newHead = new  MyPoint<T>();

        while (cur != null){
            next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }

        this.head = newHead;
    }

    /***
     * 输出当前链表
     * @return 字符串
     */
    @Override
    public String toString() {
        if (head.next!=null){
            return "["+ head.next.toString() + ']';
        }
        return null;
    }
}
