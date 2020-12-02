package cn.syutung.ListLibrary;

/***
 * 栈的接口
 * @param <T> 泛型
 */
public interface Stack<T> {
    /***
     * 入栈
     * @param a T对象
     */
    void push(T a);

    /***
     * 出栈
     * @return 返回最顶部的值
     */
    T pop();
    /***
     * 不出栈获取顶部的值
     * @return 返回最顶部的值
     */
    T get();

    /***
     * 判断栈是否为空
     * @return true or false
     */
    boolean isEmpty();
    /***
     * 判断栈的大小
     * @return 大小
     */
    int size();

}
