/*
 * Gurek Singh 2015033
 * Saurabh Kapur 2015087
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class producer implements Runnable {
	   private final ArrayList<Double> taskQueue;
	   private final ArrayList<Double> result;
	   private final int MAX_CAPACITY;
	   File file ;
	   int counter = 0;
	   public producer(ArrayList<Double> sharedQueue, int size, File file, ArrayList<Double> result )
	   {
	      this.taskQueue = sharedQueue;
	      this.MAX_CAPACITY = size;
	      this.file = file;
	      this.result = result;
	   }
	 
	   @Override
	   public void run()
	   {
		  BufferedReader br = null;
		  try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  String data;
		  for (int j = 0; j<5 ; j++ ){
		      try {
				while (((data = br.readLine()) != null) && !(data.isEmpty()))
				  {
					Double d = Double.parseDouble(data);
				     try
				     {
				        produce(d);
				     
				     } 
				     catch (InterruptedException ex)
				     {
				        ex.printStackTrace();
				     }
				  }
				//data = br.readLine();
				data  = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      result.add(Threads_demo.min);
		      result.add(Threads_demo.max);
		      result.add(Threads_demo.avg);
		      Threads_demo.predict = Math.sqrt(Threads_demo.predict) + Threads_demo.max;
		      result.add(Threads_demo.predict);
		      System.out.println("result of dataset " + j + "-" + Threads_demo.min);
		      System.out.println("result of dataset " + j + "-" + Threads_demo.max);
		      System.out.println("result of dataset " + j + "-" + Threads_demo.avg);
		      System.out.println("result of dataset " + j + "-" + Threads_demo.predict);
		      Threads_demo.min = Double.MAX_VALUE;
		      Threads_demo.max = Double.MIN_VALUE;
		      Threads_demo.avg = 0.0;
		      Threads_demo.predict = 0.0;
		  }
		      
	   }
	 
	   private void produce(Double i) throws InterruptedException, IOException
	   {
		   //if (!taskQueue.isEmpty())
	      synchronized (taskQueue)
	      {
	         while (taskQueue.size() == MAX_CAPACITY)
	         {
	            System.out.println("Queue is full " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
	            taskQueue.wait();
	         }
	           
	         //Thread.sleep(1000);
	         taskQueue.add(i);
	         taskQueue.add(i);
	         taskQueue.add(i);
	         System.out.println("Produced: " + i + " " + ++counter);
	         for (int y=0;y<1000;y++)
	        	 ;
	         taskQueue.notifyAll();
	         taskQueue.wait();
	      }
	   }
}
