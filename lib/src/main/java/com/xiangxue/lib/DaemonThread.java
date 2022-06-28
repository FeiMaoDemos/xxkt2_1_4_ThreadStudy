package com.xiangxue.lib;

public class DaemonThread {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + "---" + i);
                }
            }
        };
        t.setDaemon(true); // �������ػ��߳�
        t.start(); // ˭���õ� main�� main������ �Ҿ��ػ�main

        // ���̣߳���Ϊ�� �� Thread t 10����
        Thread.sleep(10000);

        // ���ػ��߳�  ���߳�һֱ�ڵ� Thread t ����ִ������û��

        // �ߵ�����������߳̽��������߳̽���������t�߳���û�н�����t�̶߳������������Ϊt�߳����ػ��̣߳��ػ���main
    }

}
