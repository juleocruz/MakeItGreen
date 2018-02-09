package delacruz.midterm.uic.com.makeitgreen;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {




    Button button1, button2, button3, button4, b_new;
    String buttonColor1, buttonColor2, buttonColor3, buttonColor4;
    Random r;
    int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_new = (Button) findViewById(R.id.newgame);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);

        r = new Random();
        int temp;


        //refer to the # of buttons
        //button1
        temp = r.nextInt(3)+1;
        if (temp == 1){
            buttonColor1 = "red";
        }else  if (temp == 2){
            buttonColor1 = "green";
        }else  if (temp == 3){
            buttonColor1 = "blue";
        }

        //button2
        temp = r.nextInt(3)+1;
        if (temp == 1){
            buttonColor2 = "red";
        }else  if (temp == 2){
            buttonColor2 = "green";
        }else  if (temp == 3){
            buttonColor2 = "blue";
        }

        //button3
        temp = r.nextInt(3)+1;
        if (temp == 1){
            buttonColor3 = "red";
        }else  if (temp == 2){
            buttonColor3 = "green";
        }else  if (temp == 3){
            buttonColor3 = "blue";
        }

        //button4
        temp = r.nextInt(3)+1;
        if (temp == 1){
            buttonColor4 = "red";
        }else  if (temp == 2){
            buttonColor4 = "green";
        }else  if (temp == 3){
            buttonColor4 = "blue";
        }

        //apply colors
        applyColor(button1,buttonColor1);
        applyColor(button2,buttonColor2);
        applyColor(button3,buttonColor3);
        applyColor(button4,buttonColor4);


        //clicking part
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonColor1 = changeColor(buttonColor1);
                applyColor(button1, buttonColor1);

                buttonColor2 = changeColor(buttonColor2);
                applyColor(button2, buttonColor2);

                checkForWin();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonColor1 = changeColor(buttonColor1);
                applyColor(button1, buttonColor1);

                buttonColor2 = changeColor(buttonColor2);
                applyColor(button2, buttonColor2);

                buttonColor3 = changeColor(buttonColor3);
                applyColor(button3, buttonColor3);


                checkForWin();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonColor2 = changeColor(buttonColor2);
                applyColor(button2, buttonColor2);

                buttonColor3 = changeColor(buttonColor3);
                applyColor(button3, buttonColor3);

                buttonColor4 = changeColor(buttonColor4);
                applyColor(button4, buttonColor4);

                checkForWin();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonColor3 = changeColor(buttonColor3);
                applyColor(button3, buttonColor3);

                buttonColor4 = changeColor(buttonColor4);
                applyColor(button4, buttonColor4);

                checkForWin();
            }
        });

        b_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    public void checkForWin(){
        score++;

        if(buttonColor1.equals("green")&& buttonColor2.equals("green")&& buttonColor3.equals("green")&& buttonColor4.equals("green")){
            Toast.makeText(this, "You made every Lights into Green using "+score+" moves!", Toast.LENGTH_SHORT).show();

            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
        }
    }

    public String changeColor(String color){
        if (color.equals("red")){
            color = "green";
        } else if (color.equals("green")) {
            color = "blue";
        } else if (color.equals("blue")) {
            color = "red";
        }

        return color;


    }

    public  void applyColor(Button button, String color){
        if(color.equals("red")){
            button.setBackgroundColor(Color.RED);
        }else if(color.equals("green")){
            button.setBackgroundColor(Color.GREEN);
        }else  if(color.equals("blue")){
            button.setBackgroundColor(Color.BLUE);
        }
    }
}