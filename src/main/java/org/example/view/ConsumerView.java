package org.example.view;

import org.example.controller.Colors;
import org.example.model.Question;
import org.example.services.DataServices;
import org.example.services.userServices.ConsumerServices;

import java.util.List;
import java.util.Scanner;

/**
Класс отображения интерфейса для работы в режиме потребителя
обработка запросов и данных из консоли
*/
public class ConsumerView extends BaseView {

    private final ConsumerServices services;

    public ConsumerView() {
        services = new ConsumerServices();
    }

    @Override
    public void action() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println(Colors.GREEN + "============================================" + Colors.RESET);
            System.out.println(Colors.GREEN + """
                    Выберите действие (введите нужное число):
                    1. Участвовать в викторине и получить приз.
                    2. Показать список всех игрушек.
                    0. Выход из программы.""" + Colors.RESET);
        int input = scanner.nextInt();

        switch (input) {
            case 1 -> {
                List<Question> list = DataServices.getQuestions();
                Question question = services.choiceQuestion(list);
                System.out.print(Colors.BLUE + "\t\tОтгадай загадку, получишь приз:\n" + Colors.RESET);
                System.out.printf(Colors.BLUE + "%s\nВыберите вариант ответа\n", question.getBody(), Colors.RESET);
                for (String str : question.getListAnswer()) {
                    System.out.printf(Colors.BLUE + "\t%s\n", str, Colors.RESET);
                }
                scanner.nextInt();
                while (true) {
                    if (input == question.getTrueAnswer()) {
                        String toy = services.getPrize();
                        System.out.printf(Colors.CYAN + "ПОЗДРАВЛЯЕМ!!! ВАШ ПРИЗ: >>> %s <<<\n", toy, Colors.RESET);
                        break;
                    } else {
                        System.out.println(Colors.MAGENTA + "Вы не угадали, попробуйте еще раз." + Colors.RESET);
                        scanner.nextInt();
                    }
                }
            }
            case 2 -> {
                showToysList();
            }
            case 0 -> {
                return;
            }
            default -> {
                System.out.println(Colors.RED + "Некорректное значение, повторите ввод." + Colors.RESET);
            }
        }
        }
    }
}



