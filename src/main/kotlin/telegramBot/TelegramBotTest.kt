package telegramBot

import com.pengrad.telegrambot.TelegramBot
import com.pengrad.telegrambot.TelegramException
import com.pengrad.telegrambot.UpdatesListener
import com.pengrad.telegrambot.model.Update
import com.pengrad.telegrambot.passport.decrypt.Base64
import com.pengrad.telegrambot.request.SendAnimation
import com.pengrad.telegrambot.request.SendMessage
import com.pengrad.telegrambot.request.SendPhoto
import kotlinx.coroutines.runBlocking
import openAiChat.OpenAiTestChat
import openAiImg.OpenAiTestImgJSON

class TelegramBotTest(){
    suspend fun startBot(keyTelegramBot: String?, keyOpenAi: String){
        val bot = TelegramBot(keyTelegramBot)

        bot.setUpdatesListener(
            { updates: List<Update?>? ->
                updates?.forEach { update ->
                    runBlocking {
                        val chatId = update?.message()?.chat()?.id()
                        val txtUserMessage = update?.message()?.text().toString().toLowerCase()
                        when{
                            txtUserMessage.contains("нарисуй") ->{
                                val openAiImgResponse = OpenAiTestImgJSON(keyOpenAi,txtUserMessage).write()
                                //println(openAiImgResponse)

                                val decodedByte = Base64.decode(openAiImgResponse, Base64.DEFAULT)
                                val bitmap = BitmapFactory.decodeByteArray(decodedByte, 0, decodedString.length)

                                val photo =
                                bot.execute(SendPhoto(chatId, openAiImgResponse))
                            }
                            else -> {
                                val openAiTxtResponse = OpenAiTestChat(keyOpenAi, txtUserMessage).write()
                                bot.execute(SendMessage(chatId, openAiTxtResponse))
                            }
                        }

                    }
                }
                UpdatesListener.CONFIRMED_UPDATES_ALL }
        ) { e: TelegramException ->
            if (e.response() != null) {
                // god bad response from telegram
                e.response().errorCode()
                e.response().description()
            } else {
                // probably network error
                e.printStackTrace()
            }
        }
    }
}