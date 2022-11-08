package com.example.Gateway.aspect;

import com.example.Logging.logger.CustomLogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

@Aspect
@Component
public class FilterAspect {

    private final CustomLogger LOGGER = new CustomLogger();

    @Pointcut("execution(public reactor.core.publisher.Mono com.example.Gateway.filter.PrePostGlobalFilter.filter(..)) && args(exchange, chain)")
    public void getFilterPointcut(ServerWebExchange exchange, GatewayFilterChain chain) {}

    @Before(value = "getFilterPointcut(exchange, chain)")
    public void before(JoinPoint joinPoint, ServerWebExchange exchange, GatewayFilterChain chain) {
        LOGGER.getLogger().info("Before " +joinPoint.getSignature() +" : Forwarding API calls to : "  + exchange.getRequest().getPath());
    }

    @AfterReturning(value = "getFilterPointcut(exchange, chain)")
    public void after(JoinPoint joinPoint, ServerWebExchange exchange, GatewayFilterChain chain) {
        LOGGER.getLogger().info("After " + joinPoint.getSignature() + " : Forwarding result back to client.");
    }
}
