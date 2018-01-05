package com.reactnativenavigation.utils;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;

public class UiUtils {
	public static void runOnPreDrawOnce(final View view, final Runnable task) {
		view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
			@Override
			public boolean onPreDraw() {
				view.getViewTreeObserver().removeOnPreDrawListener(this);
				task.run();
				return true;
			}
		});
	}

	public static void tintDrawable(Drawable drawable, int tint) {
		drawable.setColorFilter(new PorterDuffColorFilter(tint, PorterDuff.Mode.SRC_IN));
	}

	public static void runOnMainThread(Runnable runnable) {
		new Handler(Looper.getMainLooper()).post(runnable);
	}
}
