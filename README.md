# Selenium Automation Framework

## 📌 Overview
This project is a Selenium-based automation framework built using Java, TestNG, and the Page Object Model (POM) design pattern.

It demonstrates a structured and scalable approach to UI test automation with real-world features like logging, reporting, and failure handling.

---

## 🚀 Features
- Page Object Model (POM) design
- Data-driven testing using TestNG DataProvider
- Explicit waits for synchronization
- Screenshot capture on test failure
- Logging using SLF4J
- HTML reporting using Extent Reports
- Reusable BaseTest setup

---

## 🛠 Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Maven
- SLF4J (Logging)
- Extent Reports

---


## 📂 Project Structure
src/
├── main/java
│ ├── base → BaseTest (setup & teardown)
│ ├── pages → Page Object classes
│ └── utils → Utilities (Screenshot, Reports)
│
└── test/java
└── tests → Test cases

---

## ▶️ How to Run
1. Clone the repository
2. Open in IntelliJ
3. Run test classes using TestNG

---

## 📊 Reports
After execution:
- Screenshots → `/screenshots`
- HTML Report → `/reports/ExtentReport.html`

---

## 💡 Key Highlights
- Designed using industry-standard automation practices
- Focus on maintainability and reusability
- Handles failures with screenshots and logs
- Clean separation of test logic and UI logic

---
