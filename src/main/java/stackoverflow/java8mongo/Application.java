package stackoverflow.java8mongo;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import stackoverflow.java8mongo.domain.Token;
import stackoverflow.java8mongo.repository.TokenRepository;

@EnableAutoConfiguration
@ComponentScan(basePackages = "stackoverflow.java8mongo")
public class Application implements CommandLineRunner {
	
	@Autowired
	private TokenRepository tokenRepository;
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Override
	public void run(String... args) throws Exception {
    	tokenRepository.deleteAll();
    	
    	Token token = new Token("t1");
    	token.setCreatedAt(Instant.now());
    	tokenRepository.save(token);
    	
    	token = new Token("t2");
    	token.setCreatedAt(Instant.now());
    	tokenRepository.save(token);
    	
    	token = new Token("t3");
    	token.setCreatedAt(Instant.now());
    	tokenRepository.save(token);
    	
    	System.out.println("Find all tokens");
    	for(Token token1: tokenRepository.findAll()){
    		System.out.println(token1);
    	}
    }
}
