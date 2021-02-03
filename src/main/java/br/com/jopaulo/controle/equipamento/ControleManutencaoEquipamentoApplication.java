package br.com.jopaulo.controle.equipamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EntityScan(basePackages = "br.com.jopaulo.controle.equipamento.model")
@ComponentScan(basePackages = "br.*")
@EnableJpaRepositories(basePackages = "br.com.jopaulo.controle.equipamento.repository")
@EnableTransactionManagement
@EnableWebMvc
public class ControleManutencaoEquipamentoApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(ControleManutencaoEquipamentoApplication.class, args);		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String result = encoder.encode("1234");
		System.out.println(result);
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("/login");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}

}
