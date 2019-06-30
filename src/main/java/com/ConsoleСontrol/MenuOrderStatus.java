package com.ConsoleСontrol;

import com.Console.IAction;
import com.Console.ObjectConsole;
import com.Console.ObjectConsoleDefault;
import com.entity.OrderStatus;

public class MenuOrderStatus extends ObjectConsoleDefault {

    private OrderStatus status;


    public MenuOrderStatus() {
        super("Order Status");

        action();

    }

    @Override
    protected void update() {
        updateActions();
        super.update();
    }

    private void updateActions() {
        getACTIONS().clear();

        for (OrderStatus status : OrderStatus.values()) {
            getACTIONS().add(createAction(status));
        }
    }


    private IAction createAction(OrderStatus status) {
        return new IAction() {
            @Override
            public String getName() {
                return status.name();
            }

            @Override
            public void action() {
                setStatus(status);
                ObjectConsole.ConsoleIteration = ObjectConsole.ITERATION_CLOSE;
            }
        };
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
