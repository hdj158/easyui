package com.easy.utils;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
public class HotWaterTask {

	
	public void getMsg() {
		System.out.println("执行任务中》》》》"+new Date());
	}

}
