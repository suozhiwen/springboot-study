###1.jar
```xml

<!-- spring security 安全认证 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

<!--Token生成与解析 -->
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt</artifactId>
    <version>${jwt.version}</version>
</dependency>

```
 
###2.相关配置

1.//身份认证接口
com.java.common.srcurity.SecurityConfig.configure

2.获取用户信息和角色相关赋值
com.java.common.srcurity.service.UserDetailsServiceImpl.createLoginUser



