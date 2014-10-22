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




}
