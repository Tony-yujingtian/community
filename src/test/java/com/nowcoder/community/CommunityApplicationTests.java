package com.nowcoder.community;

import com.nowcoder.community.dao.AlapherDao;
import com.nowcoder.community.service.AlapherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
			this.applicationContext = applicationContext;
	}

	@Test
	public void testApplication() {
		System.out.println(applicationContext);
		AlapherDao alapherDao = applicationContext.getBean(AlapherDao.class);
		System.out.println(alapherDao.select());
		alapherDao = applicationContext.getBean("alapherhebinate",AlapherDao.class);
		System.out.println(alapherDao.select());
	}

	@Test
	public void testBeanMangement () {
		AlapherService alapherService = applicationContext.getBean(AlapherService.class);
		System.out.println(alapherService);
		alapherService = applicationContext.getBean(AlapherService.class);
		System.out.println(alapherService);
	}

	@Test
	public void testBeanConfig () {
		SimpleDateFormat simpleDateFormat = applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));
	}

	@Autowired
	@Qualifier("alapherhebinate")
	private AlapherDao alapherDao;

	@Autowired
	private AlapherService alapherService;

	@Autowired
	private SimpleDateFormat simpleDateFormat;

	@Test
	public void testDI () {
		System.out.println(alapherDao.select());
		System.out.println(alapherService);
		System.out.println(simpleDateFormat);
	}
}
