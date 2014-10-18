package mundo;

import java.util.ArrayList;

public class OptimizacionCaminos {
	
	private ArrayList<Camino[]> conjuntoCaminos; 
	private ArrayList<Camino> conjuntoCaminosOptimizados;
	private Carro[] carros;
	private double minCost;
	
	/**
	 * Cosntructor de la clase
	 * @param pCarros Carros con sus atributos en el momento de la craci�n del objeto
	 */
	public OptimizacionCaminos(Carro[] pCarros)
	{
		
		carros=pCarros;
		conjuntoCaminosOptimizados = new ArrayList<Camino>();
		conjuntoCaminos= new ArrayList<Camino[]>();
		for(int i=0;i<carros.length;i++)
		{
			conjuntoCaminos.add(carros[i].getPosiblesCaminos());
		}
		optimizarCaminos();
	}
	
	
	public ArrayList darConjuntoCaminosOptimizado()
	{
		return conjuntoCaminosOptimizados;
	}
	
	
	/**
	 * M�todo principal encargado de la optimizaci�n de los caminos escogidos para cada veh�culo. 
	 */
	private void optimizarCaminos()
	{
		ArrayList<Integer> disponibles = new ArrayList<Integer>(); //metas dis�nibles
		ArrayList<Integer> asignados = new ArrayList<Integer>();  //metas asignadas
	
		//Asignando camino a bodega para los autos cargados, se elimina el camino a bodega de todos los autos
		asignarABodega();
		
		//Valor base para la funci�n a optimizar
		minCost=0;	
		for(int i=0;i<conjuntoCaminos.size();i++)
		{
			minCost+=conjuntoCaminos.get(i)[i].getLongitudCamino();	
		}
		
		//Creando vector
		for(int i=0;i<conjuntoCaminos.get(0).length;i++)
		{
			disponibles.add(i);
		}
		
		//Hallando asignaci�n de caminos �ptima
		asignados = asignarCaminos(disponibles,asignados);
		
		//Asignando el camino escogido a cada veh�culo
		for(int i=0;i<asignados.size();i++)
		{
			if()conjuntoCaminosOptimizados.add(conjuntoCaminos.get(i)[asignados.get(i)]);
		}
		
				
	}
	
	/**
	 * M�todo que revisa si cada carro est� cargado. De estarlo, se le asigna camino a bodega. Adem�s se elimina el camino a bodega 
	 * de los caminos posibles a todos los autos
	 */
	public void asignarABodega()
	{		
		for(int i=0;i<carros.length;i++)
		{
			if(!carros[i].getCargado())
			{
				
				//Creando nievo Camini[] eliminando el camino a bodega (que est� en la �ltima posici�n)
				Camino[] nuevo = new Camino[conjuntoCaminos.get(0).length-1];
				for(int j=0;j<conjuntoCaminos.get(0).length-1;j++)
				{
					nuevo[j]=conjuntoCaminos.get(i)[j];
				}
				//Asignando el nuevo Camino[] al conjunto caminos
				conjuntoCaminos.add(i,nuevo);
				
			}
		}
		int eliminados=0;
		for(int i=0;i<carros.length;i++)
		{
			if(carros[i].getCargado())
			{
				conjuntoCaminosOptimizados.add(i,conjuntoCaminos.get(i)[5]);
				conjuntoCaminos.remove(i-eliminados);
				eliminados++;
			}
		}
		
		
	}
	
	
	private ArrayList<Integer> asignarCaminos(ArrayList<Integer> disponibles, ArrayList<Integer> asignados)
	{
		ArrayList<Integer> asignadosLocal;
		ArrayList<Integer> disponiblesLocal;
		
		
		if(asignados.size()==carros.length)
		{
			double costo=0;
			for(int i=0;i<asignados.size();i++)
			{
				costo+=conjuntoCaminos.get(i)[asignados.get(i)].getLongitudCamino();
			}
			if(costo<minCost)
			{
				minCost=costo;
			}	
		}
		else
		{
			for(int i=0;i<disponibles.size();i++)
			{
				asignadosLocal=asignados;
				disponiblesLocal=disponibles;
				
				asignadosLocal.add(disponiblesLocal.get(i));
				disponiblesLocal.remove(i);
				asignarCaminos(disponiblesLocal,asignadosLocal);
				
			}
		}
		
		return asignados;
	}
	
	
}
