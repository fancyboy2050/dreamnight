package com.dreamnight.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.dreamnight.model.User;

/**
 * @author tianbenzhen@pwrd.com
 * @version 2014-5-27 下午7:56:02
 */
public interface UserDao {
	
	@Insert("insert into user (email, password, salt, nickname, create_time) values (#{email}, #{password}, #{salt}, #{nickname}, now()")
	public User create(User user);
	
	@Select("select * from user where id = #{id}")
	public User get(@Param("id")Long id);
	
}
