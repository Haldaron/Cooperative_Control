package mundo;

public class ManejadorCarro extends Thread{

	private Carro carro;
	private int movingTime;
	private int harvestTime;
	private int waitingTime;
	private boolean runningThread;


	public ManejadorCarro(Carro c, int mT , int hT, int wT)
	{
		carro=c;
		movingTime=mT;
		harvestTime=hT;
		waitingTime=wT;
		runningThread=true;

	}

	@Override
	public void run() 
	{
		while(runningThread){
		movimiento();
		}
	}

	public void movimiento(){
		while(carro.getCaminoEnSeguimiento().darPrimerNodo()!=null)
		{
			carro.evaluarSiguienteMovimiento();

			if(carro.allowRun){
				try {
					sleep(movingTime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				carro.avanzarEnCamino();
			}
			else
			{
				try {
					sleep(waitingTime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

		recolección();
	}

	private void recolección() {
		while(!carro.getCargado())
		{

			if(carro.evaluarRecoleccion()){

				try {
					sleep(harvestTime);

				} 
				catch (InterruptedException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}else{
				
			}

		}
	}

}
