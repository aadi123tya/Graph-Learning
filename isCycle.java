import java.util.ArrayList;

public class isCycle {

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

    public static boolean isCycle(ArrayList<Edges> graph[],boolean visited[])
    {
        //simple apply dfs
        
        for(int i=0;i<graph.length;i++)
        {
            
            if(!visited[i])
            {
                if(isCycleUtil(graph,visited,i,-1))
                {
                  return true;  
                }

            }
        }
            return false;
    }
   

public static boolean isCycleUtil(ArrayList<Edges> graph[],boolean visited[],int curr,int par)
{

    // case 1
    visited[curr]=true;
    for(int i=0;i<graph.length;i++)
    {
        Edges e = graph[curr].get(i);
        // case 1
        if(!visited[e.dest] )
        {
            if(isCycleUtil(graph, visited, e.dest, curr))
        {
            return true;
        }
    }
        else if(visited[e.dest] && e.dest==par)
        {
            return true;
        }
        // case-3 nothing else
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
       System.out.println( isCycle(graph, visited));;
       
        
        
    }
}