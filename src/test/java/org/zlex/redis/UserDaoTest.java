package org.zlex.redis;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zlex.redis.dao.UserDao;
import org.zlex.redis.domain.User;

public class UserDaoTest {
	private ApplicationContext app;
	private UserDao userDao;
    String address1 = "成都-成都";
    String uid = "u123456";
    User user = new User();
	@Before
	public void before() throws Exception {
		app = new ClassPathXmlApplicationContext("applicationContext.xml");
		userDao = (UserDao) app.getBean("userDao");
	}

    @Test
    public void testCreate(){
        // -------------- Create ---------------
        user.setAddress(address1);
        user.setUid(uid);
        userDao.save(user);
    }

    @Test
    public void testRead(){
        // ---------------Read ---------------
        user = userDao.read(uid);
        assertEquals(address1, user.getAddress());
        System.out.println(user.getAddress());
    }
	@Test
	public void Update() {
		// --------------Update ------------
		String address2 = "北京";
		user.setAddress(address2);
		userDao.save(user);
		user = userDao.read(uid);
		assertEquals(address2, user.getAddress());
        System.out.println(address2+","+user.getAddress());
	}
    @Test
    public void testDel(){
        // --------------Delete ------------
		userDao.delete(uid);
		user = userDao.read(uid);
		assertNull(user);
    }
}
