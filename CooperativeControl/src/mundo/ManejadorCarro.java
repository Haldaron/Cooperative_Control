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
			recoleccion();
			runningThread=false;


		}
	}



	public void movimiento(){
		while(carro.getCaminoEnSeguimiento().darPrimerNodo()!=null)
		{
			if(carro.evaluarSiguienteMovimiento()){
				try {
					sleep(movingTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				carro.avanzarEnCamino();
			}
			else
			{
				try {
					sleep(waitingTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}

	}

	private void recoleccion() {
		int estado;
		boolean cont=carro.evaluarActHuerto();
		while(!carro.getCargado() && cont)
		{
			estado=carro.evaluarRecoleccion();

			if(estado==Huerto.DISPONIBLE){
				carro.recolectar();
				
				try {
					sleep(harvestTime);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
				
			}
			else if(estado==Huerto.EN_RECOLECCION){
				try {
					sleep(waitingTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else if(estado==Huerto.VACIO){
				//TODO: Diseñar el accionar a seguir cuando el huerto se encuentra vacio.
				cont=false;
				runningThread=false;
			}
			else if(estado==Huerto.ERROR)
			{
				cont=false;
				runningThread=false;
			}

		}

	}

}
