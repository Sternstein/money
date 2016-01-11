package com.example.andreas.money;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class Grafik extends AppCompatActivity {
    public String [] kat = new String[10];
    public String [] amount = new String[10];
    public int [] col = new int[10];
    public String cou;
    int x,y;
    int xp, yp, xh, yh, x1, x2, y1, y2;
    public float a,b,kp,c;
    public int im, om, i, sum, q;
    public int [] op = new int[10];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
    }

    class DrawView extends View {

        Paint p;
        RectF rectf;
        StringBuilder sb;

        public DrawView(Context context) {
            super(context);
            p = new Paint();
            rectf = new RectF(100,200,700,500);
            sb = new StringBuilder();

        }

        @Override
        protected void onDraw(Canvas canvas) {
            //canvas.drawARGB(0, 0, 0, 255);

            x=canvas.getWidth();
            y=canvas.getHeight();
            xp = x/100;
            yp = y/100;
            xh = x/2;
            yh = y/2;
            yh = yh - (yp*10);
            x1 = xh - (xp*40);
            x2 = xh + (xp*40);
            y1 = yh - (xp*40);
            y2 = yh + (xp*40);

            rectf.set(x1, y1, x2, y2);

            p.setColor(Color.BLUE);
            p.setStrokeWidth(10);

            p.setTextSize(30);

            // настраиваем выравнивание текста на центр
            p.setTextAlign(Paint.Align.CENTER);

            canvas.drawText("Аналитика", xh, (yh - (xp * 44)), p);
            canvas.drawText("Исходные данные:", xh, (yh + (xp * 44)), p);


            Intent intent = getIntent();
            Bundle bb= getIntent().getExtras();
            kat = bb.getStringArray("kate");
            amount = bb.getStringArray("ame");
            cou = intent.getStringExtra("co");
            im = 6;

            om = 45;

            p.setTextAlign(Paint.Align.LEFT);
            sum = 0;


            for (i=0; i<im; i++) {
                om+=5;
                op[i] = Integer.parseInt(amount[i]);
                sum+=op[i];


                    canvas.drawText("Категория:   " + kat[i] + "  " + op[i] + " руб", x1, (yh + (xp * om)), p);


            }

            canvas.drawText("Категория:  SUMMA  " +sum+ " руб", x1, (yh + (xp * 80)), p);




            col[0]= Color.argb(255, 255, 165, 0);
            col[1]= Color.GREEN;
            col[2]= Color.argb(255, 255, 20, 147);
            col[3]= Color.argb(255, 148, 0, 211);
            col[4]= Color.argb(255, 127, 255, 212);
            col[5]= Color.argb(255, 255, 193, 193);



            kp = 360;
            c = 0;



            for (i=0; i<im; i++) {

                b = (float) op[i]/sum;
                a = b * kp;
                p.setColor(col[i]);
                p.setStyle(Paint.Style.FILL);
                canvas.drawArc(rectf, c, a, true, p);
                p.setColor(Color.BLACK);
                p.setStyle(Paint.Style.STROKE);
                canvas.drawArc(rectf, c, a, true, p);
                c+=a;
            }







            // Инфа про цвета : Оранж (255 165 0), ДипПинк (255 20 147) ДаркВиолет (148 0 211) Аквамарин (127 255 212) Rosy 255 193 193


        }

    }
}

