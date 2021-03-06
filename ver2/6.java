class Atom {

//static block
	public final static int UP;
	public final static int DW;
	public final static int LT;
	public final static int RT;

	static {
		UP=0;
		DW=1;
		LT=2;
		RT=3;
	}

	public static final void opp(int CARD) {
		switch (CARD) {
			case UP: return DW; break;
			case DW: return UP; break;
			case LT: return RT; break;
			case RT: return LT; break;
		}
	}
//

	public Atom [] conn;
	public Flavor flavor;

	public Atom( Atom connUP,
				 Atom connDW,
				 Atom connLT,
				 Atom connRT,
				 Flavor flavor ) {
		this.conn=new Atom [] { connUP,
								connDW,
								connLT,
								connRT };

		this.flavor=flavor;
	}

	public void printA() {
		System.out.print( this.flavor + "\n" );

		for ( Atom a : conn[] ) {
			a.printA();
		}
	}
}