package com.techexhange.mobileapps.assignment1;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private NumSlider game;
    private ImageView one,two,three,four,five,six,seven,eight,zero;
    private Bitmap spritesheet;
    private ImageView[] imagesGroup = new ImageView[9];
    private Bitmap[] sprites = new Bitmap[9];
    boolean[] directions = new boolean[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spritesheet = BitmapFactory.decodeResource(this.getResources(),R.drawable.numbers_sprite_100);

        Bitmap sprite0 = Bitmap.createBitmap(spritesheet,0,0,2,20); sprites[0] = sprite0;
        Bitmap sprite = Bitmap.createBitmap(spritesheet,300,0,300,300); sprites[1]=sprite;
        Bitmap sprite2 = Bitmap.createBitmap(spritesheet,600,0,300,300);sprites[2]=sprite2;
        Bitmap sprite3 = Bitmap.createBitmap(spritesheet,900,0,300,300);sprites[3]=sprite3;
        Bitmap sprite4 = Bitmap.createBitmap(spritesheet,1200,0,300,300);sprites[4]=sprite4;
        Bitmap sprite5 = Bitmap.createBitmap(spritesheet,1500,0,300,300);sprites[5]=sprite5;
        Bitmap sprite6 = Bitmap.createBitmap(spritesheet,1800,0,300,300);sprites[6]=sprite6;
        Bitmap sprite7 = Bitmap.createBitmap(spritesheet,2100,0,300,300);sprites[7]=sprite7;
        Bitmap sprite8 = Bitmap.createBitmap(spritesheet,2400,0,300,300);sprites[8]=sprite8;

        game = new NumSlider();

        one =findViewById(R.id.one_image);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                directions=game.swapTile(1,0);
                swappingImages(directions, 1, 0);
            }
        });
        imagesGroup[1]=one;

        two =findViewById(R.id.two_image);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                directions=game.swapTile(2,0);
                swappingImages(directions, 2, 0);
            }
        });
        imagesGroup[2]=two;

        three =findViewById(R.id.three_image);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                directions=game.swapTile(0,1);
                swappingImages(directions, 0, 1);
            }
        });
        imagesGroup[3]=three;

        four = findViewById(R.id.four_image);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                directions=game.swapTile(1,1);
                swappingImages(directions, 1, 1);
            }
        });
        imagesGroup[4]=four;

        five = findViewById(R.id.five_image);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                directions=game.swapTile(2,1);
                swappingImages(directions, 2, 1);
            }
        });
        imagesGroup[5]=five;

        six = findViewById(R.id.six_image);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                directions=game.swapTile(0,2);
                swappingImages(directions, 0, 2);
            }
        });
        imagesGroup[6]=six;

        seven = findViewById(R.id.seven_image);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                directions=game.swapTile(1,2);
                swappingImages(directions, 1, 2);
            }
        });
        imagesGroup[7]=seven;

        eight = findViewById(R.id.eight_image);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                directions = game.swapTile(2,2);
                swappingImages(directions, 2, 2);
            }
        });
        imagesGroup[8]=eight;

        zero = findViewById(R.id.zero_image);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                directions= game.swapTile(0,0);
                swappingImages(directions, 0, 0);
            }
        });
        imagesGroup[0]=zero;
        loadGames();
    }


    private void swappingImages(boolean[] directions, int column, int row ){
        int oldPosition = (row*3) + column;
        int newPosition = this.getCoordinate(oldPosition, directions);
        if(newPosition<9){
            imagesGroup[newPosition].setVisibility(View.VISIBLE);
            imagesGroup[newPosition].setImageBitmap(sprites[ NumSlider.gridTiles[newPosition/3][newPosition%3].getTileValue()]);
            imagesGroup[oldPosition].setVisibility(View.INVISIBLE);
        }
        Boolean wonStatus = game.checkIfWon();
        if(wonStatus) this.won();
    }

    private int getCoordinate(int number, boolean[] directions){
        int result=9;
        for(int i=0;i<directions.length;i++){
            if(directions[i]){
                if(i==0){//toRight
                    result = number +1;
                }
                else if(i==1){//toLeft
                    result = number -1;
                }
                else if(i==2){//up
                    result=number-3;
                }
                else{//down
                    result=number+3;
                }
            }
        }
        return result;
    }

    private void won(){
        changeBitMapsColor();
        Toast.makeText(MainActivity.this, "CONGRATS YOU WON!", Toast.LENGTH_SHORT).show();
    }

    private void changeBitMapsColor(){
        Bitmap green = Bitmap.createBitmap(spritesheet,300,600,300,300);
        Bitmap green2 = Bitmap.createBitmap(spritesheet,600,600,300,300);
        Bitmap green3 = Bitmap.createBitmap(spritesheet,900,600,300,300);
        Bitmap green4 = Bitmap.createBitmap(spritesheet,1200,600,300,300);
        Bitmap green5 = Bitmap.createBitmap(spritesheet,1500,600,300,300);
        Bitmap green6 = Bitmap.createBitmap(spritesheet,1800,600,300,300);
        Bitmap green7 = Bitmap.createBitmap(spritesheet,2100,600,300,300);
        Bitmap green8 = Bitmap.createBitmap(spritesheet,2400,600,300,300);

        zero.setImageBitmap(green);
        zero.setEnabled(false);
        one.setImageBitmap(green2);
        one.setEnabled(false);
        two.setImageBitmap(green3);
        two.setEnabled(false);
        three.setImageBitmap(green4);
        three.setEnabled(false);
        four.setImageBitmap(green5);
        four.setEnabled(false);
        five.setImageBitmap(green6);
        five.setEnabled(false);
        six.setImageBitmap(green7);
        six.setEnabled(false);
        seven.setImageBitmap(green8);
        seven.setEnabled(false);

    }


    public void loadGames(){
        Random randomNumber = new Random();
        int gameChosen = randomNumber.nextInt(5);
        Resources res = getResources();
        int[] bases = new int[9];
        switch (gameChosen){
            case 0:
                bases = res.getIntArray(R.array.game);
                break;
            case 1:
                bases = res.getIntArray(R.array.game_2);
                break;
            case 2:
                bases = res.getIntArray(R.array.game_3);
                break;
            case 3:
                bases = res.getIntArray(R.array.game_4);
                break;
            case 4:
                bases = res.getIntArray(R.array.game_5);
                break;
        }

        int k=0;
        for(int i=0;i<NumSlider.winningNUmbers.length;i++){
            for(int j=0;j<NumSlider.winningNUmbers.length;j++){
                if(bases[k]==0) {
                    NumSlider.gridTiles[i][j].setTileStatus(true);
                }
                else {
                    NumSlider.gridTiles[i][j].setTileStatus(false);
                }
                NumSlider.gridTiles[i][j].setTileValue(bases[k]);
                imagesGroup[k].setImageBitmap(sprites[bases[k]]);
                k=k+1;
            }
        }




    }

}
