package com.edu.finance.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PustCompanyListTask {

	/**
	 * 【秒】   【分】  【时】   【日】  【月】   【周】  【年】
	 * @Scheduled(cron="0/5 * *  * * ? ")   //每5秒执行一次
	 */
	
	final static Logger  logger = LoggerFactory.getLogger(PustCompanyListTask.class); 

	//@Scheduled(cron = "0 0 12 * * ? ") // 每天中午十二点触发
	//每天的0点、13点、18点、21点都执行一次：0 0 0,13,18,21 * * ?
	//每隔1分钟执行一次：0 */1 * * * ?
	@Scheduled(cron = "0 */1 * * * ?")
    public void pustCompanyList() {
		System.out.println("pustCompanyList is tasking");
    }
}
