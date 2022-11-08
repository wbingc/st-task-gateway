package com.example.Gateway.filter;


import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import com.example.Logging.logger.CustomLogger;

@Component
public class PrePostGlobalFilter implements GlobalFilter, Ordered {

    private final CustomLogger LOGGER = new CustomLogger();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //LOGGER.info("Pre-filter: Forwarding API calls to : " + exchange.getRequest().getPath());
       // LOGGER.getLogger().info("Pre-filter: Forwarding API calls to : "  + exchange.getRequest().getPath());
        return chain.filter(exchange)
                .then(Mono.fromRunnable( () -> {
                    //LOGGER.info("Post-filter: Forwarding result back to client.");
                    //LOGGER.getLogger().info("Post-filter: Forwarding result back to client.");
                }));
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
