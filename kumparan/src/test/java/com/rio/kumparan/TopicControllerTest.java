package com.rio.kumparan;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.rio.kumparan.controller.TopicController;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
@RunWith(MockitoJUnitRunner.class)
public class TopicControllerTest {
	
	@Mock
	private TopicController topicController;
	
	@Test
	public void test() throws Exception {
		when(topicController.getTopics()).equals(null);
	}

	/*private MockMvc mockMvc;

	@InjectMocks
	private TopicController topicController;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(topicController).build();
	}

	@Test
	public void test() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/topics/")).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void getTopics() throws Exception {
		String uri = "/topics/";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
	}*/
}
