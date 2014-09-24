package mundo;

import java.util.ArrayList;

public class OptimizacionCaminos {
	
	private Camino[] carro0;
	private Camino[] carro1;
	private Camino[] carro2;
	
	private Integer[] indexHuertosFinales;
	
	
	
	public OptimizacionCaminos(Camino[] caminosCarro0,Camino[] caminosCarro1,Camino[] caminosCarro2)
	{
		carro0=caminosCarro0;
		carro1=caminosCarro1;
		carro2=caminosCarro2;
		
		optimizarCaminos();
		
	}
	
	public Integer[] getIndexHuertosFinales()
	{
		return indexHuertosFinales;
	}
	
	
	private void optimizarCaminos()
	{
		double minCost=carro0[0].getLongitudCamino()+carro1[1].getLongitudCamino()+carro2[2].getLongitudCamino();
		ArrayList<Integer> index= new ArrayList<Integer>();
		Integer[] indexMejorSet= new Integer[3];
		Integer[] indexParciales= new Integer[3];
		
		
		  
		for(int i=0; i<3;i++)
		{
			index.add(0);
			index.add(1);
			index.add(2);

			indexParciales[0]=i;
			index.remove(i);
			
			for(int j=0;j<2;i++)
			{
				indexParciales[1]=j;
				index.remove(j);
				indexParciales[2]=index.get(0);
				
				double costoParcial=calcularCostoCaminos(indexParciales);
				
				if(costoParcial<minCost)
				{
					minCost=costoParcial;
					indexMejorSet=indexParciales;
				}
			}
		}
		indexHuertosFinales=indexMejorSet;
	}
	public double calcularCostoCaminos(Integer[] index)
	{
		return carro0[index[0]].getLongitudCamino()+carro1[index[1]].getLongitudCamino()+carro1[index[2]].getLongitudCamino();
	}

		
}
