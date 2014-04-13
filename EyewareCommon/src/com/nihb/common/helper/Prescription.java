package com.nihb.common.helper;

public class Prescription {
	
	VisionInfo odVisionInfo;
	VisionInfo osVisionInfo;
	NihbDecimal pd;
	public Prescription() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @return the odVisionInfo
	 */
	public VisionInfo getOdVisionInfo() {
		return odVisionInfo;
	}


	/**
	 * @param odVisionInfo the odVisionInfo to set
	 */
	public void setOdVisionInfo(VisionInfo odVisionInfo) {
		this.odVisionInfo = odVisionInfo;
	}


	/**
	 * @return the osVisionInfo
	 */
	public VisionInfo getOsVisionInfo() {
		return osVisionInfo;
	}


	/**
	 * @param osVisionInfo the osVisionInfo to set
	 */
	public void setOsVisionInfo(VisionInfo osVisionInfo) {
		this.osVisionInfo = osVisionInfo;
	}


	/**
	 * @return the pd
	 */
	public NihbDecimal getPd() {
		return pd;
	}
	/**
	 * @param pd the pd to set
	 */
	public void setPd(NihbDecimal pd) {
		this.pd = pd;
	}

	
	
}
