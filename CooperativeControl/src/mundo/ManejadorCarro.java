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
		while(enSeguimiento.darPrimerNodo()!=null && carro.allowRun)
		{
			try {
				sleep(1000);
				carro.avanzarEnCamino();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}

}
