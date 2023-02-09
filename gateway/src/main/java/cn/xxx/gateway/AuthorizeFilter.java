package cn.xxx.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

// @Order(-1)
/*
* 全局过滤器GlobalFilter，其作用也是处理一切进入网关的请求，与GatewayFilter的作用一样，
* 区别在于GateWayFilter通过配置文件定义，而GlobalFilter的逻辑需要自己写代码实现。
*
* 使用场景：判断请求是否有权限访问
* 案例：
*   定义全局过滤器，拦截请求，判断请求的参数是否满足下面的条件：
*   - 参数中是否有authorization参数
*   - authorization参数值是否为admin
*   如果同时满足则放行，否则拦截
* */

@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {
    // exchange:请求上下文 里面可以获取request response等信息
    // chain 用来把请求委托给下一个过滤器
    // Mono 返回标识当前过滤器业务结束
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 1.获取请求参数
        ServerHttpRequest request = exchange.getRequest();
        MultiValueMap<String, String> params = request.getQueryParams();
        // 2.获取参数中的 authorization 参数
        String auth = params.getFirst("authorization");
        // 3.判断参数值是否等于 admin
        if ("admin".equals(auth)) {
            // 4.是，放行
            return chain.filter(exchange);
        }
        // 5.否，拦截
        // 5.1.设置状态码401:未登录
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        // 5.2.拦截请求
        return exchange.getResponse().setComplete();
    }


    /*
    * 定义此过滤器的执行顺序 等同于注解@Order()
    * */
    @Override
    public int getOrder() {
        return -1; //数字越小 越先执行
    }

}
