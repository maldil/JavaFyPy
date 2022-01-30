A JDT parser that can be used parse Python language constructs. 

Steps to build
* Follow the steps in https://wiki.eclipse.org/JDT_Code_Setup_Using_Oomph to create Eclips workspace
* Copy all the content of [this folder](https://github.com/maldil/PyEclipsJDTParser/tree/master/jdt-master/git/eclipse.jdt.core/org.eclipse.jdt.apt.core) to the folder `/location_of_workspace/jdt-master/git/eclipse.jdt.core/org.eclipse.jdt.apt.core`
* Execute `mvn11 -P build-individual-bundles package -o` in `/location_of_workspace/jdt-master/git/eclipse.jdt.core/org.eclipse.jdt.apt.core`

We have also included a previously built jar file for your convenience - [org.eclipse.jdt.core-3.25.0-SNAPSHOT.jar](https://github.com/maldil/JavaFyPy/blob/master/CustomizedEclipseJDT/org.eclipse.jdt.core-3.25.0-SNAPSHOT.jar)


Execute -
`mvn install:install-file -Dfile=/Path To File/org.eclipse.jdt.core-3.25.0-SNAPSHOT.jar -DgroupId=org.eclipse.jdt -DartifactId=org.eclipse.jdt.core -Dversion=3.25.0-SNAPSHOT -Dpackaging=jar -DgeneratePom=true`
