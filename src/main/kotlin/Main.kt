import com.pengrad.telegrambot.passport.decrypt.Base64
import kotlinx.coroutines.runBlocking
import openAiAudio.OpenAiTestAudio
import openAiChat.OpenAiTestChat
import openAiImg.ConvertRequestToFile
import openAiImg.OpenAiTestImgJSON
import java.io.ByteArrayInputStream
import java.io.File
import javax.imageio.ImageIO


suspend fun main(args: Array<String>) {

    runBlocking {
        //TelegramBotTest().startBot(args[0], args[1])
    }

    while(true) {
        val reader = readLine()
        if (reader != null) {
            runBlocking {
                //Текстовая транслитерация из аудиофайла
                //TODO reader заменить на путь к audioFile
                println(OpenAiTestAudio(args[1],"audio/test.mp3").write())

                //Тестовая реализация чата с ChatGPT
                //println(OpenAiTestChat(args[1],reader).write())

                //Тестовая реализация картинки в URL или Base64 форматах
                //println(OpenAiTestImgJSON(args[1],reader).write() + ConvertRequestToFile.count)
            }
        }
    }
}




