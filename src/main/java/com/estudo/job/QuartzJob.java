package com.estudo.job;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class QuartzJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		System.out.println("-------------> "+context.getTrigger().toString()+" Meu primeiro Quartz -> " + new Date());
		
	}

}
