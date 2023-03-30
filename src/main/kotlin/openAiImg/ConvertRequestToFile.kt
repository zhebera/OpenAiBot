package openAiImg

import com.pengrad.telegrambot.passport.decrypt.Base64
import java.io.ByteArrayInputStream
import java.io.File
import javax.imageio.ImageIO

class ConvertRequestToFile(val base64String: String) {
    companion object{
        var count = 0
    }
    fun convertBs64ToFile(): String?{
        count++

        val imageBytes = Base64.decode(base64String, Base64.DEFAULT)
        val bis = ByteArrayInputStream(imageBytes)
        val bImage = ImageIO.read(bis)
        ImageIO.write(bImage, "jpg", File("images/result_$count.jpg"))
        return "images/result_$count.jpg"
    }
}