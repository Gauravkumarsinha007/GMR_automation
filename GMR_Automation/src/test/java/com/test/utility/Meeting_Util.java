package com.test.utility;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;

public class Meeting_Util {

	static Xls_Reader reader;
	
	
	
	public static ArrayList<Object[]> GetDataFromExcel()
	{
		ArrayList<Object[]> myData= new ArrayList<Object[]>();
		try {
			reader = new Xls_Reader("C:/Users/GAURAV/workspace/GMR_Automation/src/main/java/com/textdata/GMR_Automation.xlsx");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		for(int rowNum=2; rowNum <= reader.getRowCount("Meeting"); rowNum++)
		{
			String UserName = reader.getCellData("Meeting", "UserName", rowNum);
			String Password = reader.getCellData("Meeting", "Password", rowNum);
			String url = reader.getCellData("Meeting", "url", rowNum);
			String MeetingType = reader.getCellData("Meeting", "MeetingType", rowNum);
			String Function = reader.getCellData("Meeting", "Function", rowNum);
			String MeetingTopic = reader.getCellData("Meeting", "MeetingTopic", rowNum);
			String DurationHH = reader.getCellData("Meeting", "DurationHH", rowNum);
			String DurationMM = reader.getCellData("Meeting", "DurationMM", rowNum);
			String MeetingHost = reader.getCellData("Meeting", "MeetingHost", rowNum);
			String Meetingvenue = reader.getCellData("Meeting", "Meetingvenue", rowNum);
			String Meetingagenda = reader.getCellData("Meeting", "Meetingagenda", rowNum);
			String Employeename = reader.getCellData("Meeting", "Employeename", rowNum);
			String Email = reader.getCellData("Meeting", "Email", rowNum);
			String Attach1 = reader.getCellData("Meeting", "Attach1", rowNum);
			String Attach2 = reader.getCellData("Meeting", "Attach2", rowNum);
			String AuthorizationactionCompleted = reader.getCellData("Meeting", "AuthorizationactionCompleted", rowNum);
			String Comment = reader.getCellData("Meeting", "Comment", rowNum);
			String AuthorizationactionPostpone = reader.getCellData("Meeting", "AuthorizationactionPostpone", rowNum);
			String Postponecomment = reader.getCellData("Meeting", "Postponecomment", rowNum);
			String Authorizationactioncancelled = reader.getCellData("Meeting", "Authorizationactioncancelled", rowNum);
			String cancelledcomment = reader.getCellData("Meeting", "cancelledcomment", rowNum);
			
			
			Object ob[]= { UserName,Password,url,MeetingType,Function,MeetingTopic,DurationHH,DurationMM,MeetingHost,Meetingvenue,Meetingagenda,Employeename,Email,Attach1,
					Attach2,AuthorizationactionCompleted,Comment,AuthorizationactionPostpone,Postponecomment,Authorizationactioncancelled,cancelledcomment

			};
			myData.add(ob);
		
			}

			return myData;
		
			}

}
