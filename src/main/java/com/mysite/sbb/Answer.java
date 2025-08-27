package com.mysite.sbb;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    // answer와 question entity 가 연관 -> 두 객체 간의 관계를 생각(1:1, 1:N, M:N)
    // 현재) 질문 - 답글
    // 하나의 질문에 여러 개 답글
    // 1(질문) : N(답글)
    @ManyToOne // java와 db 방식의 차이를 jpa 가 해소
    private Question question;
}
