package lab3MobDev

// Базовый класс "Посылка" с primary-конструктором
open class Parcel(val id: String, val weightKg: Double){
    // Валидация: идентификатор не должен быть пустым, а вес должен быть больше 0
    init {
        require(id.isNotBlank())
        require(weightKg > 0.0)
    }
    // Базовый метод расчета стоимости доставки (весом * 2.0)
    open fun shippingCost(): Double = weightKg * 2.0
}
// Класс "Экспресс-посылка", наследующий Parcel
class ExpressParcel(id: String, weightKg: Double) : Parcel(id, weightKg){
    // Переопределение метода: берет базовую стоимость из super.shippingCost() и добавляет фиксированную надбавку 15.0
    override fun shippingCost(): Double {
        return super.shippingCost() + 15.0
    }
}
// Класс "Эконом-посылка", наследующий Parcel
class EconomyParcel(id: String, weightKg: Double) : Parcel(id, weightKg){
    // Переопределение метода: высчитывает базовую стоимость через super.shippingCost() и применяет скидку 20%
    override fun shippingCost(): Double {
        return super.shippingCost() * 0.8
    }
}
// Функция расчета суммарной стоимости доставки для списка любых посылок
fun totalShipping(parcels: List<Parcel>): Double {
    return parcels.sumOf { it.shippingCost() } // Вызывает метод shippingCost() для каждого объекта в списке и суммирует результаты
}

fun main(){
    val parcels: List<Parcel> = listOf(
        Parcel("P1", 2.34),
        ExpressParcel("P2", weightKg = 3.1),
        EconomyParcel("P3", 5.5235)
    )
    val totalCost = totalShipping(parcels) // Расчет общей стоимости через функцию totalShipping
    println("Total shipping cost: $totalCost")
    println("Formatted: %.2f".format(totalCost))
}