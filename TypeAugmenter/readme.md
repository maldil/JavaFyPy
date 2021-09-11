An example usage is shown in the [R-CPATMiner](https://github.com/maldil/R-CPATMiner/) which is a tools that adapted to Python using JavaFyPy
```java
String typeString = this.typeinformation.get(new TypeASTNode(typeDecNeeds.getRow(), typeDecNeeds.getCol_offset(), typeDecNeeds.getName(), null));
VariableDeclarationStatement varDecStat = TypeStringToJDT.mapTypeStringToTypeTree(asn, typeDecNeeds, typeString,0);
```
[Code Line](https://github.com/maldil/R-CPATMiner/blob/210b09186b67b698132e7beb3c10ad22e15dceeb/AtomicASTChangeMining/src/main/java/python3/PythonASTUtil.java#L413)
