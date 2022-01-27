A JDT parser that can be used parse Python language constructs. 

Steps to build
* Follow the steps in https://wiki.eclipse.org/JDT_Code_Setup_Using_Oomph to create Eclips workspace
* Copy all the .java files of [this folder](https://github.com/maldil/JavaFyPy/tree/master/CustomizedEclipseJDT/jdt-master/git/eclipse.jdt.core/org.eclipse.jdt.core) to the folder `/location_of_workspace/jdt-master/git/eclipse.jdt.core/org.eclipse.jdt.apt.core`
* Execute `mvn11 -P build-individual-bundles package -o` in `/location_of_workspace/jdt-master/git/eclipse.jdt.core/org.eclipse.jdt.apt.core`
