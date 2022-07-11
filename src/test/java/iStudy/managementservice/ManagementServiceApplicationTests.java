package iStudy.managementservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class ManagementServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void findAllBeans() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ManagementServiceApplication.class);
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

			if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
				Object bean = ac.getBean(beanDefinitionName);
				System.out.println("name = " + beanDefinitionName + " object=" + bean);
			}
		}
	}
}
