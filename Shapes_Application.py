from Q5 import Shape
from Q5 import Circle
from Q5 import Rhombus
from Q5 import Ellipse

#Code for Question 6
def read_file(filename):
    categ_count = 1
    shape_count = 0
    circ_count = 0
    ell_count = 0
    rhom_count = 0
    shape_file = open(filename, "r")
    lines = shape_file.readlines()
    print("\n")
    for line in lines:
        print(str(categ_count) + ":", end =" ")
        categ_count += 1
        line_seg = line.split(" ")
        if line_seg[0] == "shape\n":
            shp = Shape()
            shp.print()
            shape_count += 1
        elif line_seg[0] == "circle":
            circ = Circle(int(line_seg[1]))
            if int(line_seg[1]) < 0:
                print("Error: Invalid Circle")
                circ.print()
                circ_count += 1
                continue
            circ.print()
            circ_count += 1
        elif line_seg[0] == "ellipse":
            ell = Ellipse(int(line_seg[1]), int(line_seg[2]))
            if int(line_seg[1]) < 0 or int(line_seg[2]) < 0:
                print("Error: Invalid Ellipse")
                ell.print()
                ell_count += 1
                continue
            ell.print()
            print("eccentricity: " + str(ell.eccentricity()))
            ell_count += 1
        elif line_seg[0] == "rhombus":
            rhom = Rhombus(int(line_seg[1]), int(line_seg[2]))
            if int(line_seg[1]) < 0 or int(line_seg[2]) < 0:
                print("Error: Invalid Rhombus")
                rhom.print()
                rhom_count += 1
                continue
            rhom.print()
            print("inradius: " + str(rhom.inradius()))
            rhom_count += 1
    #Code for Question 7
    print("\nStatistics:")
    print("\tCircle(s): " + str(circ_count))
    print("\tEllipse(s): " + str(ell_count))
    print("\tRhombus(es): " + str(rhom_count))
    print("\t\t--")
    print("\tTotal shapes: " + str(shape_count + circ_count + ell_count + rhom_count))




read_file("shapes.txt")