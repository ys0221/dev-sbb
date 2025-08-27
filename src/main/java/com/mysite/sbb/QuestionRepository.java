package com.mysite.sbb;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    // 중복 가능성 -> 원래는 List 로 하는 게 맞음
    // 아예 없을 수도 있으니까 Optional 로 선언
    Optional<Question> findBySubject(String subject);
    Optional<Question> findBySubjectAndContent(String subject1, String subject2);
    // Like - 무조건 중복 : List 로 반환
    List<Question> findBySubjectLike(String subject);
}