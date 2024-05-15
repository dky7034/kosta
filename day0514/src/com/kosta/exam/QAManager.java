package com.kosta.exam;

public class QAManager {
    private String[][] qaArray;
    private int index; // 현재 추가된 문제와 답의 개수를 추적하기 위한 변수

    public QAManager(int size) {
        qaArray = new String[size][2]; // 크기가 size인 2차원 배열 생성
        index = 0; // 초기 인덱스는 0
    }

    // 문제와 답을 추가하는 메서드
    public void addQuestionAnswer(String question, String answer) {
        if (index < qaArray.length) {
            qaArray[index][0] = question;
            qaArray[index][1] = answer;
            index++;
        } else {
            System.out.println("배열이 가득 찼습니다.");
        }
    }

    // 모든 문제와 답을 출력하는 메서드
    public void printAllQuestionsAndAnswers() {
        for (int i = 0; i < index; i++) {
            System.out.println("Question: " + qaArray[i][0] + ", Answer: " + qaArray[i][1]);
        }
    }

    // 특정 문제에 대한 답을 찾는 메서드
    public String findAnswer(String question) {
        for (int i = 0; i < index; i++) {
            if (qaArray[i][0].equals(question)) {
                return qaArray[i][1];
            }
        }
        return "Answer not found.";
    }

    public static void main(String[] args) {
        QAManager qaManager = new QAManager(10); // 최대 10개의 문제와 답을 저장할 수 있는 배열 생성
        
        qaManager.addQuestionAnswer("문제1", "답1");
        qaManager.addQuestionAnswer("문제2", "답2");
        qaManager.addQuestionAnswer("문제3", "답3");
        qaManager.addQuestionAnswer("문제4", "답4");
        qaManager.addQuestionAnswer("문제5", "답5");
        qaManager.addQuestionAnswer("문제6", "답6");
        qaManager.addQuestionAnswer("문제7", "답7");
        qaManager.addQuestionAnswer("문제8", "답8");
        qaManager.addQuestionAnswer("문제9", "답9");
        qaManager.addQuestionAnswer("문제10", "답10");

        // 모든 문제와 답을 출력
        qaManager.printAllQuestionsAndAnswers();

        // 특정 문제에 대한 답을 검색
        String questionToFind = "문제2";
        System.out.println("'" + questionToFind + "'에 대한 답은 '" + qaManager.findAnswer(questionToFind) + "'입니다.");
    }
}
