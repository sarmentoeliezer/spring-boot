/**
 * 
 */
package com.estudo.job;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author eliezer
 *
 */
public class QuartzMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Job
		JobDetail job = JobBuilder.newJob(QuartzJob.class).build();

		// Trigger
//		Trigger t = TriggerBuilder.newTrigger().withIdentity("SimpleTrigger").startNow().build();
//		Trigger t = TriggerBuilder.newTrigger().withIdentity("CronSchedule").withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ? *")).build();
		Trigger t = TriggerBuilder.newTrigger().withIdentity("CronSchedule!!!").
				withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5)).build();
		
		Trigger t2 = TriggerBuilder.newTrigger().withIdentity("CronSchedule33!!!").
				withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(1)).build();
		
		
		// Scheduler
		Scheduler s;
		try {
			s = StdSchedulerFactory.getDefaultScheduler();
			s.start();
			s.scheduleJob(job, t);
			
			Thread.sleep(1000*10);
			System.out.println("----------------------------");
			s.shutdown();
			Thread.sleep(1000*10);
			System.out.println("----------------------------");
			s = StdSchedulerFactory.getDefaultScheduler();
			s.start();
			s.scheduleJob(job, t2);
		} catch (SchedulerException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
