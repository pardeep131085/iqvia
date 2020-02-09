package com.iqvia.com.iqvia.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iqvia.com.iqvia.util.AppConstants;

/**
 * Job that will print the message on console on specified time
 * 
 * @author Pardeep
 *
 */
public class MessageJob implements Job {
	private static Logger LOG = LoggerFactory.getLogger(MessageJob.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDataMap dataMap = context.getTrigger().getJobDataMap();
		LOG.info("Incoming Message:" + dataMap.getString(AppConstants.MESSAGE));
	}

}
