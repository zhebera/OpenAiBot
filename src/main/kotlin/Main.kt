import com.aallam.openai.api.BetaOpenAI
import com.aallam.openai.api.chat.*
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI
import com.pengrad.telegrambot.TelegramBot
import com.pengrad.telegrambot.UpdatesListener
import com.pengrad.telegrambot.model.Update
import com.pengrad.telegrambot.request.SendMessage
import kotlinx.coroutines.runBlocking

suspend fun main(args: Array<String>) {

    /*runBlocking {
        telegramBot(args[0])
    }*/
    while(true) {
        val reader = readLine()
        if (reader != null) {
            runBlocking {
                openAiTest(args[1], reader)
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

@OptIn(BetaOpenAI::class)
suspend fun openAiTest(key: String, textMessage: String){
    val openAi = OpenAI(key)

    val chatCompletionRequest = OpenAiChatCompletionRequest(textMessage).chatCompletionRequest
    val imgCompletionRequest = OpenAiImage(textMessage).creation

    val chatCompletion = openAi.chatCompletion(chatCompletionRequest)

    val imgCompletion = openAi.imageURL(imgCompletionRequest)

    //println(chatCompletion.choices[0].message?.content)
    println(imgCompletion[0].url)
}