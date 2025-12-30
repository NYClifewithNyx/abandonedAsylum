# 🏚️ Abandoned Asylum  
### Java Console Text Adventure Game 🎮

A modular **Java console-based text adventure game** built with a strong focus on  
✨ **clean architecture**, ✨ **readability**, and ✨ **iterative refactoring**.

This project explores how ambiguous ideas (story + gameplay) can be translated into  
structured, maintainable systems through code.

---

## ✨ Highlights

✅ Modular architecture with clear **separation of concerns**  
✅ Extensible branching logic for easy feature expansion  
✅ Centralized **state management** (player progress, inventory, decisions)  
✅ Built through multiple **refactor cycles** to improve maintainability  
✅ Console-based but designed with **scalability in mind**

---

## 🛠️ Tech Stack

- ☕ **Java** (console application)
- 🧱 Object-Oriented Programming (OOP)
- 🧩 Enums & Classes for game state and logic
- 🌿 Git & GitHub for version control

---

## 🎯 Project Goals

This project was built to practice and demonstrate:

- ✍️ Writing **clean, readable Java code**
- 🧠 Breaking down **ambiguous requirements** into structured logic
- 🔄 Improving design through **iterative refactoring**
- 🏗️ Designing systems that are easy to extend without rewriting core logic

---

## 🧩 Architecture Overview

The codebase is organized around a few core responsibilities:

### 🕹️ Game Manager / Main Loop
- Controls the game lifecycle
- Manages scene transitions and player progression

### 📖 Scenes / Story Modules
- Each scene encapsulates:
  - narrative text
  - player choices
  - the next game state
- Designed so new scenes can be added independently

### ⌨️ Interaction & Input Handling
- Centralized input validation and prompts
- Keeps scene logic clean and focused

### 🎒 State & Models
- Player state
- Inventory and items
- Decision flags that influence outcomes

➡️ This separation made it possible to:
- add new story branches with minimal changes  
- refactor interaction logic once and improve the entire game experience

---

## 🚀 Getting Started

### ✅ Prerequisites
- ☕ Java 11+ (or 17+, depending on setup)
- 💻 Any IDE (IntelliJ recommended)

### ▶️ Run Locally

### 1. Clone the repository:
git clone https://github.com/NYClifewithNyx/abandonedAsylum.git
cd abandonedAsylum

### 2. Run the application
- In IntelliJ:
  - Open the project
  - Locate the main entry class
  - Click **Run**

- Or via terminal (example):
javac -d out src/**/*.java
java -cp out Main

🔧 If your entry class name or package differs, update the command accordingly.

## 🎮 Gameplay

- 📜 Read narrative prompts in the console
- 🔢 Make choices using keyboard input
- 🧠 Decisions affect:
  - story progression
  - available items
  - future outcomes

## 🗺️ Roadmap (Planned Improvements)

🧩 Add more scenes and branching paths  
💾 Save / Load game state  
🛡️ More robust input validation  
🧪 Basic unit tests for state transitions  

## 💡 Why This Project Matters

This project reflects my approach to engineering:

- 🏁 Start with a working MVP
- 🔄 Improve structure through refactoring
- 🧼 Keep code readable and maintainable
- 🌱 Design systems that grow gracefully over time

## 📄 License

This project is shared for learning and demonstration purposes.


