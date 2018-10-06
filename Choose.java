import java.util.Scanner;
public class Choose {
	public static void main(String [] args){
		System.out.println("You see a scary house. You are with your friends. Do you investigate? Y or N");
		Scanner inputChoice = new Scanner(System.in);
		String choice = inputChoice.nextLine();
		String upchoice = choice.toUpperCase();
		if (upchoice.equals("Y")){
			System.out.println("You are very brave. You sneak in the side door.");
		} else {
			System.out.println("Chicken. See ya.");
			return;
		}
		System.out.println("The side door creaks! Zombies awake. Continue? Y or N");
		choice = inputChoice.nextLine();
		upchoice = choice.toUppercase();
		
		if (upchoice.equals("Y")) {
			System.out.println("You find a cricket bat and destroy the first zombie! Run upstairs.");
		} else {
			System.out.println("Zombie eatsyour brain. You dies Scum.");
			return;
		}
	} 
}