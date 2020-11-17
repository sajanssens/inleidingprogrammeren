package unittesting.stringadder;

public class StringAdder {

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        } else if (input.length() == 1) {
            return Integer.parseInt(input);
        } else if (input.contains(",")) {
            String[] split = input.split(",");
            String n1 = split[0].trim();
            String n2 = split[1].trim();
            int i1 = Integer.parseInt(n1);
            int i2 = Integer.parseInt(n2);
            return i1 + i2;
        } else {
            throw new RuntimeException("Not implemented yet!");
        }
    }
}
