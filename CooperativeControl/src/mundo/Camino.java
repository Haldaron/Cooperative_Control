package mundo;

import java.util.ArrayList;

public class Camino {

	ArrayList<Nodo> secuencia;
	double longitudCamino;
	int codigo;
	Carro carro;
	Nodo destino;

	public Camino (int cod){
		secuencia= new ArrayList<Nodo>();
		longitudCamino=-1;
		codigo=cod;
		carro=null;
		destino=null;
	}
	

	public void anadirNodoAlfinal(Nodo n){
		secuencia.add(n);
		verificarInvariante();
		recalcularDistancia();
	}
	
	public void anadirNodoAlInicio(Nodo n){
		secuencia.add(0,n);;
		verificarInvariante();
		recalcularDistancia();
	}
	
	

	public Nodo eliminarPrimerNodoSecuencia(){
		Nodo rta=null;
		if(secuencia.size()>0){
		rta=secuencia.remove(0);
		verificarInvariante();
		recalcularDistancia();
		}
		return rta;
		
	}
	
	public Nodo darPrimerNodo(){
		Nodo rta= null;
		if(secuencia.size()>0){
			rta=secuencia.get(0);
		}
		return rta;
	}

	private void recalcularDistancia() {
		double dist=0;
		if(secuencia.size()!=0)
		{
			if(carro!=null){
				Nodo primer= darPrimerNodo();
				if(primer!=null)
				{
					if(primer.getPosX()==carro.getPosX() || carro.getPosY()==primer.getPosY())
					{
						dist++;
					}else{
						dist+=Math.sqrt(2);
					}
				}
				else
				{
					System.out.println("El primer nodo del camino con cod "+codigo+" es nulo");
				}
				
			}
			
			if(secuencia.size()!=1){
				for(int i=1; i<secuencia.size();i++){
					if(secuencia.get(i).getPosX()==secuencia.get(i-1).getPosX() 
							|| secuencia.get(i).getPosY()==secuencia.get(i-1).getPosY() ){
						dist+=1;
					}else{
						dist+=Math.sqrt(2);
					}
				}
			}
			longitudCamino=dist;
		}else{
			longitudCamino=0;
		}

	}
	
	public Nodo darSiguiente(){
		if(secuencia.size()>0){
			return secuencia.get(0);
		}else{
			return null;
		}
		
	}



	//Getters and Setters

	public ArrayList<Nodo> getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(ArrayList<Nodo> secuencia) {
		this.secuencia = secuencia;
	}

	public double getLongitudCamino() {
		return longitudCamino;
	}

	public void setLongitudCamino(double longitudCamino) {
		this.longitudCamino = longitudCamino;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public void setCarro(Carro c) {
		this.carro = c;
	}
	
	public Huerto getDestino()
	{
		return(Huerto)secuencia.get(secuencia.size()-1).getHuerto();
		
	}


	//Verificación de Invariante

	private void verificarInvariante(){
		int resultNodosContiguos=secuenciaDeNodosContiguos();
		assert (resultNodosContiguos==-1):"Los vecinos del nodo en la posicion "+resultNodosContiguos+" no son contiguos al mismo.";
	}

	private int secuenciaDeNodosContiguos(){
		int rta=-1;

		if(secuencia.size()>1){

			for(int i =1; i<secuencia.size();i++){
				if(secuencia.get(i).getPosX()!=secuencia.get(i-1).getPosX() 
						||secuencia.get(i).getPosY()!=secuencia.get(i-1).getPosY() ){
					rta=i;
					i=secuencia.size();
				}
			}

		}
		return rta;

	}


	public void finish(Carro c) {
		setCarro(c);
		destino=secuencia.get(secuencia.size()-1);
		recalcularDistancia();		
	}

}
