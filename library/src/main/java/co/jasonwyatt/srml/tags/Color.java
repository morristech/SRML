package co.jasonwyatt.srml.tags;

import android.content.Context;
import android.os.Build;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import co.jasonwyatt.srml.Utils;

/**
 * @author jason
 *
 * Allows you to color a chunk of text.
 *
 * Usage: {{color fg=#FF00FF}}my text{{/color}} -> Magenta "my text"
 */

class Color extends ParameterizedTag {
    static final String NAME = "color";
    private static final String PARAM_COLOR_FG = "fg";
    private static final String PARAM_COLOR_BG = "bg";

    public Color(String tagStr, int taggedTextStart) {
        super(tagStr, taggedTextStart);
    }

    @Override
    public boolean matchesClosingTag(String tagName) {
        return NAME.equalsIgnoreCase(tagName);
    }

    @Override
    public void operate(Context context, Spannable builder, int taggedTextEnd) {
        String colorValue = getParam(PARAM_COLOR_FG);
        if (colorValue != null) {
            builder.setSpan(new ForegroundColorSpan(Utils.getColorInt(context, colorValue)), getTaggedTextStart(), taggedTextEnd, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        }

        colorValue = getParam(PARAM_COLOR_BG);
        if (colorValue != null) {
            builder.setSpan(new BackgroundColorSpan(Utils.getColorInt(context, colorValue)), getTaggedTextStart(), taggedTextEnd, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        }
    }
}
