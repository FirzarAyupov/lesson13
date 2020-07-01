package ru.ayupov.task13;

public class Child {
    private final Foods[] approvedFoods;

    public Child(Foods[] approvedFoods) {
        this.approvedFoods = approvedFoods;
    }

    public String getApprovedFoods() {
        StringBuilder result = new StringBuilder();
        for (Foods af : approvedFoods) {
            result.append(af.getTitle());
            result.append(" ");
        }
        return result.toString();
    }

    public String eat(Foods food) throws FeedingException {
        String result = "";
        if (searchFoodInApprovedList(food)) {
            result = "съел " + food.getTitle() + " за обе щеки";
        } else {
            try {
                throw new FeedingException("Ребенок не любит " + food.getTitle());
            } catch (FeedingException ex) {
                throw ex;
            } finally {
                System.out.println("спасибо, мама");//TODO: Есть ли иной способ для вывода "спасибо, мама" из класса ребенка?
            }
        }
        result += System.lineSeparator() + "спасибо, мама";
        return result;
    }

    private boolean searchFoodInApprovedList(Foods food) {
        for (Foods f : this.approvedFoods) {
            if (f == food) {
                return true;
            }
        }
        return false;
    }

}
