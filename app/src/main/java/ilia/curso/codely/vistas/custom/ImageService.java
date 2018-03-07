package ilia.curso.codely.vistas.custom;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;

import ilia.curso.codely.vistas.R;

/**
 * Created by ilia.
 */

public class ImageService {

    public static Bitmap getCircleBitmap(Bitmap bitmap) {
        int minSide = Math.min(bitmap.getWidth(), bitmap.getHeight());
        final Bitmap output = Bitmap.createBitmap(minSide, minSide, Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(output);
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());

        final int color = Color.BLACK;
        final Paint paint = new Paint();

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
//        final RectF rectF = new RectF(rect);
//        canvas.drawOval(rectF, paint);
        float r = (minSide / 2);
        canvas.drawCircle(r, r, r, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        bitmap.recycle();

        return output;
    }
}
