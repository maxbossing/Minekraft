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

Also, this thing is still entirely undocumented, untested and without any instructions. 

## Modules
Because Minekraft does not want to be a big monolithic library, it is split into multiple modules that can be included 
to fit your needs. 

There are two different kinds of Modules: `Core Modules` and `Platform Modules`

### Core Modules
Core Modules are modules that can be used on any Platform Minekraft supports, for example `Vanilla-Config-Konfig`, which 
is a port of [btwonion's Konfig](https://github.com/btwonion/konfig). As this library only needs `kotlinx.serialization`,
it is set up as a platform-independent module that can be used by anyone.

**Actively maintained Core Modules:**
- Vanilla - The Base Module for all Minekraft modules
- Vanilla-config-konfig - A port of [btwonion's Konfig](https://github.com/btwonion/konfig), which per default only 
supports FabricMC but has been ported by the Minekraft team

### Platform Modules
Platform Modules are modules that are specific to one target of Minekraft, for example Paper or Fabric. An example of 
this is `Paper-Gui-KSpigot`, a Minekraft port of the [KSpigot GUI Library](https://github.com/jakobkmar/kspigot), which 
will only work on Paper and has no way to make it work on fabric without completely rewriting it.

> Platform Modules have to be registered in your Entrypoint to work, please check out the documentation of your Platform 
> to find out how to.

**Actively maintained Platform Modules:**  
Paper:
- `Paper-Core` - The Base Module for all Minekraft modules targeting Paper
- `Paper-Gui-KSpigot` - A port of the [KSpigot GUI Library](https://github.com/jakobkmar/kspigot)
- `Paper-Metrics-BStats` - BStats Metrics as a Minekraft Module

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

- [ ] Vanilla
  - Config API (kotlinx.serialization)
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