package ru.netology;

public class Main {
    public synchronized static void main(String[] args) throws InterruptedException {

        System.out.println("Приветствие Мисиксов: ");

        ThreadGroup threadGroup = new ThreadGroup("group");
        Thread thread1 = new MyThread(threadGroup,"Я Мистер Мисикс 1!");
        Thread thread2 = new MyThread(threadGroup,"Я Мистер Мисикс 2!");
        Thread thread3 = new MyThread(threadGroup,"Я Мистер Мисикс 3!");
        Thread thread4 = new MyThread(threadGroup,"Я Мистер Мисикс 4!");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        Thread.sleep(10000);
        threadGroup.interrupt();
    }
}
