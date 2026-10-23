# REST Assured API Automation Framework

An automated API testing framework built with **Java**, **REST Assured**, **TestNG**, and **Maven** in **Eclipse IDE**, utilizing a reusable API client architecture and BDD-style (`given()`, `when()`, `then()`) syntax.

---

## 🚀 Tech Stack & Tools

* **Language:** Java (JDK 8+)
* **API Testing Library:** REST Assured (BDD-style)
* **Test Runner / Framework:** TestNG
* **Build & Dependency Management:** Maven
* **IDE:** Eclipse IDE

---

## ✨ Key Features

* **Reusable API Client:** Centralized request builder to avoid code duplication across endpoints.
* **BDD Readability:** Leverages REST Assured's fluent `given() - when() - then()` syntax.
* **TestNG Integration:** Structured test execution, parallel runs, and comprehensive assertions.
* **Mavenized Build:** One-command dependency management and test execution.

---

## ⚙️ Prerequisites

Make sure you have the following installed on your machine:
* [Java JDK](https://oracle.com) (v8 or higher)
* [Eclipse IDE](https://eclipse.org) with TestNG plugin installed
* [Maven](https://apache.org) (or use Eclipse's built-in Maven support)

---

## 🛠️ Setup & Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/shindeavi47/API_Testing_Framework_RESTAssured
   ```

2. **Import into Eclipse:**
   * Open Eclipse IDE.
   * Go to `File` > `Import` > `Maven` > `Existing Maven Projects`.
   * Browse to the cloned project folder and click **Finish**.

3. **Update Maven Dependencies:**
   * Right-click the project folder in Eclipse.
   * Select `Maven` > `Update Project...` (or press `Alt + F5`).

---

## 🏃‍♂️ Running the Tests

### From Eclipse:
* Right-click `testng.xml` (or your test class).
* Select `Run As` > `TestNG Suite` (or `TestNG Test`).

### From Command Line (Maven):
Run the following command from the root directory of the project:
```bash
mvn clean test
```

---

## 📜 Sample Usage (BDD Format)

```java
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SampleApiTest extends BaseApiClient {

    @Test
    public void testGetUserDetails() {
        given()
            .spec(requestSpec)
            .pathParam("id", 2)
        .when()
            .get("/api/users/{id}")
        .then()
            .statusCode(200)
            .body("data.id", equalTo(2));
    }
}
```
