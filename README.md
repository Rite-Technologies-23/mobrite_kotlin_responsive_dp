# Responsive

A tiny Jetpack Compose library for **responsive `dp` and `sp` units**. Wrap your
dimensions with `.rdp` / `.rsp` and they scale automatically across phones,
large phones, and tablets — no manual `when (screenWidth)` blocks.

```kotlin
Text(
    text = "Hello",
    fontSize = 16.rsp,          // scales with screen size
    modifier = Modifier.padding(12.rdp)
)
```

## Install (JitPack)

> Replace `<ORG>`, `<REPO>`, and `<TAG>` with your GitHub org, repo name, and the
> release tag you push (e.g. `1.0.0`).

**1. Add the JitPack repository.** In `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }   // <-- add this
    }
}
```

**2. Add the dependency.** In your app module's `build.gradle.kts`:

```kotlin
dependencies {
    implementation("com.github.<ORG>.<REPO>:responsive:<TAG>")
}
```

> **Note:** because this is a multi-module repo, the group id is
> `com.github.<ORG>.<REPO>` and the artifact id is the module name `responsive`.

## Usage

### Basic

```kotlin
import com.rite.responsivedp.rdp
import com.rite.responsivedp.rsp

Column(modifier = Modifier.padding(16.rdp)) {
    Text("Title", fontSize = 20.rsp)
    Spacer(Modifier.height(8.rdp))
    Text("Body", fontSize = 14.rsp)
}
```

`rdp` / `rsp` are available on `Int`, `Float`, and `Double`.

### Custom scale factors

Wrap your content in `ResponsiveTheme` and pass a `ResponsiveScale` to control the
multiplier applied per screen-width bucket:

```kotlin
import com.rite.responsivedp.ResponsiveTheme
import com.rite.responsivedp.ResponsiveScale

ResponsiveTheme(
    scale = ResponsiveScale(
        smallPhone = 0.90f,
        phone = 1.00f,
        largePhone = 1.08f,
        tablet = 1.20f,
        largeTablet = 1.35f,
    )
) {
    // rdp / rsp inside here use your custom factors
    MyScreen()
}
```

Screen-width buckets (smallest width, in dp): `< 360` small phone · `< 480` phone ·
`< 600` large phone · `< 840` tablet · `≥ 840` large tablet.

## Demo app

The `app/` module in this repo is a working demo/consumer. It depends on the
library directly via `implementation(project(":responsive"))`, so you can run it
to see the units in action across device sizes.

## Requirements

- `minSdk` 21+
- Jetpack Compose

## License

[MIT](LICENSE)
