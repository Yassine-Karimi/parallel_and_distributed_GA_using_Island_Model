package ma.enset.ga.sma;

import jade.core.Agent;
import ma.enset.ga.sequencial.GAUtils;
import ma.enset.ga.sequencial.Individual;

public class IslandAgent extends Agent {
    private Individual[] population = new Individual[GAUtils.POPULATION_SIZE];

    private Individual individual1;
    public Individual individual2;

@Override
    protected void setup()
    {

    }
}
