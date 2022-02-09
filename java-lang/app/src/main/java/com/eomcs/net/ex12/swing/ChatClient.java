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

public class ChatClient extends JFrame {
  private static final long serialVersionUID = 1L;

  Socket socket;
  DataInputStream in;
  DataOutputStream out;

  JTextField addressTf = new JTextField(30); //IP 주소 입력창 객체 생성
  JTextField portTf = new JTextField(4); //Port 번호 입력창 객체 생성
  JTextArea messageListTa = new JTextArea(); //채팅창 내용 영역 객체 생성
  JTextField messageTf = new JTextField(35); //채팅 입력창 영역 객체 생성

  public ChatClient() {
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
    setSize(500, 400);

    Container contentPane = this.getContentPane();
    JPanel topPanel = new JPanel();
    topPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // 기본 레이아웃 관리자를 교체
    topPanel.add(addressTf);
    topPanel.add(portTf);
    JButton connectBtn = new JButton("연결");
    connectBtn.addActionListener(this::connectChatServer);
    topPanel.add(connectBtn);
    contentPane.add(topPanel, BorderLayout.NORTH);

    JScrollPane scrollPane = new JScrollPane(messageListTa);
    contentPane.add(scrollPane, BorderLayout.CENTER);

    JPanel bottomPanel = new JPanel();
    bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // 기본 레이아웃 관리자를 교체
    bottomPanel.add(messageTf);
    JButton sendBtn = new JButton("보내기");
    sendBtn.addActionListener(this::sendMessage);
    bottomPanel.add(sendBtn);
    contentPane.add(bottomPanel, BorderLayout.SOUTH);

    messageTf.addActionListener(this::sendMessage);

    setVisible(true);
  }

  public static void main(String[] args) throws Exception {
    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    new ChatClient();
  }

  public void connectChatServer(ActionEvent e) {
    System.out.println("서버에 연결하기!");

    try {
      socket = new Socket(
          addressTf.getText(), 
          Integer.parseInt(portTf.getText()));

      in = new DataInputStream(socket.getInputStream());
      out = new DataOutputStream(socket.getOutputStream());

      new MessageReceiver(in).start();

    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this, "서버 연결 오류!", "통신 오류!", JOptionPane.ERROR_MESSAGE);
    }
  }

  public void sendMessage(ActionEvent e) {
    if (messageTf.getText().length() == 0) {
      return;
    }

    try {
      out.writeUTF(messageTf.getText());
      out.flush();
      messageTf.setText("");

    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this, "메서지 전송 오류!", "통신 오류!", JOptionPane.ERROR_MESSAGE);
    }
  }

  class MessageReceiver extends Thread {

    DataInputStream in;

    public MessageReceiver(DataInputStream in) {
      this.in = in;
    }

    @Override
    public void run() {
      while (true) {
        try {
          String message = in.readUTF();
          messageListTa.append(message + "\n");

        } catch (Exception e) {
        }
      }
    }
  }
}







