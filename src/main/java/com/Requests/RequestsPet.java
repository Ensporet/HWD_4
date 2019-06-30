package com.Requests;

import com.entity.Pet;
import com.entity.PetStatus;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;


public class RequestsPet extends RequestPetsStore {


    public RequestsPet() {
    }


    public void addNewPetStore(Pet pet) throws IOException {
        requestPost(getLINKS().urlPet(), getGSON().toJson(pet));
    }

    public void updateAnExistingPet(Pet pet) throws IOException {
        requestPut(getLINKS().urlPet(), getGSON().toJson(pet));
    }

    public String findsPetsByStatus(PetStatus status) throws IOException {

        System.out.println(requestGet(getLINKS().urlFindBySTATUS(status)));
        return requestGet(getLINKS().urlFindBySTATUS(status));
    }

    public String findsPetsById(Long id) throws IOException {

        return requestGet(getLINKS().urlPetValue(id));

    }

    public void updatesPetWithFormData(long id, HashMap<String, Object> data) throws IOException {
        requestPutData(getLINKS().urlPetValue(id), data);
    }

    public void deletesAPet(long id) throws IOException {
        requestDeletes(getLINKS().urlPetValue(id));
    }


    public void uploadImage(long id, File file, String format) throws IOException {
        requestUpdateFile(getLINKS().urlPetValueUploadImage(id), file, format);
    }


    @Override
    public String resultCode(int code) {

        final String ANSWER = "Answer " + code + " : ";
        switch (code) {
            case 405:
                return ANSWER + "Invalid input" + "Validation exception";
            case 400:
                return ANSWER + "Invalid ID supplied";
            case 404:
                return ANSWER + "Pet not found";
            case 200:
                return ANSWER + "successful operation";

            default:
                return super.resultCode(code);
        }

    }


}
