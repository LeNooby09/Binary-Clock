import java.time.LocalTime
import javax.swing.JFrame
import javax.swing.JTextArea
import javax.swing.WindowConstants
import kotlin.concurrent.fixedRateTimer

val patterns = arrayOf(
    "[ ][ ][ ][ ][ ][ ]", "[ ][ ][ ][ ][ ][#]", "[ ][ ][ ][ ][#][ ]", "[ ][ ][ ][ ][#][#]",
    "[ ][ ][ ][#][ ][ ]", "[ ][ ][ ][#][ ][#]", "[ ][ ][ ][#][#][ ]", "[ ][ ][ ][#][#][#]",
    "[ ][ ][#][ ][ ][ ]", "[ ][ ][#][ ][ ][#]", "[ ][ ][#][ ][#][ ]", "[ ][ ][#][ ][#][#]",
    "[ ][ ][#][#][ ][ ]", "[ ][ ][#][#][ ][#]", "[ ][ ][#][#][#][ ]", "[ ][ ][#][#][#][#]",
    "[ ][#][ ][ ][ ][ ]", "[ ][#][ ][ ][ ][#]", "[ ][#][ ][ ][#][ ]", "[ ][#][ ][ ][#][#]",
    "[ ][#][ ][#][ ][ ]", "[ ][#][ ][#][ ][#]", "[ ][#][ ][#][#][ ]", "[ ][#][ ][#][#][#]",
    "[ ][#][#][ ][ ][ ]", "[ ][#][#][ ][ ][#]", "[ ][#][#][ ][#][ ]", "[ ][#][#][ ][#][#]",
    "[ ][#][#][#][ ][ ]", "[ ][#][#][#][ ][#]", "[ ][#][#][#][#][ ]", "[ ][#][#][#][#][#]",
    "[#][ ][ ][ ][ ][ ]", "[#][ ][ ][ ][ ][#]", "[#][ ][ ][ ][#][ ]", "[#][ ][ ][ ][#][#]",
    "[#][ ][ ][#][ ][ ]", "[#][ ][ ][#][ ][#]", "[#][ ][ ][#][#][ ]", "[#][ ][ ][#][#][#]",
    "[#][ ][#][ ][ ][ ]", "[#][ ][#][ ][ ][#]", "[#][ ][#][ ][#][ ]", "[#][ ][#][ ][#][#]",
    "[#][ ][#][#][ ][ ]", "[#][ ][#][#][ ][#]", "[#][ ][#][#][#][ ]", "[#][ ][#][#][#][#]",
    "[#][#][ ][ ][ ][ ]", "[#][#][ ][ ][ ][#]", "[#][#][ ][ ][#][ ]", "[#][#][ ][ ][#][#]",
    "[#][#][ ][#][ ][ ]", "[#][#][ ][#][ ][#]", "[#][#][ ][#][#][ ]", "[#][#][ ][#][#][#]",
    "[#][#][#][ ][ ][ ]", "[#][#][#][ ][ ][#]", "[#][#][#][ ][#][ ]", "[#][#][#][ ][#][#]",
    "[#][#][#][#][ ][ ]", "[#][#][#][#][ ][#]", "[#][#][#][#][#][ ]", "[#][#][#][#][#][#]"
)

fun updateTextArea(textArea: JTextArea, frame: JFrame) {
    val now = LocalTime.now()
    textArea.text = "${patterns[now.hour]}\n${patterns[now.minute]}\n${patterns[now.second]}"
    frame.title = now.toString().dropLast(10)
}

fun main() {
    val frame = JFrame("Binary Clock")
    val textArea = JTextArea(3, 18)
    textArea.font = java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12)
    frame.add(textArea)
    frame.pack()
    frame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
    frame.isVisible = true

    var x = 0
    var y = 0
    var xStep = 5
    var yStep = 5

    fixedRateTimer("timer", initialDelay = 10, period = 30) {
        val screenSize = java.awt.Toolkit.getDefaultToolkit().screenSize
        val frameWidth = frame.width
        val frameHeight = frame.height

        if (x + frameWidth >= screenSize.width || x < 0) {
            xStep = -xStep
        }
        if (y + frameHeight >= screenSize.height || y < 0) {
            yStep = -yStep
        }

        x += xStep
        y += yStep

        frame.setLocation(x, y)
    }

    while (true) {
        updateTextArea(textArea, frame)
        Thread.sleep(1000)
    }
}