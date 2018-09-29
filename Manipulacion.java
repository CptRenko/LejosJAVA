package manipulacion;

/**
 * Objetos estaticos:
 * - LCD
 * - Motor
 * - SensorPort
 * - Button
 * - Sound
 * - 
 * 
 */

/**
 * Documentación clase Manipulación.
 * 
 * Objetivo : Manipulación de robots de amenra estandarizada entre los miembros del CITT, intentando cubrir de forma 
 * sencilla y rapida la mayor parte de las funcionalidades de los robots NXT.
 * 
 * Para la utilización de esta clase, es importante aclarar un par de cosas:
 * - Los motores A,B,C tienen que ir necesariamente en los conectores A,B,C de la caja (tienen que coincidir).
 * - Para instanciar la clase, el orden de los sensores es el siguiente:
 *       - En puerto[0] (1) debe ir el sensor de Ultrasonido
 *       - En puerto[1] (2) debe ir el sensor de Sonido
 *       - En puerto[2] (3) debe ir el sensor Touch.
 *       - En puerto[3] (4) debe ir el sensor de Color.
 *       
 * 
 *  Lista de metodos y una pequeña descripción (un tanto mas de profunidad se especificara en cada metodo)
 *  
 *  static getSensorUltrasonido() -> Retorna los atributos/metodos para manipular el sensor de ultraSonido.
 *  static getSensorSonido() -> Retorna los atributos/metodos para manipular el sensor de Sonido
 *  static getSensorTouch() -> Retorna atributos/metodos para manipular el sensor touch.
 *  static getSensorColor() -> Retorna atributos/metodos para manipular el sensorColor.
 *  
 *  MOTOR:
 *  
 *  void mover -> Realizar movimiento unisono de los 3 motores
 *  void moverIndividual(char motor) -> Realizar movimiento de alguno de los 3 motores.
 *  void velocidad(int vel) -> Ajustar velocidad de los 3 motores.
 *  void velocidadIndividual(int vel, char motor) -> Ajustar velocidad de alguno de los 3 motores
 *  
 *  BOTONES:
 *  
 *  boolean botonEnterPresionado() -> Retornar si el boton central (anaranjado) es presionado (True/False)
 *  
 *  
 */

import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.nxt.Button;
import lejos.nxt.Sound;
import lejos.nxt.SoundSensor;
import lejos.nxt.TouchSensor;
import lejos.nxt.ColorSensor;
import lejos.nxt.LightSensor;

public class Manipulacion 
{
	private UltrasonicSensor sensorUltrasonido;
	private SoundSensor sensorSonido;
	private TouchSensor sensorTouch;
	private ColorSensor sensorColor;
	private LightSensor sensorLuz;
	
	
	
	/**
	 * 
	 * Constructor()
	 * Instanciar clases del Robot.
	 * 
	 * @param ultrasonicSensor : Puerto al que esta conectado el sensor ultrasonido (S1-S4)
	 * @param
	 */
	//String[] asdf = new String["puerto1", "puerto2", "puerto3", "puerto4"];
	
	//public Manipulacion(SensorPort ultrasonicSensor, SensorPort sensorSonido)
	public Manipulacion()
	{
		
	}
	
	public Manipulacion(SensorPort[] puerto)
	{
		setSensorUltrasonido(new UltrasonicSensor(puerto[0]));
		setSensorSonido(new SoundSensor(puerto[1]));
		setSensorTouch(new TouchSensor(puerto[2]));
		setSensorColor(new ColorSensor(puerto[3]));
	}
	
	/**
	 * getSensorUltrasonido()
	 *  Retorna clase del sensorUltrasonido para manipular el sensor de ultraSonido.
	 * 
	 * @return ultrasonicSensor sensorUltrasonido
	 */
	public UltrasonicSensor getSensorUltrasonido()
	{
		return sensorUltrasonido;
	}
	
	/**
	 * getSensorSonido
	 * Retorna clase del sensor de sonido para manipulacion.
	 * @return soundSensor sensorSonido
	 */
	public SoundSensor getSensorSonido()
	{
		return sensorSonido;
	}
	
	/**
	 * getSensorTouch()
	 * Retorna clase del sensorTouch para manipulación.
	 * @return TouchSensor sensorTouch
	 */
	public TouchSensor getSensorTouch()
	{
		return sensorTouch;
	}
	
	/**
	 * getSensorColor()
	 * Retorna clase del sensor de color para manipulación.
	 * @return ColorSensor sensorColor
	 */
	public ColorSensor getSensorColor()
	{
		return sensorColor;
	}
	
	private  void setSensorSonido(SoundSensor objSensorSonido)
	{
		this.sensorSonido = objSensorSonido;
	}
	
