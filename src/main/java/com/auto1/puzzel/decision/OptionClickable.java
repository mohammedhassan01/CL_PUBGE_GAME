package com.auto1.puzzel.decision;


public interface OptionClickable {
	boolean preProcess();
	boolean process();
	Object postProcess();
}
