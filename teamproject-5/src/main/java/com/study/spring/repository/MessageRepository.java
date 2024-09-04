package com.study.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.spring.domain.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
	// 특정 사용자가 받은 메시지를 모두 조회하는 메서드
    List<Message> findByReceiver(String receiver);
}
