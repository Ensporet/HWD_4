package com.Requests;

import com.entity.PetStatus;
import lombok.Data;

@Data
class Links {

    private final String
            PET = "pet",
            FIND_BI_STATUS = "pet/findByStatus?status=",
            UPLOAD_IMAGE = "uploadImage",
            USER = "user",
            CREATE_WITH_ARRAY = "createWithArray",
            CREATE_WITH_LIST = "createWithList",
            LOGIN = "login",
            LOGOUT = "logout",
            STORE = "store",
            INVENTORY = "inventory",
            ORDER = "order",
            BASE_URL = "https://petstore.swagger.io/v2";
    private final char SEPARATOR = '/';


    public final String PARAMETERS(Object o) {
        return (o == null) ? "" : o.toString();
    }


    // Pet
    public String urlPet() {
        return builderUrl(getPET());
    }

    public String urlFindBySTATUS(PetStatus petStatus) {
        return builderUrl(getPET(), getFIND_BI_STATUS() + petStatus);
    }

    public String urlPetValue(Object obj) {
        return builderUrl(getPET(), PARAMETERS(obj));
    }

    public String urlPetValueUploadImage(Object object) {
        return builderUrl(getPET(), PARAMETERS(object), getUPLOAD_IMAGE());
    }

    // Store
    public String urlStoreInventory() {
        return builderUrl(getSTORE(), getINVENTORY());
    }

    public String urlStoreOrder() {
        return builderUrl(getSTORE(), getORDER());
    }

    public String urlStoreOrderValue(Object value) {
        return builderUrl(getSTORE(), getORDER(), PARAMETERS(value));
    }

    // user

    public String urlUser() {
        return builderUrl(getUSER());
    }

    public String urlUserCreateWithArray() {
        return builderUrl(getUSER(), getCREATE_WITH_ARRAY());
    }

    public String urlUserCreateWithList() {
        return builderUrl(getUSER(), getCREATE_WITH_LIST());
    }

    public String urlUserLogin() {
        return builderUrl(getUSER(), getLOGIN());
    }

    public String urlUserLogout() {
        return builderUrl(getUSER(), getLOGOUT());
    }

    public String urlUserValue(Object value) {
        return builderUrl(getUSER(), PARAMETERS(value));
    }


    private String builderUrl(String... string) {

        StringBuilder stringBuilder = null;
        for (String s : string) {
            if (stringBuilder == null) {
                stringBuilder = new StringBuilder().append(getBASE_URL());
            }
            stringBuilder.append(getSEPARATOR());
            stringBuilder.append(s);

        }
        return stringBuilder.toString();
    }

}
