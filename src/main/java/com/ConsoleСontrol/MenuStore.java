package com.ConsoleСontrol;


import com.Console.ActValue.ActLong;
import com.Console.IAction;
import com.Console.ObjectConsoleDefault;
import com.Requests.RequestsStore;
import com.entity.Order;
import org.jsoup.HttpStatusException;

import java.io.IOException;

public class MenuStore extends ObjectConsoleDefault {

    private final RequestsStore REQUESTS_STORE = new RequestsStore();

    public MenuStore() {
        super("Store");
    }


    @Override
    protected void update() {

        getACTIONS().add(createActionDeletePurchaseOrderByID());
        getACTIONS().add(createActionFindPurchaseOrderById());
        getACTIONS().add(createActionReturnsPetInventoriesByStatus());
        getACTIONS().add(createPlaceAnOrderForAPet());

        super.update();
    }

    private IAction createActionReturnsPetInventoriesByStatus() {
        return new IAction() {
            @Override
            public String getName() {
                return "Returns Pet Inventories By Status";
            }

            @Override
            public void action() {

                try {
                    System.out.println("Result : " + getREQUESTS_STORE().returnsPetInventoriesByStatus());
                } catch (HttpStatusException h) {
                    System.out.println(getREQUESTS_STORE().resultCode(h.getStatusCode()));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        };
    }


    private IAction createPlaceAnOrderForAPet() {
        return new IAction() {
            @Override
            public String getName() {
                return "Place An Order For A Pet";
            }

            @Override
            public void action() {

                Order order = (Order) new MenuOrder(null).getObject();
                if (order != null) {
                    try {
                        getREQUESTS_STORE().placeAnOrderForAPet(order);
                        System.out.println("Place order is successfully");
                    } catch (HttpStatusException h) {
                        System.out.println(getREQUESTS_STORE().resultCode(h.getStatusCode()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }
        };
    }

    private IAction createActionFindPurchaseOrderById() {
        return new IAction() {
            @Override
            public String getName() {
                return "Find Purchase Order By Id";
            }

            @Override
            public void action() {

                Long l = new ActLong().isTrueFormat(getScanner());
                if (l != null) {
                    try {
                        System.out.println("Result : " + getREQUESTS_STORE().findPurchaseOrderById(l));
                    } catch (HttpStatusException h) {
                        System.out.println(getREQUESTS_STORE().resultCode(h.getStatusCode()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }
        };
    }


    private IAction createActionDeletePurchaseOrderByID() {

        return new IAction() {
            @Override
            public String getName() {
                return "Delete Purchase Order By ID";
            }

            @Override
            public void action() {

                Long l = new ActLong().isTrueFormat(getScanner());
                if (l != null) {
                    try {
                        getREQUESTS_STORE().deletePurchaseOrderByID(l);
                        System.out.println("Delete is successfully");
                    } catch (HttpStatusException h) {
                        System.out.println(getREQUESTS_STORE().resultCode(h.getStatusCode()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }

        };

    }


    public RequestsStore getREQUESTS_STORE() {
        return REQUESTS_STORE;
    }
}
