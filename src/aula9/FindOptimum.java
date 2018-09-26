public class FindOptimum
{
	public static int states = 0;
	public static double best_val = 1000;
	public static String best_str = "";

	public static void main(String[] args) {
		tuple(6, "");
		System.out.println("states=" + states);
		System.out.println("best_val=" + best_val);
		System.out.println("best_str=" + best_str);
	}

	public static double evaluate(String s) {
		double sum = 0;
		for (char c : s.toCharArray()) {
			if (c == 'a') { sum += 0.3; }
			if (c == 'b') { sum += 1.2; }
			if (c == 'c') { sum += 2.5; }
			if (c == 'd') { sum += 0.9; }
		}
		return Math.abs(sum - 10);
	}

	public static void tuple(int n, String s) {
		if (n == 0) {
			states++;
			double v = evaluate(s);
			if (v < best_val) {
				best_val = v;
				best_str = s;
			}
		}
	  else {
  		tuple(n - 1, s + "a");
	  	tuple(n - 1, s + "b");
	  	tuple(n - 1, s + "c");
	  	tuple(n - 1, s + "d");
		}
	}
}

