package com.edu.finance.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExampleJob {

	public void execute(){  
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").
        		format(new Date()) + "执行ExampleJob2");  
    }  
}
