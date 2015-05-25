public class tree {
	Node root 
	public tree (){
		root = null;
	}
private int maxHeAUX(Node node){
	int max= 0;
	if(node != null)
		for(int i=0; i<node.childrnsize();i++)
			max = Math.max(mazHAUX(node.children.get(i))+1,);		
			return max;
		}
	public int maxHeight(){
		return maxHeAUX;
	}
}
