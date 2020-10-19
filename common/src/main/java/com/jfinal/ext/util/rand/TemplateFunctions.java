package com.jfinal.ext.util.rand;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class TemplateFunctions {

	// //////////////////////////////////产生随机数//////////////////////////////////
	private static final AtomicInteger bgNum = new AtomicInteger(0);

	public static int bgNum(int num) {
		if (bgNum.get() > num) {
			bgNum.set(0);
		}
		bgNum.incrementAndGet();
		return bgNum.get();
	}

	public static int randomInt() {
		return new Random().nextInt();
	}

	public static int randomInt(int num) {
		return new Random().nextInt(num);
	}

}
