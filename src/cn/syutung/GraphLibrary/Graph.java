/*
 * @Author: Syutung
 * @Date: 2020-11-21 15:16:49 
 * @Last Modified by:   Syutung
 * @Last Modified time: 2020-11-21 15:16:49 
 */
package cn.syutung.GraphLibrary;
import cn.syutung.ListLibrary.InitializationList;

public interface Graph<T> {
    int getPointNumber();
    T get(int i);
    void set(int i,T x);
    void addPoint(T x);
    void addEdge(int from, int to , int weight);
    void removePoint(int i);
    void removeEdge(int x,int y);
    InitializationList<Integer> searchAllKey(T key);
    int searchKey(T key);
    void DFS(int i);
    void BFS(int i);
}
