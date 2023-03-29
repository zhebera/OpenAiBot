package openAiAudio

import com.aallam.openai.api.BetaOpenAI
import common.OpenAiCommon

@OptIn(BetaOpenAI::class)
class OpenAiTestAudio(key: String, audioFile: String): OpenAiCommon(key){
    val response = OpenAiAudioRequest(audioFile).request
    override suspend fun write() = openAi.transcription(response).text

}