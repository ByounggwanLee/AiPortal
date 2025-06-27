Spring Boot로 AI PORTAL API를 제공하는 Gradle기반 웹 애플리케이션 프로젝트를 생성해 주세요.  
- Gradle wrapper 포함
- Java 17  
- Spring Boot 3.4.7
- 기본 패키지명: com.skax.aiportal  
- 의존성: Spring Web, Spring Boot DevTools, Lombok, Slf4j, ORACLE Driver, Spring Data JPA, MyBatis Framework, Feign Client, Spring REST Docs, Swagger, Spring Data REST
- 주석 및 Springdoc OpenAPI 문서포함
- 단위테스트 모듈 생성

---
아래는 Spring Boot에서 DTO(Data Transfer Object) 클래스를 생성할 때 활용할 수 있는 참조 프롬프트 10가지입니다.

"사용자 정보를 담는 UserDto 클래스를 생성해줘. 필드는 id(Long), username(String), email(String)으로 해줘."

"게시글 정보를 위한 PostDto를 만들어줘. 필드는 postId(Long), title(String), content(String), author(String)으로 해줘."

"회원가입 요청을 위한 SignupRequestDto를 생성해줘. 필드는 username, password, email이 필요해."

"제품 정보를 담는 ProductDto 클래스를 만들어줘. 필드는 productId(Long), name(String), price(int), description(String)으로 해줘."

"로그인 응답용 LoginResponseDto를 만들어줘. 필드는 userId(Long), token(String), expiredAt(LocalDateTime)으로 해줘."

"주문 정보를 위한 OrderDto를 생성해줘. 필드는 orderId(Long), userId(Long), productIds(List<Long>), totalPrice(int)로 해줘."

"댓글 정보를 담는 CommentDto 클래스를 만들어줘. 필드는 commentId(Long), postId(Long), content(String), writer(String)으로 해줘."

"페이징 처리를 위한 PageDto를 만들어줘. 필드는 page(int), size(int), totalElements(long), totalPages(int)로 해줘."

"파일 업로드 결과를 담는 FileUploadDto를 생성해줘. 필드는 fileName(String), fileUrl(String), size(long)으로 해줘."

"에러 응답용 ErrorResponseDto를 만들어줘. 필드는 code(String), message(String), details(String)으로 해줘."
/com/skax/aiportal/sample 다시 생성해줘
- 필드는 id(Long), name(String), description(String)
- get, getAll, post, put, delete rest-api
- ResponseEntity, PageRequest, Pageable
- domain, controller. service, repository, dto를 각각 디렉토리에 생성
- 주석 및 Springdoc OpenAPI 문서포함
- 단위테스트 모듈 생성
---