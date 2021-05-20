package threads;

import model.Flag;

public class ThreadFlag extends Thread{
	
	public final static String ESC   = "\u001b[";
	public final static String DOWN  = ESC+"B";
	public final static String RIGHT = ESC+"C";
	public final static String LEFT  = ESC+"D";
	
	Flag flag;
	String color;
	int filaStart;
	int columnaStart;
	int height;
	
	public ThreadFlag(Flag flag, String color, int filaStart, int height) {
		this.flag=flag;
		this.color=color;
		this.filaStart=filaStart;
		columnaStart=0;
		this.height=height;
	}
	
	public void run() {
		
		int width=0;
		int maxWidth=50;
		int filaActual=filaStart;
		int columnaActual=columnaStart;
		
		while(width<maxWidth) {
			width++;//SE AUMENTA EL ANCHO DE LA FRANJA
			filaActual=filaStart;//SIEMPRE CUANDO TERMINA DE LLENAR LAS 3 FILAS, LA FILA DONDE EMPIEZA LA SIGUIENTE ES LA FILA START
			
			//LLENAR 3 FILAS HACIA ABAJO
			for (int i = 0; i < height; i++) {
				System.out.print(ESC+columnaActual+"G"+ESC+filaActual+"d"+color+" ");
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				filaActual=filaActual+1;
			}
			
			//COMO YA SE LLENARON LAS HEIGHT FILAS ENTONCES SE CAMBIA DE COLUMNA A LA SIGUIENTE
			columnaActual=columnaActual+1;
		}
	}
}
