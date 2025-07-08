# 🐞 QA Bug Reporting Guide

## 1. 🎯 Purpose & Scope
- Ensure all defects are reported clearly, completely, and concisely.
- Facilitate effective triage, prioritization, and resolution by the engineering team.

## 2. 📝 Writing Effective Bug Reports

### 2.1 ⚡ Title
- Summarize the issue precisely (e.g., `Login fails with valid credentials on Chrome v123`).
- Avoid generic titles (e.g., “App not working”).

### 2.2 📋 Description
- Clearly explain **what is wrong** and **where/how** it happens.
- Differentiate between **expected** and **actual** results.

### 2.3 🎬 Steps to Reproduce
- Number each action step.  
  *Example:*
  1. Go to login page.
  2. Enter valid credentials.
  3. Click “Sign In”.

### 2.4 ✅ Expected vs. Actual Result
- **Expected:** User is logged in and redirected to dashboard.
- **Actual:** Error message: “Invalid credentials” is shown.

### 2.5 📅 Environment Details
- Application version/branch.
- Browser, OS (including version), Device type.
- Network (if relevant: WiFi, mobile data, VPN).

### 2.6 🏷️ Attachments & Evidence
- Add screenshots, screen recordings, or logs if possible.
- Mark problematic area(s) in images for clarity.

## 3. 🔍 Severity & Priority
- Assign **Severity** (impact on application): Blocker, Critical, Major, Minor, Trivial.
- Suggest **Priority** (business urgency). Consult with leads for High/Critical issues.

## 4. 🚥 Status & Reproducibility
- Indicate if issue is always, sometimes, or rarely reproducible.
- State if issue is found in regression, new feature, UAT, or production.

## 5. 🧾 Sample Bug Report Template
**Title:** [Module] Clear, concise summary
**Description:** What is happening vs. what should happen.
**Steps to Reproduce:**
1. [First step...]
2. [Second step...]
...
**Expected Result:** [Describe expected behavior]
**Actual Result:** [Describe actual behavior]
**Environment:**
- App Version: 
- Browser/OS/Device: 
- Test Data Used: 
**Severity:** [Blocker/Major/Minor/Trivial]
**Priority:** [High/Medium/Low]
**Reproducibility:** [Always/Sometimes/Rarely]
**Attachments:** [Screenshots, logs, videos]

## 6. 👓 Best Practices & Tips
- **Replicate before reporting:** Confirm issue on a clean environment if possible.
- **Avoid assumptions:** Stick to facts; do not suggest root causes.
- **One bug per report:** Log distinct issues separately.
- **Update status/tags:** Mark as “Ready for Retest” after verify fixes.
- **Follow up:** Add comments for clarifications or updates as needed.

## 7. 🤝 Communication & Collaboration
- Be respectful and objective—focus on the issue, not on blame.
- Respond to developer questions promptly.
- Reference related bugs or test cases if applicable.

## 8. 🏷️ Bug Management Tools (Examples)
- Jira, Azure DevOps, Bugzilla, GitHub Issues.
- Use labels/components/versions consistently.

## 9. 📚 References
- [Atlassian Bug Reporting Best Practices](https://www.atlassian.com/agile/testing/bug-report)
- [Google Bug Reporting Guidelines](https://google.github.io/buganizer/guide.html)
- [GitHub Issues Documentation](https://docs.github.com/en/issues/tracking-your-work-with-issues/about-issues)
