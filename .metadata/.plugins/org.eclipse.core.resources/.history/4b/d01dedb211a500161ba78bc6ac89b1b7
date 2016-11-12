/*
 * Gurek Singh 2015033
 * Saurabh Kapur 2015087
 */

import java.util.ArrayList;


public class Consumer implements Runnable {
	   private final ArrayList<Double> taskQueue;
	   int opt;
	   public Consumer(ArrayList<Double> sharedQueue,int opt)
	   {
	      this.taskQueue = sharedQueue;
	      this.opt = opt;
	   }
	 
	   @Override
	   public void run()
	   {
		   while (true)
		{ 
			   if (opt == 1)
			   {
				   try {
					min ();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   }
			   else if (opt == 2)
			   {
				   try {
					max();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   }
			   else if (opt == 3)
			   {
				   try {
					avg();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   }
			   else {
				   //INSERT CODE FOR PREDICTION
				   break;
			   }
		   }
	      
	   }
	 
	   private void avg() throws InterruptedException {
		// TODO Auto-generated method stub
		   	  synchronized (taskQueue)
		      {
		         while (taskQueue.isEmpty())
		         {
		            System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
		            //taskQueue.notifyAll();
		            taskQueue.wait();
		         }
		         //Thread.sleep(1000);
		         Double i = (Double) taskQueue.remove(0);
		         Threads_demo.avg += i/100.0;
		         System.out.println("Consumed1: " + i);
		         taskQueue.notifyAll();
		         taskQueue.wait();
		      }		
	}

	private void max() throws InterruptedException 
	   {
		// TODO Auto-generated method stub
		   	  synchronized (taskQueue)
		      {
		         while (taskQueue.isEmpty())
		         {
		            System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
		            //taskQueue.notifyAll();
		            taskQueue.wait();
		         }
		         //Thread.sleep(1000);
		         Double i = (Double) taskQueue.remove(0);
		         if (Threads_demo.max  < i)
		         {
		        	 Threads_demo.max  = i;
		         }
		         System.out.println("Consumed2: " + i);
		         taskQueue.notifyAll();
		         taskQueue.wait();
		      }	
	}

	private void min() throws InterruptedException 
	{
		// TODO Auto-generated method stub
		      synchronized (taskQueue)
		      {
		         while (taskQueue.isEmpty())
		         {
		            System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
		            //taskQueue.notifyAll();
		            taskQueue.wait();
		         }
		         //Thread.sleep(1000);
		         Double i = (Double) taskQueue.remove(0);
		         if (Threads_demo.min > i)
		         {
		        	 Threads_demo.min = i;
		        	 
		         }
		         System.out.println("Consumed3: " + i);
		         taskQueue.notifyAll();
		         taskQueue.wait();
		      }		
	}

}