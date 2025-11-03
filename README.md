# java-lotto-precourse

# 🎰 로또 - Lotto Mission

## 🧭 학습 목표

- 관련 함수를 묶어 클래스를 만들고, **객체들이 협력하여 하나의 큰 기능을 수행하도록 구현**한다.  
- 클래스와 함수에 대한 **단위 테스트를 통해 정확한 동작을 보장**한다.  
- **2주 차 공통 피드백(디스코드 참고)** 을 최대한 반영한다.

---

## 🔄 객체 협력 흐름 (Flow)

```
[Application]
↓
[LottoController] ← 입력 예외 처리 (재입력)
↓
[LottoService] ← 로또 발행 / 당첨 계산
↓
[WinningNumbers] ← 당첨 번호 및 보너스 검증
↓
[Result] ← 당첨 결과, 수익률 계산
↓
[OutputView] ← 결과 출력
```

---

## 💡 구현 기능 목록

### 1. 로또 구입
- 사용자로부터 구입 금액 입력받기
- 구입 금액을 1000으로 나눈 만큼 로또 발행 
- 발행된 로또 개수 및 번호 출력

### 2. 로또 발행
- 1~45 범위에 중복되지 않는 6개 번호 생성 후 오름차순 정렬
- 번호 출력

### 3. 당첨 번호 입력
- 당첨 번호 6개 입력 받고 검증
- 보너스 번호 1개 입력 받고 검증

### 4. 당첨 결과 계산
- 사용자가 구매한 각 로또 번호와 당첨 번호 비교
- 일치 개수에 따라 등수 판정
- 보너스 번호 일치 여부에 따른 2등 구분

### 5. 결과 출력
- 각 등수별 당첨 개수 출력
- 수익률 계산 및 출력

### 6. 예외처리
- 입력값이 유효하지 않을 경우 IllegalArgumentException 발생 및 에러 문구 출력 후 다시 입력 받음

---

## ⚠️ 예외 처리 정책

- 잘못된 입력 시 `IllegalArgumentException` 발생
- `[ERROR]` 로 시작하는 메시지 출력 후 해당 입력 단계부터 재입력
- 프로그램은 `System.exit()` 없이 정상 종료

---

## 🧱 전체 구조 개요
```
src
└── main
└── java
└── lotto
├── controller
│ └── LottoController.java
├── service
│ └── LottoService.java
├── domain
│ ├── Lotto.java // 로또 한 장(엔티티)
│ ├── WinningNumbers.java // 당첨 번호(엔티티)
│ ├── Rank.java // Enum (1~5등)
│ └── Result.java // 결과 DTO
├── view
│ ├── InputView.java // 사용자 입력 담당
│ └── OutputView.java // 출력 담당
└── Application.java // 실행 진입점 (main)
```

---

## 🧩 클래스 역할 요약

| 계층 | 클래스 | 역할 |
|------|---------|------|
| **controller** | `LottoController` | 프로그램 전체 흐름 제어 (입력 → 처리 → 출력) |
| **service** | `LottoService` | 로또 발행, 당첨 결과 계산 등 핵심 비즈니스 로직 |
| **domain** | `Lotto`, `WinningNumbers`, `Rank`, `Result` | 데이터 구조 및 규칙 정의 |
| **view** | `InputView`, `OutputView` | 입력 및 출력 처리 |
| **Application** | - | 프로그램 시작점 (main 메서드 실행) |

---

## 🧪 테스트 코드 구성

| 테스트 클래스 | 주요 검증 항목 |
|----------------|----------------|
| `ApplicationTest` | 통합 테스트 (전체 실행 흐름) |
| `LottoTest` | 로또 번호 개수, 중복, 범위 검증 |
| `WinningNumbersTest` | 당첨 번호 및 보너스 번호 검증 |
| `RankTest` | 일치 개수 + 보너스 여부에 따른 등수 판정 |
| `LottoServiceTest` | 로또 발행 수량, 수익률 계산, 예외 처리 |


