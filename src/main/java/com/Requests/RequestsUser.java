package com.Requests;


import com.entity.User;

import java.io.IOException;

public class RequestsUser extends RequestPetsStore {


    public RequestsUser() {
    }


    public void createUser(User user) throws IOException {

        requestPost(getLINKS().urlUser(), getGSON().toJson(user));
    }

    public void createsListOfUsersWithGivenInputArray(User[] list) throws IOException {
        requestPost(getLINKS().urlUserCreateWithArray(), getGSON().toJson(list));
    }


    public String logsUserIntoTheSystem(String name, String password) throws IOException {
        return requestGet(getLINKS().urlUserLogin() + "?username=" + name + "?password=" + password);
    }


    public String logsOutCurrentLoggedInUserSession() throws IOException {
        return requestGet(getLINKS().urlUserLogout());
    }


    public String getUserByUserName(String name) throws IOException {
        return requestGet(getLINKS().urlUserValue(name));
    }

    public void updatedUser(User user) throws IOException {
        requestPut(getLINKS().urlUserValue(user.getUsername()), getGSON().toJson(user));
    }

    public void deleteUser(String name) throws IOException {
        requestDeletes(getLINKS().urlUserValue(name));
    }

    @Override
    public String resultCode(int code) {
        final String ANSWER = "Answer " + code + " : ";
        switch (code) {
            case 200:
                return ANSWER + "successful operation";
            case 400:
                return ANSWER + "Invalid username/password supplied";
            case 404:
                return ANSWER + "User not found";

            default:
                return super.resultCode(code);
        }
    }


}
