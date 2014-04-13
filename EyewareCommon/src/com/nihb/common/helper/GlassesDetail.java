package com.nihb.common.helper;

import java.math.BigDecimal;

public class GlassesDetail {

	GlassesItem frame;
	GlassesItem rightLens;
	GlassesItem leftLens;
	GlassesItem scr;
	GlassesItem hardexCoating;
	GlassesItem edging;
	GlassesItem nylongroving;
	GlassesItem glassesCase;
	GlassesItem framefront;
	GlassesItem temple;
	GlassesItem other1;
	GlassesItem other2;

	public GlassesDetail() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the frame
	 */
	public GlassesItem getFrame() {
		return frame;
	}

	/**
	 * @param frame the frame to set
	 */
	public void setFrame(GlassesItem frame) {
		this.frame = frame;
	}

	/**
	 * @return the rightLens
	 */
	public GlassesItem getRightLens() {
		return rightLens;
	}

	/**
	 * @param rightLens the rightLens to set
	 */
	public void setRightLens(GlassesItem rightLens) {
		this.rightLens = rightLens;
	}

	/**
	 * @return the leftLens
	 */
	public GlassesItem getLeftLens() {
		return leftLens;
	}

	/**
	 * @param leftLens the leftLens to set
	 */
	public void setLeftLens(GlassesItem leftLens) {
		this.leftLens = leftLens;
	}

	/**
	 * @return the scr
	 */
	public GlassesItem getScr() {
		return scr;
	}

	/**
	 * @param scr the scr to set
	 */
	public void setScr(GlassesItem scr) {
		this.scr = scr;
	}

	/**
	 * @return the hardexCoating
	 */
	public GlassesItem getHardexCoating() {
		return hardexCoating;
	}

	/**
	 * @param hardexCoating the hardexCoating to set
	 */
	public void setHardexCoating(GlassesItem hardexCoating) {
		this.hardexCoating = hardexCoating;
	}

	/**
	 * @return the edging
	 */
	public GlassesItem getEdging() {
		return edging;
	}

	/**
	 * @param edging the edging to set
	 */
	public void setEdging(GlassesItem edging) {
		this.edging = edging;
	}

	/**
	 * @return the nylongroving
	 */
	public GlassesItem getNylongroving() {
		return nylongroving;
	}

	/**
	 * @param nylongroving the nylongroving to set
	 */
	public void setNylongroving(GlassesItem nylongroving) {
		this.nylongroving = nylongroving;
	}

	/**
	 * @return the glassesCase
	 */
	public GlassesItem getGlassesCase() {
		return glassesCase;
	}

	/**
	 * @param glassesCase the glassesCase to set
	 */
	public void setGlassesCase(GlassesItem glassesCase) {
		this.glassesCase = glassesCase;
	}

	/**
	 * @return the framefront
	 */
	public GlassesItem getFramefront() {
		return framefront;
	}

	/**
	 * @param framefront the framefront to set
	 */
	public void setFramefront(GlassesItem framefront) {
		this.framefront = framefront;
	}

	/**
	 * @return the temple
	 */
	public GlassesItem getTemple() {
		return temple;
	}

	/**
	 * @param temple the temple to set
	 */
	public void setTemple(GlassesItem temple) {
		this.temple = temple;
	}

	/**
	 * @return the other1
	 */
	public GlassesItem getOther1() {
		return other1;
	}

	/**
	 * @param other1 the other1 to set
	 */
	public void setOther1(GlassesItem other1) {
		this.other1 = other1;
	}

	/**
	 * @return the other2
	 */
	public GlassesItem getOther2() {
		return other2;
	}

	/**
	 * @param other2 the other2 to set
	 */
	public void setOther2(GlassesItem other2) {
		this.other2 = other2;
	}

	public NihbDecimal getAmount(){
		BigDecimal amount = new BigDecimal(0);
		amount.add(this.frame.getCost().getAmount());
		amount.add(this.rightLens.getCost().getAmount());
		amount.add(this.leftLens.getCost().getAmount());
		amount.add(this.scr.getCost().getAmount());

		amount.add(this.hardexCoating.getCost().getAmount());
		amount.add(this.edging.getCost().getAmount());
		amount.add(this.nylongroving.getCost().getAmount());
		amount.add(this.glassesCase.getCost().getAmount());
		amount.add(this.framefront.getCost().getAmount());
		amount.add(this.temple.getCost().getAmount());
		amount.add(this.other1.getCost().getAmount());
		amount.add(this.other2.getCost().getAmount());
		
		return new NihbDecimal(amount);
	}
}
