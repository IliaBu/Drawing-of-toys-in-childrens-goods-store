package org.example.services.userServices;

import org.example.model.Question;
import org.example.model.Toy;
import org.example.services.DataServices;
import java.util.List;
import java.util.Random;

/**
 * Класс обрабатывает запросы из интерфейса потребителя
*/
public class ConsumerServices {

    /**
     * Получает приз
     * @return строку
     */
    public String getPrize() {
        List<Toy> toyList = DataServices.readData();
        int value = priorityValue();

        for (Toy toy : toyList) {
            if (toy.getPriority() == value) {
                if (toy.getAmount() > 0) {
                    toy.setAmount(toy.getAmount() - 1);
                    DataServices.reWriteData(toyList);
                    return toy.getTitle();
                } else {
                    getPrize();
                    toyList.remove(toy);
                    DataServices.reWriteData(toyList);
                }
            }
        }
        return getPrize();
    }

    /**
     * Получение данных о всех игрушках в виде списка
     * @return список игрушек
     */
    public List<Toy> getPrizesList() {
        return DataServices.readData();
    }

    /**
     * Обрабатывает запрос к списку вопросов
     * @param list список вопросов
     * @return случайно один из вопросов
     */
    public Question choiceQuestion(List<Question> list) {
        return list.get(new Random().nextInt(list.size()));
    }

    /**
     * Генерация случайного значения, для получения приза(игрушки)
     *         чем меньше значение, тем больше шанс получить приз.
     * @return случайное числовое значение
     */
    private int priorityValue() {
        int seed = new Random().nextInt(9) + 1;
        return new Random().nextInt(seed + 1);
    }

}