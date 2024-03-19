package controller;

import java.util.concurrent.Semaphore;

public class ThreadController extends Thread {

	private int idThread;
	private static int tempo;
	private Semaphore semaforo;

	public ThreadController(int idThread, Semaphore semaforo) {
		super();
		this.idThread = idThread;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		ThreadCalc();
		try {
			semaforo.acquire();
			ThreadArmazem();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	public void ThreadCalc() {
		System.out.println("A thread " + idThread + " está realizando o cálculo...");
		if (idThread % 3 == 1) {
			tempo = (int) (Math.random() * 1001) + 200;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else if (idThread % 3 == 2) {
			tempo = (int) (Math.random() * 1501) + 500;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			tempo = (int) (Math.random() * 2001) + 1000;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Cálculo da thread " + idThread + " terminado.");
	}

	public void ThreadArmazem() {
		System.out.println("A thread " + idThread + " está fazendo a transação.");
		if (idThread % 3 == 1) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else if (idThread % 3 == 2) {
			try {
				sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			try {
				sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Transação da thread " + idThread + " terminado.");
	}
}