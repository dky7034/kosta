package com.kosta.exam01;

public class PersonTest {
    public static void main(String[] args) {
        Person kim = new Person("김유신");
        Person lee = new Person("이순신");
        kim.sayHello();
        lee.sayHello();
    }
}
// 위의 예시에서,
// 메서드를 호출하면 호출한 순서대로 동작합니다.
// 객체 lee의 입장에서는 객체 kim의 sayHello()가 모두 끝나야
// 자신에게 기회가 옵니다.
// 만약, kim이 sayHello()를 동작하다가 문제가 발생하면
// lee에게는 영영 기회가 오지 않을 수도 있습니다.
// 만약, kim과 lee가 가능하면 공평하게 작업을 수행하도록 하려면
// "멀티쓰레드 프로그래밍"으로 할 수 있습니다.
// 자바에서는 멀티쓰레드 프로그래밍을 위하여 Thread 클래스와 Runnable 인터페이스를 이용합니다.

// Thread 클래스를 상속하거나 Runnable 인터페이스를 구현하거나 공평하게 동작시키고자 하는 일을
// (즉, 쓰레드가 해야할 일은) run 메서드를 오버라이딩해서 그 안에 써줍니다.
// 그리고 쓰레드를 가동시키기 위해서는 start() 메서드를 호출합니다.
// 만약, start() 메서드를 호출하지 않고 직접 run()을 호출하면 오류는 발생하지 않지만
// 이런 경우 공평하게 스케줄링은 되지 않고 일반 메서드처럼 동작합니다.
// 즉, 먼저 호출한 객체가 작업이 완료된 후에야 다음의 객체에게 기회가 옵니다.
// 그래서 쓰레드를 가동하려면 run()을 호출하는 것이 아니라 start()를 호출해야 합니다.

// 또, Runnable 인터페이스를 구현한 경우에는
// Runnable 인터페이스는 쓰레드를 가동시키기 위한 start() 메서드가 없기 때문에
// Thread 객체로 포장한 후 start()를 호출해야 합니다.