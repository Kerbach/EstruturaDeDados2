package aula11;

public class Latin4State
{
    public char[][] m = {{'-','-','-','-'},
                         {'-','-','-','-'},
                         {'-','-','-','-'},
                         {'-','-','-','-'}};

    public Latin4State() {}

    public Latin4State(Latin4State s) {
        for (int r = 0; r <= 3; r++) {
            for (int c = 0; c <= 3; c++) {
                this.m[r][c] = s.m[r][c];
            }
        }
    }

    private boolean colIsValid(int col) {
        int a = 0, b = 0, c = 0, d = 0;
        for (int row = 0; row <= 3; row++) {
           if (this.m[row][col] == 'a') { a++; }
           if (this.m[row][col] == 'b') { b++; }
           if (this.m[row][col] == 'c') { c++; }
           if (this.m[row][col] == 'd') { d++; }
        }
        return a <= 1 && b <= 1 && c <= 1 && d <= 1;
    }

    private boolean rowIsValid(int row) {
        int a = 0, b = 0, c = 0, d = 0;
        for (int col = 0; col <= 3; col++) {
           if (this.m[row][col] == 'a') { a++; }
           if (this.m[row][col] == 'b') { b++; }
           if (this.m[row][col] == 'c') { c++; }
           if (this.m[row][col] == 'd') { d++; }
        }
        return a <= 1 && b <= 1 && c <= 1 && d <= 1;
    }

    public boolean isValid() {
        return colIsValid(0) && colIsValid(1) &&
               colIsValid(2) && colIsValid(3) && 
               rowIsValid(0) && rowIsValid(1) &&
               rowIsValid(2) && rowIsValid(3);
    }

    public String toString() {
        return 
           m[0][0]+" "+m[0][1]+" "+m[0][2]+" "+m[0][3]+"\n" +
           m[1][0]+" "+m[1][1]+" "+m[1][2]+" "+m[1][3]+"\n" +
           m[2][0]+" "+m[2][1]+" "+m[2][2]+" "+m[2][3]+"\n" +
           m[3][0]+" "+m[3][1]+" "+m[3][2]+" "+m[3][3]+"\n";
    }
}

