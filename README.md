# JavaFyPy : A mechanism to adapt Java AST analysis tools to Python

![](https://github.com/maldil/JavaFyPy/blob/master/ICSE2022.gif)
This repositoy presents the all the above tools



A JDT parser that can be used parse Python language constructs. 

Steps to build
* Follow the steps in https://wiki.eclipse.org/JDT_Code_Setup_Using_Oomph to create Eclips workspace
* Copy all the containt of [this folder](https://github.com/maldil/PyEclipsJDTParser/tree/master/jdt-master/git/eclipse.jdt.core/org.eclipse.jdt.apt.core) to the folder `/location_of_workspace/jdt-master/git/eclipse.jdt.core/org.eclipse.jdt.apt.core`
* Execute `mvn11 -P build-individual-bundles package -o` in `/location_of_workspace/jdt-master/git/eclipse.jdt.core/org.eclipse.jdt.apt.core`
