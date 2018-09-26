package aula9;

public class Combinatorics
{
	public static int states = 0;

	public static void main(String[] args) {
		//tuple(4, "");
		//permutation(3, "");
	  combination(2, "");
		System.out.println("states=" + states);
	}

	public static void combination(int n, String s) {
		if (n == 0) {
			states++;
			System.out.println(s);
		}
	  else {
			int l = s.length();
  		if (l==0 || s.charAt(l-1) < 'a') { combination(n - 1, s + "a"); }
	  	if (l==0 || s.charAt(l-1) < 'b') { combination(n - 1, s + "b"); }
	  	if (l==0 || s.charAt(l-1) < 'c') { combination(n - 1, s + "c"); }
	  	if (l==0 || s.charAt(l-1) < 'd') { combination(n - 1, s + "d"); }
		}
	}

	public static void permutation(int n, String s) {
		if (n == 0) {
			states++;
			System.out.println(s);
		}
	  else {
  		if (! s.contains("a")) { permutation(n - 1, s + "a"); }
	  	if (! s.contains("b")) { permutation(n - 1, s + "b"); }
	  	if (! s.contains("c")) { permutation(n - 1, s + "c"); }
	  	if (! s.contains("d")) { permutation(n - 1, s + "d"); }
		}
	}

	public static void tuple(int n, String s) {
		if (n == 0) {
			states++;
			System.out.println(s);
		}
	  else {
  		tuple(n - 1, s + "a");
	  	tuple(n - 1, s + "b");
	  	tuple(n - 1, s + "c");
	  	tuple(n - 1, s + "d");
		}
	}
}

