package com.ConsoleСontrol;

import com.Console.ActValue.ActString;
import com.Console.IAction;
import com.Console.ObjectConsoleDefault;
import com.Console.Values.MenuSetValueClass;
import com.Requests.RequestsUser;
import com.entity.User;
import org.jsoup.HttpStatusException;

import java.io.IOException;

public class MenuUser extends ObjectConsoleDefault {

    private final RequestsUser REQUEST_USER = new RequestsUser();

    public MenuUser() {
        super("User");
        getACTIONS().add(createIActionGetUserByUserName());
        getACTIONS().add(createIActionCreatesListOfUsersWithGivenInputArray());
        getACTIONS().add(createIActionCreateUser());
        getACTIONS().add(createIActionUpdatedUser());
        getACTIONS().add(createIActionLogsUserIntoTheSystem());
        getACTIONS().add(createIActionLogsOutCurrentLoggedInUserSession());
        getACTIONS().add(createIActionDeleteUser());

    }


    private IAction createIActionCreateUser() {
        return new IAction() {
            @Override
            public String getName() {
                return "Create User";
            }

            @Override
            public void action() {


                User user = (User) new MenuSetValueClass("Create User", new User()).getObject();

                try {
                    getREQUEST_USER().createUser(user);
                    System.out.println("User created");
                } catch (HttpStatusException h) {
                    System.out.println(getREQUEST_USER().resultCode(h.getStatusCode()));

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        };

    }

    private IAction createIActionCreatesListOfUsersWithGivenInputArray() {
        return new IAction() {
            @Override
            public String getName() {
                return "Creates List Of Users With Given Input Array";
            }

            @Override
            public void action() {


                User[] listUser = {
                        new User(1L, "Admin", "???", "???", "email", "123", "099", 1L),
                        new User(2L, "Moderator", "???", "???", "email", "123", "099", 2L),
                        new User(3L, "Tester", "???", "???", "email", "123", "099", 3L)};


                for (User user : listUser) {
                    System.out.println("User create : " + user);
                }

                try {
                    getREQUEST_USER().createsListOfUsersWithGivenInputArray(listUser);
                    System.out.println("List user added");
                } catch (HttpStatusException h) {
                    System.out.println(getREQUEST_USER().resultCode(h.getStatusCode()));

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        };

    }


    private IAction createIActionLogsUserIntoTheSystem() {
        return new IAction() {
            @Override
            public String getName() {
                return "Logs User Into The System";
            }

            @Override
            public void action() {

                System.out.println("Entered name ");
                String name = new ActString().isTrueFormat(getScanner());
                if (name == null) {
                    return;
                }

                System.out.println("Entered password ");
                String password = new ActString().isTrueFormat(getScanner());
                if (password == null) {
                    return;
                }


                try {
                    System.out.println("Result : " + getREQUEST_USER().logsUserIntoTheSystem(name, password) + " successfully");
                } catch (HttpStatusException h) {
                    System.out.println(getREQUEST_USER().resultCode(h.getStatusCode()));

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        };

    }

    private IAction createIActionLogsOutCurrentLoggedInUserSession() {
        return new IAction() {
            @Override
            public String getName() {
                return "Logs Out Current Logged In User Session";
            }

            @Override
            public void action() {


                try {
                    System.out.println("Result : " + getREQUEST_USER().logsOutCurrentLoggedInUserSession());
                } catch (HttpStatusException h) {
                    System.out.println(getREQUEST_USER().resultCode(h.getStatusCode()));

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        };

    }

    private IAction createIActionGetUserByUserName() {
        return new IAction() {
            @Override
            public String getName() {
                return "Get User By User Name";
            }

            @Override
            public void action() {

                System.out.println("UserName");
                String name = new ActString().isTrueFormat(getScanner());
                if (name == null) {
                    return;
                }

                try {
                    System.out.println("Result : " + getREQUEST_USER().getUserByUserName(name));
                } catch (HttpStatusException h) {
                    System.out.println(getREQUEST_USER().resultCode(h.getStatusCode()));

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        };

    }

    private IAction createIActionUpdatedUser() {
        return new IAction() {
            @Override
            public String getName() {
                return "Updated User";
            }

            @Override
            public void action() {

                User user = (User) new MenuSetValueClass("User update", new User()).getObject();

                try {
                    getREQUEST_USER().updatedUser(user);
                    System.out.println("User update");
                } catch (HttpStatusException h) {
                    System.out.println(getREQUEST_USER().resultCode(h.getStatusCode()));

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        };

    }

    private IAction createIActionDeleteUser() {
        return new IAction() {
            @Override
            public String getName() {
                return "Delete User";
            }

            @Override
            public void action() {

                System.out.println("UserName");
                String name = new ActString().isTrueFormat(getScanner());
                if (name == null) {
                    return;
                }


                try {
                    getREQUEST_USER().deleteUser(name);
                    System.out.println("User deleted");
                } catch (HttpStatusException h) {
                    System.out.println(getREQUEST_USER().resultCode(h.getStatusCode()));

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        };

    }


    public RequestsUser getREQUEST_USER() {
        return REQUEST_USER;
    }
}
