package com.study.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import com.study.spring.domain.Message;
import com.study.spring.repository.MessageRepository;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    // 메시지 전송
    public Message sendMessage(Message message) {
    	System.out.println("서"+message);
    	
        return messageRepository.save(message);
    }

 // 수신자가 받은 메시지 리스트 조회 (정렬 포함)
    public List<Message> getReceivedMessages(String friendId) {
        return messageRepository.findByFriendId(friendId, Sort.by(Sort.Direction.ASC, "mNum"));  // mNum 기준 오름차순
    }
    
    // 메시지 삭제
    public void deleteMessage(Long mNum) {
    	messageRepository.deleteById(mNum); 
    }

}
