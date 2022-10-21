# graphQL-practice
graphQL을 spring boot로 연습하는 레포지토리입니다.

## yml 설정 ##
```yml
graphql:
    schema:
      file-extensions: .graphqls
      locations: classpath:graphql/**/
    graphiql:
      enabled: true
      printer:
        enabled: true
```

## 개념 정리 ##

> type : 응답값 정의, input 파라미터 값 정의 <br>
multation : post, patch 같은 개념 <br>
query : get 같은 개념 <br>
! : null 허용 x <br>

## :warning: 주의점 :warning: 

schema.graphs의 Mutation 쿼리 이름이랑 controller의 메서드 명이랑 같아야 매핑이 된다! <br>
왜인진 모르겠지만 input으로 값을 받을때 ReqDto에 @setter를 꼭 붙혀주여야 한다.
