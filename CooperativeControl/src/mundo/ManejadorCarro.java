package mundo;

public class ManejadorCarro extends Thread{
	
	private Carro carro;
	private int movingTime;
	private int harvestTime;
	
	
	public ManejadorCarro(Carro c, int mT , int hT)
	{
		carro=c;
		movingTime=mT;
		harvestTime=hT;
		run();
		
	}
	
	@Override
	public void run() 
	{
		Camino enSeguimiento=carro.getCaminoEnSeguimiento() ;
		Nodo n = enSeguimiento.darPrimerNodo() ;
		while(n!=null && carro.allowRun)
		{
			long i;
			for( i =0; i<100000*movingTime;i++){
				
			}
			carro.avanzarEnCamino();
			n= enSeguimiento.darPrimerNodo();
		}
		
	}

}
