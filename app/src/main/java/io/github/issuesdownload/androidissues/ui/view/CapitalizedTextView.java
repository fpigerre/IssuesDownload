package io.github.issuesdownload.androidissues.ui.view;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.Button;

import java.util.Locale;

/**
 * A button who's text is always uppercase which uses the roboto font.
 * Inspired by {@link com.actionbarsherlock.internal.widget.CapitalizingTextView}
 */
public class CapitalizedTextView extends Button {

    private static final boolean SANS_ICE_CREAM = Build.VERSION.SDK_INT < Build.VERSION_CODES.ICE_CREAM_SANDWICH;
    private static final boolean IS_GINGERBREAD = Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD;

    public CapitalizedTextView(Context context) {
        super(context);

        setTF(context);
    }

    public CapitalizedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setTF(context);
    }

    public CapitalizedTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        setTF(context);

    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        if (IS_GINGERBREAD) {
            try {
                super.setText(text.toString().toUpperCase(Locale.ROOT), type);
            } catch (NoSuchFieldError e) {
                //Some manufacturer broke Locale.ROOT. See #572.
                super.setText(text.toString().toUpperCase(), type);
            }
        } else {
            super.setText(text.toString().toUpperCase(), type);
        }
    }

    private void setTF(Context context) {
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Regular.ttf"));
    }


}
