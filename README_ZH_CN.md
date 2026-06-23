# 帆船 AI 助手

一个海蓝航行风格的原生 Android LLM 聊天客户端，使用 Kotlin 与 Jetpack Compose 构建。

## 功能

- 海蓝主题 Material Design 3 Android 界面和暗色模式
- 默认 AI Provider 仅保留 OpenAI、Gemini、DeepSeek
- 支持自定义 API 地址、请求头、请求体和模型配置
- 支持多模态输入
- Markdown 渲染，包含代码高亮、数学公式、表格和 Mermaid
- 支持消息分支，以及 Provider 导入/导出

## 构建

使用 Android Studio 或 Gradle：

```bash
./gradlew assembleDebug
./gradlew test
```

启用 Firebase 的构建需要在 `app/` 目录下提供 `google-services.json`。

## 许可证

见 [LICENSE](LICENSE)。
