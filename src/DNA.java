import java.util.Arrays;
import java.util.Random;

public class DNA {

    private char[] genes;
    private float fitness;
    private String target;
    private int dnaSize;


    DNA(int dnaSize, String target){
        this.dnaSize = dnaSize;
        this.target = target;
        genes = new char[dnaSize];
        for (int i = 0; i < genes.length; i++){
            genes[i] = RandomStringUtils.random();
        }
    }

    public float calculateFitness(){
        int score = 0;
        for (int i = 0; i < genes.length; i++){
            if(genes[i] == target.charAt(i))
                score++;
        }
        this.fitness = ((float)score)/target.length();
        return fitness;
    }

    @Override
    public String toString() {
        return String.valueOf(genes);
    }

    public float getFitness() {
        return fitness;
    }

    public DNA crossover(DNA partner){
        Random random = new Random();
        int midPoint = (int) random.nextFloat() * (0 - genes.length);
        DNA child = new DNA(this.dnaSize, this.target);
        for (int i = 0; i < genes.length; i++){
            if(i>midPoint) child.genes[i] = this.genes[i];
            else child.genes[i] = partner.genes[i];
        }
        return child;
    }

    public DNA mutate(float mutationRate) {

        Random random = new Random();

        for (int i = 0; i< genes.length; i++){
            float r  = random.nextFloat();
            //System.out.println("Random " + r);
            if(r < mutationRate){
                this.genes[i] = RandomStringUtils.random();
            }
        }
        return this;
    }
}
