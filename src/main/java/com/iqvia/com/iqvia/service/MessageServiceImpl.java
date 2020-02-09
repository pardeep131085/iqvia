package com.iqvia.com.iqvia.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import com.iqvia.com.iqvia.util.AppConstants;

/**
 * Implementation of Service class
 * 
 * @author Pardeep
 *
 */
@Service
public class MessageServiceImpl implements MessageService {

	private static Logger LOG = LoggerFactory.getLogger(MessageServiceImpl.class);
	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;
	@Autowired
	private JobDetailFactoryBean detailFactoryBean;
	@Override
	public boolean scheduleMessage(String timestamp, String content) {

		LocalDateTime dateTime = LocalDateTime.parse(timestamp);
		Date date = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());

		Trigger trigger = TriggerBuilder.newTrigger().usingJobData(AppConstants.MESSAGE, content)
				.usingJobData(AppConstants.TIME, date.toString()).forJob(detailFactoryBean.getObject())
				.withIdentity("messageTrigger" + LocalDateTime.now()).startAt(date).build();

		Date ft = null;
		try {
			if (this.schedulerFactoryBean.getScheduler().checkExists(detailFactoryBean.getObject().getKey())) {
				ft = this.schedulerFactoryBean.getScheduler().scheduleJob(trigger);
			} else
				ft = this.schedulerFactoryBean.getScheduler().scheduleJob(detailFactoryBean.getObject(), trigger);
		} catch (SchedulerException e) {
			LOG.error(e.getMessage());
			return false;
		}

		LOG.info(detailFactoryBean.getObject().getDescription() + " has been scheduled to run at: " + ft);
		
		return true;

	}

}