	private void setSensorUltrasonido(UltrasonicSensor objSensorUltrasonido)
	{
		this.sensorUltrasonido = objSensorUltrasonido;
	}
		
	private void setSensorTouch(TouchSensor objSensorTouch)
	{
		this.sensorTouch = objSensorTouch;
	}
	
	private void setSensorColor(ColorSensor objSensorColor)
	{
		this.sensorColor = objSensorColor;
	}
	
	/**
	 * Mover(char mov)
	 * Realizar movimiento (Adelante o hacia atras) de los 3 motores (A,B,C) al mismo tiempo.
	 * 
	 * LLAMAR A VELOCIDAD() PRIMERO.
	 * 
	 * @param char mov : Si el motor va hacia adelante o hacia atras (F (Forward) B (Backward))
	 * @return void
	 */
	public static void mover(char mov)
	{
		switch(mov)
		{
			case 'F':
				Motor.A.forward();
				Motor.B.forward();
				Motor.C.forward();
				break;
			case 'B':
				Motor.A.backward();
				Motor.B.backward();
				Motor.C.backward();
				break;
			default:
				break;
		}
	}
	
	/**
	 * MoverIndividual(char motor)
	 * Realizar movimiento de un motor en particular.
	 * NOTA: Antes de usar este metodo, es necesario o llamar a velocidad() o velocidadIndividual()
	 * de lo contrario, el motor NO SE MOVERA.
	 * @param motor Motor a ajustar (A, B o C)
	 * @param mov Si el motor va hacia adelante o hacia atras (F (Forward) B (Backward))
	 */
	public static void moverIndividual(char motor, char mov)
	{
		switch(motor)
		{
			case 'A':
				switch(mov)
				{
					case 'F':
						Motor.A.forward();
						break;
					case 'B':
						Motor.A.backward();
						break;
					default:
						break;
				}
				break;
				
			case 'B':
				switch(mov)
				{
					case 'F':
						Motor.B.forward();
						break;
					case 'B':
						Motor.B.backward();
						break;
					default:
						break;
				}
				break;
				
			case 'C':
				switch(mov)
				{
					case 'F':
						Motor.C.forward();
						break;
					case 'B':
						Motor.C.backward();
						break;
					default:
						break;
				}
				break;
			default:
				break;
		}
	}
	
	/**
	 * velocidad()
	 * 
	 * Ajustar 1 velocidad a los 3 motores. 
	 * 
	 * @param vel 
	 */
	public static void velocidad(int vel)
	{
		Motor.A.setSpeed(vel);
		Motor.B.setSpeed(vel);
		Motor.C.setSpeed(vel);
	}
	
	/**
	 * velocidadIndividual
	 * 
	 * Ajustar la velocidad de un motor en particular.
	 * 
	 * @param vel velocidad Deseada (maximo 700)
	 * @param motor motor a ajustar (A, B o C)
	 */
	public static void velocidadIndividual(int vel, char motor)
	{
		switch(motor)
		{
			case 'A':
				Motor.A.setSpeed(vel);
				break;
			case 'B':
				Motor.B.setSpeed(vel);
				break;
			case 'C':
				Motor.C.setSpeed(vel);
				break;
			default:
				break;
		}
		
	}
	
	/**
	 * Rotar
	 * 
	 * Ajustar angulo de rotación de un motor en particular.
	 * 
	 * @param char motor
	 */
	public static void rotarMotor(char motor, int angRotacion)
	{
		switch(motor)
		{
			case 'A':
				Motor.A.rotate(angRotacion);
				break;
			case 'B':
				Motor.A.rotate(angRotacion);
				break;
			case 'C':
				Motor.A.rotate(angRotacion);
				break;
			default:
				break;
		}
	}
	
	public static void matarMotor(char motor)
	{
		switch(motor)
		{
			case 'A':
				Motor.A.stop();
				break;
			
			case 'B':
				Motor.B.stop();
				break;
			
			case 'C':
				Motor.A.stop();
				break;
			
			default:
				break;
		}
		
	}
	
	public static void matarTodosMotores()
	{
		Motor.A.stop();
		Motor.B.stop();
		Motor.C.stop();
	}
	
	//lic static void 
	
	/**
	 * botonEnterPresionado()
	 * Retorna true si el boton ENTER es presionado.
	 *  
	 * @return Button.ENTER.isDown()
	 */
	public boolean botonEnterPresionado()
	{
		return Button.ENTER.isDown();
	}
	
	/**
	 * METODOS DEBUG
	 */
	public void printDistance()
	{
		LCD.drawInt(getSensorUltrasonido().getDistance(), 5, 5, 3);
	}
	
	
	

}
