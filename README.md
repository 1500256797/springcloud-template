## SpringCloud Gateway

### 使用Gateway解决浏览器跨域问题
![img.png](screenshoots/跨域問題.png)

### gateway过滤器执行顺序
![img.png](screenshoots/过滤器filter执行顺序.png)
执行顺序先看order值，order值越小，执行顺序越靠前。order值一样时，按照spring默认的排序进行执行。
![img.png](screenshoots/过滤器执行顺序图2.png)

### 全局过滤器案例
http://localhost:10010/user/2
![img.png](screenshoots/gateway没登录.png)
由于添加了全局过滤器，所以再请求时，需要给请求头添加 authorization 参数。
http://localhost:10010/user/2?authorization=admin
![img_1.png](screenshoots/img_1.png)

http://localhost:10010/order/101?authorization=admin
![img.png](screenshoots/feign+网关过滤.png)

## 使用Docker部署SpringCloud项目

### 流程
1、每个微服务都需要创建一个Dockerfile文件，用于构建镜像
2、使用maven将每个微服务打包成jar包
 - 如果某个微服务依赖了其他微服务，需要先将依赖的微服务打包成jar包，然后再打包当前微服务。
 - 修改pom.xml文件，将scope设置为system，然后在systemPath中指定jar包的路径。
 - 配置maven打包插件，将executable设置为true，这样打包出来的jar包就可以直接运行，将includeSystemScope设置为true，这样就可以将依赖的jar包一起打包进去。
3、编写docker-compose.yml文件，将每个微服务的镜像文件所在的路径配置进去。
4、使用docker-compose up -d命令启动项目。
