package ru.netology;

public class MyThread extends Thread{

    public MyThread(ThreadGroup group,String name) {
        super(group, name);
    }

    @Override
    public void run() {
        try {
            while(!isInterrupted()) {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + " Посмотрите на меня!");
            }
        } catch (InterruptedException err) {
            System.out.println("\nПоток прерван:" + err.getMessage());
        } finally{
            Thread.currentThread().interrupt();
            System.out.printf("%s Задачу выполнил!!!\n", getName());
        }
    }
}
