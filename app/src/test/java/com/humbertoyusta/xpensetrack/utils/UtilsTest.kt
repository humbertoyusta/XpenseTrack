package com.humbertoyusta.xpensetrack.utils

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class UtilsTest {
    @Test
    fun displayAmount_PositiveBalance_ReturnExpected() {
        val balance = "100.0"
        val result = displayAmount(balance)
        assertEquals(result, "€100.0")
    }

    @Test
    fun displayAmount_ZeroBalance_ReturnsExpected() {
        val balance = "0"
        val result = displayAmount(balance)
        assertEquals(result, "€0")
    }

    @Test
    fun displayAmount_NegativeBalance_ReturnsExpected() {
        val balance = "-20.50"
        val result = displayAmount(balance)
        assertEquals(result, "-€20.50")
    }

    @Test
    fun displayAmount_NegativeBalance_DoesNotCutAfterComma() {
        val balance = "-20.00"
        val result = displayAmount(balance)
        assertNotEquals(result, "-€20")
    }
}