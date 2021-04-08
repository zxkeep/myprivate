package com.keepzx.constant;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateRange implements Serializable {
	public static final DateRange DEFAULT = createInstanse(null, null);
			
	public static final DateRange createInstanse(Date beginDate,Date endDate){
		return new DateRange(beginDate,endDate);
	}
	
	private DateRange(Date beginDate,Date endDate){
		this.beginDate = beginDate;
		this.endDate = endDate;
	}
	
	private Date beginDate;
	private Date endDate;

	public Date getBeginDate() {
		return beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		DateRange other = (DateRange) obj;

		if (!this.getBeginDate().equals(other.getBeginDate())) {
			return false;
		}
		
		if (!this.getEndDate().equals(other.getEndDate())) {
			return false;
		}
		
		return true;
	}
	
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		return "[" + (this.beginDate == null ? "" : sdf.format(this.beginDate)) + "] - ["
				+ (this.endDate == null ? "" : sdf.format(this.endDate)) + "]";
	}
}
