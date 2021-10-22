fun main() {
    val a = Point(x = 3.0, y = 2.0)
    val b = Point(x = -1.0, y = -3.0)
    println(a)
    println(b)
    println(a.move0Axis())
    println(b.move0Axis())
    println(a.calculateDistance(b))
    println(a == b)
    var fraction1 = Fraction(numerator = 3.0, denominator = 4.0)
    var fraction2 = Fraction(numerator = 6.0, denominator = 8.0)
    println(fraction1)
    println(fraction1.multiplyFraction(fraction2))
    println(fraction1.divideFraction(fraction2))
    println(fraction1.addFraction(fraction2))
    println(fraction1.substractFraction(fraction2))
    println(fraction2.simplifyFraction())



}

class Point(private val x: Double, private val y: Double) {


    override fun toString(): String {
        return "($x;$y)"
    }

    override fun equals(other: Any?): Boolean {
        if (other is Point) return (x == other.x && y == other.y)

        return false
    }

    fun move0Axis(): Pair<Double, Double> {
        return Pair(-x, -y)
    }

    fun calculateDistance(other: Point): Double {
        return kotlin.math.sqrt((x - other.x) * (x - other.x) + (y - other.y) * (y - other.y))


    }
}

class Fraction(private var numerator: Double, private var denominator: Double) {


    override fun equals(other: Any?): Boolean {
        if (other is Fraction) return (numerator * other.denominator / denominator == other.numerator)
        return false
    }

    fun multiplyFraction(other: Fraction): Fraction {
        return Fraction(numerator * other.numerator, denominator * other.denominator)
    }

    override fun toString(): String {
        if(denominator==0.0) return "NaN"
        else if (numerator==0.0) return "0.0"
        return "$numerator/$denominator"
    }

    fun divideFraction(other: Fraction): Fraction {
        return Fraction(numerator * other.denominator, denominator * other.numerator)
    }

    fun addFraction(other: Fraction): Fraction {
        if (denominator == 0.0 || other.denominator == 0.0) return Fraction(0.0, 0.0)
        else if (denominator == other.denominator) return Fraction((numerator + other.numerator), denominator)
        else if (denominator != other.denominator) return Fraction(
            (numerator * other.denominator + other.numerator * denominator),
            (denominator * other.denominator)
        )
        return Fraction(0.0, 0.0)
    }

    fun substractFraction(other: Fraction): Fraction {
        if (denominator == 0.0 || other.denominator == 0.0) return Fraction(0.0, 0.0)
        else if (denominator == other.denominator) return Fraction(numerator - other.numerator, denominator)
        else if (denominator != other.denominator) return Fraction(
            (numerator * other.denominator - other.numerator * denominator),
            (denominator * other.denominator)
        )
        return Fraction(0.0, 0.0)
    }
    fun simplifyFraction():Fraction{
        var i = 1
        var gcd = 1
        if(numerator<=0.0 && denominator<=0.0){
            while (i <= -numerator && i <= -denominator) {
                if (-numerator % i == 0.0 && -denominator % i == 0.0)
                    gcd = i
                gcd = -gcd
                ++i
            }
        }else if(numerator<=0.0 && denominator>=0.0){
            while(i <=-numerator && i<= denominator){
                if(-numerator%i==0.0 && denominator%i==0.0)
                    gcd = i
                gcd =-gcd
                ++i
            }
        }else if(numerator>=0.0 && denominator<=0.0){
            while(i<=numerator && i<= -denominator){
                if(numerator % i==0.0 && -denominator % i==0.0)
                    gcd = i
                gcd = -gcd
                ++i
            }
        }else{
            while(i<=numerator && i<= denominator){
                if(numerator%i==0.0 && denominator%i==0.0)
                    gcd = i
                ++i
            }
        }


        return Fraction(numerator/gcd , denominator/gcd)
    }



}



