package com.company;

interface HighConnect{
    public void Charge();
    public void HighPower();
}

interface LowConnect{
    public void Charge();
    public void LowPower();
}

class HighVolt implements HighConnect{
    public void Charge(){
        System.out.println("������� ����������.");
    }
    public void HighPower(){
        System.out.println("�������� ������� 380 �����.");
    }
}

class LowVolt implements LowConnect{
    public void Charge(){
        System.out.println("������� ����������.");
    }
    public void LowPower(){
        System.out.println("�������� ������� 220 �����.");
    }
}

class Socket{
    private HighConnect highConnect;
    public Socket(HighConnect highConnect){
        this.highConnect = highConnect;
    }
    public void work(){
        highConnect.Charge();
        highConnect.HighPower();
    }
}

class SocketAdapter implements HighConnect{
    LowConnect lowConnect;
    public SocketAdapter(LowConnect lowConnect){
        this.lowConnect = lowConnect;
    }
    public void Charge(){
        lowConnect.Charge();
    }
    public void HighPower(){
        lowConnect.LowPower();
    }
}




    public class Main {
        public static void main(String[] args) {
            HighVolt highVolt = new HighVolt();
            Socket highSocket = new Socket(highVolt);
            highSocket.work();
            SocketAdapter socketAdapter = new SocketAdapter(new LowVolt());
            Socket lowSocket = new Socket(socketAdapter);
            lowSocket.work();
        }
    }