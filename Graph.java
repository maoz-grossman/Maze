
import java.util.LinkedList;
import java.util.Vector;


public class Graph {





	//-----------------//
	//  Graph methods  //
	//-----------------//

	// adjacent vertices list 
	public Vector<LinkedList<Vertex>> Adj;

	public Graph(int graph[][]) {
		Adj= new Vector<LinkedList<Vertex>>();
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; j++) {
				if(graph[i][j]>=0) {
					LinkedList<Vertex> list= new LinkedList<>();
					Vertex v= new Vertex(graph[i][j],i,j);
					list.add(v);
					getNeghibors(list, graph, i, j);
					Adj.add(list);
				}
			}

		}
	}

	private void getNeghibors(LinkedList<Vertex> list,int graph[][],int i,int j) {
		try {
			if(graph[i-1][j]>=0) {
				Vertex v= new Vertex(graph[i-1][j],i-1,j);
				list.add(v);
			}	

		}
		catch (Exception e) {
			
		}
		try {
			if(graph[i+1][j]>=0) {
				Vertex v= new Vertex(graph[i+1][j],i+1,j);
				list.add(v);
			}	
		}
		catch (Exception e) {
			
		}
		try {
			if(graph[i][j-1]>=0) {
				Vertex v= new Vertex(graph[i][j-1],i,j-1);
				list.add(v);
			}	
		}
		catch (Exception e) {
			
		}
		try {
			if(graph[i][j+1]>=0) {
				Vertex v= new Vertex(graph[i][j+1],i,j+1);
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
