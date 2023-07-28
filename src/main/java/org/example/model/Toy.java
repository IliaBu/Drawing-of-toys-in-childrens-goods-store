package org.example.model;
import org.example.controller.Colors;
import java.util.Objects;

/**
    @id - уникальный идентификатор игрушки
    @title - название игрушки
    @amount - количество игрушек
    @priority - приоритет/шанс выпадения игрушки
*/
public class Toy implements Comparable<Toy> {

    private int id;

    private String title;

    private int amount;

    private int priority;

    public Toy(int id, String title, int amount, int priority) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        if (priority > 9 || priority < 1) {
            System.out.println(Colors.RED + "Некорректное значение параметра 'priority'.\nУстановлено значение по-умолчанию: 5" + Colors.RESET);
            this.priority = 5;
        } else {
            this.priority = priority;
        }
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPriority() {
        return priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Toy toy = (Toy) o;

        if (id != toy.id) return false;
        if (amount != toy.amount) return false;
        if (priority != toy.priority) return false;
        return Objects.equals(title, toy.title);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + amount;
        result = 31 * result + priority;
        return result;
    }

    @Override
    public String toString() {
        return Colors.BLUE + "Toy{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", amount=" + amount +
                ", priority=" + priority +
                '}' + Colors.RESET;
    }

    @Override
    public int compareTo(Toy toy) {
        return this.priority - toy.getPriority();
    }
}