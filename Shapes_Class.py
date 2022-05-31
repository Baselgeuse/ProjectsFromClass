import math

class Shape():
    newid = 1

    def __init__(self):
        self.id = Shape.newid
        Shape.newid += 1

    def perimeter(self):
        return None

    def area(self):
        return None

    def print(self):
        print("Shape: " + self.__class__.__name__ + ", Perimeter: " + str(self.perimeter()) + ", Area: " + str(self.area()))

class Circle(Shape):
    def __init__(self,radius):
        super().__init__()
        self.radius = radius

    def perimeter(self):
        if self.radius < 0:
            return None
        return self.radius * 2 * math.pi

    def area(self):
        if self.radius < 0:
            return None
        return math.pi * math.pow(self.radius, 2)

class Ellipse(Shape):
    def __init__(self, semi_major, semi_minor):
        super().__init__()
        if semi_major < semi_minor:
            self.b = semi_major
            self.a = semi_minor
        else:
            self.a = semi_major
            self.b = semi_minor

    def area(self):
        if self.a < 0 or self.b < 0:
            return None
        return math.pi * self.a * self.b

    def eccentricity(self):
        if self.a <= self.b:
            return None
        else:
            return math.sqrt((self.a * self.a) - (self.b * self.b))

class Rhombus(Shape):
    def __init__(self, d1, d2):
        super().__init__()
        self.d1 = d1
        self.d2 = d2

    def perimeter(self):
        if self.d1 < 0 or self.d2 < 0:
            return None
        return 2*(math.sqrt(math.pow(self.d1, 2) + math.pow(self.d2, 2)))

    def area(self):
        if self.d1 < 0 or self.d2 < 0:
            return None
        return (self.d1 * self.d2)/2

    def inradius(self):
        return (self.d1 * self.d2)/(2 * math.sqrt(math.pow(self.d1, 2) + math.pow(self.d2, 2)))

