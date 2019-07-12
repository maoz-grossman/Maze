import java.util.LinkedList;
import java.util.Queue;

public class Prim {

	public static void primMaze(Graph G,char[][]maze) {
		int number_of_verticies= G.Adj.size();
		Vertex S= G.Adj.get(0).get(0);
		boolean[]of_the_maze= new boolean[number_of_verticies];
		of_the_maze[S.name]=true;
		Queue<Vertex>Q=new LinkedList<Vertex>();
		//Adds all neighbors of S to the queue
		for(Vertex v:G.Adj.get(S.name)) {
			if(v!=G.Adj.get(S.name).get(0))
				Q.add(v);
		}
		
		while(!Q.isEmpty()) {
			Vertex u= Q.poll();
			int num_of_neighbors=G.Adj.get(u.name).size()-1;
			int random = (int)(Math.random() * num_of_neighbors + 1);
			Vertex v=G.Adj.get(u.name).get(random);
			//checks if the wall separates between two cells that one is of the maze  
			if(of_the_maze[u.name]&&!of_the_maze[v.name]||!of_the_maze[u.name]&&of_the_maze[v.name]) {
				of_the_maze[u.name]=true;
				of_the_maze[v.name]=true;
				//Adds the neighbors that are not part of the maze yet
				for(Vertex ver:G.Adj.get(S.name)) {
					if(ver!=G.Adj.get(u.name).get(0))
						Q.add(ver);
				}
				
			}
		}
		
		for (int i = 0; i < of_the_maze.length; i++) {
			Vertex v=G.Adj.get(i).get(0);
			if(of_the_maze[v.name])
				maze[v.i][v.j]=' ';
				
		}
		
		
	}
}
