public class FindSolution
{
	public static int states = 0;
	public static int solutions = 0;

	public static void main(String[] args) {
		tuple(6, "");
		System.out.println("states=" + states);
		System.out.println("solutions=" + solutions);
	}

	public static boolean tuple(int n, String s) {
		if (n == 0) {
			states++;
			int x = Integer.parseInt(s, 16);
			if (x % 127 == 0) {
				System.out.println(s);
				solutions++;
				//return true;
			}
		}
	  else {
  		if (tuple(n - 1, s + "a") == true) { return true; }
	  	if (tuple(n - 1, s + "b") == true) { return true; }
	  	if (tuple(n - 1, s + "c") == true) { return true; }
	  	if (tuple(n - 1, s + "d") == true) { return true; }
		}
		return false;
	}
}

