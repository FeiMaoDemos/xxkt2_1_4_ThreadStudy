package com.xiangxue.lib;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class NewThread {

    // ��һ�ַ�ʽ  ʵʵ���ڵ��߳�
    private static class StudentThread extends Thread {

        @Override
        public void run() {
            super.run();

            System.out.println("do work Thread");
        }
    }

    // �ڶ��ַ�ʽ  ����  ----�� Thread.start
    private static class PersonThread implements Runnable {

        @Override
        public void run() {
            System.out.println("do work Runnable");
        }
    }

    // �����ַ�ʽ������  return XXX  ----�� Thread.start
    private static class WorkerThread implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("do work WorkerThread");
            Thread.sleep(10000);
            return "run success";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        StudentThread thread = new StudentThread();
        thread.start(); // .start() ����֤��������߳�
        // thread.run(); // TODO ������߳�û�а�ëǮ��ϵ�����Ǻ�������

        // ���������У���Ҫ���� Thread
        PersonThread personThread = new PersonThread();
        new Thread(personThread).start();

        // --- �з���ֵ  ���������У���Ҫ���� Thread
        WorkerThread workerThread = new WorkerThread();
        FutureTask<String> futureTask = new FutureTask<>(workerThread);
        new Thread(futureTask).start();
        System.out.println(futureTask.get()); // ������
    }
}
