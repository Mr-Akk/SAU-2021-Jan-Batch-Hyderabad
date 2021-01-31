package com.accolite.ordermanager;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrdermanagerApplicationTests {

		@InjectMocks
		OrdermanagerApplication ordermanagerApplication;
		
		@Test
		public void checkMain() {
			ordermanagerApplication.main(new String[] {});
		}

}
