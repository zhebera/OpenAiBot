package openAiAudio

import com.aallam.openai.api.BetaOpenAI
import com.aallam.openai.api.audio.TranscriptionRequest
import com.aallam.openai.api.file.FileSource
import com.aallam.openai.api.model.ModelId
import okio.*
import java.io.File

@OptIn(BetaOpenAI::class)
class OpenAiAudioRequest(audioFile: String) {
    val request = TranscriptionRequest(
        audio = FileSource(audioFile, File(audioFile).source()),
        model = ModelId("whisper-1")
    )
}
