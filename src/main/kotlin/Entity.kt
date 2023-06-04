import java.awt.Color
import java.awt.Graphics2D
import java.awt.geom.Point2D

internal open class Entity(color: Color) {
    var x: Double = 0.0
    var y: Double = 0.0
    private var speedCurrent: Float = 0f
    var speedAcceleration: Float = 0f
    var speedMax: Float = 0f
    var pathX: Double = 0.0
    var pathY: Double = 0.0
    var diameter: Float? = null
    var faction: Color = color
    var maxHP: Float = 0f
    var hp: Float = 0f
    var radiusInteraction: Float = 0f
    var damage: Float = 0f
    var lastDamage = 0
    var radiusDamage = 0f
    var pereodicDamage = 0f
    var magazine = 0
    var maxMagazine = 0
    var magazineReload = 0
    var currentReload = 0

    var life = true

    var target: Entity? = null

    open fun render(graphics: Graphics2D) {}

    open fun update() {}

    open fun gun(bullet: Bullet) {
        bullet.faction = faction
    }

    fun moveEnemy() {
        if (target != null) {
            val distance = Point2D.distance(x, y, target!!.x, target!!.y)
            if (distance <= radiusInteraction - 2) {
                speedCurrent += speedMax * speedAcceleration
            } else {
                speedCurrent -= speedMax * speedAcceleration
            }
            moved(Point2D.distance(0.0, y, 0.0, target!!.y) / distance, Point2D.distance(x, 0.0, target!!.x, 0.0) / distance)
        }
        stopMovedScreen()
    }

    fun moveAlly() {
        if (target != null) {
            val distance = Point2D.distance(x, y, target!!.x, target!!.y)
            if (distance <= 10) {
                speedCurrent += speedMax * speedAcceleration
            } else {
                speedCurrent -= speedMax * speedAcceleration
            }
            moved(Point2D.distance(0.0, y, 0.0, target!!.y) / distance, Point2D.distance(x, 0.0, target!!.x, 0.0) / distance)
        }
        stopMovedScreen()
    }

    private fun moved(speedX: Double, speedY: Double) {
        if (speedCurrent > speedMax) {
            speedCurrent = speedMax
        } else if (speedCurrent < -speedMax) {
            speedCurrent = -speedMax
        }
        if (x > target!!.x) {
            x += speedX * speedCurrent
        } else {
            x -= speedX * speedCurrent
        }
        if (y > target!!.y) {
            y += speedY * speedCurrent
        } else {
            y -= speedY * speedCurrent
        }
    }

    private fun stopMovedScreen() {
        if (x > CustomWars.WIDTH) {
            x = CustomWars.WIDTH.toDouble()
            speedCurrent = 0.0f
        }
        if (x < 0) {
            x = 0.0
            speedCurrent = 0.0f
        }
        if (y > CustomWars.HEIGHT) {
            y = CustomWars.HEIGHT.toDouble()
            speedCurrent = 0.0f
        }
        if (y < 0) {
            y = 0.0
            speedCurrent = 0.0f
        }
    }
}
