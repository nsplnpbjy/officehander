package com.comradegenrr.officehander.officehander.config;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AutoClean {

    @Scheduled(cron = "* * * 1/1 * ?")
    public void autoClean() throws IOException, InterruptedException{
        Logger logger = LoggerFactory.getLogger(AutoClean.class);
        logger.info("开始执行自动清理任务");
        Process process = Runtime.getRuntime().exec("*.xlsx");
        process.waitFor();
        logger.info("清理完毕");
    }
    
}
