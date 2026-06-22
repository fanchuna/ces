package me.rerere.rikkahub.data.datastore

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class DefaultProvidersTest {
    @Test
    fun `default providers should only include target providers`() {
        assertEquals(
            listOf("OpenAI", "Gemini", "DeepSeek"),
            DEFAULT_PROVIDERS.map { it.name }
        )
    }

    @Test
    fun `default auto model should exist in current default model list`() {
        val model = DEFAULT_PROVIDERS
            .flatMap { it.models }
            .firstOrNull { it.id == DEFAULT_AUTO_MODEL_ID }

        assertNotNull(model)
        assertEquals("deepseek-chat", model?.modelId)
    }
}
