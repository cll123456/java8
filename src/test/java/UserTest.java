
/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

import com.App;
import com.entity.User;
import com.entity.UserExample;
import com.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 这是测试User接口的
 *
 * @author Cll
 * @date 2018/10/11 18:15
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class) // 这里的Application是springboot的启动类名
public class UserTest {
	@Autowired
	private UserService userService;

	@Test
	public void insert() {
		User user = new User();
		user.setUserId(7L);
		user.setUserName("王大锤");
		user.setUserAge(21);
		user.setDescription("我叫王大锤，今天18岁。家住红谷滩。");
		System.out.println(userService.insert(user));
	}

	@Test
	public void insertSelective() {
		User user = new User();
		user.setUserId(11L);
		user.setUserName("小明");
		userService.insertSelective(user);
	}

	@Test
	public void selectByPrimaryKey() {
		User user = new User();
		System.out.println(userService.selectByPrimaryKey(1L));
	}

	@Test
	public void updateByPrimaryKeySelective() {
		User user = new User();
		user.setUserId(1L);
		user.setUserName("cll");

		System.out.println(userService.updateByPrimaryKeySelective(user));
	}

	@Test
	public void updateByPrimaryKey() {
		User user = new User();
		user.setUserId(1L);
		user.setUserName("love");
		user.setUserAge(23);
		System.out.println(userService.updateByPrimaryKey(user));
	}

	@Test
	public void selectByExample() {
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andUserAgeBetween(1, 30);
		userExample.setOrderByClause("'user_id' ASC,'user_name' DESC");
		userExample.setDistinct(true);
//		PageHelper.startPage(1,2);
//	    List<User> list = userService.selectByExample(userExample);
//		for (User user : list) {
//			System.out.println(user);
//		}
		userExample.setLimit(1);
		userExample.setOffset(4);
		List<User> list = userService.selectByExample(userExample);
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Test
	public void selectByExampleWithBLOBs() {
		UserExample userExample = new UserExample();
		// UserExample.Criteria criteria = userExample.createCriteria();
		// criteria.andUserAgeBetween(1,30);
		userExample.setOrderByClause("'user_id' ASC,'user_age' DESC");
		userExample.or().andUserIdEqualTo(3L).andUserNameLike("%");
		userExample.setDistinct(true);
		userService.selectByExampleWithBLOBs(userExample)
				.forEach(System.out::println);
	}

	@Test
	public void countByExample() {
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andUserAgeBetween(1,23);
        System.out.println(userService.countByExample(userExample));
    }

	@Test
	public void deleteByExample() {
		UserExample userExample = new UserExample();
		userExample.or().andUserAgeEqualTo(23);
		userService.deleteByExample(userExample);
	}

}
