package com.nowcoder.community;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author CHEN YANJIN
 * @date 2022/6/19 9:59
 */
@SpringBootTest
public class LoggerTest {

 private static final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

 @Test
    public void testLogger(){
     System.out.println(logger.getName());

     logger.debug("debug log");
     logger.info("info log");
     logger.warn("warn log");
     logger.error("error log");
 }


}
