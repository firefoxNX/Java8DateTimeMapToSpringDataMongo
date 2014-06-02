package stackoverflow.java8mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import stackoverflow.java8mongo.domain.Token;

public interface TokenRepository extends MongoRepository<Token, String> {


}
