import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.Semaphore;

public class ReaderAndWriter {
	volatile MutexLock mutex = new MutexLock(1);
	volatile MutexLock wrt = new MutexLock(1);
	static AtomicInteger readerCount = new AtomicInteger(0);
	public static void main(String[] args) {
		ReaderAndWriter stu = new ReaderAndWriter();
		int reader = 0;
		int writer = 0;
		for(int i=0; i<4; i++) {
			int result = new Random().nextInt(10);
			if(result <= 4) {
				reader++;
				new Thread(new ReaderThread(reader, stu.mutex, stu.wrt)).start();
			}else {
				writer++;
				new Thread(new WriterTh(writer, stu.wrt)).start();
			}
		}

	}

}

class MutexLock{
	private volatile int mutex = 1;
	MutexLock(int i){
		this.mutex = i;
	}

	MutexLock(){}

	public void atomicIncrement(){
		mutex++;
	}
	public void atomicDecrement(){
		mutex--;
	}

	public boolean isLocked(){
		return mutex <= 0;
	}

	public void wait0() { //there is a method named wait in java.lang.Object
	    synchronized (this){
            while(mutex<=0) {
               // Thread.yield();
            }
            atomicDecrement();
	    }
	}

	public void signal() {
		atomicIncrement();
	}

	public String toString(){
		return String.valueOf(this.mutex);
	}
}

class ReaderThread implements Runnable{
	MutexLock mutex;
	MutexLock wrt;
	int i;

	public ReaderThread(int i, MutexLock mutex, MutexLock wrt) {
		this.mutex = mutex;
		this.wrt = wrt;
		this.i = i;
	}

	public void run() {
		mutex.wait0();
		if(ReaderAndWriter.readerCount.incrementAndGet() == 1) {
            wrt.wait0();
            System.out.println("writer wait");
        }
		mutex.signal();
		System.out.println("reader "+i+"  come in");
		try {Thread.sleep(300);}catch(InterruptedException e){e.printStackTrace();}
		System.out.println("reader "+i+"went out");
		mutex.wait0();
		if(ReaderAndWriter.readerCount.decrementAndGet() == 0) {
			wrt.signal();
		}
		mutex.signal();
	}

}

class WriterTh implements Runnable{
	MutexLock wrt;
	int i;

	public WriterTh(int i,MutexLock wrt) {
		this.wrt = wrt;
		this.i = i;
	}

	public void run() {
		wrt.wait0();
		System.out.println("writer "+i+" come in");
		try {Thread.sleep(500);}catch(InterruptedException e){e.printStackTrace();}
		System.out.println("writer "+i+" went out");
		wrt.signal();
	}

}
