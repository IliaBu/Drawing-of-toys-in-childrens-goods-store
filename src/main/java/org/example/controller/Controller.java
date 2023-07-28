package org.example.controller;
import org.example.view.AdminView;
import org.example.view.BaseView;
import org.example.view.ConsumerView;
import java.util.Scanner;

/**
 * Класс, обрабатывает запросы пользователя из консоли
*/
public class Controller {

    public void Start() {
        System.out.println(Colors.YELLOW + "============ Лотерея игрушек ===============" + Colors.RESET);
        System.out.println("\tДля работы в режиме администратора, введите:\n\t1 (требуется пароль: 123456)");
        System.out.println("\tДля работы в режиме потребителя, введите:\n\t2");
        System.out.println(Colors.YELLOW + "============================================" + Colors.RESET);

        int input;
        Scanner scanner = new Scanner(System.in);
        BaseView[] view = {new AdminView(), new ConsumerView()};
        do {
            System.out.print(": ");
            while (!scanner.hasNextInt()) {
                System.out.println("Вводите только 1 или 2!");
                scanner.next();
            }
            input = scanner.nextInt();
            new Controller().appStart(view, input);
        } while (input > 2 || input <= 0);
    }

    public void appStart(BaseView[] view, int args) {
        switch (args) {
            case 1 -> {
                System.out.println("Режим работы: Администратора");
                System.out.println(Colors.BLUE + "============ Лотерея игрушек ===============" + Colors.RESET);
                view[0].action();
            }
            case 2 -> {
                System.out.println("Режим работы: Потребитель");
                System.out.println(Colors.GREEN + "============ Лотерея игрушек ===============" + Colors.RESET);
                view[1].action();
            }
        }
    }
}