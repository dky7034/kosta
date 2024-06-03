package com.kosta.exam02;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class NotePad extends JFrame {
    // 텍스트를 입력하기 위한 JTextArea
    JTextArea jta = new JTextArea();
    // 파일을 열거나 저장할 때에 파일을 선택할 수 있는 대화상자를 위한 변수
    JFileChooser jfc;
    // 현재 작업하고 있는 파일을 참조할 변수
    File file;
    // 파일에 변경된 내용이 있는지 판별하기 위한 변수
    // 파일을 저장하거나 열어온 그 즉시에는 변경된 내용이 없는 상태이므로
    // inNew에 false를 저장
    // TextArea에 한 글자라도 작성하면
    // isNew에 true를 저장
    boolean isNew;

    // 파일 저장 기능을 담당하는 메서드
    public void saveFile() {
        // 파일로 저장할 문자열을 가지고 옴
        String data = jta.getText();

        // 이미 파일이 열려있으면
        // 파일 선택 대화상자를 열지 않고 무조건 저장해야 하므로
        // re의 기본값을 0으로 설정합니다.
        int re = 0;

        // 파일이 아직 선택되지 않았을 때(즉, 새 파일일 때) = 열린 파일이 없거나 저장한 파일이 없다면
        if (file == null) {
            // 파일이 열려있지 않으면
            // 어떤 파일명으로 저장할지 물어볼 대화상자를 띄움
            // "저장": 0, "취소": 1
            re = jfc.showSaveDialog(null);
            // 대화상자에서 "저장"을 누름
            // 이미 파일이 열려있거나
            // 파일 저장 대화상자에서 "저장"을 눌렀다면 파일에 저장
            if (re == 0) {
                // 대화상자에서 선택한 파일 정보를 가지고 와서 file 변수에 저장
                file = jfc.getSelectedFile();
            }

            // 파일이 선택됐을 때 또는
            // 저장 대화상자에서 "저장"을 눌렀으면
            if (re == 0) {
                try {
                    // 문자 단위의 파일 출력을 위한 객체를 생성
                    // 매개변수로 대화상자에서 선택한 파일의 정보를 전달
                    FileWriter fw = new FileWriter(file);
                    // 파일로 내용을 출력
                    fw.write(data);
                    // 파일 출력 작업이 끝나면 파일을 닫음
                    fw.close();
                    // 파일이 성공적으로 생성됐다는 메시지 출력
                    JOptionPane.showMessageDialog(null, "파일 저장 성공");
                    // 저장한 파일명을 타이틀바에 설정
                    setTitle(file.getName());
                    // 방금 막 저장한 파일이므로
                    // isNew에 false를 저장
                    isNew = false;
                } catch (IOException e) {
                    System.out.println("예외 발생: " + e.getMessage());
                }
            }

        }
    }

    // 생성자
    public NotePad() {
        // 타이틀바 설정
        setTitle("제목 없음");
        // JFileChoose 객체를 생성
        // 매개변수로 작업 디렉토리를 전달
        // JFileChooser는 매개변수로 전달받은 디렉토리로 찾아가서
        // 사용자에게 파일을 선택할 수 있는 다이얼로그 창을 제공
        jfc = new JFileChooser("/Users/donggyun/data");
        jta = new JTextArea();
        JScrollPane jsp = new JScrollPane(jta);
        add(jsp);

        JMenuBar jmb = new JMenuBar();
        JMenu mn_file = new JMenu("파일");
        JMenuItem file_new = new JMenuItem("새 파일");
        JMenuItem file_open = new JMenuItem("열기");
        JMenuItem file_save = new JMenuItem("저장");

        mn_file.add(file_new);
        mn_file.add(file_open);
        mn_file.add(file_save);

        jmb.add(mn_file);

        setJMenuBar(jmb);

        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // TextArea에 키 이벤트를 등록
        jta.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                // 한 글자라도 작성되면 isNew에 true를 설정
                // 변경한 내용이 있다고 표시
                isNew = true;
            }
        });

        // 새 파일
        file_new.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TextArea에 저장되지 않은 변경된 내용이 있으면
                // "저장하시겠습니까?"라고 물어봅니다.
                if (isNew) {
                    int re = JOptionPane.showConfirmDialog(null, "변경된 내용을 저장하시겠습니까?");
                    // 0: 예, 1: 아니오, 2: 취소
                    if (re == 2) {return;}
                    if (re == 0) {saveFile();}
                }
                // 새 파일을 누르면 TextArea를 비웁니다.
                jta.setText("");
                // 타이틀바를 새로 설정합니다.
                setTitle("제목 없음");
                // 새 파일을 생성할 때 file 변수를 초기화합니다.
                file = null;
                // 새 파일이므로 변경된 내용이 없습니다.
                isNew = false;
            }
        });
        // 열기
        file_open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // 열어올 파일을 선택하기 위한 대화상자
                    // 0: 열기, 1: 취소
                    int re = jfc.showOpenDialog(null);
                    // 파일을 여는 기능을 구현
                    if (re == 0) {
                        // 파일 열기 대화상자에서 선택한 파일의 정보를 파일 변수에 저장
                        file = jfc.getSelectedFile();
                        // 문자 단위의 파일 내용을 컴퓨터 메모리로 읽어들이기 위한 객체 생성
                        // 파일 열기 대화상자에서 선택한 파일을 매개변수로 전달
                        FileReader fr = new FileReader(file);
                        // 파일로부터 한 글자씩 읽어들이기 위한 변수 선언
                        int ch;
                        // 파일의 전체 내용을 저장하기 위한 변수 선언
                        String data = "";
                        // 파일의 끝이 아닐 때까지 읽어들여 data에 저장
                        while ((ch = fr.read()) != -1) {
                            data += (char) ch + "";
                        }
                        // 파일로부터 읽어들인 전체 문자열 data를 TextArea에 설정
                        jta.setText(data);
                        // 파일을 닫아줌
                        fr.close();
                        // 열은 파일명을 타이틀바에 설정
                        setTitle(file.getName());
                        // 파일을 방금 막 읽어왔으므로 변경된 내용이 없다는 표시로
                        // isNew에 false를 저장
                        isNew = false;
                    }

                } catch (Exception ex) {
                    System.out.println("예외 발생: " + ex.getMessage());
                }
            }
        });
        // 저장
        file_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFile();
            }
        });
    }

    public static void main(String[] args) {
        new NotePad();
    }
}
