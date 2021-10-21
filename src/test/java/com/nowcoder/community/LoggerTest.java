package com.nowcoder.community;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class LoggerTest {

    @Test
    public void testLogger() {
        Logger logger = LoggerFactory.getLogger("LoggerTest.class");
        logger.debug("debug logger");
        logger.warn("warn logger");
        logger.error("errpr logger");
    }
}
