package com.example.app

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorUnitTest {

    @Test
    fun calculate20PercentTipNoRoundup() {
        val amount = 10.00
        val tipPercent = 20.00
        val expectedTip = 2.00
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent)
        assertEquals(expectedTip, actualTip, 0.001)
        assertEquals(formatCurrency(expectedTip), formatCurrency(actualTip))
    }
}