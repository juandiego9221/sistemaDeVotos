package pe.com.jdmm21.example.demoVote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DemoVoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoVoteApplication.class, args);
	}

}
