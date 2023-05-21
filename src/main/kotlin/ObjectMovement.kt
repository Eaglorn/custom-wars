class ObjectMovement {
    private var angle = 0.0
    fun rotateObject(angleChange: Double) {
        angle += angleChange
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // Задаем начальные координаты объекта
            var x = 0
            var y = 0

            // Задаем начальный угол поворота объекта
            var angle = 0.0

            // Задаем вектор движения
            val vectorX = 3
            val vectorY = 4

            // Нормализуем вектор движения
            val vectorLength = Math.sqrt((vectorX * vectorX + vectorY * vectorY).toDouble())
            val normalizedVectorX = vectorX / vectorLength
            val normalizedVectorY = vectorY / vectorLength

            // Задаем скорость объекта
            var speed = 5

            // Задаем угловую скорость объекта
            val angularSpeed = 0.1

            // Задаем ускорение объекта
            val acceleration = 0.1

            // Вычисляем новые координаты объекта
            x += (speed * normalizedVectorX).toInt()
            y += (speed * normalizedVectorY).toInt()

            // Вычисляем новый угол поворота объекта
            angle += angularSpeed

            // Изменяем скорость объекта в зависимости от ускорения
            speed += (acceleration * vectorLength).toInt()

            // Выводим новые координаты объекта и его угол поворота
            println("Новые координаты объекта: ($x, $y)")
            println("Новый угол поворота объекта: $angle")
        }
    }
}