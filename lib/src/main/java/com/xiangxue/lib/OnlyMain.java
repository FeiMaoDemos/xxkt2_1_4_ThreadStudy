package com.xiangxue.lib;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * java�Ķ��߳��޴�����
 *
 * Finalizer Object finalize() ��Ҫ��Դ���� �͸�д�÷��� �Ѵ���д������ȥ
 */
public class OnlyMain {

    public static void main(String[] args) {
    	// Java������

    	/*������̹߳���Ľӿ�*/
    	ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		/*ȡ���߳���Ϣ*/
    	ThreadInfo[] threadInfos = 
    	 threadMXBean.dumpAllThreads(false, false);
    	for(ThreadInfo threadInfo:threadInfos) {
    		System.out.println("["+threadInfo.getThreadId()+"]"+" "
    				+threadInfo.getThreadName());
    	}

		/**
		 * [5] Attach Listener
		 * [4] Signal Dispatcher
		 * [3] Finalizer
		 * [2] Reference Handler
		 * [1] main
		 *
		 * GC ���������Ͼͻ���GC����Դ��Ҫ���գ�JVM�Ż��⵽������GC
		 */

		/*try {
			Thread.sleep(1); // �����쳣 ����жϱ��
		} catch (InterruptedException e) {
			e.printStackTrace();

			�ٷ����ж� ����OK
		}*/

		// Thread.currentThread().wait();;
	}
}
