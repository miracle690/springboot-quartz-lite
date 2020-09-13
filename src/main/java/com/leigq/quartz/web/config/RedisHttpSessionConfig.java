package com.leigq.quartz.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * RedisHttpSessionConfig
 * <br/>
 * 相关文章：<a href='https://blog.csdn.net/liuxiao723846/article/details/80733565'>springboot中使用spring-session实现共享会话到redis（二）</a>
 * @author leiguoqing
 * @date 2020-09-13 17:18:45
 */
@Configuration
@EnableRedisHttpSession(redisNamespace = "spring:session:quartz-lite", maxInactiveIntervalInSeconds = 60 * 15)
public class RedisHttpSessionConfig {


}
