package com.mysite.sbb;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
class QuestionRepositoryTests {

	@Autowired // 테스트 환경에서 필수
	private QuestionRepository questionRepository;

	@Test
	@DisplayName("findAll")
	void t1() {
		List<Question> all = this.questionRepository.findAll();
		assertEquals(2, all.size());

		Question q = all.get(0);
		assertEquals("sbb가 무엇인가요?", q.getSubject());
	}

	@Test
	@DisplayName("findById")
	void t2() {
		// findById -> Optional 로 가져온다
		Optional<Question> oq = this.questionRepository.findById(1);

		// 존재하는지 체크 -> 나오면 true
		if(oq.isPresent()) {
			Question q = oq.get();
			assertEquals("sbb가 무엇인가요?", q.getSubject());
		}
	}

	// 일반적이지 않은 경우 - 정의해야함
	@Test
	@DisplayName("findBySubject")
	void t3() {
		Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?").get();
		assertEquals(1, q.getId());
	}

}
