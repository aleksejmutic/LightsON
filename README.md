#  LightsON (Graphical Electrical Circuits Editor)

LightsON is a graphical editor tool for creating and editing electrical circuit diagrams, developed in Java Swing. It allows users to place elements like junction boxes, fuses, sockets, and consumers on a canvas, and connect them with smartly routed wires. The diagrams can be saved, imported and exported.
This project was developed as part of the Software Design course during the 4th year at the Faculty of Electrical Engineering in East Sarajevo.

---

#  How LightsON was made

The first course of action while developing the application was ensuring proper documentation using RUP (Rational Unified Process) templates, following using SAP Power Designer for proper modeling using UML. After that the process of writting the implementation and coding began. 

---

#  What I learned

During the development of the application, I gained valuable experience in the proper design of software and the structured process of developing a fully functional application. I explored various software design principles and architectural patterns, including MVC, MVVM, and MVP, which helped me understand how to organize and scale complex systems effectively. Additionally, I learned the importance of testing in the development lifecycle — how it ensures the correctness, reliability, and maintainability of the software, and serves as a safeguard against regressions during future changes. 

---

#  Demo

Here is an example of how the editor works. As shown the canvas ensures proper drawing of elements as well as changing their position on the diagram. You can also customize the grid, zoom in or zoom out of the view of the diagram. 

![LightsON Demo](https://i.imgur.com/fzejEQU.gif)

---

##  Tools and Technologies

| Tool | Purpose |
|------|---------|
| **SAP PowerDesigner** | UML modeling (use case, class diagrams, etc.) |
| **Rational Unified Process (RUP)** | Structured development methodology |
| **Java Swing (planned)** | Planned GUI framework |
| **Git/GitHub** | Version control and collaboration |

---

##  Features

-  Add electrical components: Junction Box, Fuse, Socket, Switch, Consumer
-  Connect elements with auto-routed, orthogonal wires
-  Smart A* pathfinding to avoid overlapping other components
-  Snap-to-grid drawing for precise alignment
-  Move elements, with wires updating dynamically
-  Save/load diagrams as JSON
-  Customization of the diagram view

---

### Getting started
-  Clone the repository
```bash
git clone https://github.com/aleksejmutic/LightsON.git
cd LightsON
```
-  Run the application
-  See the code
-  Review following the documentation and models 


