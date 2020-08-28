package models.surveys;


import java.util.Timer;
import java.util.TimerTask;






public class CountDown {

	
		private int hour = 0 , minute = 0 ,second= 0;
		private int delay_ms = 1000 , period_ms= 1000;
		private boolean timeOut= false; 
		
		private Timer timer ;	
		private TimerTask	timerTask = new TimerTask() {
			
			@Override
			public void run() {
			
				if(second==0)
				{
					if(hour ==0 && minute==0) {
						timeOut = true ;
						timer.cancel();
						
					}
					
					else {

						second=59;

						if(minute==0) {

							minute=59;
							hour--;
						}

						else if (minute==1)
							minute =0;
						else
							minute-- ;			
					}

				}

				else {second--;	}	

			}
		} ;
		
		
	
		
		// constructor
		public  CountDown (int h , int min) {
			
			this.hour = h ;
			this.minute = min ;
		    this.timer = new Timer();
		  
		} 
			

		//timer scheduling
		public void start() { timer.scheduleAtFixedRate(timerTask, delay_ms, period_ms);}//timer.schedule(timerTask,delay_ms);}
			
			
		public String refresh() { return hour+":"+minute+":"+second; }/* refreshing the  TimerLabel */

		public boolean isTimeOut() {return timeOut;}
		public void setTimeOut(boolean timeOut) {this.timeOut = timeOut;}

		public void cancel() {timer.cancel();}
		
		


	}





