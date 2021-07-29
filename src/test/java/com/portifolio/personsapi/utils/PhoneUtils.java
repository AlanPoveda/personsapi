package com.portifolio.personsapi.utils;

import com.portifolio.personsapi.dto.request.PhonesDTO;
import com.portifolio.personsapi.entity.Phone;
import com.portifolio.personsapi.enums.PhoneType;

public class PhoneUtils {

    private static final String PHONE_NUMBER = "119999-9999";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1l;

    public static PhonesDTO createFakeDTO(){
        return PhonesDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity(){
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}
