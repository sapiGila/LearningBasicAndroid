package basic.app.id.learningbasicandroid.recyclerviewandgridview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;

/**
 * Created by Mahdi on 31/01/18.
 * Part of RecyclerGridViewExample
 */

public class MaterialColors {
    public static int get(Context context, String typeColor, int position) {
        int returnColor = Color.BLACK;
        int arrayId = context.getResources().getIdentifier(
                "mdcolor_" + typeColor, "array",
                context.getApplicationContext().getPackageName());

        if (arrayId != 0) {
            TypedArray colors = context.getResources().obtainTypedArray(arrayId);
            position *= 2;
            if (position < colors.length())
                returnColor = colors.getColor(position, Color.BLACK);
            else
                returnColor = colors.getColor(position - colors.length(), Color.BLACK);
            colors.recycle();
        }
        return returnColor;
    }
}
