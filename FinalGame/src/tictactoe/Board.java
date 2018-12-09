package tictactoe;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.swing.JFrame;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


public class Board{
   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
	   System.out.print("Player One Name: ");
       String xname = sc.nextLine();
       System.out.print("Player Two Name: ");
       String oname = sc.nextLine();
       System.out.println("          _____                    _____            _____                    _____          \n" + 
       		"         /\\    \\                  /\\    \\          /\\    \\                  /\\    \\         \n" + 
       		"        /::\\    \\                /::\\____\\        /::\\____\\                /::\\    \\        \n" + 
       		"       /::::\\    \\              /:::/    /       /:::/    /               /::::\\    \\       \n" + 
       		"      /::::::\\    \\            /:::/    /       /:::/    /               /::::::\\    \\      \n" + 
       		"     /:::/\\:::\\    \\          /:::/    /       /:::/    /               /:::/\\:::\\    \\     \n" + 
       		"    /:::/  \\:::\\    \\        /:::/    /       /:::/____/               /:::/__\\:::\\    \\    \n" + 
       		"   /:::/    \\:::\\    \\      /:::/    /       /::::\\    \\              /::::\\   \\:::\\    \\   \n" + 
       		"  /:::/    / \\:::\\    \\    /:::/    /       /::::::\\    \\   _____    /::::::\\   \\:::\\    \\  \n" + 
       		" /:::/    /   \\:::\\ ___\\  /:::/    /       /:::/\\:::\\    \\ /\\    \\  /:::/\\:::\\   \\:::\\    \\ \n" + 
       		"/:::/____/  ___\\:::|    |/:::/____/       /:::/  \\:::\\    /::\\____\\/:::/  \\:::\\   \\:::\\____\\\n" + 
       		"\\:::\\    \\ /\\  /:::|____|\\:::\\    \\       \\::/    \\:::\\  /:::/    /\\::/    \\:::\\   \\::/    /\n" + 
       		" \\:::\\    /::\\ \\::/    /  \\:::\\    \\       \\/____/ \\:::\\/:::/    /  \\/____/ \\:::\\   \\/____/ \n" + 
       		"  \\:::\\   \\:::\\ \\/____/    \\:::\\    \\               \\::::::/    /            \\:::\\    \\     \n" + 
       		"   \\:::\\   \\:::\\____\\       \\:::\\    \\               \\::::/    /              \\:::\\____\\    \n" + 
       		"    \\:::\\  /:::/    /        \\:::\\    \\              /:::/    /                \\::/    /    \n" + 
       		"     \\:::\\/:::/    /          \\:::\\    \\            /:::/    /                  \\/____/     \n" + 
       		"      \\::::::/    /            \\:::\\    \\          /:::/    /                               \n" + 
       		"       \\::::/    /              \\:::\\____\\        /:::/    /                                \n" + 
       		"        \\::/____/                \\::/    /        \\::/    /                                 \n" + 
       		"                                  \\/____/          \\/____/                                  \n" );
       playIt("Files/009.wav");
       
       if(xname.equals(oname)) {
    	   System.out.println("Don't Play Alone! Try our single-player version.");
    	   System.exit(1);
       }
       /// Setters to transfer the inputs to the game
       TicTacToeFrame.setXname(xname);
       TicTacToeFrame.setOname(oname);
       JFrame ticTacToe = new TicTacToeFrame();
       ticTacToe.setTitle("X's and O's With Friends Deluxe");
       ticTacToe.setSize(600, 600);
       ticTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       ticTacToe.setVisible(true); 
   }
   public static void playIt(String filename) {
		try {
			InputStream in = new FileInputStream(filename);
			AudioStream as = new AudioStream(in);
			AudioPlayer.player.start(as);
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}

