package ma.enset.ga.sma;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;

public class MasterAgent extends Agent {
    @Override
    protected void setup() {
        DFAgentDescription dfAgentDescription  = new DFAgentDescription();
        dfAgentDescription.setName((getAID()));
        ServiceDescription serviceDescription = new ServiceDescription();
        serviceDescription.setName("island");
        serviceDescription.setType("ga");
        dfAgentDescription.addServices(serviceDescription);
        try {
            DFService.register(this,dfAgentDescription);
        } catch (FIPAException e) {
            throw new RuntimeException(e);
        }
    }
}
