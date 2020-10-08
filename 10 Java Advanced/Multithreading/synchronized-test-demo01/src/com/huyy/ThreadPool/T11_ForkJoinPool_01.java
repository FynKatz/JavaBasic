package com.huyy.ThreadPool;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
 
public class T11_ForkJoinPool_01 {
	static int[] nums = new int[1000000];
	static final int MAX_NUM = 50000;
	static Random r = new Random();
	
	//赋值
	static {
		for(int i=0; i<nums.length; i++) {
			nums[i] = r.nextInt(100);
		}
	}
		
	//方式1：继承自RecursiveAction，没有返回值
	static class AddTask extends RecursiveAction { 
		int start, end;
		AddTask(int s, int e) {
			start = s;
			end = e;
		}
		//RecursiveAction的方法：执行主要计算
		@Override
		protected void compute() {
			if(end-start <= MAX_NUM) {
				long sum = 0L;
				for(int i=start; i<end; i++) {
					sum += nums[i];
				}			
				System.out.println("from:" + start + " to:" + end + " = " + sum);
			} else {
				int middle = start + (end-start)/2;
				AddTask subTask1 = new AddTask(start, middle);
				AddTask subTask2 = new AddTask(middle, end);
				subTask1.fork();//（继承自ForkJoinTask）异步执行此任务
				subTask2.fork();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		ForkJoinPool fjp = new ForkJoinPool();
		AddTask task = new AddTask(0, nums.length);
		fjp.execute(task);//（ForkJoinTask的方法）执行任务
		
		System.in.read();//ForkJoinPool也是守护线程，加这个为了看到结果
	}
}
