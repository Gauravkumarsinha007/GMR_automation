package com.test.utility;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;

public class NearMiss_Util {
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
		
		for(int rowNum=2; rowNum <= reader.getRowCount("NearMiss"); rowNum++)
		{
			String UserName = reader.getCellData("NearMiss", "UserName", rowNum);
			String Password = reader.getCellData("NearMiss", "Password", rowNum);
			String Function = reader.getCellData("NearMiss", "Function", rowNum);
			String Agency = reader.getCellData("NearMiss", "Agency", rowNum);
			String SubLocation = reader.getCellData("NearMiss", "SubLocation", rowNum);
			String ExactLocation = reader.getCellData("NearMiss", "ExactLocation", rowNum);
			String Severity = reader.getCellData("NearMiss", "Severity", rowNum);
			String Descriptionofwhathappened = reader.getCellData("NearMiss", "Descriptionofwhathappened", rowNum);
			String ImmediateContainmentAction = reader.getCellData("NearMiss", "ImmediateContainmentAction", rowNum);
			String Attachments1 = reader.getCellData("NearMiss", "Attachments1", rowNum);
			String Attachments2 = reader.getCellData("NearMiss", "Attachments2", rowNum);
			String Attachments3 = reader.getCellData("NearMiss", "Attachments3", rowNum);
			String Attachments4 = reader.getCellData("NearMiss", "Attachments4", rowNum);
			String PlantEHSHeadUsername = reader.getCellData("NearMiss", "PlantEHSHeadUsername", rowNum);
			String PlantEHSHeadPassword = reader.getCellData("NearMiss", "PlantEHSHeadPassword", rowNum);
			String Clickonthat = reader.getCellData("NearMiss", "Clickonthat", rowNum);
			String AuthorizationAction = reader.getCellData("NearMiss", "AuthorizationAction", rowNum);
			String Comment = reader.getCellData("NearMiss", "Comment", rowNum);
			String searchemployeename = reader.getCellData("NearMiss", "searchemployeename", rowNum);
			String InvestigationTeamUsername = reader.getCellData("NearMiss", "InvestigationTeamUsername", rowNum);
			String InvestigationTeamPassword = reader.getCellData("NearMiss", "InvestigationTeamPassword", rowNum);
			String InvestigationTeamAuthorizationAction = reader.getCellData("NearMiss", "InvestigationTeamAuthorizationAction", rowNum);
			String InvestigationTeamComment = reader.getCellData("NearMiss", "InvestigationTeamComment", rowNum);
			String PlantEHSHeadAuthorizationaction = reader.getCellData("NearMiss", "PlantEHSHeadAuthorizationaction", rowNum);
			String PlantEHSHeadComment = reader.getCellData("NearMiss", "PlantEHSHeadComment", rowNum);
			String ReviewOMHeadUsername = reader.getCellData("NearMiss", "ReviewOMHeadUsername", rowNum);
			String ReviewOMHeadPassword = reader.getCellData("NearMiss", "ReviewOMHeadPassword", rowNum);
			String ReviewOMHeadAuthorizationAction = reader.getCellData("NearMiss", "ReviewOMHeadAuthorizationAction", rowNum);
			String ReviewOMHeadComment = reader.getCellData("NearMiss", "ReviewOMHeadComment", rowNum);
			String PlantHEADUsername = reader.getCellData("NearMiss", "PlantHEADUsername", rowNum);
			String PlantHEADPassword = reader.getCellData("NearMiss", "PlantHEADPassword", rowNum);
			String PlantHEADAuthorizationaction = reader.getCellData("NearMiss", "PlantHEADAuthorizationaction", rowNum);
			String PlantHEADComment = reader.getCellData("NearMiss", "PlantHEADComment", rowNum);
			
			
			Object ob[]= { UserName,Password,Function,Agency,SubLocation,ExactLocation,Severity,Descriptionofwhathappened,ImmediateContainmentAction,Attachments1,Attachments2,
					Attachments3,Attachments4,PlantEHSHeadUsername,PlantEHSHeadPassword,Clickonthat,AuthorizationAction,Comment,searchemployeename,InvestigationTeamUsername,
					InvestigationTeamPassword,InvestigationTeamAuthorizationAction,InvestigationTeamComment,PlantEHSHeadAuthorizationaction,PlantEHSHeadComment,ReviewOMHeadUsername,
					ReviewOMHeadPassword,ReviewOMHeadAuthorizationAction,ReviewOMHeadComment,PlantHEADUsername,PlantHEADPassword,PlantHEADAuthorizationaction,PlantHEADComment


			};
			myData.add(ob);
		
			}

			return myData;
		
			}
	

}
