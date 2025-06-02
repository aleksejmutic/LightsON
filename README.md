# ⚡ LightsON

LightsON is a Java Swing-based desktop application for creating and editing electrical circuit diagrams. It allows users to place elements like junction boxes, fuses, sockets, and consumers on a canvas, and connect them with smartly routed wires using an A* pathfinding algorithm.

---

## 🖼️ Demo

![LightsON in Action](https://your-hosted-gif-link.com/lights-on-demo.gif)
<!-- Or use a local file if you're storing GIFs in assets/ -->
<!-- ![LightsON in Action](assets/lights-on-demo.gif) -->

---

## ✨ Features

- 🧱 Add electrical components: Junction Box, Fuse, Socket, Switch, Consumer
- 🔌 Connect elements with auto-routed, orthogonal wires
- 🧠 Smart A* pathfinding to avoid overlapping other components
- 📐 Snap-to-grid drawing for precise alignment
- 🔄 Move and rotate elements, with wires updating dynamically
- 📂 Save/load diagrams as JSON
- 🖱️ Right-click context menus for extra options
- 🪟 Scrollable tabbed canvas for multi-diagram workspaces

---

### Clone the repository

```bash
git clone https://github.com/aleksejmutic/LightsON.git
cd LightsON
