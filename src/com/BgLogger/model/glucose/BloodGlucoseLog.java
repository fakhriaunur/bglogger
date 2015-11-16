package com.BgLogger.model.glucose;

import android.annotation.SuppressLint;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BloodGlucoseLog {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	
	private Long id;
	private Long bloodGlucoseMeasurementUnitId;
	private BloodGlucoseMeasurementUnit BloodGlucoseMeasurementUnit;
	private Long bloodGlucoseTypeId;
	private BloodGlucoseType bloodGlucoseType;
	private BigDecimal reading;
	private Date logTime;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the bloodGlucoseMeasurementUnitId
	 */
	public Long getBloodGlucoseMeasurementUnitId() {
		return bloodGlucoseMeasurementUnitId;
	}
	/**
	 * @param bloodGlucoseMeasurementUnitId the bloodGlucoseMeasurementUnitId to set
	 */
	public void setBloodGlucoseMeasurementUnitId(Long bloodGlucoseMeasurementUnitId) {
		this.bloodGlucoseMeasurementUnitId = bloodGlucoseMeasurementUnitId;
	}
	/**
	 * @return the bloodGlucoseMeasurementUnit
	 */
	public BloodGlucoseMeasurementUnit getBloodGlucoseMeasurementUnit() {
		return BloodGlucoseMeasurementUnit;
	}
	/**
	 * @return the bloodGlucoseTypeId
	 */
	public Long getBloodGlucoseTypeId() {
		return bloodGlucoseTypeId;
	}
	/**
	 * @param bloodGlucoseTypeId the bloodGlucoseTypeId to set
	 */
	public void setBloodGlucoseTypeId(Long bloodGlucoseTypeId) {
		this.bloodGlucoseTypeId = bloodGlucoseTypeId;
	}
	/**
	 * @return the bloodGlucoseType
	 */
	public BloodGlucoseType getBloodGlucoseType() {
		return bloodGlucoseType;
	}
	/**
	 * @return the reading
	 */
	public BigDecimal getReading() {
		return reading;
	}
	/**
	 * @param reading the reading to set
	 */
	public void setReading(BigDecimal reading) {
		this.reading = reading;
	}
	/**
	 * @return the log_time
	 */
	public Date getLogTime() {
		return logTime;
	}
	/**
	 * @param log_time the log_time to set
	 */
	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}
	@SuppressLint("ParserError")
	public String getLogTimeFormatted() {
		return sdf.format(logTime);
	}
}
