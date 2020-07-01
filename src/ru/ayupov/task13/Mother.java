package ru.ayupov.task13;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Написать программу "воспитанный ребенок".
 * <p>
 * Программа должна имитировать поведение воспитанного ребенка, которого мама кормит вкусной или невкусной едой.
 * Если еда не нравится, ребенок ее не ест: выбрасывается исключительная ситуация, которая обрабатывается «мамой».
 * Воспитанный ребенок, даже если еда не естся, в любом случае скажет «спасибо» и поцелует маму.
 * <p>
 * Создать перечисление «Еда» с несколькими вариантами еды: морковь, яблоко, каша и т.д.
 * Создать класс «ребенок» с методом «кушать», принимающий на вход некоторую еду. В методе происходит сравнение
 * поступившей еды с вкусовыми предпочтениями и в случае если они не совпадают, выбрасывается исключение.
 * «Одобренная» ребенком еда съедается: возвращается сообщение «съел … за обе щеки».
 * <p>
 * Вне зависимости съел ребенок еду или выплюнул, ребенок благодарит маму, печатая в консоль «спасибо, мама».
 * <p>
 * Создать главный класс и метод main - это будет «Мама». «Мама» дает ребенку «еду» и обрабатывает исключения ребенка.
 */


public class Mother {
    private final Child child;

    public Mother() {
        Foods[] foodsWhiteList = {Foods.APPLE, Foods.BANANA, Foods.SOUP};
        child = new Child(foodsWhiteList);
    }

    void feeding(Child child, Foods food) {
        try {
            System.out.println(child.eat(food));
        } catch (FeedingException e) {
            e.printStackTrace();
        }
    }

    private void foodList() {
        System.out.println("Выберите еду для кормления:");
        System.out.println("1 - морковь");
        System.out.println("2 - яблоко");
        System.out.println("3 - банан");
        System.out.println("4 - мороженое");
        System.out.println("5 - суп");
        System.out.println("6 - каша");
        System.out.println("0 - Выход");
    }

    void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ребенок любит: " + child.getApprovedFoods());
        foodList();
        while (sc.hasNextInt()) {
            switch (sc.nextInt()) {
                case 1:
                    feeding(child, Foods.CARROT);
                    break;
                case 2:
                    feeding(child, Foods.APPLE);
                    break;
                case 3:
                    feeding(child, Foods.BANANA);
                    break;
                case 4:
                    feeding(child, Foods.ICECREAM);
                    break;
                case 5:
                    feeding(child, Foods.SOUP);
                    break;
                case 6:
                    feeding(child, Foods.PORRIDGE);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Неизвестная комманда!");
                    foodList();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new Mother().run();
    }
}


