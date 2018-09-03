package com.techexhange.mobileapps.assignment1;

public class NumSlider {

    private Tile[][] gridTiles = new Tile[3][3];
    private int[][] winningNUmbers = {{1,2,3},{4,5,6},{7,8,0}};

    public NumSlider(){
        //Configurating the grid with the tiles;
        this.config();

    }


    public  boolean[] swapTile(int columnTile, int rowTile){
        boolean toRight = false;
        boolean toLeft = false;
        boolean up = false;
        boolean down = false;
        if(!gridTiles[columnTile][rowTile].getTileStatus() && !gridTiles[columnTile][rowTile].getActive()) {
            toRight = this.checkAdjacent(rowTile, columnTile, rowTile,columnTile+1);
            toLeft = this.checkAdjacent(rowTile, columnTile, rowTile, columnTile-1);
            up = this.checkAdjacent(rowTile, columnTile, rowTile-1, columnTile);
            down = this.checkAdjacent(rowTile, columnTile, rowTile+1,columnTile);
        }
        return saveDirections(toRight,toLeft,up,down);
    }

    public boolean[] saveDirections(boolean toRight, boolean toLeft, boolean up, boolean down){
        boolean[] results = new boolean[4];
        results[0]=toRight;
        results[1]=toLeft;
        results[2]=up;
        results[3]=down;
        return results;
    }

    public void updatePositionActivation(int column, int row){
        if(this.gridTiles[row][column].getTileValue() == this.winningNUmbers[row][column]){
            this.gridTiles[row][column].setActive(false);
        }
    }
    public boolean checkPosition(int column, int row){ //If return true means that is in the correct position
        if(!this.gridTiles[row][column].getActive()){
            return true;
        }
        return false;
    }

    private boolean checkAdjacent( int presentRow, int presentColumn, int nextRow, int nextCol){
        try{
            if(this.gridTiles[nextRow][nextCol].getTileStatus()){
                this.gridTiles[nextRow][nextCol].setTileStatus(this.gridTiles[presentRow][presentColumn].getTileStatus());
                this.gridTiles[nextRow][nextCol].setTileValue(this.gridTiles[presentRow][presentColumn].getTileValue());
                this.gridTiles[presentRow][presentColumn].setTileStatus(true);
                this.gridTiles[presentRow][presentColumn].setTileValue(0);
                return true;
            }
        }
        catch(IndexOutOfBoundsException e){
            return false;
        }
        return false;
    }

    private void config(){
        this.gridTiles[0][0] = new Tile(1,false);
        this.gridTiles[0][1] = new Tile(2,false);
        this.gridTiles[0][2] = new Tile(3,false);
        this.gridTiles[1][0] = new Tile(4, false);
        this.gridTiles[1][1] = new Tile(5,false);
        this.gridTiles[1][2] = new Tile(6,false);
        this.gridTiles[2][0] = new Tile(7,false);
        this.gridTiles[2][1] = new Tile(8, false);
        this.gridTiles[2][2] = new Tile(0, true);
    }

    public boolean checkIfWon(){
        for (int i=0;i<gridTiles.length;i++){
            for(int j=0;j<gridTiles.length;j++){
                if(!(gridTiles[i][j].getTileValue()==winningNUmbers[i][j])){
                   return false;
                }
            }
        }
        return true;
    }

    public void userWonConfig(){
        for(int i=0;i<gridTiles.length;i++){
            for(int j=0;j<gridTiles.length;j++){
                gridTiles[i][j].setActive(false);
            }
        }
    }

}
