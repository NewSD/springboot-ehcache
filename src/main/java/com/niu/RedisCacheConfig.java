package com.niu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;
import java.util.HashMap;

/**
 * Created by ami on 2019/6/24.
 * redis 集群配置
 */
@Configuration
public class RedisCacheConfig {

    @Autowired
    RedisConnectionFactory connectionFactory;

    @Bean
    RedisCacheManager redisCacheManager() {
        HashMap<String, RedisCacheConfiguration> configMap = new HashMap<>();
        RedisCacheConfiguration redisCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
                .prefixKeysWith("sang:")
                .disableCachingNullValues()
                .entryTtl(Duration.ofMinutes(30));
        configMap.put("c1", redisCacheConfig);
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);
        RedisCacheManager redisCacheManager = new RedisCacheManager(
                redisCacheWriter,
                RedisCacheConfiguration.defaultCacheConfig(),
                configMap);
        return redisCacheManager;
    }

}
