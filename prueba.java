package manipulacion;
import lejos.nxt.SensorPort;

public class prueba {
	
	public static void main(String[] args)
	{
		SensorPort[] sensor=new SensorPort[] {SensorPort.S1,SensorPort.S2,SensorPort.S3,SensorPort.S4};
		Manipulacion prueba = new Manipulacion (sensor);
		Manipulacion.velocidad(100);
	    for (int i = 0; i < 5; i++) {
		do 
		{
			Manipulacion.mover('F');
			Manipulacion.moverIndividual('A', 'B');
		}
		while(prueba.getSensorUltrasonido().getDistance() > 35);
	   }	
	}
}
