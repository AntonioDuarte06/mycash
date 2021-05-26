package com.duarte.mycash;

import com.duarte.mycash.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyCashApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(MyCashApplication.class, args);

		UsuarioService service = context.getBean(UsuarioService.class);

		//Criando usuario somente para teste (depois ficará no banco)
		service.registraUsuarioAdmin("admin@mycash.com.br", "admin");
		service.save("user@mycash.com.br", "user");
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
