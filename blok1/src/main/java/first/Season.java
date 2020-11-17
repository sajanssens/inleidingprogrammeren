package first;

public enum Season {

    SPRING("Lente"), SUMMER("Zomer"), AUTUMN("Herfst"), WINTER("Winter");
    // 0             1                2                 3

    private String description;

    Season(String description){
        this.description = description;
    }

    String geefWaarde() { return this.description; }

}
