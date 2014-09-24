package mundo;

import java.util.ArrayList;
import java.util.Stack;

public class FindPath {

	private boolean[] marked;
	private int[] edgeTo;
	private final int source;

	public FindPath(Grafo g, int Source){
		source=Source;
		marked= new boolean[g.getV()];
		edgeTo= new int[g.getV()];
		bFs(g,source);

	}

	private void bFs(Grafo g, int s){
		ArrayList<Integer> cola= new ArrayList<Integer>();
		marked[s]= true;
		cola.add(s);
		while(cola.size()!=0){
			int saliente= cola.remove(0);

			for(int i : g.adj(saliente)){
				if(!marked[i]){
					edgeTo[i]=saliente;
					marked[i]=true;
					cola.add(i);
				}

			}
		}
	}
	
	public boolean hayCamino(int nodo){
		return marked[nodo];
	}
	
	public Iterable<Integer> caminoA(int nodo){
		Stack<Integer> camino= new Stack<Integer>();
		for(int i=nodo ; i!=source; i=edgeTo[i]){
			camino.push(i);
		}
		//camino.push(source);
		
		return camino;
	}
	

}
