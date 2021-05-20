package model;

import threads.ThreadFlag;

public class Flag {
	public static final String ANSI_RESET = "\u001B[0m";
	
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	
	public final static String ESC   = "\u001b[";
	
	ThreadFlag threadFlagYellow;
	ThreadFlag threadFlagBlue;
	ThreadFlag threadFlagRed;
	
	public Flag() {
		threadFlagYellow= new ThreadFlag(this, ANSI_YELLOW_BACKGROUND, 0, 6);//(Flag flag, String color, int filaStart, int height)
		threadFlagBlue= new ThreadFlag(this, ANSI_BLUE_BACKGROUND, 6, 3);
		threadFlagRed= new ThreadFlag(this, ANSI_RED_BACKGROUND, 9, 3);
	}

	public void drawFlag() throws InterruptedException {
		System.out.print(ESC+"2J");//Clear screen
		
		threadFlagYellow.start();
		threadFlagBlue.start();
		threadFlagRed.start();
		
		threadFlagYellow.join();
		threadFlagBlue.join();
		threadFlagRed.join();
		
		System.out.print(ANSI_RESET+ESC+"0G"+ESC+"13d");
	}
}
