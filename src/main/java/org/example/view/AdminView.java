package org.example.view;

import org.example.controller.Colors;
import org.example.services.userServices.AdminServices;

import java.util.Scanner;

/**
 * Класс отображения интерфейса для работы в режиме администратора
 * обработка запросов и данных из консоли
 */
public class AdminView extends BaseView {

    private final AdminServices services;

    public AdminView() {
        services = new AdminServices();
    }

    /**
     * Выбор действия
     */
    @Override
    public void action() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(Colors.CYAN + "Введите пароль: " + Colors.RESET);
        String password = scanner.nextLine();

        while (true) {

            if (!services.checkPassword(password)) {
                System.out.println(Colors.RED + "Некорректный пароль, повторите ввод.\n:>>> " + Colors.RESET);
                password = scanner.nextLine();
                continue;
            }

            System.out.println(Colors.BLUE + """
                    Выберите действие (введите нужное число):
                    1. Добавить игрушки в список.
                    2. Показать список всех игрушек.
                    3. Добавить вопрос для викторины.
                    4. Показать список всех вопросов викторины.
                    0. Выход из программы.""" + Colors.RESET);
            String input = scanner.nextLine();

                switch (input) {
                    case "1" -> {
                        services.addToy();
                    }
                    case "2" -> {
                        showToysList();
                    }
                    case "3" -> {
                        services.addQuestion();
                    }
                    case "4" -> {
                        services.getQuestionList();
                    }
                    case "0" -> {
                        return;
                    }
                    default -> {
                        System.out.println(Colors.RED + "Некорректное значение, повторите ввод." + Colors.RESET);
                    }
                }
            }
        }
}



