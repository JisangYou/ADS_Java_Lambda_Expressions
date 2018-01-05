# ADS04 Java 

## 수업 내용
- Lambda식을 학습

## Code Review

1. basic

```Java
public class LamdaInterfaceBasic {

	public void run() {

		/*
		 * 단항 인터페이스
		 * 
		 * */
		
		
		// 1. Supplier : 입력값이 있고, 반환값이 없을 때 사용
		Supplier<Integer> supplier = () -> 180 + 20;
		System.out.println(supplier.get());
		// 2. Consumer : 입력값이 있고, 반환값이 없을 때 사용 코드 블럭에서 사용처리가 되어야 한다.
		Consumer<Integer> consumer = System.out::println;
		consumer.accept(100);
		// 3. Function : 입력값이 있고, 반환값이 있다.
		// 입력값과 반환값의 타입을 제네릭으로 정의
		Function<Integer, Double> function = x -> x * 0.5;
		System.out.println(function.apply(50));
		// 4. Predicate : 입력값에 대한 참 거짓을 판단. return type = boolean
		Predicate<Integer> predicate = x -> x < 100;
		System.out.println("50은 100보다 작습니다. : " + predicate.test(50));
		// 5. 입력과 반환 타입이 동일 할 때 사용
		UnaryOperator<Integer> unary = x -> x + 20;
		System.out.println(unary.apply(100));
		

		/*
		 * 이항 인터페이스
		 * 
		 * */
		
		//1. BiConsumer : Consumer에 입력 값이 두개
		BiConsumer<Integer, Integer> biConsumer =(x,y)-> System.out.println(x+y);
		biConsumer.accept(30, 27);
		//2. BiFunction : Function에 입력 값이 두개
		//3. BiPredicate : Predicate에 입력 값이 두개
		//4. BinaryOperator:  --      입력 값이 두개
	}

}
```

2. main

```Java
ublic class LamdaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LamdaInterfaceBasic lib = new LamdaInterfaceBasic();
		lib.run();
		
		OneProcess process = new OneProcess();
		process.process(
		// callback 클래스를 lambda로 변경하기
		// 1. 함수명을 없애고 (){} 사이에 화살표를 넣는다.
		// (int x) -> {
		// System.out.println(x);
		// }
		// 2. 파라미터가 하나이면 타입을 생략할 수 있다.
		// (x) -> {
		// System.out.println(x);
		// }
		// 3. 하나의 파라미터면 파라미터측의 괄호를 생략,
		// 로직이 한줄이면 로직측의 괄호를 생략
		// x -> System.out.println(x)
		// 4. 파라미터가 없으면 괄호를 반드시 작성
		// () -> System.out.println(x)
		// 5. 리턴 값이 있을 경우
		// () -> return "hello"
		// 6. 참조형 -> 로직이 실행되는 측의 인자와 리턴이 되는 인자를 매칭할  수 있으면
	    // 파라미터의 개수가 예측 가능할 경우 객체 :: 메서드 형태로 호출 할 수 있다.
			System.out::println
		);
	}
}

class OneProcess {
	public void process(One one) {
		one.run(10002);
	}
}

// 1. 하나의 클래스에 하나의 함수 (o)

interface One {
	public void run(int x);

}

```


## 보충설명

- 람다식 

람다식, 또는 람다 함수는 프로그래밍 언어에서 사용되는 개념으로 익명 함수(Anonymous functions)를 지칭하는 용어

- 장점

코드의 간결성: 효율적인 람다 함수의 사용을 통하여 불필요한 루프문의 삭제가 가능하며, 동일한 함수를 재활용할 수 있는 여지가 커진다.
필요한 정보만을 사용하는 방식을 통한 퍼포먼스 향상: 지연 연산을 지원하는 방식[2]을 통하여 효율적인 퍼포먼스를 기대할 수 있다. 이 경우 메모리 상의 효율성 및 불필요한 연산의 배제가 가능하다는 장점이 있다.

- 단점

어떤 방법으로 작성해도 모든 원소를 전부 순회하는 경우는 람다식이 조금 느릴 수 밖에 없다. (어떤 방법으로 만들어도 최종 출력되는 bytecode 나 어셈블리 코드는 단순 while(혹은 for) 문 보다 몇 단계를 더 거치게 된다.)
익명함수의 특성상 함수 외부의 캡처를 위해 캡처를 하는 시간제약 논리제약적인 요소도 고려해야한다.
람다식을 너무 남발하여 사용하게되면 오히려 코드를 이해하기 어려울 수 도 있다

- 사용 예제 코드

```Java

() -> {}                     // No parameters; result is void
() -> 42                     // No parameters, expression body
() -> null                   // No parameters, expression body
() -> { return 42; }         // No parameters, block body with return
() -> { System.gc(); }       // No parameters, void block body
() -> {
  if (true) { return 12; }
  else { return 11; }
}                          // Complex block body with returns
(int x) -> x+1             // Single declared-type parameter
(int x) -> { return x+1; } // Single declared-type parameter
(x) -> x+1                 // Single inferred-type parameter
x -> x+1                   // Parens optional for single inferred-type case
(String s) -> s.length()   // Single declared-type parameter
(Thread t) -> { t.start(); } // Single declared-type parameter
s -> s.length()              // Single inferred-type parameter
t -> { t.start(); }          // Single inferred-type parameter
(int x, int y) -> x+y      // Multiple declared-type parameters
(x,y) -> x+y               // Multiple inferred-type parameters
(final int x) -> x+1       // Modified declared-type parameter
(x, final y) -> x+y        // Illegal: can't modify inferred-type parameters
(x, int y) -> x+y          // Illegal: can't mix inferred and declared types

```

## TODO

- 우선 개념 및 간단한 사용법 익히기

## Retrospect

- 코드 보기가 처음에는 조금 어색함
- 추후에 배울 함수형 언어를 위해 개념을 이해하고 차이가 뭔지 검색해봐야 할 것 같음

## Output
- 생략