package com.iqvia.com.iqvia.config;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.iqvia.com.iqvia.job.MessageJob;

/**
 * <p>
 * Configuration file for config application context, creating
 * SchedulerFactoryBean bean and other required beans
 * </p>
 * 
 * @author Pardeep
 *
 */
@Configuration
public class Config {
	private ApplicationContext applicationContext;
	private DataSource dataSource;

	public Config(ApplicationContext applicationContext, DataSource dataSource) {
		this.applicationContext = applicationContext;
		this.dataSource = dataSource;
	}

	@Bean
	public AutowiringSpringBeanJobFactory jobFactory() {
		AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
		jobFactory.setApplicationContext(applicationContext);
		return jobFactory;
	}

	/**
	 * Scheduler Factory bean that returns Scheduler for Scheduling Job
	 * 
	 * @param jobFactory
	 * @return
	 */
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean(AutowiringSpringBeanJobFactory jobFactory) {
		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		schedulerFactoryBean.setConfigLocation(new ClassPathResource("quartz.properties"));
		schedulerFactoryBean.setOverwriteExistingJobs(true);
		schedulerFactoryBean.setAutoStartup(true);
		schedulerFactoryBean.setDataSource(this.dataSource);
		schedulerFactoryBean.setWaitForJobsToCompleteOnShutdown(true);
		schedulerFactoryBean.setJobFactory(jobFactory);
		return schedulerFactoryBean;
	}

	/**
	 * Job Detail Factory bean
	 * 
	 * @return
	 */
	@Bean
	public JobDetailFactoryBean jobDetailFactoryBean() {
		JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
		factoryBean.setJobClass(MessageJob.class);
		factoryBean.setDurability(true);
		factoryBean.setName("messageSchJob");
		factoryBean.setDescription("This is message Schedule Job");
		return factoryBean;
	}

}
