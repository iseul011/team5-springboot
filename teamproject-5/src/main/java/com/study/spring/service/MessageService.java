package com.study.spring.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.spring.domain.Message;
import com.study.spring.repository.MessageRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service  // Service 레이어 명시
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;  // Repository 주입

    // 메시지 전송 메서드
    public Message sendMessage(Message message) {
        message.setCreateSysdate(LocalDateTime.now());  // 전송 시간 설정
        return messageRepository.save(message);    // 메시지 저장
    }

    // 수신자가 받은 메시지 리스트를 조회
    public List<Message> getReceivedMessages(String receiver) {
        return messageRepository.findByReceiver(receiver);
    }

    // 새로운 메시지가 있는지 확인하는 메서드
    public boolean hasNewMessage(String receiver, LocalDateTime lastChecked) {
        List<Message> messages = messageRepository.findByReceiver(receiver);
        // 새로운 메시지가 있는지 확인 (마지막으로 확인한 시간 이후의 메시지 여부)
        return messages.stream().anyMatch(msg -> msg.getSentTime().isAfter(lastChecked));
    }
}