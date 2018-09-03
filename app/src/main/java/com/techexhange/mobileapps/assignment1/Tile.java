package com.techexhange.mobileapps.assignment1;
// Tiles for the mobile app course
public class Tile {

    private int tileValue;
    private boolean tileStatus;
    private boolean active;


    public Tile(int tileValue, boolean tileStatus){
        this.tileValue=tileValue;
        this.tileStatus=tileStatus;
        this.active=true;
    }

    public int getTileValue(){
        return this.tileValue;
    }

    public void setTileValue(int newValue){
        this.tileValue=newValue;
    }

    public boolean getTileStatus(){
        return this.tileStatus;
    }
    public void setTileStatus(boolean newStatus){
        this.tileStatus=newStatus;
    }
    public void setActive(boolean newActive){
        this.active = false;
    }
    public boolean getActive(){
        return this.active;
    }

}
