package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

class HContentSecurityPolicyReportOnly implements Header
{
	private Header rawHeader;
	
	public HContentSecurityPolicyReportOnly(Header raw)
	{
		rawHeader = raw;
		parse(rawHeader);
	}
	
	private void parse(Header raw)
	{
		
	}
	
	@Override
	public String getName()
	{
		return "Content-Security-Policy-Report-Only";
	}
	
	@Override
	public String getData()
	{
		return "";
	}
	
	@Override
	public boolean isValid()
	{
		return false;
	}
}
