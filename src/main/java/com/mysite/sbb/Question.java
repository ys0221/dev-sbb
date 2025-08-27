package com.mysite.sbb;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
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

    // 클래스간의 힌트 주기 -> @OneToMany
    // 얘는 Column 이 안 생김!
    // 왜냐? 리스트는 여러 개의 값을 갖고 있는데 column 안에는
    // 하나의 값 밖에 넣을 수가 없다!
    // Question_Answers 라는 새로운 테이블을 만들어 해결해줌
    // 따라서 관계만 잘 설정하면 된다

    // mappedBy -> 외래키를 만들 필요가 없음을 알려줌 -> 테이블(Question_Answers) 안 생김
    // answer 입장에서 question 필요 / question 입장에서 answer 필수 아님 -> OneToMany 안 해도 됨
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answers;

}
