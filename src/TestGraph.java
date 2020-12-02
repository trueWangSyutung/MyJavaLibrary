

import cn.syutung.GraphLibrary.MyGraph;
import cn.syutung.ListLibrary.InitializationList;

import java.util.ArrayList;

public class TestGraph {



    public static void main(String[] args) {
        test3();

    }
    public static void test1(){
        ArrayList<String> points = new ArrayList<>();
        points.add("A");
        points.add("B");
        points.add("F");
        points.add("C");
        MyGraph<String> q = new MyGraph<>(points,true);
        System.out.println(q.toString());
        q.removePoint(3);
        System.out.println(q.toString());
        q.addPoint("D");
        q.addPoint("E");
        q.addEdge(0,1,1);
        q.addEdge(0,3,1);
        q.addEdge(1,2,9);
        q.addEdge(1,3,12);
        q.addEdge(2,4,1);
        q.addEdge(0,4,4);
        q.addEdge(3,2,1);
        q.addEdge(3,4,1);
        System.out.println(q.toString());
        q.DFS(0);
        q.BFS(0);
    }
    public static void test2(){
        ArrayList<String> points = new ArrayList<>();
        points.add("A");
        points.add("B");
        points.add("C");
        points.add("D");
        MyGraph<String> q = new MyGraph<>(points,false);
        q.addPoint("E");
        q.addPoint("F");
        q.addPoint("G");
        q.addEdge(0,1,1);
        q.addEdge(0,2,1);
        q.addEdge(0,3,9);
        q.addEdge(1,4,12);
        q.addEdge(1,2,1);
        q.addEdge(2,3,4);
        q.addEdge(2,4,4);
        q.addEdge(3,4,4);
        q.addEdge(3,5,4);
        System.out.println(q.toString());
        //System.out.println(q.getEdges());
        q.DFS(0);
        q.BFS(0);
        System.out.println(q.Prim().toString());

    }
    public static void test3() {
        ArrayList<String> points = new ArrayList<>();
        points.add("A");
        points.add("B");
        points.add("C");
        points.add("D");
        points.add("E");
        points.add("F");
        MyGraph<String> q = new MyGraph<>(points, false);
        q.addEdge(0,1,45);
        q.addEdge(0,2,28);
        q.addEdge(0,3,10);
        q.addEdge(1,2,12);
        q.addEdge(1,4,21);
        q.addEdge(2,3,17);
        q.addEdge(2,4,26);
        q.addEdge(3,4,15);
        q.addEdge(3,5,13);
        q.addEdge(4,5,11);
        System.out.println(q.Prim().toString());
        //System.out.println(q.Prim().Prim().toString());


    }



    }
