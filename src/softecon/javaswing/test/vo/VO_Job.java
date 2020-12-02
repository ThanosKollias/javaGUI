package softecon.javaswing.test.vo;

import java.io.*;

/*
 * @author tkol
 */
public class VO_Job implements Serializable {

    private double _salary;
    private String _nameOfJob;

    //constructor
    public VO_Job(double _salary, String _nameOfJob) {
        this._salary = _salary;
        this._nameOfJob = _nameOfJob;
    }

    //getters and setters
    public double getSalary() {
        return _salary;
    }

    public void setSalary(double _salary) {
        this._salary = _salary;
    }

    public String getNameOfJob() {
        return _nameOfJob;
    }

    public void setNameOfJob(String _nameOfJob) {
        this._nameOfJob = _nameOfJob;
    }

    public boolean equals(VO_Job job) {
        if (this._nameOfJob.equalsIgnoreCase(job.getNameOfJob()) && this._salary == job.getSalary()) {
            return true;
        }

        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof VO_Job) {
            return equals((VO_Job) obj);

        }

        return false;
    }

}
