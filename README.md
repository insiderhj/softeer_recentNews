**프연2-오늘의 뉴스 모아보기**

- 페어프로그래밍의 정의

하나의 컴퓨터로 2명이 함께 작업하는 방식

한 사람은 네비게이터, 한 사람은 드라이버<br>
예린 : 네비게이터 / 희진 : 드라이버 역할로 진행 !

[[Agile] 짝 프로그래밍(Pair Programming)이란 - Heee's Development Blog](https://gmlwjd9405.github.io/2018/07/02/agile-pair-programming.html)

- 페어프로그래밍 방식(룰) 정하기

1) 커밋규칙

`[커밋태그] : 내용 #이슈번호`

예시) add : login 파일 추가 #1

- add : 새로운 파일 추가
- feat : 만들어진 파일에 새로운 기능 추가
- fix : 기능 수정, 버그 수정
- docs : 문서 수정
- comment : 주석 추가
- test : 테스트 코드 추가
- merge : 다른 브랜치와의 merge
- refactor : 코드 수정 및 타입, 변수명 변경
- style : 코드 스타일 변경(코드 자체의 변경 없이 스타일만 변경된 경우)
- remove : 코드 또는 파일, 리소스 제거
- setting : 패키지 구조 변경

2) 코드컨벤션

자바 기본 컨벤션으로 진행

3) 작업 흐름
이슈 생성 후 작업 완료 후 pr 날림

4) 사용한 요소 및 논의

- newsapi 사용 → api키 발급
- 발급한 키를 이용하여 api 호출하는 형식으로 진행
- maven이 있는 파일로 시작하는 것이 맞다고 판단 → 새로운 프로젝트 생성
- 필요한 dependency를 추가해야함
- 반환된 요소 중 title만 뽑아내기
