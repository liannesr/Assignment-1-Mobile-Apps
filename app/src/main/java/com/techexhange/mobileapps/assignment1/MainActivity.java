package com.techexhange.mobileapps.assignment1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private NumSlider game;
    private ImageView one,two,three,four,five,six,seven,eight,zero;
    private Map<ImageView, Integer> coordinatesMap;
    private Map<Integer, Tuple> inverseCoordinates;
    private static final String TAG = MainActivity.class.getSimpleName();
    private Bitmap spritesheet;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spritesheet = BitmapFactory.decodeResource(this.getResources(),R.drawable.numbers_sprite_100);

        //Bitmap sprite = Bitmap.createBitmap(spritesheet,300,0,300,300);
        Bitmap sprite = Bitmap.createBitmap(spritesheet,300,0,300,300);
        Bitmap sprite2 = Bitmap.createBitmap(spritesheet,600,0,300,300);
        Bitmap sprite3 = Bitmap.createBitmap(spritesheet,900,0,300,300);
        Bitmap sprite4 = Bitmap.createBitmap(spritesheet,1200,0,300,300);
        Bitmap sprite5 = Bitmap.createBitmap(spritesheet,1500,0,300,300);
        Bitmap sprite6 = Bitmap.createBitmap(spritesheet,1800,0,300,300);
        Bitmap sprite7 = Bitmap.createBitmap(spritesheet,2100,0,300,300);
        Bitmap sprite8 = Bitmap.createBitmap(spritesheet,2400,0,300,300);

        game = new NumSlider();
        coordinatesMap = new HashMap<ImageView, Integer>();
        inverseCoordinates = new HashMap<Integer, Tuple>();
        one =findViewById(R.id.one_image);
        one.setOnClickListener(this::onImagePressed);
        one.setImageBitmap(sprite);


        two =findViewById(R.id.two_image);
        two.setOnClickListener(this::onImagePressed);
        two.setImageBitmap(sprite2);

        three =findViewById(R.id.three_image);
        three.setOnClickListener(this::onImagePressed);
        three.setImageBitmap(sprite3);

        four = findViewById(R.id.four_image);
        four.setOnClickListener(this::onImagePressed);
        four.setImageBitmap(sprite4);

        five = findViewById(R.id.five_image);
        five.setOnClickListener(this::onImagePressed);
        five.setImageBitmap(sprite5);

        six = findViewById(R.id.six_image);
        six.setOnClickListener(this::onImagePressed);
        six.setImageBitmap(sprite6);

        seven = findViewById(R.id.seven_image);
        seven.setOnClickListener(this::onImagePressed);
        seven.setImageBitmap(sprite7);

        eight = findViewById(R.id.eight_image);
        eight.setOnClickListener(this::onImagePressed);
        eight.setImageBitmap(sprite8);

        zero = findViewById(R.id.nine_image);
        zero.setOnClickListener(this::onImagePressed);
        //eight.setImageBitmap(sprite8);
        zero.setVisibility(View.INVISIBLE);




        coordinatesMap.put(one,0); inverseCoordinates.put(0,new Tuple(one,0,sprite));
        coordinatesMap.put(two,1); inverseCoordinates.put(1,new Tuple(two,1,sprite2));
        coordinatesMap.put(three,2); inverseCoordinates.put(2,new Tuple(three,2,sprite3));
        coordinatesMap.put(four,3); inverseCoordinates.put(3,new Tuple(four,3,sprite4));
        coordinatesMap.put(five,4); inverseCoordinates.put(4,new Tuple(five,4,sprite5));
        coordinatesMap.put(six,5); inverseCoordinates.put(5, new Tuple(six,5,sprite6));
        coordinatesMap.put(seven,6); inverseCoordinates.put(6, new Tuple(seven,6,sprite7));
        coordinatesMap.put(eight,7); inverseCoordinates.put(7,new Tuple(eight,7,sprite8));
        coordinatesMap.put(zero,8); inverseCoordinates.put(8,new Tuple(zero,8,sprite8));
        //coordinatesMap.put(nine,9); inverseCoordinates.put(9, new Tuple(nine,9,null));

    }

    private void onImagePressed(View v){

        int row = coordinatesMap.get(v)/3;
        int column = coordinatesMap.get(v)%3;
        boolean[] directions = game.swapTile(column,row);
        int newPosition = this.getCoordinate(coordinatesMap.get(v),directions); //Int position to move
        if (newPosition<9){
            Bitmap oldBitmap = inverseCoordinates.get(coordinatesMap.get(v)).getBitmap();
            inverseCoordinates.get(newPosition).setBitmap(oldBitmap);
            ImageView toMove = inverseCoordinates.get(coordinatesMap.get(v)).getImage(); //The number of the image
            ImageView NewImage = inverseCoordinates.get(newPosition).getImage();
            NewImage.setImageBitmap(inverseCoordinates.get(coordinatesMap.get(toMove)).getBitmap());

            toMove.setVisibility(View.INVISIBLE);
            NewImage.setVisibility(View.VISIBLE);
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
        for(int i=0;i<inverseCoordinates.size();i++){
            inverseCoordinates.get(i).getImage().setOnContextClickListener(null);
        }

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

        one.setImageBitmap(green);
        two.setImageBitmap(green2);
        three.setImageBitmap(green3);
        four.setImageBitmap(green4);
        five.setImageBitmap(green5);
        six.setImageBitmap(green6);
        seven.setImageBitmap(green7);
        eight.setImageBitmap(green8);

    }
}
