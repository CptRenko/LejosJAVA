package manipulacion;

import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;

public class laberinto {
	
	public static void main(String[] args)
	{
		SensorPort[] str = new SensorPort[] {SensorPort.S1, SensorPort.S2, SensorPort.S3, SensorPort.S4};
		Manipulacion robot = new Manipulacion(str);
		
		
		Manipulacion.velocidad(500);
		
		Sound.setVolume(200);
		boolean continuar = false;
		int contador = 0;
		
		do
		{
			robot.printDistance();
			if(contador <= 15000)
			{
				while(contador <= 15000 && !robot.botonEnterPresionado())
				{
					LCD.drawInt(contador, 7, 5, 3);
					if(robot.getSensorUltrasonido().getDistance() <= 35)
					{
						Sound.beepSequence();//Sound.beep();
						Manipulacion.matarMotor('B');
						Manipulacion.rotarMotor('C', 45);
						continuar = true;
						
					}
					else
					{
						Manipulacion.moverIndividual('B','F');
						Manipulacion.moverIndividual('C', 'F');
						continuar = true;
						
					}
					
					if(continuar)
					{
						contador++;
					}
				}
				
			}
			else
			{
					Manipulacion.matarTodosMotores();
			}
		}
		while(!robot.botonEnterPresionado());
	}

}