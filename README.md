# Minekraft

Minekraft is my personal kotlin library for plugins and mods in minecraft.

It is the spiritual successor to my old library, [MXPaper](https://github.com/maxbossing/mxpaper), which in itself 
is a fork of [KSpigot](https://github.com/jakobkmar/kspigot), but meant to be more modular and cross-platform.

It combines many different open source libraries ([#credits](#credits)) and adds many features that ease the 
development experience for kotlin connoisseurs 

## Usage
> Please do not use Minekraft right now, it's still in a very early alpha and not even nearly feature-complete

As long as Minekraft is not officially released, I will not provide builds for it. If you want to use it,
prove yourself capable enough of dealing with it by building it.

### Implementing Minekraft
```kotlin
/*
 * This is your Main Entrypoint, instead of `JavaPlugin()`
 * WARNING: Do not override on(Load|Enable|Disable), this will break Minekraft!
 * override load, start and stop instead
 */
class Main() : Minekraft() {
    
    // If you want to use a Minekraft Module, you have to add them into modules
    // This will automatically register them and do housekeeping
    override val modules = listOf(KSpigotGUI)
    
    override fun load() {
        // Server load stuff
    }
  
    override fun start() {
        // Server start stuff
    }
  
    override fun stop() {
        // Server stop stuff
    }
}
```

## Credits
This library is a combination of many different MC utilities from all over the internet, and I hope I can credit
everyone on here. However, if you find something from yourself or someone else that has been mislabeled, feel free
to contact me (`@__VA_ARGS__` on Discord, `@va_args:matrix.org` on matrix)

- [KSpigot](https://github.com/jakobkmar/kspigot) 
  - `KListeners` was adapted from `SingleListener`
  - `KTask` is an adaption from `KSpigotRunnable`
  - `Paper-Gui-KSpigot` is the KSpigot GUI Library ported to Minekraft as a module
  - Many Extensions/Utils have been ported from KSpigot, because they're so frigging good
- [bukkit-kotlin-serialization](https://github.com/typst-io/bukkit-kotlin-serialization)
  - `minekraft.paper.serialization` has been adapted from this

## Todo

- [ ] Document your code you fucking shithead 


- [ ] Fabric 
  - [ ] Somewhat parity with paper module
- [ ] Paper
  - [ ] GUI Module (KSpigot IGUI / KtPaperGui / Custom ?)
    - [x] KSpigot GUI
  - [ ] Scoreboard Module
  - [ ] I18n System
  - [ ] Player input / await Module
  - [ ] Hologram Module
  - [ ] PlaceholderAPI Module
  - [ ] Options/Settings/Config Abstraction 
    - Per Player Options
    - Global Options
  - [ ] Packet Utils

## License
As long as not stated otherwise, `Minekraft` is licensed under the `GNU Affero General Public License, version 3`,
which requires that any modified version of this software, or software using it, whether directly or used over a 
network has to have its code available to its users, in addition to the standard GPL requirements for sharing
modifications. 