package com.inouttv.sincroguia.utils;

import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FontLoader {
	private static Typeface sDefaultFont;
	private static Typeface sFontBold;

	private FontLoader() {

	}

	private static <T extends View> T apply(T view, Typeface typeface) {
		if (view == null || typeface == null || view.isInEditMode())
			return view;

		applyInternal(view, typeface);
		return view;
	}

	private static void applyInternal(View view, Typeface typeface) {
		if (view instanceof ViewGroup) {
			final ViewGroup vg = (ViewGroup) view;
			final int childCount = vg.getChildCount();
			for (int i = 0; i < childCount; i++) {
				applyInternal(vg.getChildAt(i), typeface);
			}
		} else if (view instanceof TextView) {
			((TextView) view).setTypeface(typeface);
		}
	}

	public static <T extends View> T applyDefault(T view) {
		return apply(view, sDefaultFont);
	}

	public static <T extends View> T applyBold(T view) {
		return apply(view, sFontBold);
	}

	public static Typeface getDefaultFont() {
		return sDefaultFont;
	}

	public static void setDefaultFont(Typeface defaultFont) {
		sDefaultFont = defaultFont;
	}

	public static Typeface getsFontBold() {
		return sFontBold;
	}

	public static void setsFontBold(Typeface sFontBold) {
		FontLoader.sFontBold = sFontBold;
	}
}