package org.mateusjose98.simplechat;

import org.mateusjose98.simplechat.entity.Users;
import org.mateusjose98.simplechat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleChatApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SimpleChatApplication.class, args);
    }
    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
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
