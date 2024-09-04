package com.study.spring.domain;

import java.time.LocalDateTime;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Message {
	
	// 시퀀스, 메시지넘버
	@Id
	@SequenceGenerator (
			name="mSEQ",
			sequenceName = "M_SQ",
			allocationSize = 1
			)	
	@GeneratedValue(generator="mSEQ")
	private Long mNum;
	
	// member 외래키
	@ManyToOne
    @JoinColumn(name = "memId") 
    private Member member;
	
	// 친구id
	@NonNull
	private String friendId;
	
	// 쪽지 내용
	@NonNull
	private String mContent;
	
	// 작성일
	@NonNull
	private LocalDateTime createSysdate;

}
