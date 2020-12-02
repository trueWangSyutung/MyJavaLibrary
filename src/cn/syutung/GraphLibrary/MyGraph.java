package cn.syutung.GraphLibrary;
import cn.syutung.ListLibrary.InitializationList;
import cn.syutung.ListLibrary.MyQueue;
import java.util.ArrayList;

public class MyGraph<T> implements Graph<T> {

    private static final int MAX_NUMBER = 0x0000fffff;
    private final boolean has_direction;
    ArrayList<T> points;
    int[][] matrix;
    EdgeList edges = new EdgeList();


    public MyGraph() {
        this.points = new ArrayList<>();
        matrix = new int[64][64];
        has_direction = false;
    }

    public MyGraph(ArrayList<T> a, boolean has_direction) {
        matrix = new int[a.size()][a.size()];
        this.points = a;
        this.has_direction = has_direction;
    }

    public MyGraph(ArrayList<T> a,EdgeList edges, boolean has_direction){
        this.edges= edges;
        this.has_direction = has_direction;
        EdgeList e = new EdgeList();
        this.points =a;
        matrix = new int[a.size()][a.size()];
        for (Edge edge : edges){
            matrix[edge.getFrom()][edge.getTo()] = edge.getWeight();
            matrix[edge.getTo()][edge.getFrom()] = edge.getWeight();
            e.add(new Edge(edge.getTo(), edge.getFrom(), edge.getWeight()));
        }
        this.edges.addAll(e);

    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    @Override
    public int getPointNumber() {
        return points.size();
    }

    @Override
    public T get(int i) {
        return points.get(i);
    }

    @Override
    public void set(int i, T x) {
        this.points.set(i, x);
    }

    @Override
    public void addPoint(T x) {
        points.add(x);

        if (points.size() > matrix.length) {
            int[][] bak = matrix;
            this.matrix = new int[points.size() * 2][points.size() * 2];
            for (int i = 0; i < points.size() - 1; i++) {
                System.arraycopy(bak[i], 0, matrix[i], 0, points.size() - 1);
            }

        }
    }

    @Override
    public void addEdge(int from, int to, int weight) {
        if (!has_direction) {
            matrix[to][from] = weight;
            edges.add(new Edge(to, from, weight));
        }
        matrix[from][to] = weight;
        edges.add(new Edge(from, to, weight));
    }

    @Override
    public void removePoint(int m) {
        this.points.remove(m);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == m - 1 && j == m - 1) {
                    matrix[i][j] = 0;
                }
                if (i > m - 1 && j > m - 1) {
                    matrix[i - 1][j - 1] = matrix[i][j];
                    matrix[i][j] = 0;
                } else if (i > m - 1 && j < m - 1) {
                    matrix[i - 1][j] = matrix[i][j];
                    matrix[i][j] = 0;
                } else if (i < m - 1 && j > m - 1) {
                    matrix[i][j - 1] = matrix[i][j];
                    matrix[i][j] = 0;
                } else if (i < m - 1 && j < m - 1) {
                    matrix[i][j] = matrix[i][j];
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    @Override
    public void removeEdge(int x, int y) {
        matrix[x][y] = 0;
        edges.remove(new Edge(x, y, matrix[x][y]));
    }

    @Override
    public InitializationList<Integer> searchAllKey(T key) {
        InitializationList<Integer> p = new InitializationList<>();
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i) == key) {
                p.add(i);
            }
        }
        return p;
    }

    @Override
    public int searchKey(T key) {
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i) == key) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void DFS(int i) {
        if (i < 0 || i > this.getPointNumber()) {
            return;
        }
        boolean[] visited = new boolean[this.getPointNumber()];
        int j = i;
        do {
            if (!visited[j]) {
                System.out.print("[");
                DFS(j, visited);
                System.out.print("]");
            }
            j = (j + 1) % (getPointNumber());
        } while (j != i);
        System.out.println();
    }

    public void DFS(int j, boolean[] visited) {
        System.out.print(points.get(j));
        visited[j] = true;
        for (int k = 0; k < points.size(); k++) {
            if (matrix[j][k] != 0 && !visited[k]) {
                System.out.print("->");
                DFS(k, visited);
            }
        }
    }


    @Override
    public void BFS(int i) {
        if (i < 0 || i > this.getPointNumber()) {
            return;
        }
        boolean[] visited = new boolean[getPointNumber()];
        int j = i;
        MyQueue<Integer> myStack = new MyQueue<>();
        do {
            if (!visited[j]) {
                BFS(j, visited, myStack);
            }
            j = (j + 1) % getPointNumber();
        } while (j != i);
        System.out.println();

    }

    private void BFS(int j, boolean[] visited, MyQueue<Integer> myStack) {
        System.out.print(points.get(j) + " ");
        visited[j] = true;
        myStack.enqueue(j);
        while (!myStack.isEmpty()) {
            j = myStack.dequeue();

            for (int k = 0; k < matrix.length; k++) {
                if (matrix[j][k] != 0) {
                    if (!visited[k]) {
                        System.out.print(points.get(k) + " ");
                        visited[k] = true;
                        myStack.enqueue(k);
                    }

                }
            }
        }
    }

    private int getAllWeight(){
        int i = 0;
        for (Edge edge:edges){
            i+=edge.getWeight();
        }
        return i/2;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("图：\n" +
                "顶点集合：" + points.toString() +
                '\n');
        for (int i = 0; i < points.size(); i++) {
            for (int j = 0; j < points.size(); j++) {
                s.append(matrix[i][j]).append(" ");
            }
            s.append("\n");
        }
        s.append("权值：").append(getAllWeight());
        return s.toString();
    }



    public MyGraph<T> Prim() {
            EdgeList edgeList = new EdgeList();
            ArrayList<Integer> edgesnum = new ArrayList<>();
            int begin=0,end=0,weight;
            int[] print = new int[getPointNumber()];
            boolean[] visited = new boolean[getPointNumber()];
            for (int i = 0; i < getPointNumber(); i++) {
                print[i] = 0;
            }
            visited[0] = true;
            edgesnum.add(0);
            while (edgeList.size() < getPointNumber() ) {
                EdgeList edges1 = new EdgeList();
                for (Integer row:edgesnum){
                    EdgeList bak = edges.findByFrom(row);
                    for (Edge edge:bak){
                        if (!visited[edge.getTo()]){
                            edges1.add(edge);
                        }
                    }

                }
                if (edges1.isEmpty()){
                    break;
                }
                edges1.sort();
                visited[edges1.get(0).getTo()] = true;

                edgeList.add(edges1.get(0));
                edgesnum.add(edges1.get(0).getTo());
            }
        return new MyGraph<>(points,edgeList,false);
    }

}