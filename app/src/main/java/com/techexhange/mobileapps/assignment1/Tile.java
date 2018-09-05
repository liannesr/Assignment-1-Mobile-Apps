package com.techexhange.mobileapps.assignment1;

/**
 * Programmed: Lianne Sanchez Rodriguez
 * Tile, represents the Tiles in a grid game
 * represented as a 2D Array with properties such as
 * value, status and activation.
 */
public class Tile {

    private int tileValue;
    private boolean tileStatus;
    private boolean active;


    /**
     * The class constructor
     * @param tileValue the value in the current tile.
     * @param tileStatus the status which establishes if it is empty ot not.
     */
    public Tile(int tileValue, boolean tileStatus){
        this.tileValue=tileValue;
        this.tileStatus=tileStatus;
        this.active=true;
    }

    /**
     * Method to access the current value of a tile.
     * @return tileValue the Tile current value.
     */
    public int getTileValue(){
        return this.tileValue;
    }

    /**
     * Method to change the current value of a Tile.
     * @param newValue this is the new value that we want for our tile.
     */
    public void setTileValue(int newValue){
        this.tileValue=newValue;
    }

    /**
     * Method to access the current status of a tile (filled or empty).
     * @return tileStatus, which is the current status of the tile (in boolean value).
     */
    public boolean getTileStatus(){
        return this.tileStatus;
    }

    /**
     * Method to change the current status of the Tile.
     * @param newStatus which is the new status of the Tile.
     */
    public void setTileStatus(boolean newStatus){
        this.tileStatus=newStatus;
    }

    /**
     * Method to change the activation method of the Tile.
     * @param newActive , new activation value for the Tile.
     */
    public void setActive(boolean newActive){
        this.active = false;
    }

    /**
     * Method to access the current activation value of the tile.
     * @return active, which is the activation value of the Tile.
     */
    public boolean getActive(){
        return this.active;
    }

}
