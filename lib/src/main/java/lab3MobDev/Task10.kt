package lab3MobDev
// Базовый класс для билетов
open class Ticket(val code: String, val basePrice: Int){
    init {
        require(code.isNotBlank())
        require(basePrice > 0)
    }

    // Базовый метод получения цены
    open fun price(): Int = basePrice
}

// Билет для взрослого (использует базовую цену)
class AdultTicket(code: String, basePrice: Int) : Ticket(code, basePrice)

// Детский билет с кодом опекуна
class ChildTicket(code: String, basePrice: Int, val guardianCode: String) : Ticket(code, basePrice){
    init {
        require(guardianCode.isNotBlank())
    }

    // Скидка 50% от базовой стоимости
    override fun price(): Int = super.price() / 2
}

// VIP-билет с доступом в бизнес-зал
class VipTicket(code: String, basePrice: Int, val loungeAccess: Boolean) : Ticket(code, basePrice){
    //Доплата за VIP-статус и бизнес-зал
    override fun price(): Int = super.price() + if (loungeAccess) 50 else 20
}

//Вычисление итоговой стоимости всех билетов (Полиморфизм)
fun checkout(tickets: List<Ticket>): Int{
    return tickets.sumOf { it.price() }
}

// Фильтрация кодов опекунов с использованием is + Smart Cast
fun childGuardianCodes(tickets: List<Ticket>): List<String>{
    val result = mutableListOf<String>()
    for (ticket in tickets){
        //Smart Cast: если ticket является ChildTicket, компилятор автоматически дает доступ к полю guardianCode
        if (ticket is ChildTicket){
            result.add(ticket.guardianCode)
        }
    }
    return result
}
fun main(){
    // Создаем список различных билетов
    val tickets: List<Ticket> = listOf(
        AdultTicket("A-101", 100),                      // price = 100
        ChildTicket("C-201", 60, guardianCode = "G-1"),  // price = 30
        VipTicket("V-301", 20, loungeAccess = true),    // price = 20 + 50 = 70
        ChildTicket("C-202", 60, guardianCode = "G-9")   // price = 30
    )

    val total = checkout(tickets)
    val guardians = childGuardianCodes(tickets)

    println("total=$total")
    println("guardians=${guardians.joinToString(", ")}")
}