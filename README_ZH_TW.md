# CES

一個精簡後的原生 Android LLM 聊天客戶端，使用 Kotlin 與 Jetpack Compose 構建。

## 功能

- Material Design 3 Android 介面和暗色模式
- 預設 AI Provider 僅保留 OpenAI、Gemini、DeepSeek
- 支援自訂 API 位址、請求標頭、請求本文和模型配置
- 支援多模態輸入
- Markdown 渲染，包含程式碼高亮、數學公式、表格和 Mermaid
- 支援訊息分支，以及 Provider 匯入/匯出

## 構建

使用 Android Studio 或 Gradle：

```bash
./gradlew assembleDebug
./gradlew test
```

啟用 Firebase 的構建需要在 `app/` 目錄下提供 `google-services.json`。

## 許可證

見 [LICENSE](LICENSE)。
