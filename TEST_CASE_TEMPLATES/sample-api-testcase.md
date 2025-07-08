# 📑 API Test Case Template

---

## Test Case ID
`API-<Module>-<Number>`  
*Example: API-USER-001*

## Title
Short, descriptive summary of the test case  
*Example: [GET] Fetch user details with valid user ID*

## Objective
State the purpose of this test.  
*Example: Verify the user details API returns correct information for a valid user ID.*

## Preconditions
- User exists in the system.
- Test environment is up and running.
- Valid authentication token is available.

## Test Data
| Field         | Value        | Description                 |
|---------------|-------------|-----------------------------|
| userId        | 1234        | Existing user in DB         |
| Auth Token    | ABCDXYZ...  | Valid token with user scope |

## Request Details
- **Endpoint:** `/api/v1/users/{userId}`
- **HTTP Method:** `GET`
- **Headers:**
  - `Authorization: Bearer <token>`
  - `Content-Type: application/json`
- **Body:** _(if applicable, usually blank for GET)_

## Steps
1. Replace `{userId}` in endpoint with `1234`.
2. Set required headers.
3. Send the `GET` request to `/api/v1/users/1234`.

## Expected Results
- **HTTP Status:** `200 OK`
- **Response Time:** `< 500 ms`
- **Response Body Structure:**

json
    {
      "id": 1234,
      "name": "John Doe",
      "email": "john.doe@example.com",
      "status": "active"
    }

- **Validation Points:**
  - Returned `id` matches request user ID
  - All mandatory fields are present
  - Schema validation passes
  - No sensitive data is exposed

## Postconditions / Cleanup
- None (Read-only API call)

## Attachments / References
- [API Documentation](https://api.example.com/docs/users#get)
- [Related User Story/Ticket](https://jira.example.com/browse/USER-1001)

---

> _Note: Attach cURL commands, Postman collections, or example logs/screenshots below if needed for debugging or reporting._
