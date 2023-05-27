package ma.enset.ga.sma;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;
import jade.wrapper.StaleProxyException;
import ma.enset.ga.sequencial.GAUtils;

public class SimpleContainer {
    public static void main(String[] args) throws ControllerException {
        Runtime runtime = Runtime.instance();
        ProfileImpl profile = new ProfileImpl();
        profile.setParameter(Profile.MAIN_HOST, "localhost");
        AgentContainer agentContainer = runtime.createAgentContainer(profile);
        for (int i = 0; i < GAUtils.ISLAND_NUMBER; i++) {
            AgentController IslandAgent = agentContainer.createNewAgent("Island"+i,IslandAgent.class.getName(),new Object[]{});
            IslandAgent.start();
        }
        AgentController masterAgent = agentContainer.createNewAgent("masteragent",MainContainer.class.getName(),new Object[]{});
    masterAgent.start();
    }
}
