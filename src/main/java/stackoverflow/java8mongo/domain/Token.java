package stackoverflow.java8mongo.domain;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="tokens")
public class Token {

	@Field("name")
	private String name;
	
	@Field("created_at")
	private Instant createdAt;
	
	@PersistenceConstructor
	public Token(@Value("#root.name")String name) { 
//			@Value("#root.created_at") Instant createdAt){
		super();
		this.name = name;
//		this.createdAt = createdAt;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Token [name=%s, createdAt=%s],", name, createdAt);
	}

}
