package co.jasonwyatt.srml.tags;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.StyleSpan;

/**
 * Created by jason on 11/10/16.
 *
 * For italicizing text.
 */
class Italic extends Tag {
    static final String NAME = "i";

    Italic(String tagStr, int taggedTextStart) {
        super(tagStr, taggedTextStart);
    }

    @Override
    public boolean matchesClosingTag(String tagName) {
        return NAME.equalsIgnoreCase(tagName);
    }

    @Override
    public void operate(Spannable builder, int taggedTextEnd) {
        builder.setSpan(new StyleSpan(Typeface.ITALIC), getTaggedTextStart(), taggedTextEnd, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
    }
}