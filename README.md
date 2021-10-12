# MSA

## Spring cloud
설정 파일의 중앙화(Git을 활용한 형상 관리)

## Service discovery (Spring cloud netflix eureka)
어떤 서비스(서버)가 어떤 url:port인지 찾아주는 녀석
key : value

MSA를 만들기 전에 먼저 마이크로 서비스들을 네이밍 서버에 등록을 해야한다.

> 클라이언트는 최초에 로드밸런서(또는 API 게이트 웨이)로 요청을 보낸다. 
> 로드 밸런서는 클라이언트가 사용하고자 하는 서비스가 어디에 위치하는지 알아내기 위해 > Eureka에게 요청을 보낸다.

Group은 도메인 주소를 뒤집어서 하는 것이 일반적  
ex) com.example

### Dependencies
- Spring Boot > 2.4.1
- Spring Cloud Discovery > Eureka Server
네이밍 서버로 동작하기 위해서는 최소한 유레카만 있으면 된다.

### Eureka 활성화
Application.java에 @EnableEurekaServer 애너테이션을 달아준다.

## user-service
### Dependencies
- Eureka discovery client
- spring web
- spring boot devtools
- lombok
### Enalbe DiscoveryClient
Eureka Client로 해도 상관은 없다.

## 실행하기
- VM Option에 ```-Dserver.port=xxxx```를 입력해주면 다른 포트로 인스턴스를 한개 더 띄울 수 있음
- 다음과 같이 CLI 실행방법도 있음
```./mvnw spring-boot:run -Dspring-boot.run.jvaArguments='-Dserver.port=9003' ```
- 메이븐 빌드를 하고 jar 파일을 실행시키는 방법 
```bash
$ ./mvnw clean
$ ./mvnw compile package
$ java -jar -Dserver.port=9004 ./target/user-service-0.0.1-SNAPSHOT.jar
```

