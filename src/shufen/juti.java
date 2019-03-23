package shufen;

import java.util.Scanner;
import java.math.*;

public class juti {
	public juti() {
		
	}
	public void gauss1() {
	System.out.println("自动请输入：1");
	System.out.println("手动输入：2");
	String s=new Scanner(System.in).next();
	switch(s){
	case "1":
		System.out.println("输入阶数>3");
		String h=new Scanner(System.in).next();
		int n=Integer.parseInt(h);
		double[][] m=new double[n][n];
		double[] b=new double[n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				m[i][j]=0;
			}
		}
		for(int i=0;i<n;i++) {
			if(0<i&&i<n-1) {
				m[i][i-1]=8;
				m[i][i]=6;
				m[i][i+1]=1;
			}
			if(i==0) {
			m[i][i]=6;
			m[i][1]=1;
			}
			if(i==n-1)
				{m[i][i]=6;
			    m[i][i-1]=8;}
		}
		for(int i=0;i<n;i++) {
			if(i==0) {
				b[i]=7;
			}
			if(0<i&&i<n-1) {
				b[i]=15;
			}
			if(i==n-1)
				b[i]=14;	
		}
		System.out.println("预置系数矩阵");
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
			System.out.print(m[i][j]+" ");
			}
			System.out.println("");
		}
		
		for(int i=0;i<n;i++) {
			double max=zhuan(m[i][i]);
			int gh=-1;
			for(int j=i;j<n;j++)
			{
				if(zhuan(m[j][i])>max) {
					max=zhuan(m[j][i]);
					gh=j;
				}	
			}
			if(max==0) {
				System.out.println("no unique solution");
				return;
			}
			
			if(gh!=-1&&max!=0){
				double a=0;
				double sd=0;
				for(int j=0;j<n;j++) {
					a=m[i][j];
					m[i][j]=m[gh][j];
					m[gh][j]=a;		 
				}
				    sd=b[i];
				    b[i]=b[gh];
				    b[gh]=sd;	
			}
			for(int h2=i+1;h2<n;++h2) {
				double num=m[h2][i];
				if(num!=0) {
			  for(int hi=i;hi<n;hi++) {
				m[h2][hi]=m[h2][hi]-((num/(double)m[i][i]))*m[i][hi];
			  }
			  b[h2]= b[h2]-((num/(double)m[i][i]))*b[i];
			  }
			}	
		}
		double[] x=new double[n];
		 x[n-1]=b[n-1]/m[n-1][n-1];
	    for(int i=n-1;i>=0;i--) {
	    	 double sum=0;
	    	for(int j=i+1;j<n;j++) {
	    		sum=sum+m[i][j]*x[j];
	    	}
	    	x[i]=(b[i]-sum)/m[i][i];
	      }
	    System.out.println("化简后系数矩阵");
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
			System.out.print(m[i][j]+" ");
			}
			System.out.println("");
		}
		 System.out.println("方程组的解");
		for(int i=0;i<n;i++) {
			System.out.println( "x"+i+"="+x[i]);
		}
		break;
	case "2":
	 case2();
		
		break;
		
	}
	return;
		
	}
	public void gauss2() {
		System.out.println("输入阶数>3");
		String h=new Scanner(System.in).next();
		int n=Integer.parseInt(h);
		double[][] m=new double[n][n];
		double[] b=new double[n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				m[i][j]=0;
			}
		}
		System.out.println("输入系数矩阵");
		
		Scanner sca=new Scanner(System.in);
		String jie=sca.next();
		String[] jie1=jie.split(",");
		System.out.println(jie);
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				
				m[i][j]=Double.parseDouble(jie1[i*n+j]);	
			}
		}
		System.out.println("输入结果集");
		String jie2=new Scanner(System.in).next();
		String[] jie3=jie2.split(",")	;	
		for(int i=0;i<n;i++) {
			b[i]=Double.parseDouble(jie3[i]);
			System.out.println(b[i]);
			
		}
		System.out.println("读取的矩阵");
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
			System.out.print(m[i][j]+" ");
			}
			System.out.println("");
		}
		
		for(int i=0;i<n;i++) {
			double max=zhuan(m[i][i]);
			int gh=-1;
			for(int j=i;j<n;j++)
			{
				if(zhuan(m[j][i])>max) {
					max=zhuan(m[j][i]);
					gh=j;
				}	
			}
			if(max==0) {
				System.out.println("no unique solution");
				return;
			}
			
			if(gh!=-1&&max!=0){
				double a=0;
				double sd=0;
				for(int j=0;j<n;j++) {
					a=m[i][j];
					m[i][j]=m[gh][j];
					m[gh][j]=a;		 
				}
				    sd=b[i];
				    b[i]=b[gh];
				    b[gh]=sd;	
			}
			for(int h2=i+1;h2<n;++h2) {
				double num=m[h2][i];
				if(num!=0) {
			  for(int hi=i;hi<n;hi++) {
				m[h2][hi]=m[h2][hi]-((num/(double)m[i][i]))*m[i][hi];
			  }
			  b[h2]= b[h2]-((num/(double)m[i][i]))*b[i];
			  }
			}	
		}
		double[] x=new double[n];
		 x[n-1]=b[n-1]/m[n-1][n-1];
	    for(int i=n-1;i>=0;i--) {
	    	 double sum=0;
	    	for(int j=i+1;j<n;j++) {
	    		sum=sum+m[i][j]*x[j];
	    	}
	    	x[i]=(b[i]-sum)/m[i][i];
	      }
	    System.out.println("化简后系数矩阵");
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
			System.out.print(m[i][j]+" ");
			}
			System.out.println("");
		}
		 System.out.println("方程组的解");
		for(int i=0;i<n;i++) {
			System.out.println( "x"+i+"="+x[i]);
		}
		
			
	}
	public double zhuan(double s) {
		if(s>=0)
			return s;
		else
			return 0-s;
					
		
	}
	public void case2() {
		System.out.println("输入阶数>3");
		String h=new Scanner(System.in).next();
		int n=Integer.parseInt(h);
		double[][] m=new double[n][n];
		double[] b=new double[n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				m[i][j]=0;
			}
		}
		for(int i=0;i<n;i++) {
			if(0<i&&i<n-1) {
				m[i][i-1]=8;
				m[i][i]=6;
				m[i][i+1]=1;
			}
			if(i==0) {
			m[i][i]=6;
			m[i][1]=1;
			}
			if(i==n-1)
				{m[i][i]=6;
			    m[i][i-1]=8;}
		}
		for(int i=0;i<n;i++) {
			if(i==0) {
				b[i]=7;
			}
			if(0<i&&i<n-1) {
				b[i]=15;
			}
			if(i==n-1)
				b[i]=14;	
		}
		System.out.println("预置系数矩阵");
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
			System.out.print(m[i][j]+" ");
			}
			System.out.println("");
		}
		for(int i=0;i<n;i++) {
			int s=i+1;
			System.out.println("第"+s+"列可选元素");
			for(int j=i;j<n;j++) {
				System.out.print(m[j][i]+" ");
			}
			System.out.println("请选取第"+s+"列主元");
			String sd1=new Scanner(System.in).next();
			double max=Double.parseDouble(sd1);
			int gh=-1;
			
			for(int j=i;j<n;j++)
			{
				if(m[j][i]==max) {
					max=m[j][i];
					gh=j;
				}	
			}
			if(max==0) {
				System.out.println("no unique solution");
				return;
			}
			
			if(gh!=-1&&max!=0){
				double a=0;
				double sd=0;
				for(int j=0;j<n;j++) {
					a=m[i][j];
					m[i][j]=m[gh][j];
					m[gh][j]=a;		 
				}
				    sd=b[i];
				    b[i]=b[gh];
				    b[gh]=sd;	
			}
			for(int h2=i+1;h2<n;++h2) {
				double num=m[h2][i];
				if(num!=0) {
			  for(int hi=i;hi<n;hi++) {
				m[h2][hi]=m[h2][hi]-((num/(double)m[i][i]))*m[i][hi];
			  }
			  b[h2]= b[h2]-((num/(double)m[i][i]))*b[i];
			  }
			}	
		}
		double[] x=new double[n];
		 x[n-1]=b[n-1]/m[n-1][n-1];
	    for(int i=n-1;i>=0;i--) {
	    	 double sum=0;
	    	for(int j=i+1;j<n;j++) {
	    		sum=sum+m[i][j]*x[j];
	    	}
	    	x[i]=(b[i]-sum)/m[i][i];
	      }
	    System.out.println("化简后矩阵");
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
			System.out.print(m[i][j]+" ");
			}
			System.out.println("");
		}
		 System.out.println("方程组的解");
		for(int i=0;i<n;i++) {
			System.out.println( "x"+i+"="+x[i]);
		}
	}
}
