# Exploratory Testing Notes - Monefy App

## 📋 Test Session Details
- **Tester**: Pulkit Chaturvedi
- **Device**: iOS
- **App Version**: 1.9.0
- **Date**: 26 Apr 2025
- **Duration**: ~1 hour

## Table of Contents
1. [Charter C1: Home Screen (Landing Page)](#charter-c1-home-screen-landing-page)
2. [Charter C2: Editing/Deleting an Expense](#charter-c2-editingdeleting-an-expense)
3. [Charter C3: Side Menu (Categories, Accounts, Currencies and Settings)](#charter-c3-side-menu-categories-accounts-currencies-and-settings)
4. [Charter C4: Side Menu (Accounts, Date Frequency Selection)](#charter-c4-side-menu-accounts-date-frequency-selection)
5. [Charter C5: Explore App Behavior in Offline Mode](#charter-c5-explore-app-behavior-in-offline-mode)

---

## Charter C1: Home Screen (Landing Page)
<a name="charter-c1-home-screen-landing-page"></a>

### Test Observations

| Area               | Observation                                                                          | Result       | Defect ID (if any)          |
|:-------------------|:-------------------------------------------------------------------------------------|:-------------|:----------------------------|
| UI/UX Layout       | All labels are visible and aligned properly.                                         | 🟢 Pass      | -                           |
| Default Balance    | Unnecessary 0 balance is shown even when no data is present.                         | 🔴 Fail      | [C1-M01](#charter-c1-home-screen-landing-page-identified-defects) |
| Add Expense Button | Button is present and working correctly.                                             | 🟢 Pass      | -                           |
| Add Income Button  | Button missing on first launch; appeared after restarting the app.                   | 🔴 Fail      | [C1-M02](#charter-c1-home-screen-landing-page-identified-defects) |
| Launch Time        | App launches within 2 seconds, acceptable performance.                               | 🟢 Pass      | -                           |
| Crash/Freeze       | No crash or freeze experienced during exploration.                                   | 🟢 Pass      | -                           |
| Balance Display    | Balance shows "0.00" correctly when no transactions are made.                      | 🟢 Pass      | -                           |
| Theme/Dark Mode    | Could not be verified due to paid version constraints.                               | ⚪ Not Executed | -                         |

### Identified Defects
<a name="charter-c1-home-screen-landing-page-identified-defects"></a>

| Defect ID | Summary                                                               | Steps to Reproduce                                                                                                                                 | Severity |
|:----------|:----------------------------------------------------------------------|:----------------------------------------------------------------------------------------------------------------------------------------------------|:---------|
| C1-M01    | Unnecessary 0 balance is shown even before any transactions are added. | 1. Install and open the app. <br> 2. Observe balance display on Home Screen.                                                                      | Low      |
| C1-M02    | Add Income button not visible on first launch.                        | 1. Fresh install the app. <br> 2. Open Home Screen. <br> 3. Notice missing "Add Income" option. <br> 4. Restart app and check again.                 | Medium   |

### Additional Notes

- **Pass**: When the functionality works as expected.
- **Fail**: When a defect is discovered.
- **Not Executed**: When testing could not be performed due to app limitations.

### Risk Assessment

- **UI Consistency Risk**: Missing "Add Income" button initially could confuse new users.
- **Functional Stability Risk**: If the balance handling is not precise at zero state, financial apps can mislead users.
- **Testing Limitation Risk**: Certain visual or theme-based features require a paid version, leading to incomplete verification.

---

## Charter C2: Editing/Deleting an Expense
<a name="charter-c2-editingdeleting-an-expense"></a>

### Test Observations

| Area             | Observation                                                      | Result       | Defect ID (if any)                 |
|:-----------------|:-----------------------------------------------------------------|:-------------|:-----------------------------------|
| Edit Expense     | Able to edit existing expense details correctly.                 | 🟢 Pass      | -                                  |
| Delete Expense   | Able to delete expense with confirmation prompt.                 | 🟢 Pass      | -                                  |
| Undo Option      | No visible undo option after deleting an expense.                | 🔴 Fail      | [C2-M03](#charter-c2-editingdeleting-an-expense-identified-defects) |
| Update Balance   | Balance updates correctly after editing/deleting an expense.     | 🟢 Pass      | -                                  |
| UI Feedback      | No animation or visual confirmation after delete.                | 🔴 Fail      | [C2-M04](#charter-c2-editingdeleting-an-expense-identified-defects) |

### Identified Defects
<a name="charter-c2-editingdeleting-an-expense-identified-defects"></a>

| Defect ID | Summary                                            | Steps to Reproduce                                                                                     | Severity |
|:----------|:---------------------------------------------------|:--------------------------------------------------------------------------------------------------------|:---------|
| C2-M03    | Missing undo option after deleting an expense.     | 1. Add an expense. <br> 2. Delete the expense. <br> 3. Observe no undo option.                          | Medium   |
| C2-M04    | Lack of visual feedback after deleting an expense. | 1. Add an expense. <br> 2. Delete the expense. <br> 3. Notice no animation or feedback given.             | Low      |

### Risk Assessment

- **Data Recovery Risk**: Missing undo could lead to accidental loss of important data.
- **User Experience Risk**: Lack of visual cues after deletion may confuse users.

---

## Charter C3: Side Menu (Categories, Accounts, Currencies and Settings)
<a name="charter-c3-side-menu-categories-accounts-currencies-and-settings"></a>

### Test Observations

| Area                   | Observation                                                   | Result       | Defect ID (if any)                 |
|:-----------------------|:--------------------------------------------------------------|:-------------|:-----------------------------------|
| Categories Navigation  | Categories list opens correctly.                              | 🟢 Pass      | -                                  |
| Add New Category       | Adding a new category possible.                               | 🟢 Pass      | -                                  |
| Accounts Navigation    | Accounts list opens correctly.                                | 🟢 Pass      | -                                  |
| Add New Account        | Adding a new account possible.                                | 🟢 Pass      | -                                  |
| Currencies Navigation  | Currencies list opens correctly.                              | 🟢 Pass      | -                                  |
| Currency Exchange Rates| Manual editing required; not automatic.                       | 🔴 Fail      | [C3-M05](#charter-c3-side-menu-categories-accounts-currencies-and-settings-identified-defects) |
| Settings Navigation    | Settings open correctly without crash.                        | 🟢 Pass      | -                                  |

### Identified Defects
<a name="charter-c3-side-menu-categories-accounts-currencies-and-settings-identified-defects"></a>

| Defect ID | Summary                                            | Steps to Reproduce                                                                                     | Severity |
|:----------|:---------------------------------------------------|:--------------------------------------------------------------------------------------------------------|:---------|
| C3-M05    | Currency exchange rates not updated automatically. | 1. Navigate to Currencies. <br> 2. Check if exchange rates are updated automatically.                 | Medium   |

### Risk Assessment

- **Accuracy Risk**: Manual currency updates can cause miscalculation in multi-currency tracking.

---

## Charter C4: Side Menu (Accounts, Date Frequency Selection)
<a name="charter-c4-side-menu-accounts-date-frequency-selection"></a>

### Test Observations

| Area              | Observation                                                          | Result       | Defect ID (if any)                 |
|:------------------|:---------------------------------------------------------------------|:-------------|:-----------------------------------|
| Account Management| Able to add, edit, and delete accounts.                              | 🟢 Pass      | -                                  |
| Frequency Selection| Date frequency filter works as expected.                            | 🟢 Pass      | -                                  |
| UI Stability      | Occasional lag when switching frequency filter.                      | 🔴 Fail      | [C4-M06](#charter-c4-side-menu-accounts-date-frequency-selection-identified-defects) |

### Identified Defects
<a name="charter-c4-side-menu-accounts-date-frequency-selection-identified-defects"></a>

| Defect ID | Summary                                              | Steps to Reproduce                                                                                     | Severity |
|:----------|:-----------------------------------------------------|:--------------------------------------------------------------------------------------------------------|:---------|
| C4-M06    | Lag when switching date frequency in side menu.      | 1. Open side menu. <br> 2. Select different date frequencies quickly. <br> 3. Notice UI lag.          | Low      |

---

## Charter C5: Explore App Behavior in Offline Mode
<a name="charter-c5-explore-app-behavior-in-offline-mode"></a>

### Test Observations

| Area                   | Observation                                                          | Result       | Defect ID (if any)                 |
|:-----------------------|:---------------------------------------------------------------------|:-------------|:-----------------------------------|
| App Launch             | Launches successfully in offline mode.                               | 🟢 Pass      | -                                  |
| Add Expense Offline    | Able to add expenses offline.                                        | 🟢 Pass      | -                                  |
| Sync After Reconnect   | No automatic sync or warning about unsynced data.                    | 🔴 Fail      | [C5-M07](#charter-c5-explore-app-behavior-in-offline-mode-identified-defects) |

### Identified Defects
<a name="charter-c5-explore-app-behavior-in-offline-mode-identified-defects"></a>

| Defect ID | Summary                                                        | Steps to Reproduce                                                                                                       | Severity |
|:----------|:---------------------------------------------------------------|:--------------------------------------------------------------------------------------------------------------------------|:---------|
| C5-M07    | No auto-sync or alert about unsynced data after reconnecting. | 1. Add data offline. <br> 2. Reconnect to internet. <br> 3. Observe no sync action or alert.                             | Medium   |

### Risk Assessment

- **Data Loss Risk**: Without sync or warning, users might assume data is already backed up.
- **Reliability Risk**: Missing offline error handling leads to poor app reliability perception.

---

## Summary of Defects and Prioritization

| Defect ID | Summary | Severity | Priority |
|:----------|:--------|:---------|:---------|
| C1-M01    | Unnecessary 0 balance is shown even before any transactions are added. | Low    | Medium |
| C1-M02    | Add Income button not visible on first launch.                     | Medium | High   |
| C2-M03    | Missing undo option after deleting an expense.                     | Medium | Medium |
| C2-M04    | Lack of visual feedback after deleting an expense.                 | Low    | Low    |
| C3-M05    | Currency exchange rates not updated automatically.                 | Medium | High   |
| C4-M06    | Lag when switching date frequency in side menu.                    | Low    | Low    |
| C5-M07    | No auto-sync or alert about unsynced data after reconnecting.      | Medium | High   |
