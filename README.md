# 📱 Kotlin Responsive DP 🚀

[![](https://jitpack.io/v/Rite-Technologies-23/mobrite_kotlin_responsive_dp.svg)](https://jitpack.io/#Rite-Technologies-23/mobrite_kotlin_responsive_dp)

> **💡 Purpose:** A lightweight **Jetpack Compose** library that makes your `dp` and `sp`
> units **responsive** across every screen size. Wrap any dimension with `.rdp` / `.rsp`
> and it scales automatically — from small phones to large tablets — with **zero**
> manual `when (screenWidth)` blocks. Drop it in, and your UI just adapts.

---

## Table of Contents

1. ✨ [What's Included](https://github.com/Rite-Technologies-23/mobrite_kotlin_responsive_dp/?tab=readme-ov-file#-whats-included)
2. 🔧 [Tech Stack](https://github.com/Rite-Technologies-23/mobrite_kotlin_responsive_dp/?tab=readme-ov-file#-tech-stack)
3. 📋 [Prerequisites](https://github.com/Rite-Technologies-23/mobrite_kotlin_responsive_dp/?tab=readme-ov-file#-prerequisites)
4. 📦 [Installation (JitPack)](https://github.com/Rite-Technologies-23/mobrite_kotlin_responsive_dp/?tab=readme-ov-file#-installation-jitpack)
5. 🚀 [Usage](https://github.com/Rite-Technologies-23/mobrite_kotlin_responsive_dp/?tab=readme-ov-file#-usage)
6. 📐 [How Scaling Works](https://github.com/Rite-Technologies-23/mobrite_kotlin_responsive_dp/?tab=readme-ov-file#-how-scaling-works)
7. 🎯 [API Reference](https://github.com/Rite-Technologies-23/mobrite_kotlin_responsive_dp/?tab=readme-ov-file#-api-reference)
8. 📱 [Demo App](https://github.com/Rite-Technologies-23/mobrite_kotlin_responsive_dp/?tab=readme-ov-file#-demo-app)

---

## ✨ What's Included

| Feature                | Details                                                                 |
| ---------------------- | ----------------------------------------------------------------------- |
| **Responsive Units**   | `.rdp` and `.rsp` extensions on `Int`, `Float`, and `Double`            |
| **Auto Scaling**       | Dimensions scale by screen-width bucket (small phone → large tablet)    |
| **Tablet Aware**       | Uses smallest-width heuristic; treats `sw ≥ 600dp` as a tablet          |
| **Customizable Scale** | Override scale factors per bucket via `ResponsiveScale`                 |
| **Compose Native**     | Built on `CompositionLocal` — no context or Activity plumbing needed    |
| **Tiny Footprint**     | Runtime + UI Compose deps only; no reflection, no extra transitive load |
| **JitPack Ready**      | Publish and consume in any app with a single dependency line            |

---

## 🔧 Tech Stack

| Library              | Version         | Purpose                              |
| -------------------- | --------------- | ------------------------------------ |
| `Kotlin`             | 2.1.21          | Primary programming language         |
| `Jetpack Compose`    | BOM 2025.06.00  | Modern declarative UI toolkit        |
| `Compose Runtime`    | via BOM         | `CompositionLocal` scale propagation |
| `Compose UI`         | via BOM         | `Dp` / `TextUnit` unit types         |
| `AndroidX Annotation`| 1.9.1           | `@Immutable` scale model             |
| `Android Gradle Plugin` | 8.13.0       | Build tooling                        |

---

## 📋 Prerequisites

- **JDK 17** configured in Android Studio.
- **Android SDK 36** installed via SDK Manager.
- Consuming app **`minSdk` 21+** with **Jetpack Compose** enabled.

---

## 📦 Installation (JitPack)

The library is published via [JitPack](https://jitpack.io). Coordinates below use tag
`1.0.1` — bump the version to whatever release tag you consume.

### 📥 1. Add the JitPack Repository

In your **`settings.gradle.kts`**:

```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }   // 👈 add this
    }
}
```

### 🔗 2. Add the Dependency

In your **app module's `build.gradle.kts`**:

```kotlin
dependencies {
    implementation("com.github.Rite-Technologies-23:mobrite_kotlin_responsive_dp:1.0.1")
}
```

> **Note:** JitPack publishes this repo as a single artifact at the repo-root
> coordinate — the group id is `com.github.Rite-Technologies-23` and the artifact id
> is the repo name `mobrite_kotlin_responsive_dp`.

### 🔨 3. Sync

Click **File > Sync Project with Gradle Files** and you're ready to go.

---

## 🚀 Usage

### 🎨 Basic

Just import the extensions and swap `.dp` / `.sp` for `.rdp` / `.rsp`:

```kotlin
import com.rite.responsivedp.rdp
import com.rite.responsivedp.rsp

Column(modifier = Modifier.padding(16.rdp)) {
    Text(text = "Title", fontSize = 20.rsp)
    Spacer(Modifier.height(8.rdp))
    Text(text = "Body", fontSize = 14.rsp)
}
```

### 🧩 Custom Scale Factors

Wrap your content in `ResponsiveTheme` and pass a `ResponsiveScale` to control the
multiplier applied in each screen-width bucket:

```kotlin
import com.rite.responsivedp.ResponsiveTheme
import com.rite.responsivedp.ResponsiveScale

ResponsiveTheme(
    scale = ResponsiveScale(
        smallPhone  = 0.90f,
        phone       = 1.00f,
        largePhone  = 1.08f,
        tablet      = 1.20f,
        largeTablet = 1.35f,
    )
) {
    // every .rdp / .rsp inside here uses your custom factors
    MyScreen()
}
```

---

## 📐 How Scaling Works

The library reads the current configuration's **smallest width** (and treats
`sw ≥ 600dp` as a tablet, using full width in that case), then multiplies your value by
a factor chosen from these buckets:

| Screen Width (dp) | Bucket        | Default Factor |
| ----------------- | ------------- | -------------- |
| `< 360`           | Small Phone   | `0.90`         |
| `360 – 479`       | Phone         | `1.00`         |
| `480 – 599`       | Large Phone   | `1.08`         |
| `600 – 839`       | Tablet        | `1.20`         |
| `≥ 840`           | Large Tablet  | `1.35`         |

So `16.rdp` renders as `~14.4dp` on a small phone and `~21.6dp` on a large tablet —
automatically.

---

## 🎯 API Reference

The `com.rite.responsivedp` package exposes:

- **`Int.rdp` / `Float.rdp` / `Double.rdp`** → responsive `Dp`.
- **`Int.rsp` / `Float.rsp` / `Double.rsp`** → responsive `TextUnit` (sp).
- **`Dp.responsive()` / `TextUnit.responsive()`** → the underlying scaling functions.
- **`ResponsiveTheme(scale, content)`** → provides custom scale factors to a subtree.
- **`ResponsiveScale(...)`** → `@Immutable` data class holding the per-bucket factors.
- **`LocalResponsiveScale`** → the `CompositionLocal` backing the active scale.

---

## 📱 Demo App

The **`app/`** module in this repo is a working demo/consumer. It depends on the library
directly via `implementation(project(":responsive"))`, so you can open the project, run
the `app` configuration, and see the responsive units adapt across device sizes and
emulators.

---

## 📄 License

Distributed under the [MIT License](LICENSE).
