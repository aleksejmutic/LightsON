#  LightsON

LightsON is a graphical editor tool for creating and editing electrical circuit diagrams, developed in Java Swing. It allows users to place elements like junction boxes, fuses, sockets, and consumers on a canvas, and connect them with smartly routed wires. The diagrams can be saved, imported and exported.
This project was developed as part of the Software Design course during the 4th year at the Faculty of Electrical Engineering in East Sarajevo.

---

#  Demo

Here is an example of how the editor works. 

![LightsON Demo](https://i.imgur.com/fzejEQU.gif)

---

##  Features

-  Add electrical components: Junction Box, Fuse, Socket, Switch, Consumer
-  Connect elements with auto-routed, orthogonal wires
-  Smart A* pathfinding to avoid overlapping other components
-  Snap-to-grid drawing for precise alignment
-  Move and rotate elements, with wires updating dynamically
-  Save/load diagrams as JSON
-  Right-click context menus for extra options
-  Scrollable tabbed canvas for multi-diagram workspaces

---

### Getting started
-  Clone the repository
```bash
git clone https://github.com/aleksejmutic/LightsON.git
cd LightsON
