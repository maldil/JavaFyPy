import org.jpp.astnodes.PythonTree;
import org.jpp.astnodes.Visitor;

public class TestVisitor extends Visitor {
    @Override
    public void traverse(PythonTree node) throws Exception {
        System.out.println("fun");
        System.out.println(node.getNode());
        node.traverse(this);
    }

}
