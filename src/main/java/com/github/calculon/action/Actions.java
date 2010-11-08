package com.github.calculon.action;

import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;

public class Actions {

	public static Runnable doClick(final View target) {
		return new Runnable() {
			public void run() { target.performClick(); }
		};
	}
	
	public static Runnable doLongClick(final View target) {
		return new Runnable() {
			public void run() { target.performLongClick(); }
		};
	}
	
	public static Runnable doSetText(final View target, final String text) {
		return new Runnable() {
			public void run() { ((TextView)target).setText(text); }
		};
	}

	public static Runnable doSetChecked(final View target, final boolean checked) {
		return new Runnable() {
			public void run() { ((Checkable)target).setChecked(checked); }
		};
	}
}
