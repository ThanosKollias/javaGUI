package softecon.javaswing.test.vo;

/*
 * @author tkol
 */
public class VO_GUI {

    private String _name = null;
    private String _className = null;

    public VO_GUI(String name, String className) {
        _name = name;
        _className = className;
    }

    public String getName() {
        return _name;
    }

    public String getClassName() {
        return _className;
    }

    @Override
    public String toString() {
        return _name;
    }

}
