package ma.enset.ga.sma;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SequentialBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import ma.enset.ga.sequencial.GAUtils;
import ma.enset.ga.sequencial.Individual;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class IslandAgent extends Agent {
    private Individual[] population = new Individual[GAUtils.POPULATION_SIZE];

    private Individual individual1;
    public Individual individual2;

@Override
    protected void setup()
    {

        SequentialBehaviour sequentialBehaviour = new SequentialBehaviour();
        sequentialBehaviour.addSubBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                      initialize();
                      sortPopulation();
            }
        });
        sequentialBehaviour.addSubBehaviour(new Behaviour() {
           int iter =0;
             @Override
            public void action() {
                crossover();
                mutation();
                sortPopulation();
                iter++;

            }

            @Override
            public boolean done() {
                return  GAUtils.MAX_IT==iter || getBestFintness()==GAUtils.CHROMOSOME_SIZE;
            }
        });
        sequentialBehaviour.addSubBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                DFAgentDescription dfAgentDescription = new DFAgentDescription();
                ServiceDescription serviceDescription = new ServiceDescription();
                serviceDescription.setType("ga");
                dfAgentDescription.addServices(serviceDescription);
                DFAgentDescription[] dfAgentDescriptions;
                try {
                    dfAgentDescriptions = DFService.search(getAgent(),dfAgentDescription);
                } catch (FIPAException e) {
                    throw new RuntimeException(e);
                }

                ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
                aclMessage.addReceiver(dfAgentDescriptions[0].getName());
                aclMessage.setContent(Arrays.toString(population[0].getGenes())+" "+String.valueOf(population[0].getFitness()));
                send(aclMessage);


            }
        });
        addBehaviour(sequentialBehaviour);


    }
    public void initialize()
    {
        for (int i = 0; i < GAUtils.POPULATION_SIZE; i++) {
            population[i] = new Individual();
            population[i].calculateFitness();


        }
    }
    public void crossover() {
        individual1 = new Individual(population[0].getGenes());
        individual2 = new Individual(population[1].getGenes());
        Random random = new Random();
        int crossPoint = random.nextInt(GAUtils.CHROMOSOME_SIZE - 1);
        crossPoint++;
        for (int i = 0; i < crossPoint; i++) {
            individual1.getGenes()[i] = population[1].getGenes()[i];
            individual2.getGenes()[i] = population[0].getGenes()[i];
        }
    }
    public void showPopulation(){
        for (Individual individual:population) {
            System.out.println(Arrays.toString(individual.getGenes())+" = "+individual.getFitness());
        }
    }
    public void sortPopulation(){
        Arrays.sort(population, Comparator.reverseOrder());
    }
    public void mutation(){
        Random random=new Random();
        // individual1
        if(random.nextDouble()>GAUtils.MUTATION_PROB){
            int index = random.nextInt(GAUtils.CHROMOSOME_SIZE);
            individual1.getGenes()[index]=GAUtils.CHARATERS.charAt(random.nextInt(GAUtils.CHARATERS.length()));
        }
        // individual2
        if(random.nextDouble()>GAUtils.MUTATION_PROB){
            int index = random.nextInt(GAUtils.CHROMOSOME_SIZE);
            individual2.getGenes()[index]=GAUtils.CHARATERS.charAt(random.nextInt(GAUtils.CHARATERS.length()));
        }
        // System.out.println("Après mutation ");
        // System.out.println("Individual 1 "+Arrays.toString(individual1.getChromosome()));
        //System.out.println("Individual 2 "+Arrays.toString(individual2.getChromosome()));
        individual1.calculateFitness();
        individual2.calculateFitness();
        population[GAUtils.POPULATION_SIZE-2]=individual1;
        population[GAUtils.POPULATION_SIZE-1]=individual2;


    }
    public int getBestFintness(){
        return population[0].getFitness();
    }
    @Override
    protected void takeDown() {
        try {
            DFService.deregister(this);
        } catch (FIPAException e) {

        }
    }
}
