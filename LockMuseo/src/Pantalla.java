import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Pantalla {
	
	static Pantalla pantalla=new Pantalla();
	Lock exclusion;
	
	public static Pantalla getPantalla()
	{
		return pantalla;
	}
	public  Pantalla()
	{
		exclusion=new ReentrantLock();
	}
	
	public void escribir(String texto)
	{
		exclusion.lock();
		try {
			System.out.println(texto);
		}finally {
			exclusion.unlock();
		}
	}

}
