# TODO - 기능

- 리소스를 사용해서 이름을 이미지로 다 바꾸기
  - 모집 기능에도 이미지 적용
  - 리소스 이미지는 WAS까지 안 가고 웹 서버에서 제공하도록 변경(공부 필요)
- 로그인 기능 추가
   - 구글, 네이버 사용 및 Spring Security 적용
   - Interceptor 를 통한 구현 먼저 해 보기
- 택틱 저장 기능 추가 (로그인 기능 이후)
   - 자신만의 택틱을 기록하거나 알려주는 페이지
   - 다른 사람의 택틱을 볼 수 있음
   - 택틱을 쉽게 입력하도록 UI에 극단적으로 공을 들여야 할듯
- 기록 기능 추가(로그인 기능 이후)
    - UID 입력 필수
    - 나의 총력전 등수 및 점수를 기록해보는 페이지
    - 그래프처럼 보여주는 방식도 고려
- 설문 기능 추가
- 퀴즈 기능 추가
- 성향 찾기 기능 추가
- 코스트 기능 수정
    - 코스트 회복의 정확성 검증 및 수정 (`setTimeout`이라 오류 있는 것 같음)
    - 코스트 관련 기믹 구현
      - 코스트 회복량: 체리노, 히마리, 새루카, 수시노, 히후미, 슌, 바스나
      - 코스트 변경: 우이, 코코나, 새후카, 토키, 체스미
      - 시작 시 타이머 시간 기준 2초간 코스트 회복 연기
    - 타이머 추가 및 시간 선택 기능 (3 / 4분)
- 계산 페이지
    - Damage
    - Heal Amount

# TODO - 기능 외 

- Spring Data JPA 적용
- Domain name 구매 및 적용
- AWS Route 53으로 HTTPS 적용
- GitHub Action 으로 CI / CD
- Vue 리팩토링
- API 결과 캐싱해서 DB 및 서버 부담 줄이기

## 기타

- 더 추가해야 할 페이지
  - 업데이트 & 픽업 페이지 (필요성에 대한 고민)