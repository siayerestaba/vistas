package com.inouttv.sincroguia.custom;

import android.content.Context;
import android.graphics.Typeface;

public class SGTypeFace {

	private static final String TAG = SGTypeFace.class.getSimpleName();

	/**
	 * Initializes custom Typeface
	 *
	 * @param context
	 * @param typefaceAsset
	 * @return Typeface
	 */
	public static Typeface initializeAppTypeface(Context context, String typefaceAsset) {
		// Log.i(TAG, "Initialized " + typefaceAsset);
		return Typeface.createFromAsset(context.getAssets(), typefaceAsset);
	}

}