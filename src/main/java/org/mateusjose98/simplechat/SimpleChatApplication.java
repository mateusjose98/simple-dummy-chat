package org.mateusjose98.simplechat;

import org.mateusjose98.simplechat.entity.Users;
import org.mateusjose98.simplechat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SimpleChatApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SimpleChatApplication.class, args);
    }
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Environment environment;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("URL: " + environment.getProperty("spring.datasource.url"));
        System.out.println("Username: " + environment.getProperty("spring.datasource.username"));
        environment.getProperty("spring.datasource.url");
        environment.getProperty("spring.datasource.username");

        Users joao = new Users();
        joao.setEmail("joao@email.com");
        joao.setName("João");
        userRepository.save(joao);

        Users maria = new Users();
        maria.setEmail("maria@email.com");
        maria.setName("Maria");
        userRepository.save(maria);

        Users jose = new Users();
        jose.setEmail("josé@email.com");
        jose.setName("José");
        userRepository.save(jose);

    }
}
