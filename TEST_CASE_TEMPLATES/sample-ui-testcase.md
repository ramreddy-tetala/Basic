# 🖥️ UI Test Case Template

---

## Test Case ID
`UI-<Module>-<Number>`  
*Example: UI-LOGIN-001*

## Title
Clear, descriptive summary of the test  
*Example: Login page - Successful login with valid credentials*

## Objective
State what this test validates/ensures.  
*Example: Verify that a user can log into the application with valid credentials and is redirected to the dashboard.*

## Preconditions
- Application is deployed and accessible.
- Test user account exists with valid credentials.
- Browser is installed and functional.

## Test Data
| Field     | Value                   | Description         |
|-----------|------------------------|---------------------|
| Username  | johndoe@example.com    | Valid user email    |
| Password  | MySecurePassword!123   | Valid password      |

## Test Environment
- Browser: Chrome 123.0 / Firefox 115.0 / Edge 110.0
- OS: Windows 11 / macOS Ventura
- Application URL: `https://app.example.com/login`

## Steps
1. Launch the browser and navigate to the application URL.
2. Locate the **Email/Username** input and enter `johndoe@example.com`.
3. Locate the **Password** input and enter `MySecurePassword!123`.
4. Click the "**Login**" button.
5. Wait for redirection to the dashboard.

## Expected Results
- User is redirected to the dashboard page.
- User profile name is displayed in the header.
- No error messages are shown.
- Application is responsive and UI elements are as per design.

## Validation Points
- Login is successful only with valid credentials.
- Error is displayed for invalid credentials (negative case recommended separately).
- All fields have correct placeholders and labels.
- Button is disabled until both fields are filled.
- No visible sensitive information in the UI or console.

## Postconditions / Cleanup
- User is logged in (perform logout if needed).
- Close the browser after validation.

## Attachments / Evidence
- **Screenshots** of the login flow and final dashboard.
- **Video recording** if available.
- **Console/network logs** on errors or UI issues.
- [Related requirement or user story](https://jira.example.com/browse/LOGIN-101)

## Notes / Comments
- Perform cross-browser and cross-platform (mobile/desktop) checks if required.
- Use appropriate wait mechanisms (explicit waits) for dynamic UI elements.
- Document any UI issues separately in the bug tracker.

---

> _Tip: Attach screenshots, HAR files, or any test automation script (Java/Python with Selenium, Cypress, Playwright, etc.) if automation is available for reference and debugging._
