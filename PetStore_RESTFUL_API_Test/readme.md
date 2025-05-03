# 🐾 Swagger Petstore API Test Automation Framework

## 📖 Overview

This project is an automated test framework designed to perform **CRUD operations** on the [Swagger Petstore API](https://petstore.swagger.io/).  
It is implemented using **Java**, **JUnit 5**, **RestAssured**, and **Allure** for reporting.

✅ Supports testing endpoints for creating, updating, deleting, and retrieving pets.

---

## 🚀 Features

- Automated **API tests** for `/pet` endpoints (Create, Read, Update, Delete)
- Written in **Java** using **RestAssured** for HTTP requests
- Test framework powered by **JUnit 5**
- Integrated **Allure Reports** for beautiful reporting
- Uses **Maven** for dependency management and build
- Simple and extendable structure

---

## 🛠️ Tech Stack

| Tool / Framework    | Purpose                          |
|--------------------|----------------------------------|
| Java (JDK 17+)      | Programming Language             |
| Maven               | Build & Dependency Management    |
| JUnit 5             | Test Framework                   |
| RestAssured         | API Testing Library              |
| Allure              | Test Reporting                   |

---

## 📂 Project Structure

```
project-root
│
├── src
│   ├── main
│   │   └── java
│   │       └── model
│   │           └── Pet.java
│   └── test
│       └── java
│           └── tests
│               ├── BaseTest.java
│               └── PetTests.java
├── pom.xml
├── allure-results/
├── allure-report/
└── README.md
```

---

## ⚙️ Setup Instructions

### 1️⃣ **Clone the repository**

```bash
git clone <repo-url>
cd <repo-directory>
```

### 2️⃣ **Install dependencies**

Make sure Maven is installed and run:

```bash
mvn clean install
```

### 3️⃣ **Run tests**

You can execute all tests using:

```bash
mvn test
```

Or run a specific test:

```bash
mvn test -Dtest=PetTests
```

---

## 📝 Generating Reports

After running the tests, generate the Allure report:

```bash
allure serve allure-results
```

This will automatically generate and open the report in your browser.

Alternatively, generate static report files:

```bash
allure generate allure-results --clean -o allure-report
```

You can then view the report by opening `allure-report/index.html` in a browser.

---

## ✅ Available Tests

| Test Name               | Description                                  |
|------------------------|----------------------------------------------|
| createPetTest           | Creates a new pet in the store               |
| updatePetTest           | Updates an existing pet                      |
| deletePetTest           | Deletes an existing pet                      |
| findPetsByStatusTest    | Retrieves pets by status                     |
| getNonExistingPetTest   | Retrieves a non-existing pet (negative case) |

---

## 📝 Test Annotations

All test cases are annotated with:

- `@Epic("Pulkit home assignment")`
- `@Feature("Pet API tests")`
- Additional `@Story`, `@Severity`, or `@Description` can be added if needed

✅ Integrated for **Allure reporting**.

---

## 📌 How to Clean Generated Files

To clean build and generated files:

```bash
mvn clean
```

To clean Allure results:

```bash
rm -rf allure-results/
rm -rf allure-report/
```

---

## 🏁 Conclusion

This project demonstrates API testing best practices using Java, RestAssured, JUnit5, and Allure.

---

## 🙋‍♂️ Maintainer

**Pulkit Chaturvedi**  
Quality Chapter Lead | Test Automation Enthusiast

