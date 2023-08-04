package ir.behrooz.bmicalculator

class ChangeFormatDecimal {

    fun convertLongDecimalToShortDecimal(decimal: Double): Double =
        String.format("%.2f", decimal).toDouble()

}