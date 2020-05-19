package com.springboot.EventManager.model;

public class RegTypeCount {

	private int self;
	private int group;
	private int others;
	private int corporate;

	public RegTypeCount() {
		self = 0;
		group = 0;
		others = 0;
		corporate = 0;
	}

	public int getSelf() {
		return self;
	}

	public void setSelf(int self) {
		this.self = self;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public int getOthers() {
		return others;
	}

	public void setOthers(int others) {
		this.others = others;
	}

	public int getCorporate() {
		return corporate;
	}

	public void setCorporate(int corporate) {
		this.corporate = corporate;
	}

}
