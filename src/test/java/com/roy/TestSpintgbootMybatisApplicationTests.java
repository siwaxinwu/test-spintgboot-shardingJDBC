package com.roy;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.roy.bean.Course;
import com.roy.bean.Udict;
import com.roy.bean.User;
import com.roy.mapper.CourseMapper;
import com.roy.mapper.UdictMapper;
import com.roy.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestSpintgbootMybatisApplicationTests {

		@Autowired(required = false)
		CourseMapper courseMapper;

		@Autowired(required = false)
		UserMapper userMapper;

		@Autowired
		UdictMapper udictMapper;



		/**
		 * 水平分表测试插入10条数据
		 */
		@Test
		void testAddCourse() {
				for (int i = 0; i < 10; i++) {
						Course course = new Course();
						course.setCname("java" + i);
						course.setCstatus("normal" + i);
						course.setUserId(1000L);
						int result = courseMapper.insert(course);
				}
		}

		/**
		 * 水平分表以后做查询的测试，在代码里面是无感知的
		 */
		@Test
		void testfindOne() {
				QueryWrapper<Course> wrapper = new QueryWrapper<>();
				wrapper.eq("cid", 544496628162101248L);
				Course course = courseMapper.selectOne(wrapper);
				System.out.println(course);
		}

		/**
		 * 测试水平分库,插入数据
		 */
		@Test
		void testAddCourse1() {
				for (int i = 0; i < 10; i++) {
						Course course = new Course();
						course.setCname("javaDemo" + i);
						course.setCstatus("normal" + i);
						course.setUserId(3001L);
						int result = courseMapper.insert(course);
				}
		}

		/**
		 * 水平分库查询
		 */
		@Test
		void testfindOne1() {
				QueryWrapper<Course> wrapper = new QueryWrapper<>();
				wrapper.eq("cid", 544556077203587073L).eq("user_id", 3001L);
				Course course = courseMapper.selectOne(wrapper);
				System.out.println(course);
		}


		/**
		 * 测试垂直分库，添加数据
		 */
		@Test
		void testAddUser() {
				User user = new User();
				user.setUsername("jack");
				user.setUstatus("a");
				int result = userMapper.insert(user);
				System.out.println(result);
		}

		/**
		 * 垂直分库查询
		 */
		@Test
		void testfindUser() {
				QueryWrapper<User> wrapper = new QueryWrapper<>();
				wrapper.eq("user_id", 544581030607060993L);
				User user = userMapper.selectOne(wrapper);
				System.out.println(user);
		}

		/**
		 * 公共表操作添加数据，会一起添加
		 */
		@Test
		void testAddCommon() {
				Udict udict = new Udict();
				udict.setUstatus("a");
				udict.setUvalue("已启用");
				int result = udictMapper.insert(udict);
				System.out.println(result);
		}

		/**
		 * 公共表删除数据，会一起删除
		 */
		@Test
		void deleteUdict() {
				QueryWrapper<Udict> wrapper = new QueryWrapper<>();
				wrapper.eq("dictid", 544597719063199745L);
				int result = udictMapper.delete(wrapper);
				System.out.println(result);
		}
}
