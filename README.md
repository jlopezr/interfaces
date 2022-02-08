# Interfaces

Welcome to Interfaces on Exercism's Software Architecture on Java Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

*TODO*

## Instructions

In this exercise you'll be playing with geometric figures. All of them have its area and perimeter, but depending on the specific figure, its calculation will be different,i.e the area formula of the circle is not the same that the square.

In addition to that, each figure has different characteristics that identify it. For example a circle is completely determined with its radius, meanwhile a rectangle is determined by two of its sides.

Each figure will have a `double getArea()` and `double getPerimeter()` methods that will return the calculated area and perimeter based on its characteristics.


You will have to implement a `FigureManager` where you should be able to add different figures of different types and be able to calculate the sum of areas and perimeters of all the figures.


// Figure, Circle, Rectangle, Square classes (or interfaces)
// 

## 1. Create the Circle

Implement the `Circle` and its area and perimeter methods.

```java
Circle c = new Circle(1); // 1 is the radius
c.getArea() // => 3.141592653589793
```

## 2. Create the Square

Implement the `Square`.


```java
Square s = new Square(1); // 1 is the side
s.getArea() // => 1
```

## 3. Create the Rectangle

Do the same with the `Rectangle`.

```java
Rectangle r = new Rectangle(2, 1); // 2 and 1 are the sizes of the sides r.getArea() // => 2
```


## 4. Create the FigureManager

Implement the `FigureManager.addNewFigure()` method that adds a new figure to the manager. 

Add and update the figure accordangly.


```java
FigureManager f = new FigureManager();
Circle c = new Circle(1);
Square s = new Square(1);
f.addNewFigure(c);
f.addNewFigure(s);
```

## 5. Calculate the total area
 
Update the `FigureManager` to add the `double calculateTotalArea()` method:

```java
FigureManager f = new FigureManager();
Circle c = new Circle(1);
Square s = new Square(1);
f.addNewFigure(c);
f.addNewFigure(s);
f.calculateTotalArea() // => 4.141592653589793
```

## 6. Calculate the total perimeter
 
Update the `FigureManager` to add the `double calculateTotalPerimeter()` method:

```java
FigureManager f = new FigureManager();
Square s1 = new Square(1);
Square s2 = new Square(2);
f.addNewFigure(s1);
f.addNewFigure(s2);
f.calculateTotalPerimeter() // => 12
```

## Source

### Created by

- @jlopezr