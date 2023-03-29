import com.pengrad.telegrambot.TelegramBot
import com.pengrad.telegrambot.TelegramException
import com.pengrad.telegrambot.UpdatesListener
import com.pengrad.telegrambot.model.Update
import kotlinx.coroutines.runBlocking
import telegramBot.TelegramBotTest

suspend fun main(args: Array<String>) {

    runBlocking {
        TelegramBotTest().startBot(args[0], args[1])
    }

    /*while(true) {
        val reader = readLine()
        if (reader != null) {
            runBlocking {
                //Текстовая транслитерация из аудиофайла
                //TODO reader заменить на путь к audioFile
                //println(OpenAiTestAudio(args[1],reader))

                //Тестовая реализация чата с ChatGPT
                println(OpenAiTestChat(args[1],reader).write())

                //Тестовая реализация картинки в URL или Base64 форматах
                /*println(OpenAiTestImgJSON(args[1], reader).write())
                println(OpenAiTestImgURL(args[1], reader).write())*/

            }
        }
    }*/
}







