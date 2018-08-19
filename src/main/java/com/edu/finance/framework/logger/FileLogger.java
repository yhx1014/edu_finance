package com.edu.finance.framework.logger;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

import com.edu.finance.util.Toolkit;

/**
 * 
 * 单独生成日志文件
 *
 */
public class FileLogger {
	
	/**
	 * 只传name，其他使用默认值
	 * @param name
	 * @return
	 */
	public static Logger getFileLogger(String name){
		return FileLogger.getFileLogger(name, Level.INFO, false, 20, "10MB");
	}
	
	
	/**
	 * 在tomcat的log下生成logger名称的日志文件
	 * @param name  logger的名称
	 * @param level 级别
	 * @param isAdditivity 是否继承root
	 * @param maxBackups 最大备份数
	 * @param maxFileSize 文件大小(KB MB GB)
	 * @return
	 */
	public static synchronized Logger getFileLogger(String name, Level level, boolean isAdditivity, int maxBackups, String maxFileSize) {
        Logger logger = Logger.getLogger(name);
        if (logger.getAllAppenders().hasMoreElements()){
        	return logger;
        }
        
        logger.removeAllAppenders();
        logger.setLevel(level);
        logger.setAdditivity(isAdditivity);
        // 生成新的Appender
        RollingFileAppender appender = new RollingFileAppender();
        
        // log的输出形式
        PatternLayout layout = new PatternLayout();
        layout.setConversionPattern("[%-5p] %d{yyyy-MM-dd HH:mm:ss,SSS} $$thread=[%t] %M(%L):%m%n");
        appender.setLayout(layout);
        // log输出路径
        // 这里使用了环境变量[catalina.home]，只有在tomcat环境下才可以取到
        String tomcatPath = java.lang.System.getProperty("catalina.home");
        if (Toolkit.isEmpty(tomcatPath)){
        	tomcatPath = ".";
        }
        appender.setFile(tomcatPath + "/logs/" + name + ".log");
        appender.setMaxBackupIndex(maxBackups);
        appender.setMaxFileSize(maxFileSize);
        appender.setEncoding("UTF-8");
        appender.setAppend(true);
        // 适用当前配置
        appender.activateOptions();
        // 将新的Appender加到Logger中
        logger.addAppender(appender);
        return logger;
    }
}
