package com.leigq.quartz.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * RedisHttpSessionConfig
 * @author leiguoqing
 * @date 2020-09-13 17:18:45
 */
@Configuration
@EnableRedisHttpSession(redisNamespace = "spring:session:quartz-lite", maxInactiveIntervalInSeconds = 60 * 15)
public class RedisHttpSessionConfig {


}
