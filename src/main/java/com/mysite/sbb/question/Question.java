package com.mysite.sbb.question;

import com.mysite.sbb.answer.Answer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
// entity 때문에 question 은 table 이 되어야함

public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200) // varchar(200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    // fetch=FetchType.EAGER -> table 을 join 해서 가져옴
    // EAGER -> 필요한 방식을 미리 로딩 - 불필요한 경우에도 데이터를 다 가져옴
    // 기본 타입 -> fetch=FetchType.LAZY : 필요하면 DB를 다시 보겠다
    @OneToMany(mappedBy = "question", fetch=FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<Answer> answers = new ArrayList<>(); // 현재 Null 이 들어있음 -> new 로 초기화해줘야함(객체 추가를 위해서)

    public void addAnswer(String content) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setQuestion(this);
        answers.add(answer);
    }
}
