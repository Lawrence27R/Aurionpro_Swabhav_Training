import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aurionpro.model.Computer;

public class ComputerTest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Computer computer = context.getBean(Computer.class);
		System.out.println(computer);
	}
}
