package com.example.servingwebcontent;

import org.junit.jupiter.api.Test;

import com.example.servingwebcontent.model.*;

public class ServingWebContentApplicationTest {

	@Test
	public void testModel() throws Exception {
		TestUser.test();
        TestProduct.test();
		TestCategory.test();
	}
}