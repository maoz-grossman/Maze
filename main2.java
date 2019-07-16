
public class main2 {

	public static void main(String[] args) {
		char Block='■';
		char Start='S';
		char End='E';
	char[][]maze= {{Block,Block,Block,Block,Block,Block,Block,Block,Block,Start,Block,Block,Block},
			       {Block,' ',Block,' ',' ',' ',Block,' ',' ',' ',' ',' ',Block},
				   {Block,' ',' ',' ',Block,Block,Block,' ',Block,Block,Block,' ',Block},
			       {Block,Block,Block,' ',Block,' ',Block,' ',Block,' ',Block,' ',Block},
			       {Block,' ',Block,' ',Block,' ',' ',' ',' ',' ',Block,' ',Block},
			       {Block,' ',Block,' ',Block,Block,Block,Block,Block,' ',Block,Block,Block},
			       {Block,' ',' ',Block,' ',Block,' ',' ',' ',' ',' ',' ',Block},
			       {Block,Block,' ',' ',' ',' ',Block,' ',Block,' ',Block,Block,Block},
			       {Block,Block,Block,Block,Block,' ',Block,' ',Block,' ',' ',' ',Block},
			       {Block,Block,' ',' ',' ',' ',' ',' ',Block,Block,Block,' ',Block},
			       {Block,' ',' ',Block,Block,' ',' ',Block,Block,' ',Block,' ',Block},
			       {Block,' ',' ',Block,' ',' ',' ',' ',Block,' ',' ',' ',Block},
			       {Block,Block,End,Block,Block,Block,Block,Block,Block,Block,Block,Block,Block}
			       };
	Maze.printMaze(maze);
	

	int[][]mazename=Maze.Vertecies_name(maze,Start,End,Block);

	Graph g= new Graph(mazename,1);

	Vertex _s= Maze.get_start_point();
	BFS bfs=new BFS(g, _s);
	 bfs.Get_path(Maze.get_end_point(),maze);
	System.out.println("\n---solution---\n");

	Maze.printMaze(maze);

	}

}
