package com.kosta.exam02;

public class StudentVO {
    private String name; // 학생 이름을 저장할 변수
    private int kor; // 국어 점수를 저장할 변수
    private int eng; // 영어 점수를 저장할 변수
    private int math; // 수학 점수를 저장할 변수

    // 객체 정보를 문자열로 반환하는 메소드
    @Override
    public String toString() {
        return "StudentVO [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
    }

    // 학생 이름을 반환하는 getter 메소드
    public String getName() {
        return name;
    }

    // 학생 이름을 설정하는 setter 메소드
    public void setName(String name) {
        this.name = name;
    }

    // 국어 점수를 반환하는 getter 메소드
    public int getKor() {
        return kor;
    }

    // 국어 점수를 설정하는 setter 메소드
    public void setKor(int kor) {
        this.kor = kor;
    }

    // 영어 점수를 반환하는 getter 메소드
    public int getEng() {
        return eng;
    }

    // 영어 점수를 설정하는 setter 메소드
    public void setEng(int eng) {
        this.eng = eng;
    }

    // 수학 점수를 반환하는 getter 메소드
    public int getMath() {
        return math;
    }

    // 수학 점수를 설정하는 setter 메소드
    public void setMath(int math) {
        this.math = math;
    }

    // 모든 필드를 초기화하는 생성자
    public StudentVO(String name, int kor, int eng, int math) {
        super();
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    // 기본 생성자
    public StudentVO() {
        super();
        // TODO Auto-generated constructor stub
    }
}
