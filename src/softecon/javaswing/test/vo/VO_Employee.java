package softecon.javaswing.test.vo;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

/*
 * @author tkol
 */
public class VO_Employee implements Serializable, Comparable<VO_Employee> {

    private static final long serialVersionUID = -9056112600667812085L;
//    private static final long serialVersionUID = -5398884032681160451L;
    static int counter = 1;
    private int _empId;
    private String _empName;
    private String _empSurname;
    private VO_Job _empJob;

    //constructor
//    public VO_Employee(int _empId, String _empName, String _empSurname, VO_Job _empJob) {
//        this._empId = _empId;
//        this._empName = _empName;
//        this._empSurname = _empSurname;
//        this._empJob = _empJob;
//    }
    public VO_Employee(String _empName, String _empSurname, VO_Job _empJob) {

        this._empName = _empName;
        this._empSurname = _empSurname;
        this._empJob = _empJob;
        setEmpId(counter);
        counter++;
    }

    //getters and setters
    public int getEmpId() {
        return _empId;
    }

    public void setEmpId(int _empId) {
        this._empId = _empId;
    }

    public String getEmpName() {
        return _empName;
    }

    public void setEmpName(String _empName) {
        this._empName = _empName;
    }

    public String getEmpSurname() {
        return _empSurname;
    }

    public void setEmpSurname(String _empSurname) {
        this._empSurname = _empSurname;
    }

    public VO_Job getEmpJob() {
        return _empJob;
    }

    public void setEmpJob(VO_Job _empJob) {
        this._empJob = _empJob;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof VO_Employee) {
            if (((VO_Employee) obj).getEmpName().equals(obj) && ((VO_Employee) obj).getEmpSurname().equals(obj)) {
                return equals((VO_Employee) obj);
            }

        }

        return false;
    }

    public int compare(VO_Employee emp1, VO_Employee emp2) {
        int result = (int) emp1.getEmpName().compareTo(emp2.getEmpName());
        int secResult = (int) (result == 0 ? emp1.getEmpSurname().compareTo(emp2.getEmpSurname()) : result);
        return (int) (result == 0 ? emp1.getEmpJob().getSalary() - (emp2.getEmpJob().getSalary()) : secResult);
    }

    @Override
    public int compareTo(VO_Employee emp1) {
        int result = (int) this.getEmpName().compareTo(emp1.getEmpName());
        int secResult = (int) (result == 0 ? this.getEmpSurname().compareTo(emp1.getEmpSurname()) : result);
        return (int) (result == 0 ? this.getEmpJob().getSalary() - (emp1.getEmpJob().getSalary()) : secResult);
    }

}
