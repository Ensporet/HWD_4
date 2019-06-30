package com.ConsoleСontrol;

import com.Console.ActValue.ActLong;
import com.Console.ActValue.ActString;
import com.Console.IAction;
import com.Console.ObjectConsoleDefault;
import com.Requests.RequestsPet;
import com.entity.Pet;
import org.jsoup.HttpStatusException;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class MenuPet extends ObjectConsoleDefault<IAction> {

    private final RequestsPet REQUEST_PET = new RequestsPet();

    public MenuPet() {

        super("Pets");

        getACTIONS().add(createActionAddANewPetToTheStore());
        getACTIONS().add(createActionUpdateAnExistingPet());
        getACTIONS().add(createActionFindsPetsByStatus());
        getACTIONS().add(createActionFindsPetsById());
        getACTIONS().add(createActionUpdatesPetWithFormData());
        getACTIONS().add(createActionDeletesAPet());
        getACTIONS().add(createActionUploadImage());


    }


    private IAction createActionAddANewPetToTheStore() {

        return new IAction() {
            @Override
            public String getName() {
                return "Add a new pet to the store";
            }

            @Override
            public void action() {

                Pet pet = new MenuCreatePet().getPet();
                if (pet == null) {
                    System.out.println("Pet is not create");
                    return;
                } else {
                    System.out.println("Pet is created");

                }


                try {
                    getREQUEST_PET().addNewPetStore(pet);
                    System.out.println("<New Pet added>");
                } catch (HttpStatusException httpStatusException) {
                    System.out.println(getREQUEST_PET().resultCode(httpStatusException.getStatusCode()));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("<Error!>");
                }

            }
        };
    }


    private IAction createActionUpdateAnExistingPet() {
        return new IAction() {
            @Override
            public String getName() {
                return "Update An Existing Pet";
            }

            @Override
            public void action() {
                Pet pet = new MenuCreatePet().getPet();
                if (pet == null) {
                    System.out.println("Pet is not create");
                    return;
                } else {
                    System.out.println("Pet is created");

                }
                try {
                    getREQUEST_PET().updateAnExistingPet(pet);
                    System.out.println("Pet is update");
                } catch (HttpStatusException httpStatusException) {
                    System.out.println(
                            getREQUEST_PET().resultCode(httpStatusException.getStatusCode()));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("<Error!>");
                }
            }
        };
    }


    private IAction createActionFindsPetsByStatus() {
        return new IAction() {
            @Override
            public String getName() {
                return "Finds Pets By Status";
            }

            @Override
            public void action() {

                MenuPetStatus menuPetStatus = new MenuPetStatus();
                if (menuPetStatus.getPetStatus() == null) {
                    System.out.println("Pet status not selected");
                    return;
                }


                try {
                    String result = getREQUEST_PET().findsPetsByStatus(menuPetStatus.getPetStatus());
                    System.out.println("Result : \n" + result);
                } catch (HttpStatusException httpStatusException) {
                    System.out.println(getREQUEST_PET().resultCode(httpStatusException.getStatusCode()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }


    private IAction createActionFindsPetsById() {
        return new IAction() {
            @Override
            public String getName() {
                return "Finds Pets By Id";
            }

            @Override
            public void action() {

                Long l = new ActLong().isTrueFormat(getScanner());
                if (l == null) {
                    System.out.println("Id not select");
                    return;
                }


                try {
                    System.out.println("Result : " + getREQUEST_PET().findsPetsById(l));
                } catch (HttpStatusException httpStatusException) {
                    System.out.println(getREQUEST_PET().resultCode(httpStatusException.getStatusCode()));
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }
        };
    }


    public IAction createActionUpdatesPetWithFormData() {
        return new IAction() {
            @Override
            public String getName() {
                return "Updates Pet With FormData";
            }

            @Override
            public void action() {

                System.out.println("Id");
                Long l = new ActLong().isTrueFormat(getScanner());
                if (l == null) {
                    System.out.println("Id not select");
                    return;
                }

                HashMap<String, Object> hashMap = new HashMap<>();

                System.out.println("Name");
                String n = new ActString().isTrueFormat(getScanner());
                if (n == null) {
                    System.out.println("name not entered");
                    return;
                }
                hashMap.put("name", n);


                MenuPetStatus menuPetStatus = new MenuPetStatus();
                if (menuPetStatus.getPetStatus() == null) {
                    System.out.println("Status not select");
                    return;
                }
                hashMap.put("status", menuPetStatus.getPetStatus());

                try {
                    getREQUEST_PET().updatesPetWithFormData(l, hashMap);
                    System.out.println("Update successfully");
                } catch (HttpStatusException httpStatusException) {
                    System.out.println(getREQUEST_PET().resultCode(httpStatusException.getStatusCode()));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("<Error>");
                }
            }
        };
    }


    private IAction createActionDeletesAPet() {
        return new IAction() {
            @Override
            public String getName() {
                return "Deletes A Pet";
            }

            @Override
            public void action() {

                System.out.println("Id");
                Long l = new ActLong().isTrueFormat(getScanner());
                if (l == null) {
                    System.out.println("Id not select");
                    return;
                }

                try {
                    getREQUEST_PET().deletesAPet(l);
                    System.out.println("Delete successfully");
                } catch (HttpStatusException h) {
                    System.out.println(getREQUEST_PET().resultCode(h.getStatusCode()));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("<Error>");
                }
            }
        };

    }


    private IAction createActionUploadImage() {
        return new IAction() {
            @Override
            public String getName() {
                return "Upload Image";
            }

            @Override
            public void action() {

                System.out.println("Id");
                Long l = new ActLong().isTrueFormat(getScanner());
                if (l == null) {
                    System.out.println("Id not select");
                    return;
                }

                System.out.println("File");
                File file = new File(new ActString().isTrueFormat(getScanner()));
                if (!file.exists()) {
                    System.out.println("File not exist !");
                    return;
                }

                System.out.println("Format");
                String s = new ActString().isTrueFormat(getScanner());
                if (s == null) {
                    System.out.println("Format not select!");
                    return;
                }

                try {
                    getREQUEST_PET().uploadImage(l, file, s);
                    System.out.println("File upload successfully");
                } catch (HttpStatusException ht) {
                    System.out.println(getREQUEST_PET().resultCode(ht.getStatusCode()));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("<Error>");
                }

            }
        };
    }


    public RequestsPet getREQUEST_PET() {
        return REQUEST_PET;
    }
}
