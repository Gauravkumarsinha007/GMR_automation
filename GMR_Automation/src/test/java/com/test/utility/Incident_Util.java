package com.test.utility;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;

public class Incident_Util {

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
		
		for(int rowNum=2; rowNum <= reader.getRowCount("Incident"); rowNum++)
		{
			String Username = reader.getCellData("Incident", "Username", rowNum);
			String Password = reader.getCellData("Incident", "Password", rowNum);
			String Function = reader.getCellData("Incident", "Function", rowNum);
			String Agency = reader.getCellData("Incident", "Agency", rowNum);
			String SubLocation = reader.getCellData("Incident", "SubLocation", rowNum);
			String Shift = reader.getCellData("Incident", "Shift", rowNum);
			String ExactLocation = reader.getCellData("Incident", "ExactLocation", rowNum);
			String Descriptionofwhathappened = reader.getCellData("Incident", "Descriptionofwhathappened", rowNum);
			String ImmediateContainmentAction = reader.getCellData("Incident", "ImmediateContainmentAction", rowNum);
			String Employee = reader.getCellData("Incident", "Employee", rowNum);
			String Name = reader.getCellData("Incident", "Name", rowNum);
			String Age = reader.getCellData("Incident", "Age", rowNum);
			String DepartmentOP = reader.getCellData("Incident", "DepartmentOP", rowNum);
			String Gender = reader.getCellData("Incident", "Gender", rowNum);
			String Attachments1 = reader.getCellData("Incident", "Attachments1", rowNum);
			String Attachments2 = reader.getCellData("Incident", "Attachments2", rowNum);
			String Attachments3 = reader.getCellData("Incident", "Attachments3", rowNum);
			String Attachments4 = reader.getCellData("Incident", "Attachments4", rowNum);
			String HODUsername = reader.getCellData("Incident", "HODUsername", rowNum);
			String HODPassword = reader.getCellData("Incident", "HODPassword", rowNum);
			String Clickonthat = reader.getCellData("Incident", "Clickonthat", rowNum);
			String AuthorizationAction = reader.getCellData("Incident", "AuthorizationAction", rowNum);
			String Comment = reader.getCellData("Incident", "Comment", rowNum);
			String PlantEHSHeadUsername = reader.getCellData("Incident", "PlantEHSHeadUsername", rowNum);
			String PlantEHSHeadPassword = reader.getCellData("Incident", "PlantEHSHeadPassword", rowNum);
			String AuthorizationActionPlantEHSHead = reader.getCellData("Incident", "AuthorizationActionPlantEHSHead", rowNum);
			String CommentPlantEHSHead = reader.getCellData("Incident", "CommentPlantEHSHead", rowNum);
			String searchemployee = reader.getCellData("Incident", "searchemployee", rowNum);
			String InvestigationTeamUsername = reader.getCellData("Incident", "InvestigationTeamUsername", rowNum);
			String InvestigationTeamPassword = reader.getCellData("Incident", "InvestigationTeamPassword", rowNum);
			String TypeofInjury = reader.getCellData("Incident", "TypeofInjury", rowNum);
			String NatureofInjury = reader.getCellData("Incident", "NatureofInjury", rowNum);
			String AuthorizationActionInvestigationTeam = reader.getCellData("Incident", "AuthorizationActionInvestigationTeam", rowNum);
			String CommentInvestigationTeam = reader.getCellData("Incident", "CommentInvestigationTeam", rowNum);
			String PlantEHSHUsername = reader.getCellData("Incident", "PlantEHSHUsername", rowNum);
			String PlantEHSHPassword = reader.getCellData("Incident", "PlantEHSHPassword", rowNum);
			String AuthorizationActionPlantEHSH = reader.getCellData("Incident", "AuthorizationActionPlantEHSH", rowNum);
			String CommentPlantEHSH = reader.getCellData("Incident", "CommentPlantEHSH", rowNum);
			String InvstegationOMHeadUsername = reader.getCellData("Incident", "InvstegationOMHeadUsername", rowNum);
			String InvstegationOMHeadPassword = reader.getCellData("Incident", "InvstegationOMHeadPassword", rowNum);
			String AuthorizationActionInvstegationOMHead = reader.getCellData("Incident", "AuthorizationActionInvstegationOMHead", rowNum);
			String InvstegationOMHeadComment = reader.getCellData("Incident", "InvstegationOMHeadComment", rowNum);
			String InvstegationPlantHEADUsername = reader.getCellData("Incident", "InvstegationPlantHEADUsername", rowNum);
			String InvstegationPlantHEADPassword = reader.getCellData("Incident", "InvstegationPlantHEADPassword", rowNum);
			String Actiontobetaken = reader.getCellData("Incident", "Actiontobetaken", rowNum);
			String Responsibility = reader.getCellData("Incident", "Responsibility", rowNum);
			String Priority = reader.getCellData("Incident", "Priority", rowNum);
			String AuthorizationActionInvstegationPlantHEAD = reader.getCellData("Incident", "AuthorizationActionInvstegationPlantHEAD", rowNum);
			String InvstegationPlantHEADComment = reader.getCellData("Incident", "InvstegationPlantHEADComment", rowNum);
			
			
			Object ob[]= { Username,Password,Function,Agency,SubLocation,Shift,ExactLocation,Descriptionofwhathappened,ImmediateContainmentAction,Employee,Name,Age,DepartmentOP,
					Gender,Attachments1,Attachments2,Attachments3,Attachments4,HODUsername,HODPassword,Clickonthat,AuthorizationAction,Comment,PlantEHSHeadUsername,PlantEHSHeadPassword,
					AuthorizationActionPlantEHSHead,CommentPlantEHSHead,searchemployee,InvestigationTeamUsername,InvestigationTeamPassword,TypeofInjury,NatureofInjury,
					AuthorizationActionInvestigationTeam,CommentInvestigationTeam,PlantEHSHUsername,PlantEHSHPassword,AuthorizationActionPlantEHSH,CommentPlantEHSH,
					InvstegationOMHeadUsername,InvstegationOMHeadPassword,AuthorizationActionInvstegationOMHead,InvstegationOMHeadComment,InvstegationPlantHEADUsername,
					InvstegationPlantHEADPassword,Actiontobetaken,Responsibility,Priority,AuthorizationActionInvstegationPlantHEAD,InvstegationPlantHEADComment

			};
			myData.add(ob);
		
			}

			return myData;
		
			}
	}
