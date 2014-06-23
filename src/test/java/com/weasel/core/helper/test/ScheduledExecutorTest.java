package com.weasel.core.helper.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.weasel.lang.helper.ScheduledExecutor;


/**
 * @author Dylan
 * @time 2013-10-15
 */
public class ScheduledExecutorTest implements Runnable{

	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		ScheduledExecutor.submitTask(new ScheduledExecutorTest(), 1);
		try {
			Thread.currentThread().sleep(100000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		System.out.println("task runing in " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}
}
