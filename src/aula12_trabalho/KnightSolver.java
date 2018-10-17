/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula12_trabalho;

import static aula12_trabalho.KnightState.N;
import static aula12_trabalho.KnightState.estadosParciais;
//import static aula12_trabalho.KnightState.imprimeSolucao;
import static aula12_trabalho.KnightState.isSafe;
import static aula12_trabalho.KnightState.resolvedor;

/**
 *
 * @author wrkerber
 */
public class KnightSolver
{
    public static void main(String args[]) 
    { 
        resolvedor(); 
    }
    
    /* resolve o problema do KnightTour (passeio de cavaleiro)
        usando Backtracking. Esta função principalmente
        usa resolveRecursao() para resolver o problema.
        retorna false se nenhum tour completo for possível.
        caso contrário, retorne true e imprima o tour.
        pode haver mais de um
        soluções, esta função imprime uma das
        soluções viáveis.  */
    
    /* função recursiva para resolver o Knight */
    static boolean resolveRecursao(int x, int y, int movimentoI, int solucao[][], int movimentoX[], int movimentoY[])
    { 
        int k, proximoX, proximoY; 
        if (movimentoI == N * N) 
        //if (movimentoI == N * N && ((x == 1 && y == 2) || (x == 2 && y == 1)) ) 
            return true; 
  
        /* tenta todos os próximos movimentos da coordenada atual x, y */
        for (k = 0; k < 8; k++) 
        { 
            proximoX = x + movimentoX[k]; 
            proximoY = y + movimentoY[k]; 
            if (isSafe(proximoX, proximoY, solucao)) 
            { 
                solucao[proximoX][proximoY] = movimentoI; 
                if (resolveRecursao(proximoX, proximoY, movimentoI + 1, solucao, movimentoX, movimentoY)) 
                    return true; 
                else
                    solucao[proximoX][proximoY] = -1;// backtracking 
            } 
        } 
        //System.out.println("\n\nNão achou: "+ movimentoI);
        //imprimeSolucao(solucao);
        estadosParciais++;
        return false;
    } 
}
