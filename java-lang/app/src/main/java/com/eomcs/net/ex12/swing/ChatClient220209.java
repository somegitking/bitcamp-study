package com.eomcs.net.ex12.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class ChatClient220209 extends JFrame {
  private static final long serialVersionUID = 1L;

  //계속 사용해야 하기 때문에 인스턴스 변수로 선언함
  Socket socket;
  DataInputStream in;
  DataOutputStream out;

  JTextField addressTf = new JTextField(30); //IP 주소 입력창 객체 생성
  JTextField portTf = new JTextField(4); //Port 번호 입력창 객체 생성
  JTextArea messageListTa = new JTextArea(); //채팅창 내용 영역 객체 생성
  JTextField messageTf = new JTextField(35); //채팅 입력창 영역 객체 생성

  public ChatClient220209() {
    super("채팅!!");
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        try {in.close();} catch (Exception ex) {}
        try {out.close();} catch (Exception ex) {}
        try {socket.close();} catch (Exception ex) {} //소켓을 제일 마지막에 닫느다.입출력 스트림 보다 먼저 닫으면 안된다. 
        System.exit(0);
      }
    });
    setSize(500, 400);//cc

    Container contentPane = this.getContentPane(); //채팅창 전체 객체 생성
    JPanel topPanel = new JPanel(); //윗쪽 패널(IP주소, Port번호, 입력 버튼) 객체 생성
    topPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // 기본 레이아웃 관리자를 교체
    topPanel.add(addressTf);//IP 주소 입력창 추가
    topPanel.add(portTf); //port 번호 입력창 추가
    JButton connectBtn = new JButton("연결"); //연결 버튼 객체 생성
    connectBtn.addActionListener(this::connectChatServer); //연결 버튼 클릭시 connectChatServer 메소드 실행
    topPanel.add(connectBtn); //연결 버튼 추가
    contentPane.add(topPanel, BorderLayout.NORTH); //위쪽에 배치

    JScrollPane scrollPane = new JScrollPane(messageListTa); //스크롤 바 객체 생성
    contentPane.add(scrollPane, BorderLayout.CENTER); // 중앙에 배치 

    JPanel bottomPanel = new JPanel(); //아래쪽 패널(채팅 입력, 보내기 버튼) 객체 생성
    bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // 기본 레이아웃 관리자를 교체
    bottomPanel.add(messageTf); //채팅 내용 추가
    JButton sendBtn = new JButton("보내기"); //보내기 버튼 객체 생성
    sendBtn.addActionListener(this::sendMessage); //버튼을 누르면 채팅 메시지 전송
    bottomPanel.add(sendBtn);//보내기 버튼 추가
    contentPane.add(bottomPanel, BorderLayout.SOUTH); //아래쪽에 배치

    messageTf.addActionListener(this::sendMessage); //엔터를 눌러도 채팅 메시지 전송

    setVisible(true);//조건이 true일 경우 채팅창이 보여짐
  }

  public static void main(String[] args) throws Exception { //메인함수
    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); //채팅창 윈도우의 스타일 지정
    new ChatClient220209();
  }

  public void connectChatServer(ActionEvent e) { //채팅 서버에 접속하는 메소드
    System.out.println("서버에 연결하기!");

    try {
      socket = new Socket( //IP주소와 port 번호로 채팅 서버에 접속을 시도한다.
          addressTf.getText(), //IP 번호 입력창에서 IP 주소를 받아 온다.
          Integer.parseInt(portTf.getText())); //port 번호 입력창에서 port 번호를 받아 온다.

      in = new DataInputStream(socket.getInputStream());//입력 스트림 인스턴스 생성
      out = new DataOutputStream(socket.getOutputStream());//출력 스트림 인스턴스 생성

      new MessageReceiver(in).start();//서버로 부터 메시지를 받는 인스턴스 생성

    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this, "서버 연결 오류!", "통신 오류!", JOptionPane.ERROR_MESSAGE);
    }
  }

  public void sendMessage(ActionEvent e) {
    if (messageTf.getText().length() == 0) {//채팅 입력창에 아무것도 없으면 아무일도 하지 않고 제어를 넘긴다.
      return;
    }

    try {
      out.writeUTF(messageTf.getText());//채팅 메시지 입력란의 문자열을 가져와 출력 시도
      out.flush();
      messageTf.setText(""); //채팅 메시지 입력란 안의 문자열을 지운다. 보낸 문자열을 지운다.

    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this, "메서지 전송 오류!", "통신 오류!", JOptionPane.ERROR_MESSAGE);
    }
  }

  class MessageReceiver extends Thread { //서버로 부터 메시지를 받아오는 일을 하는 객체

    DataInputStream in;

    public MessageReceiver(DataInputStream in) {
      this.in = in;
    }

    @Override
    public void run() {
      while (true) {
        try {
          String message = in.readUTF();//서버로 부터 문자열을 읽어서 문자열 변수에 저장한다.
          messageListTa.append(message + "\n");//가져온 문자열에 \n을 붙여서 채팅창에 한 줄씩 보이게 함.

        } catch (Exception e) {
        }
      }
    }
  }
}







