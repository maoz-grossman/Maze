//-------------------------------------------------------------//
//*************************************************************//
//                  Breadth-first search                       //   
//____________________________________________________________ //
// Breadth-first search (BFS) is an algorithm for traversing   //
// or searching tree or graph data structures.                 //
// It starts at the tree root (or some arbitrary node of       // 
// a graph, sometimes referred to as a 'search key'[1]),       //
// and explores all of the neighbor nodes at the present depth // 
// prior to moving on to the nodes at the next depth level.    //
//*************************************************************//
//-------------------------------------------------------------//




import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	final static public int infinity= Integer.MAX_VALUE;
	private String color[];
	private Vertex parent[];
	private int dist[];
	private Queue<Vertex>Q;
	private Vertex source;


	public BFS(Graph G,Vertex _s) {
		int n=G.Adj.size();
		color=new String[n];
		parent=new Vertex[n];
		dist=new int[n];
		for(int i=0;i<n;i++) {
			color[i]="WHIT";
			dist[i]=infinity;
			parent[i]=null;
		}
		Q= new LinkedList<Vertex>();
		source=_s;
		color[source.name]="GRAY";
		dist[source.name]=0;
		parent[source.name]=null;
		Q.add(source);
		initiate(G);
	}


	//-------------------//
	//   building tree   //
	//-------------------//

	private void initiate(Graph G) {
		while(!Q.isEmpty()) {
			Vertex u= Q.poll();
			for(Vertex v: G.Adj.get(u.name)) {//like Adj[u]
				if(color[v.name].equals("WHIT")) {
					color[v.name]="GRAY";
					dist[v.name]=dist[u.name]+1;
					parent[v.name]=u;
					Q.add(v);
				}
			}
			color[u.name]="BLACK";
		}

	}



	//---------------------------------------------//
	//  Get the shortest path to a specific vertex //
	//---------------------------------------------//


	public String Get_path(Vertex v,char[][]maze) {
		String path="";
		Vertex par=parent[v.name];
		if(par==null)return "No path from source to v";
		path+=par.name+"->"+v.name;
		maze[par.i][par.j]='.';
		while(source.name!=par.name) {
			par=parent[par.name];
			path=par.name+"->"+path;
			maze[par.i][par.j]='.';
		}
		return path;
	}



	/**
	 * The time complexity can be expressed as O(|V|+|E|),
	 *  since every vertex and every edge will be explored in the worst case.
	 *   |V| is the number of vertices and |E| is the number of edges in the graph. 
	 *   Note that O(|E|) may vary between O(1) and O(|V|^{2}), depending on how sparse the input graph is.
	 */

}
