# Builder Pattern Assignment

## About

This project demonstrates the Builder design pattern in Java using a space mission theme. The idea is that a space mission can have many different configurations, and Builder lets us create it step by step instead of passing everything into one huge constructor.

## Initial Submission Note

Initially I misunderstood the assignment and submitted an empty document. As soon as I understood what was required, I corrected it and completed the actual implementation.

## Builder Pattern

Builder is a creational design pattern that lets you build a complex object step by step. Instead of one big constructor with many parameters, you call small methods one at a time to set only the parts you need. When you are done, you call build() and get the finished object. This makes it easy to create different configurations of the same object using the same building process.

## Project Roles

| Role | Class |
|------|-------|
| Product | `Mission` |
| Builder | `MissionBuilder` |
| Director | `MissionDirector` |
| Client | `Main` |

## Fluent API

Every method in `MissionBuilder` returns `this`, which means you can chain calls one after another on the same line. This is called a fluent API or method chaining.

```java
new MissionBuilder()
    .name("Mars One")
    .target("Mars")
    .crew(4)
    .days(300)
    .build();
```

## Validation

Before creating a `Mission`, the `build()` method checks that the important fields are filled in correctly. If something is missing or wrong, it throws an `IllegalArgumentException` right away so the problem is caught early.

## Clean Code

### 1. Meaningful Names

Names should clearly say what something is or does, without needing a comment to explain it.

**Before:**
```java
public void x(String a)
```

**After:**
```java
public MissionBuilder name(String name)
```

The second version tells you exactly what the method does just by reading it.

---

### 2. Small Methods

Each method should do one small thing. Long methods that do many things are hard to read.

**Before:**
```java
public Mission buildMissionAndValidateAndPrint() {
    // 40 lines of mixed logic
}
```

**After:**
```java
public Mission build() {
    if (name == null || name.isEmpty()) {
        throw new IllegalArgumentException("Mission name is required");
    }
    return new Mission(this);
}
```

The method is short and does only one job.

---

### 3. Single Responsibility

Each class should have one clear purpose and not try to do everything.

**Before:**
```java
public class Mission {
    // stores mission data
    // also validates input
    // also prints reports
    // also manages director logic
}
```

**After:**
- `Mission` — stores mission data
- `MissionBuilder` — builds and validates the mission
- `MissionDirector` — provides preset configurations
- `Main` — runs the program

Each class has one responsibility.

---

### 4. Validation Before Object Creation

Invalid objects should not be created at all. The `build()` method checks values before calling `new Mission(this)`.

**Before:**
```java
public Mission build() {
    return new Mission(this);
}
```

**After:**
```java
public Mission build() {
    if (crew <= 0) {
        throw new IllegalArgumentException("Crew must be greater than 0");
    }
    return new Mission(this);
}
```

Now a mission with zero crew can never exist.

---

### 5. Consistent Formatting

All builder methods are written the same way: same indentation, same return type, same pattern. This makes the code much easier to read.

**Before:**
```java
public MissionBuilder name(String name){ this.name=name; return this;}
public MissionBuilder target(String t) {
this.target=t;
    return this; }
```

**After:**
```java
public MissionBuilder name(String name) {
    this.name = name;
    return this;
}

public MissionBuilder target(String target) {
    this.target = target;
    return this;
}
```

Consistent formatting reduces confusion and makes the code look professional.

## How to Run

1. Open the `testforjava` folder in IntelliJ IDEA.
2. Mark the `src` folder as the Sources Root (right-click → Mark Directory As → Sources Root).
3. Open `Main.java`.
4. Click the green Run button next to `main`.

You can also compile and run from the command line:

```
javac -d out src/Mission.java src/MissionBuilder.java src/MissionDirector.java src/Main.java
java -cp out Main
```
