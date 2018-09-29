package manipulacion;

import lejos.nxt.SensorPort;

public class movimientos {
	
	public static void main(String[] args)
	{
		SensorPort[] str = new SensorPort[] {SensorPort.S1, SensorPort.S2, SensorPort.S3, SensorPort.S4}; 
		Manipulacion brazo= new Manipulacion(str);
		Manipulacion.velocidad(500);
		
		do
		{
			Manipulacion.moverIndividual('A', 'F');
			
		}
		while(!brazo.botonEnterPresionado());
		
	}

}
