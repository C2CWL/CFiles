# CFiles

Android 文件管理器，由 C2CWL 个人自用，按需修改，不提供技术支持。

基于 [CluvexStudio/Strata](https://github.com/CluvexStudio/Strata)，保留其版权声明、第三方许可和 [GNU AGPL v3.0 or later](LICENSE)。

## 约定

- 安装包 ID：`io.github.c2cwl.cfiles`；调试版追加 `.debug`。
- 图标：默认、极简、深色三款，可在「设置 → 外观」切换；支持 Android 13+ 主题图标。
- 最低支持 Android 7.0；Android 7.x 使用矢量回退图标。
- 内部 Kotlin 命名空间和 JNI 名称沿用上游，方便同步。

## 构建

需要 Android SDK、NDK，以及安装了 Android 目标的 Rust 和 `cargo-ndk`；JDK 17 由 Gradle 处理。

```bash
rustup target add aarch64-linux-android armv7-linux-androideabi x86_64-linux-android
cargo install cargo-ndk
native/fetch-pdfium.sh
native/build.sh
./gradlew :app:assembleDebug
```

## 下载

| ABI | 说明 |
|---|---|
| `arm64-v8a` | 多数现代手机 |
| `armeabi-v7a` | 32 位 ARM 设备 |
| `x86_64` | 模拟器或 x86 设备 |
| `universal` | 不确定架构时使用 |
