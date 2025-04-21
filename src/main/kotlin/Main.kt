package ru.netology

fun main() {
    //проверка
    for (i in -60..24 * 60 * 60 * 3 + 1000 step 500) {
        agoToText(i)
    }

}

fun agoToText(ago: Int) {
    val time: Int = when {
        ago in 0..3600 -> ago / 60
        ago > 3600 -> ago / 3600
        else -> ago
    }

    val text: String = when {
        ago in 0..60 -> "только что"
        ago in 61..60 * 60 -> "$time ${minutesForm(time)} назад"
        ago in 60 * 60 + 1..24 * 60 * 60 -> "$time ${hoursForm(time)} назад"
        ago in 24 * 60 * 60 + 1..24 * 60 * 60 * 2 -> "вчера"
        ago in 24 * 60 * 60 * 2..24 * 60 * 60 * 3 -> "позавчера"
        ago > 24 * 60 * 60 * 3 + 1 -> "давно"

        else -> "неизвестно когда" //если значение будет null или отрицательным
    }

    println("был(а) $text")
}

fun minutesForm(minutes: Int): String {

    val lastDigit: Int = minutes % 10 //последняя цифра

    return when {

        minutes in 11..14 -> "минут"
        lastDigit == 1 -> "минуту"
        lastDigit in 2..4 -> "минуты"

        else -> "минут"
    }
}

fun hoursForm(hours: Int): String = when (hours) {
    1, 21 -> "час"
    in 2..4, in 22..24 -> "часа"
    else -> "часов"
}