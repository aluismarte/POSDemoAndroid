package com.alsjava.courses.posdemoandroid.model.communication.request;

import java.util.Date;

/**
 * Created by aluis on 11/9/19.
 */
public class ReportRequest extends Request {

    private Date startDate;
    private Date endDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
