package com.ConsoleСontrol;

import com.Console.ActValue.ActLong;
import com.Console.ActValue.ActString;
import com.Console.IAction;
import com.Console.ObjectConsole;
import com.Console.ObjectConsoleDefault;
import com.Console.Values.MenuSetValueClass;
import com.entity.Category;
import com.entity.Pet;
import com.entity.Tag;

import java.util.ArrayList;
import java.util.List;

public class MenuCreatePet extends ObjectConsoleDefault {

    private Pet pet = new Pet();

    public MenuCreatePet() {
        super("Create Pet");


        action();
    }


    @Override
    protected void update() {
        getACTIONS().clear();
        getACTIONS().add(createActionCategories());
        getACTIONS().add((createActionId()));
        getACTIONS().add(createActionName());
        getACTIONS().add(creteActionPhotoURL());
        getACTIONS().add(createAddNewTag());
        getACTIONS().add(createActionPetStatus());
        super.update();
    }


    private IAction createActionPetStatus() {
        return new IAction() {
            @Override
            public String getName() {
                return "Pet Status : " + getPet().getStatus();
            }

            @Override
            public void action() {

                MenuPetStatus menuPetStatus = new MenuPetStatus();
                if (menuPetStatus.getPetStatus() != null) {
                    getPet().setStatus(menuPetStatus.getPetStatus());
                    ObjectConsole.ConsoleUpdate = true;
                }


            }
        };
    }

    private IAction createAddNewTag() {
        return new IAction() {
            @Override
            public String getName() {
                return "List Tags : " + getPet().getTags();
            }

            @Override
            public void action() {
                if (getPet().getTags() == null) {
                    getPet().setTags(new ArrayList<>());
                }


                Tag tag = new Tag();
                new MenuSetValueClass("Create Tags", tag);
                if (tag.getId() != null && tag.getName() != null) {
                    getPet().getTags().add(tag);
                    System.out.println("Tag is create");
                    ObjectConsole.ConsoleUpdate = true;
                } else {
                    System.out.println("Tag is not create");
                }

            }
        };
    }


    private IAction creteActionPhotoURL() {
        return new IAction() {
            @Override
            public String getName() {
                return "Photo url " + " : " + getPet().getPhotoUrls();
            }

            @Override
            public void action() {

                final String SEPARATOR = "'";

                System.out.println(
                        "Entered url photos used this separator <"
                                + SEPARATOR
                                + "> example: https://fff,https://app");

                String s = getScanner().nextLine();
                List list = new ArrayList();
                for (String url : s.split(SEPARATOR)) {
                    list.add(url);
                }
                if (getPet().getPhotoUrls() == null) {
                    getPet().setPhotoUrls(list);
                } else {
                    getPet().getPhotoUrls().clear();
                    getPet().getPhotoUrls().addAll(list);
                }

                ObjectConsole.ConsoleUpdate = true;
            }
        };
    }

    private IAction createActionName() {
        return new IAction() {
            @Override
            public String getName() {
                return "Name " + " : " + getPet().getName();
            }

            @Override
            public void action() {

                String s = new ActString().isTrueFormat(getScanner());
                if (s != null) {
                    getPet().setName(s);
                    ObjectConsole.ConsoleUpdate = true;
                }
            }
        };
    }

    private IAction createActionId() {
        return new IAction() {
            @Override
            public String getName() {
                return "Id " + " : " + getPet().getId();
            }

            @Override
            public void action() {

                Long l = new ActLong().isTrueFormat(getScanner());
                if (l != null) {
                    getPet().setId(l);
                    ObjectConsole.ConsoleUpdate = true;
                }
            }
        };
    }

    private IAction createActionCategories() {
        final String name = "Categories";

        return new IAction() {
            @Override
            public String getName() {
                return name + " : " + getPet().getCategory();
            }

            @Override
            public void action() {

                Category category = new Category();
                new MenuSetValueClass(name, category);
                if (category.getId() != null && category.getName() != null) {
                    System.out.println("Category is crafted");
                    getPet().setCategory(category);
                    ObjectConsole.ConsoleUpdate = true;
                } else {
                    System.out.println("Category is not create");
                }

            }
        };
    }


    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
