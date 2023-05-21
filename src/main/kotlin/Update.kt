import java.awt.Color

internal class Update(game: CustomWars) {
    private var update = System.currentTimeMillis()
    private var game: CustomWars? = null

    init {
        this.game = game
    }

    fun update() {
        if (System.currentTimeMillis() - update >= 1000 / tick) {
            update = System.currentTimeMillis()
            for (e in CustomWars.entity) {
                if (e.life) {
                    e.update()
                }
            }
            for (e in CustomWars.bullet) {
                if (e.life) {
                    e.update()
                }
            }
            for (e in CustomWars.effect) {
                if (e.life) {
                    e.update()
                }
            }

            for (i in CustomWars.entity.size - 1 downTo 0) {
                if (!CustomWars.entity[i].life) CustomWars.entity.removeAt(i)
            }

            for (i in CustomWars.bullet.size - 1 downTo 0) {
                if (!CustomWars.bullet[i].life) CustomWars.bullet.removeAt(i)
            }

            for (i in CustomWars.effect.size - 1 downTo 0) {
                if (!CustomWars.effect[i].life) CustomWars.effect.removeAt(i)
            }

            var green = 0
            var orange = 0
            for (e in CustomWars.entity)
                if (e.life)
                    if (e.faction === Color.GREEN) {
                        green++
                    } else
                        orange++
        }
    }

    companion object {
        internal const val tick = 35
    }
}