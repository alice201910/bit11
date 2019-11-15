package org.zerock.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/security-context.xml")
@Log4j
public class EncoderTests {
	
	@Autowired
	private BCryptPasswordEncoder encoder; //encode만 있고 decode가 없음. -> DB에 암호화된 문장 저장 하면 원문 뭔지 모름

	@Test
	public void test2() {
		String text = "$2a$10$vwzRz6KZtnP4JIdEzmIaUeGjtwkviafGuHOWzIkKFe0z3EGsMJcbW";
		//올바르게 encode 되었는지?
		boolean result = encoder.matches("abcde", text); //원본은 뭔지 모르겠지만 원본패스워드와 encode한 패스워드가 같은 쌍?
		log.info(result);
	}
	
	@Test
	public void test1() {
		
		//1.주입이 되는가? - 성공
		log.info(encoder);
		
		String text = "abcde";
		//인코딩
		String en1 = encoder.encode(text);
		
		log.info(en1);
		
		String en2 = encoder.encode(text); // 똑같은 값을 넣었지만 다른 값이 나옴
		
		log.info(en2);
		
	}
	
}
