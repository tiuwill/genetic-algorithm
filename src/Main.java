import java.util.Random;

public class Main {

    public static void main(String[] args) {

        String target = "to be or not to be";

        GeneticAlgorithm ga = new GeneticAlgorithm(
                1000,
                target.length(),
                target,
                0.01f
                );

          ga.run();
//        ga.updateMatingPool();
//        ga.showMatingPool();
    }

}
