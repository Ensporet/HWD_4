package com.ConsoleСontrol;


import com.Console.IAction;
import com.Console.Values.MenuSetValueClass;
import com.entity.Order;

public class MenuOrder extends MenuSetValueClass {


    public MenuOrder(Order obj) {
        super("Order", (obj == null) ? new Order() : obj);
    }

    @Override
    protected void updateActions() {
        super.updateActions();

    }

    @Override
    protected void update() {
        super.update();
        getACTIONS().add(createActionOrderStatus());
    }

    private IAction createActionOrderStatus() {
        return new IAction() {
            @Override
            public String getName() {
                return "Order status : " + ((Order) getObject()).getStatus();
            }

            @Override
            public void action() {


                MenuOrderStatus status = new MenuOrderStatus();
                if (status.getStatus() != null) {
                    ((Order) getObject()).setStatus(status.getStatus());
                }
            }
        };
    }


}
