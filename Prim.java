/**
 *___________________________________________________________________________            	
 *               		Randomized Prim's algorithm
 * --------------------------------------------------------------------------
 *  This algorithm is a randomized version of Prim's algorithm.
 *  1. Start with a grid full of walls.
 *  2. Pick a cell, mark it as part of the maze. 
 *     Add the walls of the cell to the wall list.
 *  3. While there are walls in the list:
 *  	i) Pick a random wall from the list.
 *  	   If only one of the two cells that the wall divides is visited, then:
 *  		   a) Make the wall a passage and mark the unvisited cell 
 *  			  as part of the maze.
 *  		   b) Add the neighboring walls of the cell to the wall list.
 *  	ii) Remove the wall from the list.
 *   
 * ----------------------------------------------------------------------------  	      
 */



import java.util.LinkedList;


public class Prim {
	private static char start_sign='S';
	private static char end_sign='E';
	private static boolean[]of_the_maze;
	private static LinkedList<Vertex>Q=new LinkedList<Vertex>();
	private static int[][]graph;
	
	public static void set_signs(char start, char end) {
		start_sign=start;
		end_sign=end;
	}
	
	public static void primMaze(Graph G,int[][]_graph,char[][]maze) {

		int number_of_verticies= G.Adj.size();	
		/**
		 * 2. Pick a cell, mark it as part of the maze. 
		 *     Add the walls of the cell to the wall list.
		 */
		Vertex S= G.Adj.get(0).get(0);
		graph=_graph;
		of_the_maze= new boolean[number_of_verticies];
		//marks the source vertex as part of the maze
		of_the_maze[S.name]=true;
		Q=new LinkedList<Vertex>();
		//Adds all walls of S to the list
		for(Vertex v:G.Adj.get(S.name)) {
			if(v.name!=G.Adj.get(S.name).get(0).name)
				Q.add(v);
		}
		
		//3. While there are walls in the list:
		while(!Q.isEmpty()) {
			// i) Pick a random wall from the list.
			int num_of_walls=Q.size();
			int random = (int)(Math.random() * num_of_walls);
			Vertex u= Q.get(random);
			
			//If only one of the two cells that the wall divides is visited
			if(one_of_the_cells_is_visited(u)) {
				//a) Make the wall a passage
				of_the_maze[u.name]=true;
				int neighbor_index= get_neighbor(u);
				Vertex neighbor=G.Adj.get(neighbor_index).get(0);
				//mark the unvisited cell  as part of the maze.
				of_the_maze[neighbor_index]=true;
				of_the_maze[u.pre.name]=true;
				//b) Add the neighboring walls of the cell to the wall list.
				for(Vertex v:G.Adj.get(neighbor.name)) {
					if(v.name!=G.Adj.get(S.name).get(0).name
							&&
					  !of_the_maze[v.name]	)
						Q.add(v);
				}
				
			}
			//ii) Remove the wall from the list.
			Q.remove(random);
		}
		
		
		//to change the main maze
		//is not part of the original algorithm
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				if(i==0&&j==0)
					maze[i][j]=start_sign;
				else if(of_the_maze[graph[i][j]])
					maze[i][j]=' ';
			}
		}
		int end_point=graph[graph.length-1][graph[0].length-1];
		for (int i = of_the_maze.length-1; i > 0; --i) {
			if(of_the_maze[i]==true) {
				end_point=i;
				break;
			}
		}
		Vertex end= G.Adj.get(end_point).get(0);
		maze[end.i][end.j]=end_sign;	
		
	}
	
	private static int get_neighbor(Vertex v) {
		Vertex pre= v.pre;
		int _i;
		int _j;
		int neighbor=0;
		if(v.i==pre.i) {
			_i=v.i;
		}
		else
			_i=(v.i-pre.i)+v.i;
	if(v.j==pre.j) {
		_j=v.j;
	}
	else
		_j=(v.j-pre.j)+v.j;
	try {
		neighbor= graph[_i][_j];
	}
	catch (Exception e) {
		return -1;
	}
	return neighbor;
	}
	
	//checks if one of the cells that the wall blocks is already part of the maze
	private static boolean one_of_the_cells_is_visited(Vertex v) {
		Vertex pre= v.pre;
		int neighbor=get_neighbor(v);
		if(neighbor==-1)
			return false;
		if(of_the_maze[neighbor]&&!of_the_maze[pre.name]
				||
		  !of_the_maze[neighbor]&&of_the_maze[pre.name])
			return true;

		return false;
	}
	
}
