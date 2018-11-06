/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula12_trabalho;

import static aula12_trabalho.KnightSolver.resolveRecursao;

/**
 *
 * @author wrkerber
 */
public class KnightState
{
    // Tamanho do tabuleiro
    static int N = 6; 
    // de 0 a 7
    static int posicaoInicalX = 0; 
    static int posicaoInicalY = 0; 
    public static int estadosParciais = 0;
  
    static boolean resolvedor() 
    { 
        int[][] tabuleiro = new int[8][8]; 
  
        /* Inicializa a matriz de solução */
        for (int x = 0; x < N; x++) 
            for (int y = 0; y < N; y++) 
                tabuleiro[x][y] = -1; 
  
       /* movimentoX[] e movimentoY[] definem o próximo movimendo do Knight. 
          movimentoX[] é o próximo valor da cordenada X 
          movimentoY[] é o próximo valor da cordenada Y */
        int movimentoX[] = {2, 1, -1, -2, -2, -1, 1, 2}; 
        int movimentoY[] = {1, 2, 2, 1, -1, -2, -2, -1}; 
  
        tabuleiro[posicaoInicalX][posicaoInicalY] = 0; 
  
        /* começa do 0,0 e explora todos os caminhos usando solveKTUtil() */
        if (!resolveRecursao(posicaoInicalX, posicaoInicalY, 1, tabuleiro, movimentoX, movimentoY)) 
        { 
            System.out.println("Solução não existe"); 
            return false; 
        } 
        else
            System.out.println("Solução:"); 
            imprimeSolucao(tabuleiro); 
  
        return true; 
    } 
    
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
        
        System.out.println("\n Estados parciais: "+ estadosParciais);
    } 
}
