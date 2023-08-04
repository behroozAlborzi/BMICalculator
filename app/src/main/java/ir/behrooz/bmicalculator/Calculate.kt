package ir.behrooz.bmicalculator

class Calculate {

    fun calculateBMI(height:Double?,weight:Double?): Double? {


        if (height == null || weight == null) {
            return null
        }

        return ChangeFormatDecimal().convertLongDecimalToShortDecimal(weight / (height * height))



    }

}