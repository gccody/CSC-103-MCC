/*
 * Project 3: QueenSimulation.java
 * Author: Grant Cody
 * Date: 11/3/2022
 * Description: This program simulates the placement of queens on a chessboard and finds all possible solutions.
 */

import java.util.Arrays;

/**
 * Queen solver custom class
 * @author Grant Cody
 */
class QueenSimulation {

  public static void main(String[] args)  {
    int size = 10;

    int[][] board = new int[size][size];

    for (int i = 0; i < size; i++) {
        Arrays.fill(board[i], 0);
    }

    QueenSimulation queenSolver = new QueenSimulation(size);

    queenSolver.nQueen(queenSolver.getBoard(), 0);
    System.out.printf("Number of solutions for (N = %s) is %s", size, queenSolver.getNumSolutions());
}

  private int numSolutions = 0;
  private int[][] board;

  public QueenSimulation(int size) {
    board = new int[size][size];
  }

  /**
   * Checks to see if the queen is safe in the current location
   * 
   * @param board - The current state of the board
   * @param row - The current row to place a queen
   * @param col - The current column to place a queen
   * @return - Returns true if the queen can be placed in the current row and column
   */
  public boolean isSafe(int[][] board, int row, int col) {
    for (int i = 0; i < row; i++) {
      if (board[i][col] == 1) {
        return false;
      }
    }

    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)  {
      if (board[i][j] == 1) {
        return false;
      }
    }

    for (int i = row, j = col; i >= 0 && j < board.length; i--, j++)  {
      if (board[i][j] == 1) {
        return false;
      }
    }

    return true;
  }

  /**
   * Solves the n-queen problem
   * @param board - The current state of the board
   * @param row - The current row to place a queen
   */
  public void nQueen(int[][] board, int row) {
    if (row == board.length) {
      this.numSolutions++;
      return;
    }

    for (int i = 0; i < board.length; i++)  {
      if (isSafe(board, row, i))  {
        board[row][i] = 1;
        nQueen(board, row + 1);
        board[row][i] = 0;
      }
    }
  }

  /**
   * @return The Board
   */
  public int[][] getBoard() {
    return this.board;
  }

  /**
   * @return The number of solutions
   */
  public int getNumSolutions() {
    return this.numSolutions;
  }
}