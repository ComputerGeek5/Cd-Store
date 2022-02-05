package com.example.techstore.validator;

import com.example.techstore.model.Cd;

public interface CdValidator {
    String cdExistsErrorMessage = "This cd already exists";

    boolean validateCreatedCd(Cd cd);

    boolean validateUpdatedCd(Cd cd);
}
