# Kaprekar's Constant App 

An interactive Android app that demonstrates the mathematical mystery of **Kaprekar's Constant (6174)**. 

## What It Does
1. You Input: Any 4-digit number with at least two unique digits (e.g., `2026`).
2. App Counts:  The exact number of steps taken to reach 6174 (always 7 steps or fewer).
3. App Shows: The exact subtraction path used to get there.

### Example Path for `2026` (6 Steps):
  Step 1: `6220 - 0226 = 5994`
  Step 2: `9954 - 4599 = 5355`
  Step 3: `5553 - 3555 = 1998`
  Step 4: `9981 - 1899 = 8082`
  Step 5: `8820 - 0288 = 8532`
  Step 6: `8532 - 2358 = 6174`  *(Target Reached)*

##  How the Routine Works
The app automates this simple loop:
1. Sorts your digits from highest to lowest (makes the **largest** number).
2. Sorts your digits from lowest to highest (makes the **smallest** number).
3. **Subtracts** the small number from the large number.
4. Repeats until the result hits and gets trapped on **6174**.

##  Setup
1. Clone this repository.
2. Open the folder in **Android Studio**.
3. Press **Run** to launch on your device or emulator.
