package com.sergeytsemerov.mytests

import org.junit.Assert.*
import org.junit.Test

class EmailValidatorTest {

    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.com"))
    }

    @Test
    fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.co.uk"))
    }

    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email"))
    }

    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email..com"))
    }

    @Test
    fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("@email.com"))
    }

    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(""))
    }

    @Test
    fun emailValidator_NullEmail_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(null))
    }

    @Test
    fun emailValidator_CorrectEmailSimple_NegativeTest() {
        assertTrue(EmailValidator.isValidEmail("name@email...com"))
    }

    @Test
    fun emailValidator_CorrectEmailSubDomain_NegativeTest() {
        assertTrue(EmailValidator.isValidEmail("name@email.@co.uk"))
    }

    @Test
    fun emailValidator_InvalidEmailNoTld_NegativeTest() {
        assertTrue(EmailValidator.isValidEmail("name@email"))
    }

    @Test
    fun emailValidator_emailEqualsAnotherEmail_ReturnsTrue() {
        assertEquals("name@email.com", EmailValidator.emailEquals("name@email.com"))
    }

    @Test
    fun emailValidator_emailNotEqualsAnotherEmail_ReturnsTrue() {
        assertNotEquals("name@mail.com", EmailValidator.emailEquals("name@email.com"))
    }

    @Test
    fun emailValidator_arrayOfEmailsIsEqual_ReturnsTrue() {
        assertArrayEquals(
            arrayOf("name@email.com", "name@gmail.com"), EmailValidator.arrayOfEmails(
                arrayOf("name@email.com", "name@gmail.com")
            )
        )
    }

    @Test
    fun emailValidator_arrayOfEmailsIsNotEqual_ReturnsFalse() {
        assertArrayEquals(
            arrayOf("name@email.com", "name@gmail.com"), EmailValidator.arrayOfEmails(
                arrayOf("name@email.com", "namename@gmail.com")
            )
        )
    }

    @Test
    fun emailValidator_emailIsNull_ReturnsTrue() {
        assertNull(EmailValidator.emailNullExaminer(null))
    }

    @Test
    fun emailValidator_emailIsNotNull_ReturnsTrue() {
        assertNotNull(EmailValidator.emailNullExaminer("name@test.com"))
    }

    @Test
    fun emailValidator_emailIsTheSameAs_ReturnsTrue() {
        assertSame("name@test.com", EmailValidator.emailEquals("name@test.com"))
    }
}