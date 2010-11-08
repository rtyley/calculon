package com.github.calculon.unit.assertion;

import static com.github.calculon.action.Actions.doClick;
import static com.github.calculon.action.Actions.doLongClick;
import static com.github.calculon.action.Actions.doSetChecked;
import static com.github.calculon.action.Actions.doSetText;
import static junit.framework.Assert.assertEquals;
import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;

import com.github.calculon.CalculonUnitTest;
import com.github.calculon.action.Actions;


public class UnitTestViewAssertion<ActivityT extends Activity> extends
UnitTestUserInputAssertionBase<View, ActivityT> {

	public UnitTestViewAssertion(CalculonUnitTest<ActivityT> testCase, Activity activity,
			Instrumentation instrumentation, View view) {
		super(testCase, activity, instrumentation);
		this.target = view;
	}

	public UnitTestActionAssertion<ActivityT> setChecked(boolean checked) {
		return perform(doSetChecked(target, checked));
	}
	
	public UnitTestActionAssertion<ActivityT> setText(String text) {
		return perform(doSetText(target, text));
	}
	
	public UnitTestActionAssertion<ActivityT> click() {
		return perform(doClick(target));
	}

	public UnitTestActionAssertion<ActivityT> longClick() {
		return perform(doLongClick(target));
	}
	
	private UnitTestActionAssertion<ActivityT> perform(Runnable runnable) {
		return new UnitTestActionAssertion<ActivityT>(testCase, activity, instrumentation, runnable, true);
	}

	public void isVisible() {
		assertEquals("view expected to be VISIBLE, but wasn't", View.VISIBLE, target
				.getVisibility());
	}

	public void isInvisible() {
		assertEquals("view expected to be INVISIBLE, but wasn't", View.INVISIBLE, target
				.getVisibility());
	}

	public void isGone() {
		assertEquals("view expected to be GONE, but wasn't", View.GONE, target.getVisibility());
	}
}
