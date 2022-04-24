package com.games;

public class Sudoku {

    private static final int GRID_SIZE = 9;

    public static void main(String[] args) {
        int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }};
        printGrid(grid);
        if(solvableGrid(grid)){
            System.out.println("\n>>>>>>  Grid solved!\n");
            printGrid(grid);
        }else{
            System.out.println("\nUnsolvable grid");
        }
    }

    private static boolean solvableGrid(int grid[][]) {
        for(int row =0;row< GRID_SIZE;row++){
            for(int col = 0;col<GRID_SIZE;col++){
                if(grid[row][col] == 0){
                    for(int val = 1;val<=GRID_SIZE;val++){
                        if(isValidBox(grid,val,row,col)){
                            grid[row][col] = val;
                            if(solvableGrid(grid)){
                                return true;
                            }else{
                                grid[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidBox(int[][] grid, int val, int row, int col) {
        return !presentInRow(grid,val,row)&&
                !presentInCol(grid,val,col)&&
                !presentInBox(grid,row,col,val);
    }

    private static boolean presentInBox(int[][] grid, int row, int col, int val) {
        int localBoxRow = row- row%3;
        int localBoxCol = col - col%3;

        for(int i =localBoxRow;i< localBoxRow+3;i++){

            for(int j = localBoxCol;j<localBoxCol+3;j++) {

                    if(grid[i][j] == val)
                        return true;
            }
        }
        return false;
    }

    private static boolean presentInRow(int[][] grid, int val, int row) {
        for(int col=0;col<GRID_SIZE;col++){
            if(grid[row][col] == val)
                return true;
        }
        return false;
    }

    private static boolean presentInCol(int[][] grid, int val, int col) {
        for(int row=0;row<GRID_SIZE;row++){
            if(grid[row][col] == val)
                return true;
        }
        return false;
    }

    private static void printGrid(int [][] grid) {
        for(int row=0;row<GRID_SIZE;row++){
            if(row!=0 && row%3 == 0){
                System.out.println("----------");
            }
            for(int col =0;col<GRID_SIZE;col++){
                if(col!=0 && col%3 == 0){
                    System.out.print("|");
                }
                System.out.print(grid[row][col]);
            }
            System.out.println();
        }
    }
}
