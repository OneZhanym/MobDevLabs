package lab3MobDev

//Базовый клас для всех уведомлений
open class Notification(private val payload: String) {
    init {
        require(payload.isNotBlank())
    }
    // protected метод: доступен в дочерних классах EmailNotification и SmsNotification,
    // но защищен от прямого вызова извне (например, из функции main или sendAll)
    protected fun body(): String = payload

    // Базовый метод отрисовки уведомления
    open fun render(): String = body()
}

//Класс для отправки по Email
class EmailNotification(payload: String, val to: String): Notification(payload){
    init {
        require(to.isNotBlank())
    }

    //Дочерний класс видит protected метод body() и форматирует строку
    override fun render(): String = "Email to $to: ${body()}"
}

//Класс для отправки по SMS
class SmsNotification(payload: String, val phone: String): Notification(payload){
    init {
        require(phone.isNotBlank())
    }

    //Дочерний класс видит protected метод body() и форматирует строку
    override fun render(): String = "SMS to $phone: ${body()}"
}

//Функция рассылки всех уведомлений
fun sendAll(items: List<Notification>){
    for (item in items) {
        //Полиморфный вызов: для каждого типа вызывается своя версия render()
        println(item.render())
    }
}
fun main(){
    val notification: List<Notification> = listOf(
        Notification("System reboot scheduled"),
        EmailNotification("Your invoice is ready", "user@example.com"),
        SmsNotification("Your verification code is 4821", "+1234567890")
    )
    println("Sending all notifications:\n")
    sendAll(notification)
    // Проверка инкапсуляции:
    // val n = Notification("Test")
    // n.payload  // ОШИБКА: payload — private
    // n.body()     // ОШИБКА: body() — protected (недоступен снаружи)
}