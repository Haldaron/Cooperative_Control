package mundo;

import java.util.ArrayList;

public class OptimizacionCaminos {
	
private ArrayList<Camino[]> conjuntoCaminos; 
	
	private Integer[] indexHuertosFinales;
	private Carro[] carros;
	
	
	public OptimizacionCaminos(ArrayList pConjuntoCaminos, Carro[] pCarros)
	{
		
		carros=pCarros;
		conjuntoCaminos= pConjuntoCaminos;
		optimizarCaminos();
	}
	
	public Integer[] getIndexHuertosFinales()
	{
		return indexHuertosFinales;
	}
	
	private void optimizarCaminos()
	{
		ArrayList<Camino[]> conjuntoCaminosOptimizado=new ArrayList();
	
		for(int i=0;i<carros.length;i++)
		{
			carros[i].darCargado;
			
		}
		double minCost=0;
		for(int i=0;i<conjuntoCaminos.size();i++)
		{
			minCost+=conjuntoCaminos.get(i)[i].getLongitudCamino();
			
		}
	}
	
//	
//	private void optimizarCaminos()
//	{
//		double minCost=carro0[0].getLongitudCamino()+carro1[1].getLongitudCamino()+carro2[2].getLongitudCamino();
//		ArrayList<Integer> index= new ArrayList<Integer>();
//		Integer[] indexMejorSet= new Integer[3];
//		Integer[] indexParciales= new Integer[3];
//		
//		
//		  
//		for(int i=0; i<3;i++)
//		{
//			index.add(0);
//			index.add(1);
//			index.add(2);
//
//			indexParciales[0]=i;
//			index.remove(i);
//			
//			for(int j=0;j<2;i++)
//			{
//				indexParciales[1]=j;
//				index.remove(j);
//				indexParciales[2]=index.get(0);
//				
//				double costoParcial=calcularCostoCaminos(indexParciales);
//				
//				if(costoParcial<minCost)
//				{
//					minCost=costoParcial;
//					indexMejorSet=indexParciales;
//				}
//			}
//		}
//		indexHuertosFinales=indexMejorSet;
//	}
//	public double calcularCostoCaminos(Integer[] index)
//	{
//		return carro0[index[0]].getLongitudCamino()+carro1[index[1]].getLongitudCamino()+carro1[index[2]].getLongitudCamino();
//	}
//
//		
}
