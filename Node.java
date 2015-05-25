import java.util.ArrayList;
public class Node{
	public final ArrayList<Node> children;
	public final int data;
	public Node(int d){
		data = d;
		children = new ArrayList<Node>();
	}
}
