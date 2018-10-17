package aula11;

public class Latin4Solver
{
    public static int complete_states;
    public static int partial_states;
    public static int solutions;

    public static void main(String[] args)
    {
        Latin4State start = new Latin4State();
        //start.m[1][1] = 'b';
        //start.m[1][2] = 'b';
        solve(start);
        System.out.println("complete states: " + complete_states);
        System.out.println("partial states : " + partial_states);
        System.out.println("solutions      : " + solutions);
    }
    
    public static boolean solve(final Latin4State state)
    {
        boolean found = false;
        int r = 0, c = 0;
        for (r = 0; r <= 3; r++) {
            for (c = 0; c <= 3; c++) {
                if (state.m[r][c]=='-') {
                    found = true;
                    break;
                }
            }
            if (found) { break; }
        }

        if (!found) { // BASE CASE: matrix is full
            complete_states++;
            //System.out.println(state);

            if (state.isValid()) {
                solutions++;
                System.out.println(state);
                return true;
            }
        }
        else { // GENERAL CASE: choose letter to fill an empty position
            partial_states++;
            //System.out.println(state);

            // PRUNNING: skip invalid partial states
            if (! state.isValid()) { return false; }
    
            Latin4State sa = new Latin4State(state);
            sa.m[r][c] = 'a';
            if (solve(sa) == true) { return true; }

            Latin4State sb = new Latin4State(state);
            sb.m[r][c] = 'b';
            if (solve(sb) == true) { return true; }

            Latin4State sc = new Latin4State(state);
            sc.m[r][c] = 'c';
            if (solve(sc) == true) { return true; }

            Latin4State sd = new Latin4State(state);
            sd.m[r][c] = 'd';
            if (solve(sd) == true) { return true; }
        }
        return false;
    }
}

