public class Test {
	public static void main (String [] args){
		double root = Math.sqrt(17);
		System.out.println(root);
		double mypi = Math.PI;
		System.out.println(mypi);
		/// calling the void method
		myprint("Jeff");
		System.out.println(myTimes(45,85));
	}
	
	/// my void method
	public static void myprint(String stuff){
		System.out.println(stuff);
	}
	public static int myTimes(int x, int y){
		return x*y;
	}

}