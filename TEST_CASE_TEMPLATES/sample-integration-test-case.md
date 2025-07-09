# Integration Test Case: User Registration with Email Notification

**Test Case ID:** ITC-001  
**Title:** Register New User and Trigger Email Notification  
**Created By:** [Your Name]  
**Date Created:** [YYYY-MM-DD]  

---

## Pre-conditions

- Backend application and database service are running
- Email service is configured (using test or staging environment)
- No existing user in the database with the email `testuser@example.com`

---

## Test Data

| Field    | Value                 |
|----------|-----------------------|
| Name     | Test User             |
| Email    | testuser@example.com  |
| Password | TestPass123!          |

---

## Test Steps

| Step | Action                                                                      | Expected Result                                                                      |
|------|-----------------------------------------------------------------------------|--------------------------------------------------------------------------------------|
| 1    | Send a `POST` to `/api/users/register` with the test data                   | HTTP 201 Created; response body includes new user details (id, name, email present)  |
| 2    | Query the database for `testuser@example.com`                               | User is present; password is hashed                                                  |
| 3    | Check test email inbox or email service logs for sent messages              | "Welcome" or registration confirmation email was sent to the user                    |
| 4    | Repeat step 1 with the same email address                                   | HTTP 409 Conflict (or appropriate error); duplicate user is **not** created          |

---

## Post-conditions

- Test user `testuser@example.com` is present in the database
- Email log/service contains the sent welcome/confirmation email

---

## Clean-up

- Delete the test user from the database
- Remove any generated emails (if applicable)

---

## Notes

- Use mocking/staging environment for external services as needed
- Test should be repeatable; clean up state after run
- Adjust field names, endpoints, and responses according to the actual application

---

## Attachments

- [ ] API response log
- [ ] Database snapshot or query result
- [ ] Email payload or log

---

**Result:**  
- [ ] Pass  
- [ ] Fail (add logs, errors, or observations below)

---
