package com.developerbhuwan.typewriter.enrollment;

import lombok.Getter;
import lombok.Value;

import java.time.LocalDate;

class NewApplicant {

    private PersonalDetail personalDetail;

    @Getter
    private Status status;

    void enroll() {

        this.status = Status.PENDING_VERIFICATION;
    }

    enum Status {
        PENDING_VERIFICATION
    }

    enum Gender {
        MALE, FEMALE
    }

    @Value
    static class PersonalDetail {

        private final String firstName;
        private final String middleName;
        private final String lastName;
        private final LocalDate dateOfBirth;
        private final Gender gender;

    }
}
