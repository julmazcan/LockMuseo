import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Museo {

		Lock exclusion;
		int ocupacion;
		Pantalla pantalla;
		
		public Museo ()
		{
			ocupacion=0;
			pantalla= Pantalla.getPantalla();
			exclusion = new ReentrantLock();
		}
		
		public void visitar()
		{
			exclusion.lock();
			try {
				ocupacion=ocupacion+1;
				System.out.println("Ha entrado un visitante");
			}
			finally {
				exclusion.lock();
			}
		}
		
		public void salir(){
			ocupacion=ocupacion-1;
			pantalla.escribir("Ha salido un visitante");
		}
}
