package com.hello.topic.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hello.topic.vo.TopicVO;

@Repository
public class TopicDAOImpl extends SqlSessionDaoSupport implements TopicDAO {
	
	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public List<TopicVO> readAllTopics() {
		return getSqlSession().selectList("Topic.readAllTopics");
	}

	@Override
	public TopicVO readOneTopicByTopicId(int id) {
		return getSqlSession().selectOne("Topic.readOneTopicByTopicId", id);
	}

	@Override
	public int createNewTopic(TopicVO topicVO) {
		return getSqlSession().insert("Topic.createNewTopic", topicVO);
	}

	@Override
	public int updateOneTopic(TopicVO topicVO) {
		return getSqlSession().update("Topic.updateOneTopic", topicVO);
	}

	@Override
	public int deleteOneTopic(int id) {
		return getSqlSession().delete("Topic.deleteOneTopic", id);
	}

}
