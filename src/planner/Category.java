package planner;

import java.math.BigDecimal;

public class Category {

    private String name;
    private BigDecimal prediction;

    public Category(String name, BigDecimal prediction) {
        this.name = name;
        this.prediction = prediction;
    }
    public Category(String name) {
        this.name = name;
    }

    public Category createCategory (String nameCategory){
        Category myCategory = new Category(nameCategory);
        return myCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrediction() {
        return prediction;
    }

    public void setPrediction(BigDecimal prediction) {
        this.prediction = prediction;
    }
}
