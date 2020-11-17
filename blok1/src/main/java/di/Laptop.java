package di;

public class Laptop implements IComputer {

    @Override public void cpu() {
        System.out.println("tick");
    }
}
