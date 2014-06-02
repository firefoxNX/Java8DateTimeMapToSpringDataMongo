package stackoverflow.java8mongo;

import java.time.Instant;

import org.springframework.core.convert.converter.Converter;

public class LongToInstantConverter implements Converter<Long, Instant> {
    @Override
    public Instant convert(Long source) {
        return Instant.ofEpochMilli(source);
    }
}