package aula10;

public class RouteSolution
{
	public static int states = 0;
	public static int solutions = 0;

	public static void main(String[] args) {
		permutation(6, "");
		System.out.println("\nstates=" + states);
		System.out.println("solutions=" + solutions);
	}

	public static int[][] times = {{ 0, 18, 36, 29, 47, 13}, 
                                    {18,  0, 25, 12,  7, 18},  
                                    {36, 25,  0, 15, 31, 23}, 
                                    {29, 12, 15,  0, 24, 34}, 
                                    {47,  7, 31, 24,  0, 10}, 
                                    {13, 18, 23, 34, 10,  0}};

	public static int evaluate(String s) {
		int sum = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			int start = s.charAt(i)   - '0';
			int end   = s.charAt(i+1) - '0';
			sum += times[start][end];
		}
		return sum;
	}

	public static boolean permutation(int n, String s) {
		if (n == 0) {
			states++;
			if (evaluate(s) < 80) { // FOUND A SOLUTION!
				System.out.println("route=" + s + "  time=" + evaluate(s));
				solutions++;
				//return true;
			}
		}
	  else {
  		if (! s.contains("0")) { if (permutation(n - 1, s + "0")) return true; }
  		if (! s.contains("1")) { if (permutation(n - 1, s + "1")) return true; }
  		if (! s.contains("2")) { if (permutation(n - 1, s + "2")) return true; }
  		if (! s.contains("3")) { if (permutation(n - 1, s + "3")) return true; }
  		if (! s.contains("4")) { if (permutation(n - 1, s + "4")) return true; }
  		if (! s.contains("5")) { if (permutation(n - 1, s + "5")) return true; }
		}
		return false;
	}
}

