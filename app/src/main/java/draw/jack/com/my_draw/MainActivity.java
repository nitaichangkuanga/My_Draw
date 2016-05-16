package draw.jack.com.my_draw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Canvas canvas;
    private Paint paint;
    private ImageView iv;
    private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);
        bitmap = Bitmap.createBitmap(600, 600, Bitmap.Config.RGB_565);
        canvas = new Canvas(bitmap);
        paint = new Paint();
        //设置画板的底色为白色
        canvas.drawColor(Color.WHITE);
        //去掉锯齿
        paint.setAntiAlias(true);
        //红色笔去画画
        paint.setColor(Color.RED);
        //画笔的宽度
        paint.setStrokeWidth(10.0f);
    }

    public void canvasDraw(View view) {
        switch (view.getId()) {
            case R.id.drawLine:
                canvas.drawLine(0,0,300,600,paint);
                break;
            case R.id.drawRec:
                canvas.drawRect(100,100,300,400,paint);
                break;
            case R.id.drawCircle:
                canvas.drawCircle(100,100,50,paint);
                break;
            case R.id.drawArc:
                canvas.drawArc(100,100,300,400,0,160,true,paint);
                break;
            case R.id.drawTrigon:
                Path path = new Path();
                path.lineTo(30,30);
                path.lineTo(30,130);
                path.lineTo(130,130);
                canvas.drawPath(path,paint);
                break;
        }
        iv.setImageBitmap(bitmap);
    }
}
