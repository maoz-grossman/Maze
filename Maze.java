

public class Maze {
	static char start_sign;
	static char end_sign;
	static char block_sign;
	private static Vertex start;
	private static Vertex end;


	public static int[][] Vertecies_name(char[][]mazeMatrix, char start_char,char end_char,char block_char){
		block_sign=block_char;
		start_sign=start_char;
		end_sign=end_char;
		int raw= mazeMatrix.length;
		int col= mazeMatrix[0].length;
		int[][]NameOfvertex= new int[raw][col];
		int index=0;
		for(int i=0;i<raw;++i)
			for(int j=0;j<col;j++) {
				if(mazeMatrix[i][j]!=block_sign) 
					NameOfvertex[i][j]=index++;
				else
					NameOfvertex[i][j]=-1;
				if(mazeMatrix[i][j]==start_sign) 
					start= new Vertex(NameOfvertex[i][j], i, j);
				if(mazeMatrix[i][j]==end_sign) 
					end= new Vertex(NameOfvertex[i][j], i, j);

			}
		return NameOfvertex;
	}
	
	public static char[][] get_random_maze(int hight,int width,char block){
		block_sign=block;
		char[][]maze=new char[hight][width];
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				maze[i][j]=block_sign;
			}
		}
		
		int[][] graph=new int[hight][width];
		int index=0;
		
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; j++) {
				graph[i][j]=index++;
			}
		}
		Graph G =new Graph(graph);
		Prim.primMaze(G, maze);
		return maze;
		
	}
	
	
	public static Vertex get_start_point() {
		return start;
	}

	public static Vertex get_end_point() {
		return end;
	}
	
	public static void printMaze(char[][]maze) {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				if(maze[i][j]==' ')
					System.out.print("  ");
				else
					System.out.print(maze[i][j]+" ");
			}
			System.out.println();
		}
	}


}
