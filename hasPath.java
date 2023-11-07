import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class hasPath {

    static class Edges
    {
        int beg;
        int dest;
        int wt;
    public Edges(int beg,int dest,int wt)
     {
        this.beg = beg;
        this.dest = dest;
        this.wt= wt;

     }
    }
    public static void createGraph(ArrayList<Edges> graph[])
    {
            graph[0].add(new Edges(0, 1, 1));      
            graph[0].add(new Edges(0, 2, 1));



            graph[1].add(new Edges(1, 0, 1));
            graph[1].add(new Edges(0, 3, 1));



        graph[2].add(new Edges(2, 0, 1));
         graph[2].add(new Edges(2, 4, 1));

                graph[3].add(new Edges(3, 1, 1));
               graph[3].add(new Edges(3, 4, 1));
                graph[3].add(new Edges(3, 5, 1));



                graph[4].add(new Edges(4, 2, 1));
                graph[4].add(new Edges(4, 3, 1));
                graph[4].add(new Edges(4, 5, 1));

                graph[5].add(new Edges(5, 3, 1));
                graph[5].add(new Edges(5,4, 1));
                graph[5].add(new Edges(5, 6, 1));

                graph[5].add(new Edges(6, 5, 1));

    }
   

  public static boolean hasPath(ArrayList<Edges> graph[],int src,int dest,boolean visited[])
  {

    if(src==dest)return true;
    visited[src]=true;
    for(int i=0;i<graph[src].size();i++)
    {
        if(!visited[graph[src].get(i).dest] && hasPath(graph, graph[src].get(i).dest, dest, visited))
        {
            return true;
        }
    }
    return false;

  }


    
    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edges> graph[]=  new ArrayList[v];
        for(int i=0;i<v;i++)
        {
            graph[i] = new ArrayList<>();
        }
        boolean visited[]=new boolean[v+1];
        createGraph(graph);
        // bfs(graph,v);
        // dfs(graph, 0, visited);
       System.out.println( hasPath(graph, 6, 88, visited));
       
        
        
    }
}