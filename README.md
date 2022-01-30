# JavaFyPy : A mechanism to adapt Java AST analysis tools to Python

Over the years, researchers have developed a solid toolset to analyse Java software systems. JavaFyPy enables adapting these tools to Python.

![](https://github.com/maldil/JavaFyPy/blob/master/ICSE2022.png)

JavaFyPy creates a Python AST that the Java AST mining tools can process. The above diagram shows the steps of AST transformation performed by JavaFyPy.

This repositoy presents all the above tools

You can follow the following steps to adapt Java AST mining tools to Python.


1. JPythonParser is a Python parser developed in Java. You can use the class PyASTParser to create the initial AST of the Python code `content` as below.
    ```
    mod ast = PyASTParser.parsePython(content);
    ```
2. Then the class `PythonASTUtil:createPyCompilationUnit` in SyntaxtTranformer transforms the syntax and augments the AST with type information using the `TypeAugmentor`. You can use the type information in [https://github.com/mlcodepatterns/PythonTypeInformation](https://github.com/mlcodepatterns/PythonTypeInformation) for type augmentation. 

3. As the next step, migrate the existing Java parser of your tool to our eclipse JDT parser provided in [CustomizedEclipseJDT](https://github.com/maldil/JavaFyPy/tree/master/CustomizedEclipseJDT)




Using JavaFyPy, we adapted Java [RefactoringMiner](https://github.com/tsantalis/RefactoringMiner) and [CPATMiner](https://github.com/nguyenhoan/CPatMiner) to Python. We provide two example usages below.

1. Py-RefactoringMiner - [click-me](https://github.com/maldil/RefactoringMiner/blob/master/src/main/java/refactoringminer/python/PythonASTUtil.java#L46)
2. R-CPATMiner - [click-me](https://github.com/maldil/R-CPATMiner/blob/210b09186b67b698132e7beb3c10ad22e15dceeb/AtomicASTChangeMining/src/main/java/change/CFile.java#L39)
