package com.comradegenrr.officehander.officehander.config;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "autoclean",name = "enable",havingValue = "true")
public class AutoClean {

    @Scheduled(fixedDelay = 50000)
    public void autoClean(){
        Logger logger = LoggerFactory.getLogger(AutoClean.class);
        logger.info("开始执行自动清理任务");
        Process process;
        try {
            process = Runtime.getRuntime().exec("*.xlsx");
            process.waitFor();
        } catch (IOException e) {
            logger.info("没有可清除的文件");
        } catch (InterruptedException e) {
            logger.info("没有可清除的文件");
            e.printStackTrace();
        }
        logger.info("清理完毕");
    }
    
}
