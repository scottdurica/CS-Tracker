package emroxriprap.com.tracker;

import java.util.Date;

/**
 * Created by Scott Durica on 3/17/2015.
 */
public class Entry {

    private String jobName, description;
    private Date inTime;
    private Date outTime;

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }


    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }


    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
