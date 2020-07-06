package com.huyy.ThreadPool;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
 
public class T11_ForkJoinPool_02 {
	static int[] nums = new int[1000000];
	static final int MAX_NUM = 50000;
	static Random r = new Random();
	
	//赋值
	static {
		for(int i=0; i<nums.length; i++) {
			nums[i] = r.nextInt(100);
		}
	}

	//方式2：继承自RecursiveTask，有返回值
	static class AddTask extends RecursiveTask<Long> { 
		int start, end;
		AddTask(int s, int e) {
			start = s;
			end = e;
		}
		@Override
		protected Long compute() {
			if(end-start <= MAX_NUM) {
				long sum = 0L;
				for(int i=start; i<end; i++) sum += nums[i];
				return sum;//继承自RecursiveTask，有返回值
			} 
			int middle = start + (end-start)/2;
			AddTask subTask1 = new AddTask(start, middle);
			AddTask subTask2 = new AddTask(middle, end);
			subTask1.fork();
			subTask2.fork();
			return subTask1.join() + subTask2.join();//合并
		}
	}
	
	public static void main(String[] args) throws IOException {
		ForkJoinPool fjp = new ForkJoinPool();
		AddTask task = new AddTask(0, nums.length);
		fjp.execute(task);
		long result = task.join();//合并
		System.out.println(result);
	}
}
