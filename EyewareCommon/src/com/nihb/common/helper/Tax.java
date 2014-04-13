package com.nihb.common.helper;

public class Tax {

	NihbDecimal gst;
	NihbDecimal pst;
	NihbDecimal hst;

	public Tax() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the gst
	 */
	public NihbDecimal getGst() {
		return gst;
	}

	/**
	 * @param gst the gst to set
	 */
	public void setGst(NihbDecimal gst) {
		this.gst = gst;
	}

	/**
	 * @return the pst
	 */
	public NihbDecimal getPst() {
		return pst;
	}

	/**
	 * @param pst the pst to set
	 */
	public void setPst(NihbDecimal pst) {
		this.pst = pst;
	}

	/**
	 * @return the hst
	 */
	public NihbDecimal getHst() {
		return hst;
	}

	/**
	 * @param exam_hst the exam_hst to set
	 */
	public void setHst(NihbDecimal hst) {
		this.hst = hst;
	}

	
}
