package stackoverflow.java8mongo;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages = {"stackoverflow.java8mongo.repository"})
public class MongoConfiguration extends AbstractMongoConfiguration {

    @Override
    public CustomConversions customConversions() {
        return new CustomConversions(Arrays.asList(new InstantToLongConverter(), new LongToInstantConverter()));
    }

	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return "tokens";
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		return new MongoClient("127.0.0.1");
	}
}