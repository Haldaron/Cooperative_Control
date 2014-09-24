package mundo;

import java.util.ArrayList;

public class Grafo {
	
	public int V;
	public int E;
	public ArrayList[] adjuntos;  
	private Nodo[][] malla;
	
	
	/**
	 * Crea un grafo de listas de adyacencia a partir de una matriz cuadrada que entra por parámetro.
	 * @param malla
	 */
	
	public Grafo (Nodo[][] grid){
		
		malla=grid;
		int N=malla[0].length;
		V=(int)Math.pow(malla[0].length, 2);
		adjuntos= new ArrayList[V];
		
		
		
		  for (int i = 0; i < V; i++) {
	            adjuntos[i] = new ArrayList<Integer>();
	        }
		
		for(int i=0 ; i<malla[0].length ; i++){
			for(int j=0; j<malla[0].length;j++){
				ArrayList adjAct= adjuntos[N*i+j];
				boolean ir1=i-1>=0;
				boolean is1=i+1<N-1;
				boolean jr1=j-1>=0;
				boolean js1=j+1<N-1;
				
				if(ir1){
					if(jr1){
						adjAct.add(N*(i-1)+j-1);
						E++;
					}
					
					adjAct.add(N*(i-1)+j);
					E++;
					
					if(js1){
						adjAct.add(N*(i-1)+j+1);
						E++;
					}
				}
				if(js1){
					adjAct.add(N*i+j+1);
					E++;
					if(i+1<N-1){
						adjAct.add(N*(i+1)+j+1);
						E++;
					}
				}
				
				if(is1){
					
					adjAct.add(N*(i+1)+j);
					E++;
					if(jr1){
						adjAct.add(N*(i+1)+j-1);
						E++;
					}
				}
				
				if(jr1){
					adjAct.add(N*(i)+j-1);
					E++;
				}
				
			}
			
		}
	}


	
	public ArrayList<Integer> adj(int v){
		if(v<0||v>=V) throw new IndexOutOfBoundsException();
		return adjuntos[v];
		
	}
	
	public int getV() {
		return V;
	}


	public void setV(int v) {
		V = v;
	}


	public int getE() {
		return E;
	}


	public void setE(int e) {
		E = e;
	}


	public ArrayList[] getAdjuntos() {
		return adjuntos;
	}


	public void setAdjuntos(ArrayList[] adjuntos) {
		this.adjuntos = adjuntos;
	}
	
	
	

}
