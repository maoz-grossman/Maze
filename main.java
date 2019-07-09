
public class main {

	public static void main(String[] args) {
		char[][]maze= {{'#','S','#','#','#','#','#','#','#'},
				{'#',' ','#',' ','#',' ',' ',' ','#'},
				{'#',' ',' ',' ','#',' ','#',' ','#'},
				{'#','#','#',' ','#',' ','#',' ','#'},
				{'#',' ',' ',' ','#',' ','#',' ','#'},
				{'#',' ',' ',' ',' ',' ','#',' ','#'},
				{'#',' ',' ','#',' ','#',' ',' ','#'},
				{'#','#','#','#','#','#','E','#','#'}
		};
		Maze.printMaze(maze);


		int[][]mazename=Maze.Vertecies_name(maze);

		Graph g= new Graph(mazename);

		Vertex _s= Maze.get_start_point();
		BFS bfs=new BFS(g, _s);
		bfs.Get_path(Maze.get_end_point(),maze);
		System.out.println("\n---solution---\n");

		Maze.printMaze(maze);
	}


}
