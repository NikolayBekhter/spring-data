package ru.geekbrains.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import ru.geekbrains.model.Basket;

@Configuration
@ComponentScan("ru.geekbrains")
@EnableRedisRepositories(basePackages = "ru.geekbrains.repository")
@PropertySource("classpath:application.yml")
public class BasketConfig {
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }
    @Bean
    public RedisTemplate<String, Basket> redisTemplate() {
        final RedisTemplate<String, Basket> template = new RedisTemplate<String, Basket>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setValueSerializer(new GenericToStringSerializer<Basket>(Basket.class));
        return template;
    }
}
