# 🧾 Receipt Processor API

A RESTful API built with **Java + Spring Boot** for the Fetch Rewards take-home challenge. It processes receipts and returns reward points based on specific rules.

---

## 🚀 Installation & Running

### Prerequisites
- Java 17+
- Maven 3.8+

### Steps to Build and Run

```bash
# Clone the repository
git clone https://github.com/Inviboy123/receipt-processor.git
cd receipt-processor

# Run the application
mvn spring-boot:run
```

The service will start on:  
➡️ `http://localhost:8080`

---

## 📦 Technologies Used

- **Java 17**
- **Spring Boot 3.2**
- **Maven** – Dependency Management
- **Lombok** (optional)
- **JUnit** – for unit testing

---

## 📚 API Endpoints

### ➕ POST /receipts/process

Processes a receipt and returns a unique receipt ID.

**Request Example:**

```json
{
  "retailer": "Target",
  "purchaseDate": "2022-01-01",
  "purchaseTime": "14:33",
  "items": [
    {
      "shortDescription": "Mountain Dew 12PK",
      "price": "6.49"
    },
    {
      "shortDescription": "Emils Cheese Pizza",
      "price": "12.25"
    }
  ],
  "total": "35.35"
}
```

**Response Example:**

```json
{
  "id": "1d51ee2b-cd8b-4351-b1a0-3cce69b37f46"
}
```

---

### 📊 GET /receipts/{id}/points

Retrieves the points associated with a submitted receipt.

**Request Example:**

```http
GET /receipts/1d51ee2b-cd8b-4351-b1a0-3cce69b37f46/points
```

**Response Example:**

```json
{
  "points": 109
}
```

---

## 🧪 Testing

### ✅ Sample curl Test

```bash
curl -X POST http://localhost:8080/receipts/process \
  -H "Content-Type: application/json" \
  -d '{
    "retailer": "Target",
    "purchaseDate": "2022-01-01",
    "purchaseTime": "14:33",
    "items": [
      {
        "shortDescription": "Mountain Dew 12PK",
        "price": "6.49"
      },
      {
        "shortDescription": "Emils Cheese Pizza",
        "price": "12.25"
      }
    ],
    "total": "35.35"
  }'
```

---

## 🧪 Unit Tests

Basic unit test for point calculation will be located in:

```
src/test/java/com/fetch/receiptprocessor/service/ReceiptServiceTest.java
```

Tests include:
- ✅ Points from retailer name
- ✅ Round dollar total
- ✅ Description-based bonus
- ✅ Time of day bonus

Run tests with:

```bash
mvn test
```

---

## 👤 Author

**Sujit Kumar**  
Java Backend Developer — Fetch Challenge Submission

---
