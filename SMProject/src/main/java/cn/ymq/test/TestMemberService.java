package cn.ymq.test;

import java.util.Date;
import java.util.Random;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ymq.service.IMemberService;
import cn.ymq.vo.Member;
import junit.framework.TestCase;

public class TestMemberService {
	private static Random rand = new Random();
	private static ApplicationContext context;
	static {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Test
	public void testAdd() throws Exception{
		Member vo = new Member();
		int idx = rand.nextInt(13231);
		vo.setMid("ID:"+idx);
		vo.setName("张三:"+idx);
		vo.setAge(16);
		vo.setBirthday(new Date());
		vo.setSalary(15555.0);
		vo.setNote("哈哈哈");
		IMemberService service = context.getBean("memberServiceImpl",IMemberService.class);
		TestCase.assertTrue(service.add(vo));
	}
}
