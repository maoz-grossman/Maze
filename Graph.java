
import java.util.LinkedList;
import java.util.Vector;


public class Graph {





	//-----------------//
	//  Graph methods  //
	//-----------------//

	// adjacent vertices list 
	public Vector<LinkedList<Vertex>> Adj;

	public Graph(int graph[][],int scip) {
		Adj= new Vector<LinkedList<Vertex>>();
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; j++) {
				if(graph[i][j]>=0) {
					LinkedList<Vertex> list= new LinkedList<>();
					Vertex v= new Vertex(graph[i][j],i,j);
					list.add(v);
					getNeighbors(list, graph,v, i, j,scip);
					Adj.add(list);
				}
			}

		}
	}
	
	
	private void getNeighbors(LinkedList<Vertex> list,int graph[][],Vertex pre,int i,int j,int skip) {
		try {
			if(graph[i-skip][j]>=0) {
				Vertex v= new Vertex(graph[i-skip][j],i-skip,j);
				v.pre=pre;
				list.add(v);
			}	

		}
		catch (Exception e) {
			
		}
		try {
			if(graph[i+skip][j]>=0) {
				Vertex v= new Vertex(graph[i+skip][j],i+skip,j);
				v.pre=pre;
				list.add(v);
			}	
		}
		catch (Exception e) {
			
		}
		try {
			if(graph[i][j-skip]>=0) {
				Vertex v= new Vertex(graph[i][j-skip],i,j-skip);
				v.pre=pre;
				list.add(v);
			}	
		}
		catch (Exception e) {
			
		}
		try {
			if(graph[i][j+skip]>=0) {
				Vertex v= new Vertex(graph[i][j+skip],i,j+skip);
				v.pre=pre;
				list.add(v);
			}	
		}
		catch (Exception e) {
			
		}

	}




	public String toString() {
		String s="";
		for(LinkedList<Vertex>list:Adj) {
			for(Vertex v:list) {
				s+=v.name+"-> ";
			}
			s+="\n";
		}
		return s;
	}


}
