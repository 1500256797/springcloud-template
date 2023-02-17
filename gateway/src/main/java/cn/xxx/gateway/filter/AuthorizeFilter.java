package cn.xxx.gateway.filter;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;


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
        HttpHeaders headers = exchange.getRequest().getHeaders();
        String token = "";
        String url = exchange.getRequest().getURI().getPath();
        // 使用 Spring Gateway 和过滤器实现检查 WebSocket 请求路径中是否包含 token 参数的示例代码
        // WebSocket协议是无法在请求头中携带token等参数的。如果需要在WebSocket请求中携带token参数进行鉴权，
        // 可以考虑使用类似于在url路径中携带token的方式。在客户端建立WebSocket连接时，可以在url路径中携带token参数  wss://example.com/audio?token=your_token
        // 判断是否为 WebSocket 请求
        if (headers.containsKey("Upgrade") && headers.get("Upgrade").contains("websocket")) {
            String query = exchange.getRequest().getURI().getQuery();
            // 判断请求路径中是否包含 token 参数
            if (query != null && query.contains("token=")) {
                token = query.split("token=")[1];
            } else if (url.contains("token=")) {
                token = url.split("token=")[1];
            }
        } else {
            // 非 WebSocket 请求，继续执行后续操作
            // 1.获取请求参数
            ServerHttpRequest request = exchange.getRequest();
            MultiValueMap<String, String> params = request.getQueryParams();

            // 2. 获取请求参数的url
            System.out.println("【 url 】 " + url   );
            if (url.startsWith("/oauth")) {
                // 3. 如果是登录请求，直接放行
                return chain.filter(exchange);
            }

            if (url.startsWith("/tUsers/login")) {
                // 3. 如果是登录请求，直接放行
                return chain.filter(exchange);
            }
            token = exchange.getRequest().getHeaders().getFirst("Authorization");
        }

        System.out.println("【 token 】 " + token);
        if (token == null) {
            // 拦截请求
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        token = token.split("\\.")[1];
        byte[] bytes = Base64.getUrlDecoder().decode(token);
        try {
            token = new String(bytes, "UTF-8");
            //解析为json对象
            JSONObject tokenJSON = JSONObject.parseObject(token);
            System.out.println(tokenJSON);

            List<String> scope = tokenJSON.getJSONArray("scope").toJavaList(String.class);

            //访问资源服务1,需要scope1的授权
            if (url.startsWith("/tUsers") && scope.contains("scope1")) {
                return chain.filter(exchange);
            }

            //访问资源服务2,需要scope2的授权
            if (url.startsWith("/tOrders") && scope.contains("scope2")) {
                return chain.filter(exchange);
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return chain.filter(exchange);
    }


    /*
    * 定义此过滤器的执行顺序 等同于注解@Order()
    * */
    @Override
    public int getOrder() {
        return -1; //数字越小 越先执行
    }

}
