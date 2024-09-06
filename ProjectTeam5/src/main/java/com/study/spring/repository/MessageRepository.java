package com.study.spring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;

import com.study.spring.domain.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
	
    // 특정 사용자가 받은 모든 메시지 조회(정렬)
	List<Message> findByFriendId(String friendId, Sort sort);

}
