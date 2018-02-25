package com.lh.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.lh.config.ApplicationConfig;
import com.lh.pojo.Role;
import com.lh.pojo.User;

/**
 *
 * @author liuhao
 * @date 2017-12-08 11:17:07
 */
public class SpringTest {
	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
		User u  = jdbcTemplate.queryForObject("select * from user where id=1 ", new RowMapper<User>() {

			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					User  u= new User();
					u.setName(rs.getString("name"));
				return u;
			}
			
		});
		List<User> ls = jdbcTemplate.query("select * from user where name like  ? ", new Object[] {"��ҹ�ǳ�"}, new RowMapper<User>() {

			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					User  u= new User();
					u.setName(rs.getString("name"));
				return u;
			}
			
		});
		for (int i = 0; i < ls.size(); i++) {
			System.out.println(ls.get(i).getName());
		}
		System.out.println(u.getName());
		Map<String, Object> map = jdbcTemplate.queryForMap("select * from user where id=1");
		System.out.println("queryformap" + map.get("name"));
		
//		User user1 = (User) context.getBean("user1");
//		User user2 = (User) context.getBean("user2");
//		System.out.println(user2.getName());
	}
	//����ע���ȡbean
	@Test
	public void testAnnotation() {
//		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		//AnnotationConfigApplicationContext����һ����������λ����
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class); 
		Role role = context.getBean(Role.class);
		System.out.println(role.getRole_name());
	}
}
