package com.dreamnight.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.dreamnight.model.Consciousness;

public interface ConsciousnessDao {
	
	@Insert("insert into consciousness (user_id, content, create_time) values (#{userId}, #{content}, #{createTime})")
	public Consciousness create(Consciousness consciousness);
	
	@Select("select count(*) from consciousness where user_id = #{userId} and date(create_time) = curdate()")
	public int countByUserCurday(@Param("userId")Long userId);
	
	@Select("select * from consciousness where user_id = #{userId}")
	public List<Consciousness> all(@Param("userId")Long userId);

}
