package com.study.spring.controller;

import java.util.List;

import com.study.spring.domain.Message;
import com.study.spring.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;  // 서비스 주입

    // 메시지 전송 API
    @PostMapping("/send")
    public Message sendMessage(@RequestBody Message message) {
        return messageService.sendMessage(message);  // 메시지 전송
    }

    // 특정 사용자가 받은 메시지 조회 API
    @GetMapping("/received/{receiver}")
    public List<Message> getReceivedMessages(@PathVariable String receiver) {
        return messageService.getReceivedMessages(receiver);  // 받은 메시지 조회
    }

    // 새로운 메시지가 있는지 확인하는 API
    @GetMapping("/has-new-message/{receiver}")
    public Map<String, Boolean> hasNewMessage(@PathVariable String receiver, @RequestParam("lastChecked") String lastChecked) {
        LocalDateTime lastCheckedTime = LocalDateTime.parse(lastChecked);  // 마지막으로 확인한 시간 파싱
        boolean hasNew = messageService.hasNewMessage(receiver, lastCheckedTime);
        Map<String, Boolean> response = new HashMap<>();
        response.put("hasNewMessage", hasNew);
        return response;  // 새로운 메시지가 있는지 여부 반환
    }
}