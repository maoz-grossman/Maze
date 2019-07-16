
public class main {

	public static void main(String[] args) {
		
		char [][]maze= Maze.get_random_maze(21, 30,'S','E','■');
		Maze.printMaze(maze);
		int[][]mazename=Maze.Vertecies_name(maze,'S','E','■');
		Graph g= new Graph(mazename,1);

		Vertex _s= Maze.get_start_point();
		BFS bfs=new BFS(g, _s);
		 bfs.Get_path(Maze.get_end_point(),maze);
		System.out.println("\n\t\t---solution---\n");

		Maze.printMaze(maze);

	}


}



