public class MapGraph {

//
	public final static int DRONE;
	public final static int BLANK;
	public final static int OBSTL;
	public final static int SOLUT;

	static {
		DRONE=2;
		BLANK=0;
		OBSTL=1;
		SOLUT=3;
	}
//


	public Atom [][] map;

	public MapGraph(int h, int w) {
		map = new Atom[h][w];
		
		for (int i=0; i<h; i++)
			for (int j=0; j<w; j++)
				map[i][j]=new Atom( null,
									null,
									null,
									null,
									BLANK );

		gen();
	}

	public MapGraph(int [][] matrix) {	
		map = new Atom[ matrix.length ][ matrix[0].length ];

		for (int k=0; k<h; i++)
			for (int l=0; l<w; j++)
				map[k][l]=new Atom( null,
									null,
									null,
									null,
									BLANK );

		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				//if an unknown object is detected inside the matrix, it gets replaced with a OBSTL (1) in the graph matrix
				if ( matrix[i][j]<0 || matrix[i][j]>3 ) {
					matrix[i][j]=1; continue;
				}

				map[i][j].flavor=matrix[i][j];
			}
		} 
		
		gen();
	}

	//to print all the map call method gen()
	public void gen() {
		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map[0].length; j++) {
				if (i>0)
					map[i][j].conn[0]=map[i-1][j];

				if (j>0)
					map[i][j].conn[2]=map[i][j-1];

				if (i<map.length-1)
					map[i][j].conn[1]=map[i+1][j];

				if (j<map[0].length-1)
					map[i][j].conn[3]=map[i][j+1];

				print(i,j);
			}
			p();
		}
	}

	public void setSOLUT(int a, int b) {
		if ( a<map.length && b<map[0].length )
			map[a][b]=Backtrack.SOLUT;
	}

	public void setDRONE(int a, int b) {
		if ( a<map.length && b<map[0].length )
			map[a][b]=Backtrack.DRONE;
	}

    public void setOBSTL(int a, int b) {
		if ( a<map.length && b<map[0].length )
			map[a][b]=Backtrack.OBSTL;
	}

	public void setBLANK(int a, int b) {
		if ( a<map.length && b<map[0].length )
			map[a][b]=Backtrack.BLANK;
	}


/*
*   O↓→ ← O↓→ ← O↓→ ← O↓→ ← O↓→ ← O↓  
*  ↑O↓→ ←↑O↓→ ←↑O↓→ ←↑O↓→ ←↑D↓→ ←↑O↓  
*  ↑O↓→ ←↑O↓→ ←↑O↓→ ←↑O↓→ ←↑O↓→ ←↑O↓  
*  ↑O↓→ ←↑X↓→ ←↑X↓→ ←↑X↓→ ←↑O↓→ ←↑O↓  
*  ↑O↓→ ←↑O↓→ ←↑X↓→ ←↑X↓→ ←↑O↓→ ←↑O↓  
*  ↑O↓→ ←↑O↓→ ←↑O↓→ ←↑O↓→ ←↑O↓→ ←↑O↓  
*  ↑O → ←↑Ω → ←↑O → ←↑O → ←↑O → ←↑O   
*
* MapGraph concept
*
* Input matrix
* 000000
* 000020 
* 000000 
* 011100 
* 001100 
* 000000
* 030000
*/

	public void print(int a, int b) {
		if (map[a][b]==null) {
			p("  x  ");
			return;
		}

		if (map[a][b-1]!=null) p("←");
		else				   s();

		if (map[a-1][b]!=null) p("↑");
		else 				   s();

		switch (map[a][b].flavor) {
			case DRONE: p("D"); break;
			case BLANK: p("O"); break;
			case OBSTL: p("X"); break;
			case SOLUT: p("Ω"); break;
			case default: p("?"); break;
		}

		if (map[a+1][b]!=null) p("↓");
		else 				   s();

		if (map[a][b+1]!=null) p("→");
		else 				   s();

		s();
	}

	public int mol() 		{ return map.length*map[0].length; }

	public void p(String s) { System.out.print(s);    }
	public void s()			{ System.out.print(" ");  }
	public void p()			{ System.out.println(""); }
}