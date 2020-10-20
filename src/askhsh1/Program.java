package askhsh1;

public class Program {
	private String programName;
	private int data, sms, calls;
	private float billingFee, ectraBilling;
	
	public Program() {
		
	}
	public Program(String programName, int data, int sms, int calls, float billingFee) {
		super();
		this.programName = programName;
		this.data = data;
		this.sms = sms;
		this.calls = calls;
		this.billingFee = billingFee;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getSms() {
		return sms;
	}

	public void setSms(int sms) {
		this.sms = sms;
	}

	public int getCalls() {
		return calls;
	}

	public void setCalls(int calls) {
		this.calls = calls;
	}

	public float getBillingFee() {
		return billingFee;
	}

	public void setBillingFee(float billingFee) {
		this.billingFee = billingFee;
	}

	public float getEctraBilling() {
		return ectraBilling;
	}

	public void setEctraBilling(float ectraBilling) {
		this.ectraBilling = ectraBilling;
	}
	
	
	
	
}
