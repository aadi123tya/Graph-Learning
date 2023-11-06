import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfs {

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
    public static void bfs(ArrayList<Edges> graph[],int v)
    {
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[v];
        q.add(0);
        while(!q.isEmpty())
        {
            int curr = q.remove();
            if(!visited[curr])
            {
                System.out.println(curr);
                q.add(curr);
                visited[curr]  =true;
                for(int i=0;i<graph[curr].size();i++)
                {
                    // System.out.print(graph[curr].get(i).dest + " ");
                    q.add(graph[curr].get(i).dest);
                }
            }
        }

    }
    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edges> graph[]=  new ArrayList[v];
        for(int i=0;i<v;i++)
        {
            graph[i] = new ArrayList<>();
        }
        createGraph(graph);
        bfs(graph,v);
        
        
    }
}