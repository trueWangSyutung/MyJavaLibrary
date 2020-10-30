package cn.syutung.Library;
/***
 * @apiNote 链表类的实现接口
 * @author BISTU_Syutung
 * @version 1.0.1
 * @param <T> 泛型
 */
public interface LianList<T> {
     int size = 0;
     T get(int i);
     void set(int i ,T p);
     MyPoint<T> getPoint(int i);

     int size();
     void add(T p);
     void add(int i,T x);
     void del(int i);
     void del();
     void clear();
     void heBing(InitializationList<T> list);
     void niZhuan();
     String toString();
}
