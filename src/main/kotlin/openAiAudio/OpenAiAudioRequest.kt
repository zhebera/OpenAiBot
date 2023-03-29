package openAiAudio

import com.aallam.openai.api.BetaOpenAI
import com.aallam.openai.api.audio.TranscriptionRequest
import com.aallam.openai.api.file.FileSource
import com.aallam.openai.api.file.FileSourceBuilder
import com.aallam.openai.api.model.ModelId

@OptIn(BetaOpenAI::class)
class OpenAiAudioRequest(audioFile: String) {
    val request = TranscriptionRequest(
        audio = FileSource(name = audioFile, source = FileSourceBuilder().source!!),
        model = ModelId("whisper-1")
    )
}
