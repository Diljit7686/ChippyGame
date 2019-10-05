package com.example.chippygame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;

public class flyingTank extends View {
private int tankX;
private int tankY;
private int tankSpeed;
private int canvasWidth, canvasHeight;
private boolean Touch = false;

    private Bitmap tank;
private  Bitmap backgroundImage;

private Paint scorePaint = new Paint();

private Bitmap life[] = new Bitmap[2];

    public flyingTank(Context context) {


        super(context);

       tank = BitmapFactory.decodeResource(getResources(), R.drawable.tank2);


       backgroundImage = BitmapFactory.decodeResource(getResources(),R.drawable.background);

       scorePaint.setColor(Color.WHITE);
       scorePaint.setTextSize(70);
       scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
       scorePaint.setAntiAlias(true);
       life[0] = BitmapFactory.decodeResource(getResources(),R.drawable.heart);
       life[1] = BitmapFactory.decodeResource(getResources(),R.drawable.greyheart);


       tankY = 550;

    }
    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();



        canvas.drawBitmap(backgroundImage,0,0,null);

        int minTankY = tank.getHeight();
        int maxTankY = canvasHeight-tank.getHeight() * 3;

        if(tankY < minTankY){
            tankY = minTankY;
        }
        if(tankY > maxTankY){
            tankY = maxTankY;
        }
tankSpeed = tankSpeed + 2;

        if (Touch)
        {
canvas.drawBitmap(tank, tankX , tankY , null);
Touch = false;
        }

        else
        {
            canvas.drawBitmap(tank , tankX , tankY , null);
        }

        canvas.drawText("Score : " , 20 ,60 , scorePaint);
        canvas.drawBitmap(life[0],380,10,null);
        canvas.drawBitmap(life[0],540,10,null);
        canvas.drawBitmap(life[0],700,10,null);


        // canvas.drawBitmap(tank,70,100,null);

    }
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if (event.getAction() == MotionEvent.ACTION_DOWN)
        {
            Touch = true;

            tankSpeed = -22;
        }
        return true;




    }

}
