package aula12_trabalho;

/**
 *
 * @author wrkerber
 */

/*
 SE 
 * todos os quadrados são visitados imprima a solução
SENÃO
   a) Adicione um dos próximos movimentos ao vetor de solução e recursivamente 
   verifique se esse movimento leva a uma solução
   b) Se o movimento escolhido na etapa acima não levar a uma solução
   em seguida, remova esse movimento do vetor da solução e tente outro 
   movimentos alternativos.
   c) Se nenhuma das alternativas funcionar, então retorne false (Retornando false 
   irá remover o item adicionado anteriormente em recursão e se falso for 
   retornado pela chamada inicial de recursão, então "nenhuma solução existe")
 * */
public class KnightTour 
{ 
    // Tamanho do tabuleiro
    static int N = 8; 
  
    /* verifica se i, j são índices válidos para o tabuleiro de xadrez N * N */
    static boolean isSafe(int x, int y, int sol[][]) 
    { 
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1); 
    } 
  
    /* printa a matriz de solução  */
    static void imprimeSolucao(int solucao[][]) 
    { 
        for (int x = 0; x < N; x++) 
        { 
            for (int y = 0; y < N; y++) 
            System.out.print(solucao[x][y] + " "); 
            System.out.println(""); 
        } 
    } 
  
    /* resolve o problema do KnightTour (passeio de cavaleiro)
        usando Backtracking. Esta função principalmente
        usa solveKTUtil() para resolver o problema.
        retorna false se nenhum tour completo for possível.
        caso contrário, retorne true e imprima o tour.
        pode haver mais de um
        soluções, esta função imprime uma das
        soluções viáveis.  */
    static boolean solveKT() 
    { 
        int[][] solucao = new int[8][8]; 
  
        /* Inicializa a matriz de solução */
        for (int x = 0; x < N; x++) 
            for (int y = 0; y < N; y++) 
                solucao[x][y] = -1; 
  
       /* movimentoX[] e movimentoY[] definem o próximo movimendo do Knight. 
          movimentoX[] é o próximo valor da cordenada X 
          movimentoY[] é o próximo valor da cordenada Y */
        int movimentoX[] = {2, 1, -1, -2, -2, -1, 1, 2}; 
        int movimentoY[] = {1, 2, 2, 1, -1, -2, -2, -1}; 
  
        solucao[7][7] = 0; 
  
        /* começa do 0,0 e explora todos os caminhos usando solveKTUtil() */
        if (!solveKTUtil(0, 0, 1, solucao, movimentoX, movimentoY)) 
        { 
            System.out.println("Solução não existe"); 
            return false; 
        } 
        else
            imprimeSolucao(solucao); 
  
        return true; 
    } 
  
    /* função recursiva para resolver o Knight */
    static boolean solveKTUtil(int x, int y, int movimentoI, int solucao[][], int movimentoX[], int movimentoY[])
    { 
        int k, proximoX, proximoY; 
        if (movimentoI == N * N) 
            return true; 
  
        /* tenta todos os próximos movimentos da coordenada atual x, y */
        for (k = 0; k < 8; k++) 
        { 
            proximoX = x + movimentoX[k]; 
            proximoY = y + movimentoY[k]; 
            if (isSafe(proximoX, proximoY, solucao)) 
            { 
                solucao[proximoX][proximoY] = movimentoI; 
                if (solveKTUtil(proximoX, proximoY, movimentoI + 1, solucao, movimentoX, movimentoY)) 
                    return true; 
                else
                    solucao[proximoX][proximoY] = -1;// backtracking 
            } 
        } 
        System.out.println("\n\nNão achou: "+ movimentoI);
        imprimeSolucao(solucao);
        return false;
    } 
  
    public static void main(String args[]) 
    { 
        solveKT(); 
    } 
} 

