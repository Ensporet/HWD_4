package com.Requests;


import com.entity.Order;

import java.io.IOException;

public class RequestsStore extends RequestPetsStore {

    public RequestsStore() {
    }


    public String returnsPetInventoriesByStatus() throws IOException {
        return requestGet(getLINKS().urlStoreInventory());
    }

    public void placeAnOrderForAPet(Order order) throws IOException {
        requestPost(getLINKS().urlStoreOrder(), getGSON().toJson(order));
    }

    public String findPurchaseOrderById(Long id) throws IOException {
        return requestGet(getLINKS().urlStoreOrderValue(id));
    }

    public void deletePurchaseOrderByID(Long id) throws IOException {
        requestDeletes(getLINKS().urlStoreOrderValue(id));
    }


    @Override
    public String resultCode(int code) {

        final String ANSWER = "Answer " + code + " : ";

        switch (code) {
            case 200:
                return ANSWER + "successful operation";
            case 400:
                return ANSWER + "Invalid Order \\" + "Invalid ID supplied";
            case 404:
                return ANSWER + "Order not found";


            default:
                return super.resultCode(code);
        }
    }


}
