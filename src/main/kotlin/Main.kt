import com.pengrad.telegrambot.TelegramBot
import com.pengrad.telegrambot.UpdatesListener
import com.pengrad.telegrambot.model.Update
import kotlinx.coroutines.runBlocking
import openAiChat.OpenAiTestChat

suspend fun main(args: Array<String>) {

    /*runBlocking {
        telegramBot(args[0])
    }*/
    while(true) {
        val reader = readLine()
        if (reader != null) {
            runBlocking {

                //Тестовая реализация чата с ChatGPT
                println(OpenAiTestChat(args[1],reader).write())

                //Тестовая реализация картинки в URL или Base64 форматах
                /*println(OpenAiTestImgJSON(args[1], reader).write())
                println(OpenAiTestImgURL(args[1], reader).write())*/
            }
        }
    }
}



suspend fun telegramBot(key: String?){
    val bot = TelegramBot(key)

    bot.setUpdatesListener { updates: List<Update?>? ->
        updates?.forEach { update ->
            val chatId = update?.message()?.chat()?.id()

        }
        UpdatesListener.CONFIRMED_UPDATES_ALL
    }
}






