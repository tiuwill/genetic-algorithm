import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static sun.misc.Version.println;

public class GeneticAlgorithm {

    private DNA[] population;
    private String target;
    private ArrayList<DNA> matingPool = new ArrayList<>();
    private float mutationRate;
    private DNA best;
    private int dnaSize;



    GeneticAlgorithm(int populationSize, int dnaSize, String target,float mutationRate){
        this.dnaSize = dnaSize;
        this.best = new DNA(dnaSize,target);
        this.mutationRate = mutationRate;
        this.target = target;
        population = new DNA[populationSize];
        setup(dnaSize, target);
    }

    public void run(){
        int generation = 1;
        //while (generation<20000){
        while (!best.toString().equals(target)) {
            this.updateMatingPool();
            System.out.println("best so far : " + best.toString());
            System.out.println("Generation: " + generation);
            System.out.println("Best fitness: " + best.getFitness() * 100);

            //GERA NOVA POPULAçÂO
            for (int i = 0; i< population.length; i++){
                population[i] = this.reproduce();
            }
            generation++;
        }
        //this.showMatingPool();
    }

    private void setup(int dnaSize, String target){
        for (int i = 0; i < population.length; i++){
            population[i] = new DNA(dnaSize, target);
        }
    }

    public DNA reproduce(){
        Random random = new Random();
        int a = (int)(random.nextFloat() * (0 - matingPool.size()));
        if(a < 0)
            a  = a * -1;

        int b = (int)(random.nextFloat() * (0 - matingPool.size()));

        if(b < 0)
            b  = b * -1;


      //  System.out.println("PARENT: "+ a);

        DNA parentA = matingPool.get(a);
        DNA parentB = matingPool.get(b);

        DNA child =  parentA.crossover(parentB);
        return child.mutate(mutationRate);
    }


    public void calculateFitness(){
        for (int i = 0; i < population.length; i++){
            population[i].calculateFitness();
        }
    }

    public void updateMatingPool(){
        this.best = new DNA(dnaSize,target);
        matingPool = new ArrayList<>();
        for (int i = 0; i < population.length; i++){
            int n = (int) (population[i].calculateFitness() * 100);
            if(best.getFitness() < population[i].getFitness())
                best = population[i];

            for (int j = 0; j < n; j++){
                matingPool.add(population[i]);
            }
        }
    }

    public void show(){
        Arrays.stream(population).forEach(System.out::println);
    }

    public void showFitness(){
        Arrays.stream(population).forEach(dna -> System.out.println(dna.getFitness()));
    }

    public void showMatingPool(){
        matingPool.forEach(System.out::println);
    }

}
