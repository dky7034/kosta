package com.kosta.exam07;

// 소비자 클래스
// 생산자와 상관없이 계속하여 제품을 소비하도록 하기 위하여
// 멀티스레드가 되게 합니다.
public class Consumer extends Thread {
    // 생산자와 제품을 공유하기 위하여
    // 멤버변수로 제품을 선언합니다.
    private Product product;

    // 생성자
    // 생성시에 제품을 매개변수로 전달받아 초기화합니다.
    public Consumer(Product product) {
        super();
        this.product = product;
    }

    // 소비자 스레드가 해야 할 일:
    // run()을 오버라이딩하여 작성해 줍니다.
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                product.useNumber();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
