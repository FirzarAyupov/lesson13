package ru.ayupov.task13;

public enum Foods {

    CARROT ("морковь"),
    APPLE ("яблоко"),
    BANANA("банан"),
    ICECREAM("мороженое"),
    SOUP("суп"),
    PORRIDGE ("каша");


    private String title;

    Foods(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Food{" +
                "title='" + title + '\'' +
                '}';
    }
}
