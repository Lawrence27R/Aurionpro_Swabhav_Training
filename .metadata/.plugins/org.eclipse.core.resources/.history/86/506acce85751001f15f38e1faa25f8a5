package com.aurionpro.behavioural.chainofrespon.test;

import com.aurionpro.behavioural.chainofrespon.model.ISupportHandler;
import com.aurionpro.behavioural.chainofrespon.model.ManagerLevelSupportHandler;
import com.aurionpro.behavioural.chainofrespon.model.Priority;
import com.aurionpro.behavioural.chainofrespon.model.Request;
import com.aurionpro.behavioural.chainofrespon.model.StaffLevelSupportHandler;
import com.aurionpro.behavioural.chainofrespon.model.SupervisorLevelSupportHandler;

public class RequestTest {
    public static void main(String[] args) {
        ISupportHandler staffLevel = new StaffLevelSupportHandler();
        ISupportHandler SupervisorLevel = new SupervisorLevelSupportHandler();
        ISupportHandler managerLevel = new ManagerLevelSupportHandler();

        staffLevel.setNextHandler(SupervisorLevel);
        SupervisorLevel.setNextHandler(managerLevel);

        Request request1 = new Request(Priority.BASIC);
        Request request2 = new Request(Priority.INTERMEDIATE);
        Request request3 = new Request(Priority.CRITICAL);

        staffLevel.handleRequest(request1);
        System.out.println();
        staffLevel.handleRequest(request2);
        System.out.println();
        staffLevel.handleRequest(request3);
    }
}
