package suanfa.type13gtaph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @ClassName: Graph
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/29 14:45
 */
public class Graph {

    private ArrayList<String> vertexList;//存储顶点集合
    private int[][] edges;//存储图对应的邻接矩阵
    private int numOfEdges;//表示边的数目

    //定义一个数组boolean[], 记录某个系欸但是否被访问
    private boolean[] isVisited = new boolean[8];


    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
    }

    //插入节点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * //添加边
     *
     * @param v1     表示点的下标即 第几个顶点
     * @param v2
     * @param weight
     */
    public void     insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    //图中常用的方法
    //返回结点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //得到边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回结点i(下标)对应的数据0->"A" 1->"B" 2->"C"
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回v1和v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }
    public void showGraph(){
        for (int[] link : edges){
            System.err.println(Arrays.toString(link));
        }
    }
    //得到第一个邻接节点的下标 w
    public int getFirstNeighbor(int index){
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0){
                return i;
            }
        }
        return -1;
    }
    //根据上一个邻接节点获取下一个邻接节点
    public int getNextNeighbor(int v1 ,int v2){
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0){
                return i;
            }
        }
        return -1;
    }

    /**
     * 深度优先算法
     * @param isVisited
     * @param i
     */
    public void dfs(boolean[] isVisited,int i){
        //访问第一个节点
        System.out.print(getValueByIndex(i)+"->");
        isVisited[i] = true;
        //查找第一个邻接节点
        int w = getFirstNeighbor(i);
        //说明有
        while (w != -1) {
            if(!isVisited[w]){
                dfs(isVisited,w);
            }
            //已经被访问过
            w = getNextNeighbor(i,w);
        }
    }
    public void dfs(){
        for (int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    /**
     * 广度优先算法
     * @param isVisited
     * @param i
     */
    public void bfs(boolean[] isVisited,int i){
        int u; //表示队列的头节点对应的下标
        int w; //邻接节点w
        //队列
        LinkedList<Object> queue = new LinkedList<>();
        //访问节点
        System.out.print(getValueByIndex(i)+"->");
        //标记
        isVisited[i] = true;
        //将节点加入队列
        queue.addLast(i);
        //判断是否为空
        while (!queue.isEmpty()){
            //取出队列的头节点下标
            u = (Integer) queue.removeFirst();
            //得到第一个邻接节点的下标w
            w = getFirstNeighbor(u);
            while (w != -1){
                if (!isVisited[w]){
                    //打印
                    System.out.print(getValueByIndex(w)+"->");
                    //标记
                    isVisited[w] = true;
                    //入队
                    queue.addLast(w);
                }
                //u所在的行 w列
                //以U为前驱节点,找w后面的下一个邻接点
                w = getNextNeighbor(u,w);
            }
        }
    }
    public void bfs(){
        for (int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }

    public static void main(String[] args) {
        int n = 8;
        //String[] VertexVal = {"A", "B", "C", "D", "E"};
        String[] VertexVal = {"1", "2", "3", "4", "5","6","7","8"};

        Graph graph = new Graph(n);
        for (String val : VertexVal){
            graph.insertVertex(val);
        }
        //添加边
//        graph.insertEdge(0,1,1);
//        graph.insertEdge(0,2,1);
//        graph.insertEdge(1,2,1);
//        graph.insertEdge(1,3,1);
//        graph.insertEdge(1,4,1);

        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);

        graph.showGraph();
        //System.out.println("深度优先");
        //graph.dfs();
        System.out.println();
        System.out.println("广度优先");
        graph.bfs();
    }
}
