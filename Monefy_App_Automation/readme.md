
#  Money-App Automation Project (Pulkit_N26_Assignment)

## 📋 Overview

This project is an automated testing framework for the **Money-App** Android application. It validates the app’s core functionalities using **Java**, **Appium**, **TestNG**, and **Extent Reports**.

The framework follows the **Page Object Model (POM)** design pattern to ensure **scalability, maintainability, and readability**. It also integrates **Extent Reports** to generate rich, interactive HTML reports.

---

## 🗂️ Project Structure

```
Monefy_App_Automation/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com.pulkit.assignment/
│   │           ├── base/              # Base page for helper functions
│   │           ├── driver/            # Driver management (DriverManager.java)
│   │           ├── pages/             # Page classes (HomePage.java, BalancePage.java)
│   │           └── utils/             # Utilities (TestUtils.java)
│   │
│   └── test/
│       └── java/
│           └── com.pulkit.assignment/
│               ├── base/              # Base test setup (BaseTest.java)
│               └── tests/             # Test classes (AddExpenseAndIncomeEntryTest.java)
                └── util/              # App interactions, Extent Reporting, Test Listener    
├── pom.xml                            # maven configurations
├── testng.xml                         # TestNG suite configuration
```

---

## 💡 Key Features

### ✅ Page Object Model (POM)

Each screen of Money-App is represented as a dedicated **Java class** encapsulating:

- **Element locators** (buttons, fields, etc.)
- **Actions/Methods** to interact with the page

Benefits:

- Centralizes element management
- Easier maintenance when UI changes
- Cleaner, reusable code

Example classes:

- `HomePage.java`: methods to add income/expense, navigate home
- `BalancePage.java`: methods to fetch balance
- `EditIncomePage.java`: methods to edit income entries

---

### ✅ Implemented Test Cases

Implemented in `AddExpenseAndIncomeEntryTest.java`:

| Test Case         | Description                                       |
|------------------|---------------------------------------------------|
| skipWelcomeTour   | Verifies user can skip welcome tour               |
| verifyAppTitle    | Checks if app title displays correctly            |
| addExpenseEntry   | Adds an expense & verifies balance update         |
| addIncomeEntry    | Adds an income & verifies balance update          |

Each test includes assertions and logging for traceability.

---

### ✅ Test Reporting with Extent Reports

Integrated **Extent Reports** provides:

- Interactive HTML test reports
- Logs for pass/fail status, exceptions, and timestamps
- Optional screenshots on failures
- Auto-generated reports after every run

Reports are saved in `/test-output/ExtentReports/` (path configurable in `BaseTest.java`).

---

### ✅ Driver Management

`DriverManager.java` handles **AppiumDriver** setup:

- Initializes AndroidDriver with desired capabilities
- Connects to Appium server
- Manages driver lifecycle cleanup

Supports **cross-device testing** via configurable capabilities.

---

### ✅ Utilities

Provided in `TestUtils.java`, `TestListener.java`:

- Dynamic waits (explicit wait utilities)
- Screenshot capture on failure
- Extent Report logging
- Centralized helper functions

---

## 🧰 Tech Stack

| 🔧 Tool       | ✅ Usage                          |
|---------------|--------------------------------|
| Java           | Core language                   |
| Maven          | Build & dependency management   |
| Appium         | Mobile automation               |
| TestNG         | Test orchestration              |
| Extent Reports | Test reporting                  |
| AndroidDriver  | Android automation (UiAutomator2) |

---

## 🚀 Prerequisites

✅ Install:

- Java JDK 8+
- Maven
- Node.js
- Appium CLI (`npm install -g appium` or `npx appium`)
- Android SDK & Emulator (or real Android device)
- Appium Inspector (optional for locator inspection)

Ensure `adb devices` lists your connected device.

---

## 📝 Setup Instructions

1. Clone the repository:

   ```bash
   git clone <repo-url>
   cd Monefy_App_Automation
   ```

2. Install dependencies:

   ```bash
   mvn clean install
   ```

3. Start Appium server:

   ```bash
   npx appium
   ```

4.  Update device capabilities in `BaseTest.java`:

   ```java
   caps.setCapability("appium:udid", "<your-device-udid>");
   caps.setCapability("appium:deviceName", "<your-device-name>");
   ```

---

## 🏃 Running Tests

You can run tests via:

✅ **Maven CLI:**

```bash
mvn test
```

✅ **Using `testng.xml`:**

```bash
mvn test -DsuiteXmlFile=testng.xml
```

✅ **IDE TestNG Runner:**

- Right-click `testng.xml` → Run
- Or run test classes individually

---

## 📊 Test Reports

After execution:

- Reports located at `/test-output/ExtentReports/`
- Screenshots (if enabled) at `/test-output/screenshots/`

Sample report view:

![Extent Report Sample](/Users/p.chaturvedi/StudioProjects/Pulkit_N26_Assignment1/Monefy_App_Automation/test-output/TestExecutionSummary.png)

---

## 🌱 Future Enhancements

- ✅ Add more test coverage (transaction categories, recurring entries)
- ✅ Parameterize device configuration for multi-device runs
- ✅ CI/CD integration (GitHub Actions, Jenkins)
- ✅ Include screenshots for **all test steps** (not just failures)
- ✅ Explore Allure Reports or video recording integration
---

## 📞 Contact

Created by **Pulkit Chaturvedi**  
📧 Email: pulkitchaturvedi87@gmail.com
---