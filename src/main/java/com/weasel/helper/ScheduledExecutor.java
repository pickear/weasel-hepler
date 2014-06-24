package com.weasel.helper;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author Dylan
 * @time 2013-10-15
 */
public class ScheduledExecutor {
	

	private static ScheduledExecutorService service;
	
	static{
		service = Executors.newScheduledThreadPool(3, new ThreadFactory() {
			public Thread newThread(Runnable r) {
				Thread thread = new Thread(r);
				thread.setDaemon(true);
				return thread;
			}
		});
	}
	
	
	/**
	 * @param task
	 * @param intervalMinutes
	 */
	public static void submitTask(Runnable task,long intervalMinutes){
		service.scheduleWithFixedDelay(task, 0, intervalMinutes, TimeUnit.MINUTES);
	}
	
	
}
