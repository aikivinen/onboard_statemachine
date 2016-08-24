package com.state_machine.core.states;

import com.state_machine.core.actions.Action;
import com.state_machine.core.providers.ActionProvider;
import com.state_machine.core.states.util.ErrorType;
import com.state_machine.core.states.util.Failure;
import mavros_msgs.SetModeRequest;
import mavros_msgs.SetModeResponse;
import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.logging.Log;
import org.ros.exception.RemoteException;
import org.ros.message.Time;
import org.ros.node.service.ServiceClient;
import org.ros.node.service.ServiceResponseListener;

import java.util.List;

public class IdleState extends State {

    public IdleState(ActionProvider actionProvider,
                     ServiceClient<SetModeRequest, SetModeResponse> setModeService,
                     Log log) {
        super(actionProvider, setModeService, log);
        prerequisites.add(actionProvider.getSetFCUModeAction("STABILIZE"));
        prerequisites.add(actionProvider.getDisarmAction());
    }

    public void chooseNextAction(Time time){
    }

    public boolean isIdling() { return true; }

    public boolean isSafeToExit(){
        return true;
    }

    public String toString() {
        return "IdleState";
    }
}
