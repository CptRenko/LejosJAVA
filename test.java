package manipulacion;

import lejos.nxt.SensorPort;
//import lejos.nxt.LCD;

public class test {
	
	public static void main(String[] args)
	{
		SensorPort[] s = new SensorPort[] {SensorPort.S1, SensorPort.S2, SensorPort.S3, SensorPort.S4};
		Manipulacion mp = new Manipulacion(s);
		
		//Manipulacion.velocidadIndividual(800, 'C');
		Manipulacion.velocidad(500);
		
		int distance = 30;
				
		while(!mp.botonEnterPresionado() && distance >= 30)
		{
			//try { Thread.sleep(250); } catch(InterruptedException ex) {}
			distance = mp.getSensorUltrasonido().getDistance();
			try { Thread.sleep(250); } catch(InterruptedException ex) {}
			//Thread.sleep(300);
			Manipulacion.moverIndividual('C', 'F');
			Manipulacion.moverIndividual('B', 'F');
			//Manipulacion.mover('F');
			//Manipulacion.moverIndividual('C', 'F');
			//Manipulacion.moverIndividual('B', 'F');
			//LCD.drawString( String.valueOf(mp.getSensorUltrasonido().getDistance()), 2, 4);
			mp.printDistance();
			Manipulacion.rotarMotor('A', 150);
		}
	}

}
