package mundo;

import java.util.ArrayList;

public class Grafo {

	public int V;
	public int E;
	public ArrayList<Integer>[] adjuntos;  
	private Nodo[][] malla;


	/**
	 * Crea un grafo de listas de adyacencia a partir de una matriz cuadrada que entra por parámetro.
	 * @param malla
	 */

	public Grafo (Nodo[][] grid){

		malla=grid;
		int N=malla[0].length;
		V=(int)Math.pow(N, 2);
		adjuntos= new ArrayList[V];

		int i,j,k,l,m;
		Nodo n;
		for (k = 0; k < V; k++) 
		{
			adjuntos[k] = new ArrayList<Integer>();
			j=k%N;
			i=(k-j)/N;
			for(l=i-1;l<=i+1;l++)
			{
				for(m=j-1;m<=j+1;m++)
				{
					if(m!=j || l!=i)
					{
						try
						{
							n=malla[l][m];
							adjuntos[k].add(l*N+m);
						}
						catch(IndexOutOfBoundsException e)
						{

						}
					}
				}
			}
		}

		verificarInvariante();

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


	public ArrayList<Integer>[] getAdjuntos() {
		return adjuntos;
	}


	public void setAdjuntos(ArrayList<Integer>[] adjuntos) {
		this.adjuntos = adjuntos;
	}



	private void verificarInvariante() {
		int i,x1,y1,x2,y2 ;
		ArrayList<Integer> actual;
		Nodo nodoAEvaluar;
		Nodo posibleAdyacente;
		int N=(int) Math.sqrt(V);
		for(i = 0; i< V; i++){
			actual=adj(i);
			x1=i%N;
			y1=(i-x1)/N;
			nodoAEvaluar=malla[y1][x1];
			for (Integer j : actual) 
			{
				x2=j%N;
				y2=(j-x2)/N;
				posibleAdyacente=malla[y2][x2];
				if(!nodoAEvaluar.esAdyacenteA(posibleAdyacente)){
					System.err.println("Error en posición "+i+" de lista.");
				}
			}
		}
	}


}
