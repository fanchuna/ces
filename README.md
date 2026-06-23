# Sail AI Assistant

A sailing-themed native Android LLM chat client built with Kotlin and Jetpack Compose.

## Features

- Sea-blue Material Design 3 Android UI with dark mode
- Default AI providers limited to OpenAI, Gemini, and DeepSeek
- Custom API base URL, headers, request body, and model configuration
- Multimodal input support
- Markdown rendering with code highlighting, math, tables, and Mermaid
- Message branching and export/import for providers

## Build

Use Android Studio or Gradle:

```bash
./gradlew assembleDebug
./gradlew test
```

A `google-services.json` file is required under `app/` for Firebase-enabled builds.

## License

See [LICENSE](LICENSE).
