package aula11;

public class Latin3Solver
{
    public static int states;

    public static void main(String[] args)
    {
        solve(new Latin3State());
        System.out.println("states=" + states);
    }
    
    public static boolean solve(final Latin3State state)
    {
        boolean found = false;
        int r = 0, c = 0;
        for (r = 0; r <= 2; r++) {
            for (c = 0; c <= 2; c++) {
                if (state.m[r][c]=='-') {
                    found = true;
                    break;
                }
            }
            if (found) { break; }
        }

        if (!found) { // BASE CASE: matrix is full
            states++;
            if (state.isSolution()) {
                System.out.println(state);
                return true;
            }
        }
        else { // GENERAL CASE: choose letter to fill an empty position
            Latin3State sa = new Latin3State(state);
            sa.m[r][c] = 'a';
            if (solve(sa) == true) { return true; }

            Latin3State sb = new Latin3State(state);
            sb.m[r][c] = 'b';
            if (solve(sb) == true) { return true; }

            Latin3State sc = new Latin3State(state);
            sc.m[r][c] = 'c';
            if (solve(sc) == true) { return true; }
        }
        return false;
    }
}

