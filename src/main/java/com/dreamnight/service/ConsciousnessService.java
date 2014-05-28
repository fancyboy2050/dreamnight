package com.dreamnight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dreamnight.dao.ConsciousnessDao;
import com.dreamnight.model.Consciousness;

/**
 * @author tianbenzhen@pwrd.com
 * @version 2014-5-27 下午8:16:40
 */
@Component
public class ConsciousnessService {
	
	@Autowired
	private ConsciousnessDao consciousnessDao;
	
	/**
	 * 发布consciousness
	 * @param consciousness
	 * @return
	 */
	public Consciousness addConsciousness(Consciousness consciousness){
		consciousnessDao.create(consciousness);
		return consciousness;
	}
	
	/**
	 * 检测当天是否已经发过consciousness
	 * @param userId
	 * @return
	 */
	public boolean checkDayOfConsciousness(Long userId){
		return consciousnessDao.countByUserCurday(userId) > 0;
	}
	
	/**
	 * 用户的所有consciousness
	 * @param userId
	 * @return
	 */
	public List<Consciousness> getUsersAll(Long userId){
		return consciousnessDao.all(userId);
	}

}
