package com.datafin.risk.controller.publish;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 接入企业信息测试
 * @author jiwenlong
 *
 */
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml","classpath:spring-mvc.xml"})
public class DataApiControllerTest extends AbstractTestNGSpringContextTests {
	
	@Autowired
	//private AYXApiController aYXApiController;
	
	private Logger logger = LogManager.getLogger(DataApiControllerTest.class);
	
	private MockMvc mockMvc;
	
	@BeforeClass
	public void beforeClass() {
		
		MockitoAnnotations.initMocks(this);
		//mockMvc = MockMvcBuilders.standaloneSetup(aYXApiController).build();
	}
	
	@Test
	public void visitWithoutTomcat() throws Exception{	

		MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.post("/api/ayx/pushData")
				.param("account", "lry-test")
				.param("accessKey", "US1lO8VlvSpN4QFPPYmrsQ==")

				)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn().getResponse();
		response.setCharacterEncoding("UTF-8");
		Thread.sleep(30000000);
		logger.info("*******************************" + response.getContentAsString());
		
	}
	
//	public static void main(String[] args) {
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("account", "yonyou-test");
//		params.put("accessKey", "US1lO8VlvSpN4QFPPYmrsQ==");
//		params.put("sName", "张三测试有限公司");
//		
//		
//		System.out.println(RequestTools.httpPost("http://localhost:8080/credit/api/companyInfo/entEncounterInfo", params));
//	}

}
