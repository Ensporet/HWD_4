package com.ConsoleСontrol;

import com.Console.IAction;
import com.Console.ObjectConsole;
import com.Console.ObjectConsoleDefault;
import com.entity.PetStatus;

public class MenuPetStatus extends ObjectConsoleDefault {

    private PetStatus petStatus;


    public MenuPetStatus() {
        super("Pet Status");

        action();

    }

    @Override
    protected void update() {
        updateActions();
        super.update();
    }

    private void updateActions() {
        getACTIONS().clear();

        for (PetStatus petStatus : PetStatus.values()) {
            getACTIONS().add(createAction(petStatus));
        }
    }


    private IAction createAction(PetStatus petStatus) {
        return new IAction() {
            @Override
            public String getName() {
                return petStatus.name();
            }

            @Override
            public void action() {
                setPetStatus(petStatus);
                ObjectConsole.ConsoleIteration = ObjectConsole.ITERATION_CLOSE;
            }
        };
    }

    public PetStatus getPetStatus() {
        return petStatus;
    }

    public void setPetStatus(PetStatus petStatus) {
        this.petStatus = petStatus;
    }
}
