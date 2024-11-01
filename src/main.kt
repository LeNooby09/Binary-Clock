import java.time.LocalTime
import javax.swing.JFrame
import javax.swing.JTextArea
import javax.swing.WindowConstants

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

    while (true) {
        updateTextArea(textArea, frame)
        Thread.sleep(1000)
    }
}