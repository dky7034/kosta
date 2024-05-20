package com.kosta.exam03;

import com.kosta.exam02.A;

public class B extends A {
    private String data;
    public void info() {
        System.out.println(title + ", " + year + ", " + data);
        // 아무리 상속받은 자식클래스라 할지라도
        // 부모클래스의 private 영역에는 접근할 수 없습니다.
        // 만약에 외부의 다른 클래스로부터는 보호하고,
        // 자식클래스에게는 접근을 허용하려면 접근 제어자를 protected로 합니다.
        // 접근명시자를 생략하는 default 접근명시자는
        // 동일한 패키지에 있는 클래스들에게만 접근을 허용합니다.
        // 상속받은 클래스라 할지라도 동일한 패키지에 있지 않으면 접근할 수 없습니다.
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
}
