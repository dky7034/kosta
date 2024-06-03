package com.kosta.exam01;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class NotePad05 extends JFrame {
    // 파일을 어느 경로에 저장할건지 설정하기 위한 JFileChooser
    JFileChooser jfc;
    // 텍스트가 입력되는 공간
    JTextArea jta;
    // 현재 작업 중인 파일 (없으면 null)
    File file;
    // 열어오거나 저장한 후에 변경된 내용이 있는지 판별할 변수
    boolean isNew;

    // 공통되는 기능을 메서드로 처리
    public void saveFile() {
        // TextArea에 입력된 텍스트를 가져와서 변수 data에 저장
        String data = jta.getText();

        // 저장할 다이얼로그에서 "저장", "취소"를 눌렀는지 판별할 변수
        // 이미 파일이 있는 경우를 대비하여 초기값 0을 설정
        int result = 0;

        // 저장 다이얼로그를 띄움
        // 다이얼로그에서 취소를 누르면 1, 저장을 누르면 0을 반환함
        // 취소: 1 / 저장: 0
        // 파일이 아직 선택되지 않았을 때(즉, 새 파일일 때) = 열린 파일이 없거나 저장한 파일이 없다면
        if (file == null) {
            // 저장 다이얼로그를 띄움
            // 저장 다이얼로그에서 "저장", "취소"를 눌렀는지 판별할 변수 result
            result = jfc.showSaveDialog(null);
            // 저장을 누름
            if (result == 0) {
                // 다이얼로그에서 선택한 파일을 file 변수에 저장
                file = jfc.getSelectedFile();
            }
        }

        // 파일이 선택되었을 때 (새 파일이든 기존 파일이든) 또는
        // 저장 다이얼로그에서 "저장"을 눌렀으면
        if (result == 0) {
            try {
                // 텍스트 파일을 기록하는 방법:
                // 선택한 파일을 저장
                FileWriter fw = new FileWriter(file);
                fw.write(data);
                fw.close();
                // 메시지를 띄우기 위한 JOptionPane 클래스 (콘솔에 출력하지 않고)
                JOptionPane.showMessageDialog(null, "파일을 생성하였습니다.");
                // 파일명을 타이틀로 설정
                setTitle(file.getName());
                // 파일을 저장한 다음 inNew에 변경된 내용이 없음을 알리기 위해서
                // false를 설정
                isNew = false;
            } catch (Exception exception) {
                System.out.println("예외 발생: " + exception.getMessage());
            } // end catch
        } // end if
    } // end saveFile()

    // 생성자
    public NotePad05() {
        // 제목 설정
//        setTitle("메모장");
        super("제목 없음");
        jfc = new JFileChooser("/Users/Donggyun/data");
        // 생성자 호출 시 텍스트를 입력하는 JTextArea 객체 생성
        jta = new JTextArea();
        // TextArea에 스크롤바를 감싸는 역할을 함
        JScrollPane jsp = new JScrollPane(jta);
        add(jsp);

        // 메뉴바 만들기
        JMenuBar jmb = new JMenuBar();
        // 주 메뉴
        JMenu mn_file = new JMenu("File");
        // 부 메뉴
        JMenuItem fine_new = new JMenuItem("새 파일");
        JMenuItem file_open = new JMenuItem("열기");
        JMenuItem fine_save = new JMenuItem("저장");

        // 주 메뉴에 부 메뉴 추가
        mn_file.add(fine_new);
        mn_file.add(file_open);
        mn_file.add(fine_save);

        // 메뉴바에 주 메뉴 추가
        jmb.add(mn_file);

        // 프레임에 메뉴바를 추가(설정)
        setJMenuBar(jmb);

        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // TextArea에 키보드 이벤트를 설정
        jta.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                // 변화된 내용이 있음
                isNew = true;
            }
        });

        // 부 메뉴에 이벤트 리스너 등록
        // 1. 새 파일
        fine_new.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 변경된 내용이 있으면 "저장하시겠습니까?"라고 물어보도록 함
                // isNew의 기본값은 false
                // 키보드 이벤트를 설정하여 키를 뗀 적이 있으면 isNew는 true가 됨
                if (isNew) {
                    // Cancel(취소): 2, No(아니오): 1, Yes(예): 0
                    // Cancel: 새 파일을 취소
                    // No: 변경된 내용을 저장하지 않고 새 파일을 생성
                    // Yes: 변경된 내용을 저장하고 새 파일을 생성
                    int result = JOptionPane.showConfirmDialog(null, "변경된 내용을 저장하시겠습니까?");
                    if (result == 2) { return; }
                    switch (result) {
                        case 0:
                            // 변경 내용을 저장하고 새 파일 생성
                            saveFile();
                            break;
                        case 1:
                            // 변경 내용을 저장하지 않고 새 파일 생성
                            break;
                        case 2:
                            // 새 파일을 취소
                            return;
                    }

                }
                jta.setText("");
                setTitle("제목 없음");
                // 새 파일을 생성할 때 file 변수를 초기화
                file = null;
                // 새 파일이므로 변경된 내용이 없음
                isNew = false;

            }
        });
        // 2. 열기
        file_open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 열기 다이얼로그를 띄움
                // 반환값 => 취소: 1 / 열기: 0
                int result = jfc.showOpenDialog(null);
                if (result == 0) {
                    try {
                        // 텍스트 파일을 읽어오는 방법:
                        file = jfc.getSelectedFile();
                        FileReader fr = new FileReader(file);
                        // 파일로부터 한 문자를 읽어서 변수 ch에 저장
                        int ch;
                        // ch(정수형)를 문자 타입으로 변환하여 저장하기 위한 변수 String data를 생성
                        String data = "";
                        // 파일을 끝까지 읽기 위한 반복문
                        while ((ch = fr.read()) != -1) {
                            data += (char) ch + "";
                        }
                        // 텍스트 필드에 읽어들인 문자열을 설정
                        jta.setText(data);
                        // 파일을 닫음
                        fr.close();
                        // 파일명을 타이틀로 설정
                        setTitle(file.getName());
                        // 파일을 열어온 다음 변경된 내용이 없음을 설정하기 위해서
                        // false를 설정
                    } catch (Exception exception) {
                        System.out.println("예외 발생: " + exception.getMessage());
                    }
                }
            }
        });
        // 3. 저장
        fine_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFile();
            } // end actionPerformed
        });
    }

    // 메인 메서드
    public static void main(String[] args) {
        new NotePad05();
    }

}
