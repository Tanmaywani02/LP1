import java.util.*;

class CpuSchedulingSJF {
	void findWaitingAndTurnTime(int p[],int n,int bTime[]) {
		int wTime[]=new int[n];
		int tTime[]=new int[n];
		int temp,pTemp;
		float totalWaitingTime=0;
		float totalTurnAroundTime=0;

		for(int k=0;k<bTime.length;k++) {
			for(int i=0;i<bTime.length;i++) {
				for(int j=0;j<bTime.length;j++) {
					if(bTime[i]<bTime[j]) {
						temp=bTime[i];
						bTime[i]=bTime[j];
						bTime[j]=temp;

						pTemp=p[i];
						p[i]=p[j];
						p[j]=pTemp;
					}
				}
			}
		}

		wTime[0]=0;
		for(int i=1;i<wTime.length;i++) {
			wTime[i]=bTime[i-1]+wTime[i-1];
			totalWaitingTime=totalWaitingTime+wTime[i];
		}

		for(int i=0;i<tTime.length;i++) {
			tTime[i]=wTime[i]+bTime[i];
			totalTurnAroundTime=totalTurnAroundTime+tTime[i];
		}

		System.out.println("--------SJF CPU SCHEDULING ALGORITHM---------");
		System.out.println("Processes\tBurst Time\tWaiting Time\tTurnAround Time");
		for(int i=0;i<n;i++) {
			System.out.println(i+1+"\t\t   "+bTime[i]+"\t\t  "+wTime[i]+"\t\t  "+tTime[i]);
		}
	    System.out.println("\t\t\t\t---------\t---------");
	    System.out.println("\t\t\t\tTotal ="+totalWaitingTime+"\tTotal= "+totalTurnAroundTime);

	    System.out.println("Average Waiting Time ="+(totalWaitingTime/n));
		System.out.println("Average Turn Around Time ="+(totalTurnAroundTime/n));
	}

	public static void main(String args[]) {
		//consider all process are in ready in queue....
		CpuSchedulingSJF cpu=new CpuSchedulingSJF();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of processes ");
		int n=sc.nextInt();
		int p[]=new int[n];
		for(int i=0;i<p.length;i++) {
			p[i]=i;
		}
		int bTime[]=new int[n];
		for(int i=0;i<bTime.length;i++) {
			System.out.println("Enter Burst Time for Process "+(i+1));
			bTime[i]=sc.nextInt();
		}
		cpu.findWaitingAndTurnTime(p,n,bTime);
	}
}