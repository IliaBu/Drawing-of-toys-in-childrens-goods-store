package org.example.view;

import org.example.controller.Colors;
import org.example.model.Toy;
import org.example.services.DataServices;

import java.util.List;

/**
Базовый интерфейс для всех классов отображения
пользовательского интерфейса
*/
public abstract class BaseView{

    public abstract void action();

    /**
     * Отображение списка игрушек
     */
    public void showToysList() {
        List<Toy> list = DataServices.readData();
        System.out.println(Colors.GREEN + "============================================" + Colors.RESET);
        System.out.println(Colors.GREEN + "=========== Список игрушек =================" + Colors.RESET);
        System.out.println(Colors.GREEN + "============================================" + Colors.RESET);
        for (Toy toy : list) {
            System.out.printf(Colors.YELLOW + "Название игрушки: %s, Количество: %d шт., Коэффициент получения приза: %d\n", toy.getTitle(), toy.getAmount(), toy.getPriority(), Colors.RESET);
            System.out.println(Colors.GREEN + "__________________________________________________________________________" + Colors.RESET);
        }
        System.out.println(Colors.GREEN + "Справка по коэффициент получения приза:\n" +
                "Чем больше коэффициент получения приза, тем меньше шанс получить приз\n" +
                "то есть с коэффициентом '9' шанс примерно 1 к 100" + Colors.RESET);
    }
}

