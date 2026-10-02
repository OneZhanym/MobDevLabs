package lab3MobDev

open class Assessment(val title: String, val maxPoints: Int){
    init {
        require(title.isNotBlank())
        require(maxPoints > 0)
    }
    // Базовый расчет коэффициента оценки: нормализация raw-баллов в диапазон [0.0, 1.0]
    open fun scoreTowardGrade(raw:Int): Double{
        return raw.coerceIn(0, maxPoints).toDouble() / maxPoints
    }
}

//Класс "Тест" с штрафом за просрочку
class Quiz(title: String, maxPoints: Int, val penaltyIfLate: Double) : Assessment(title, maxPoints){
    init {
        require(penaltyIfLate in 0.0..0.5)
    }
    // Переопределение: получаем базовый коэффициент через super.scoreTowardGrade(raw)
    // и умножаем его на множитель штрафа (1.0 - penaltyIfLate)
    override fun scoreTowardGrade(raw: Int): Double {
        return super.scoreTowardGrade(raw) * (1.0 - penaltyIfLate)
    }
}

// Класс "Проект" с возможностью получения бонусных баллов
class Project(title: String, maxPoints: Int, val bonusCap: Double): Assessment(title, maxPoints){
    init {
        require(bonusCap in 0.0..0.5)
    }
    /*
     Формула расчета:
     1. Вызываем super.scoreTowardGrade(raw) для расчета базовой доли (максимум 1.0 для очков до maxPoints).
     2. Если raw превышает maxPoints, рассчитываем избыточную долю (лишние баллы / maxPoints)
        и ограничиваем её сверху значением bonusCap через .coerceAtMost(bonusCap).
     3. Итоговый коэффициент равен базовой доле плюс ограниченный бонус.
    */
    override fun scoreTowardGrade(raw: Int): Double {
        val baseScore = super.scoreTowardGrade(raw)
        val bonusRatio = if (raw > maxPoints) {
            ((raw - maxPoints).toDouble() / maxPoints).coerceAtMost(bonusCap)
        } else {
            0.0
        }
        return baseScore + bonusRatio
    }
}

fun main(){
    val assessments: List<Assessment> = listOf(
        Assessment("Midterm Exam", 100),
        Quiz("Kotlin Basic Quiz", 20, penaltyIfLate = 0.2),
        Project("Android App Project", 100, bonusCap = 0.15)
    )
    val sampleRaw = 110
    println("Scoring results for raw points = $sampleRaw:\n")
    for (a in assessments){
        val score = a.scoreTowardGrade(sampleRaw)
        val percentage = score * 100
        println("${a.title} (${a::class.simpleName}):")
        println(" Max points: ${a.maxPoints}")
        println(" Final score ratio: %.4f (%.2f%%)\n".format(score, percentage))
    }
}