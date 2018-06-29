package com.developerbhuwan.typewriter.enrollment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NewApplicantTest {

    @Test
    void cannot_enroll_when_not_complete_academic_detail() {

    }

    @Test
    void cannot_enroll_when_not_complete_personal_detail() {

    }

    @Test
    void cannot_enroll_when_not_complete_parents_detail() {

    }

    @Test
    void cannot_enroll_when_not_complete_contact_detail() {

    }


    @Test
    void can_enroll() {
        NewApplicant applicant = new NewApplicant();
        applicant.enroll();
        assertEquals(NewApplicant.Status.PENDING_VERIFICATION, applicant.getStatus());
    }

}